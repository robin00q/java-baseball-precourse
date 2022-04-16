package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.BaseballErrors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballsTest {

    @ParameterizedTest(name = "Baseballs 객체 생성 위반")
    @MethodSource(value = "invalid_baseballs_creation_parameter")
    void invalid_baseballs_creation(int ball1, int ball2, int ball3) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Baseballs(ball1, ball2, ball3))
                .withMessageStartingWith(BaseballErrors.INVALID_BASEBALL_PREFIX);
    }

    static Stream<Arguments> invalid_baseballs_creation_parameter() {
        return Stream.of(
                Arguments.of(0, 1, 2),
                Arguments.of(1, 2, 10),
                Arguments.of(0, 0, 0),
                Arguments.of(10, 10, 10));
    }

    @DisplayName("Baseballs 객체 생성 정상케이스")
    @Test
    void valid_baseball_creation() {
        // given
        int ball1 = 1;
        int ball2 = 2;
        int ball3 = 5;

        // when, then
        assertThatCode(() -> new Baseballs(ball1, ball2, ball3))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "야구공들 끼리 비교해서, strike count 를 가져온다.")
    @MethodSource("compare_baseballs_and_get_strike_count_parameter")
    void compare_baseballs_and_get_strike_count(Baseballs baseballs1, Baseballs baseballs2, int expectedStrikeCount) {
        // given: none

        // when, then
        assertThat(baseballs1.getStrikeCount(baseballs2)).isEqualTo(expectedStrikeCount);
    }

    static Stream<Arguments> compare_baseballs_and_get_strike_count_parameter() {
        return Stream.of(
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(1, 2, 3), 3),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(1, 2, 4), 2),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(1, 3, 4), 1),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(4, 5, 6), 0)
        );
    }

    @ParameterizedTest(name = "야구공들 끼리 비교해서, ball count 를 가져온다.")
    @MethodSource("compare_baseballs_and_get_ball_count_parameter")
    void compare_baseballs_and_get_ball_count(Baseballs baseballs1, Baseballs baseballs2, int expectedBallCount) {
        // given: none

        // when, then
        assertThat(baseballs1.getBallCount(baseballs2)).isEqualTo(expectedBallCount);
    }

    static Stream<Arguments> compare_baseballs_and_get_ball_count_parameter() {
        return Stream.of(
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(2, 3, 1), 3),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(2, 3, 9), 2),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(3, 8, 7), 1),
                Arguments.of(new Baseballs(1, 2, 3), new Baseballs(4, 5, 6), 0)
        );
    }
}