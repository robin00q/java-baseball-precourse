package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.ComputerErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("컴퓨터는 항상 멤버로 Baseballs 를 가진다.")
    @Test
    void invalid_computer_creation() {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Computer(null))
                .withMessageMatching(ComputerErrors.COMPUTER_REQUIRED_BASEBALLS);
    }

    @DisplayName("컴퓨터 정상적으로 생성 테스트")
    @Test
    void computer_creation_test() {
        // given
        Baseballs baseballs = new Baseballs(1, 2, 3);

        // when, then
        assertThatCode(() -> new Computer(baseballs)).doesNotThrowAnyException();
    }
}