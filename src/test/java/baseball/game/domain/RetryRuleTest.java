package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.RetryErrors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RetryRuleTest {

    @ParameterizedTest(name = "입력값에 따른 Retry Enum 을 반환한다.")
    @MethodSource("retry_find_by_restart_value_parameter")
    void retry_find_by_restart_value(String input, RetryRule expected) {
        // given: none

        // when, then
        assertThat(RetryRule.findByRestartValue(input)).isSameAs(expected);
    }

    static Stream<Arguments> retry_find_by_restart_value_parameter() {
        return Stream.of(
                Arguments.of("1", RetryRule.RESTART),
                Arguments.of("2", RetryRule.DONE));
    }

    @DisplayName("올바르지 않은 재시도입력값인 경우, 예외를 출력한다.")
    @Test
    void retry_invalid_input() {
        // given
        String invalidInput = "3";

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RetryRule.findByRestartValue(invalidInput))
                .withMessageStartingWith(RetryErrors.INVALID_RESTART_INPUT);
    }
}