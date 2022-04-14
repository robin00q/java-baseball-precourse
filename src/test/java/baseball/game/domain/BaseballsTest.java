package baseball.game.domain;

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
    void invalid_baseballs_creation(Baseball ball1, Baseball ball2, Baseball ball3) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Baseballs(ball1, ball2, ball3))
                .withMessageStartingWith(BaseballErrors.INVALID_BASEBALLS_PREFIX)
                .withMessageEndingWith(BaseballErrors.INVALID_BASEBALLS_POSTFIX);
    }

    static Stream<Arguments> invalid_baseballs_creation_parameter() {
        return Stream.of(
                Arguments.of(new Baseball(1), new Baseball(2), null),
                Arguments.of(new Baseball(1), null, new Baseball(3)),
                Arguments.of(null, new Baseball(2), new Baseball(3)),
                Arguments.of(null, null, null));
    }

    @DisplayName("Baseballs 객체 생성 정상케이스")
    @Test
    void valid_baseball_creation() {
        // given
        Baseball ball1 = new Baseball(1);
        Baseball ball2 = new Baseball(2);
        Baseball ball3 = new Baseball(5);

        // when, then
        assertThatCode(() -> new Baseballs(ball1, ball2, ball3))
                .doesNotThrowAnyException();
    }
}