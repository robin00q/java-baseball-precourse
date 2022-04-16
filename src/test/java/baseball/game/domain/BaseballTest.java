package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.BaseballErrors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}