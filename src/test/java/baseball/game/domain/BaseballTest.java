package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.BaseballErrors;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {

    @ParameterizedTest(name = "야구공_생성_오류케이스_최대_최소값_위반")
    @CsvSource(value = {
            "0:" + BaseballErrors.INVALID_BASEBALL_NUMBER_MINIMUM_POSTFIX,
            "10:" + BaseballErrors.INVALID_BASEBALL_NUMBER_MAXIMUM_POSTFIX},
            delimiter = ':')
    void invalid_baseball_creation(int ballNumber, String errorMessagePostFix) {
        // given
        int position = 1;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Baseball(ballNumber, position))
                .withMessageStartingWith(BaseballErrors.INVALID_BASEBALL_PREFIX)
                .withMessageEndingWith(errorMessagePostFix);
    }

    @ParameterizedTest(name = "야구공_생성_오류케이스_최대_최소_위치값_위반")
    @CsvSource(value = {
            "0:" + BaseballErrors.INVALID_BASEBALL_POSITION_MINIMUM_POSTFIX,
            "4:" + BaseballErrors.INVALID_BASEBALL_POSITION_MAXIMUM_POSTFIX},
            delimiter = ':')
    void invalid_baseball_position_creation(int position, String errorMessagePostFix) {
        // given
        int ballNumber = 1;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Baseball(ballNumber, position))
                .withMessageStartingWith(BaseballErrors.INVALID_BASEBALL_POSITION_PREFIX)
                .withMessageEndingWith(errorMessagePostFix);
    }

    @ParameterizedTest(name = "야구공 생성 정상케이스")
    @CsvSource(value = {"1:1", "9:1", "1:2", "9:2", "1:3", "9:3"}, delimiter = ':')
    void valid_baseball_creation(int ballNumber, int position) {
        // given: none
        // when, then
        assertThatCode(() -> new Baseball(ballNumber, position))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "하나의 야구공과 여러개의 야구공을 비교해, ball 상태인지 확인한다.")
    @MethodSource("compare_baseball_is_ball_status_parameter")
    void compare_baseball_is_ball_status(Baseball baseball, List<Baseball> anotherBaseballs) {
        // given: none
        // when, then
        assertThat(baseball.isBallStatus(anotherBaseballs)).isTrue();
    }

    static Stream<Arguments> compare_baseball_is_ball_status_parameter() {
        return Stream.of(
                Arguments.of(new Baseball(1, 1), Collections.singletonList(new Baseball(1, 2))),
                Arguments.of(new Baseball(1, 1), Arrays.asList(new Baseball(1, 2), new Baseball(2, 1)))
        );
    }

    @ParameterizedTest(name = "하나의 야구공과 여러개의 야구공을 비교해, strike 상태인지 확인한다.")
    @MethodSource("compare_baseball_is_strike_status_parameter")
    void compare_baseball_is_strike_status(Baseball baseball, List<Baseball> anotherBaseballs) {
        // given: none
        // when, then
        assertThat(baseball.isStrikeStatus(anotherBaseballs)).isTrue();
    }

    static Stream<Arguments> compare_baseball_is_strike_status_parameter() {
        return Stream.of(
                Arguments.of(new Baseball(1, 1), Collections.singletonList(new Baseball(1, 1))),
                Arguments.of(new Baseball(2, 2), Arrays.asList(new Baseball(1, 1), new Baseball(2, 2)))
        );
    }
}