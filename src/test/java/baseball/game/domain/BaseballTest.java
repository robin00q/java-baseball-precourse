package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.BaseballErrors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

    @ParameterizedTest(name = "야구공_생성_오류케이스_최대_최소값_위반")
    @CsvSource(value = {
            "0:" + BaseballErrors.INVALID_BASEBALL_MINIMUM_POSTFIX,
            "10:" + BaseballErrors.INVALID_BASEBALL_MAXIMUM_POSTFIX},
            delimiter = ':')
    void invalid_baseball_creation(int ballNumber, String errorMessagePostFix) {
        // given: none
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Baseball(ballNumber))
                .withMessageStartingWith(BaseballErrors.INVALID_BASEBALL_PREFIX)
                .withMessageEndingWith(errorMessagePostFix);
    }

    @ParameterizedTest(name = "야구공 생성 정상케이스")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void valid_baseball_creation(int ballNumber) {
        // given: none
        // when, then
        assertThatCode(() -> new Baseball(ballNumber))
                .doesNotThrowAnyException();
    }
}