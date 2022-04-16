package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.PlayerErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어는 항상 멤버로 Baseballs 를 가진다.")
    @Test
    void invalid_player_creation() {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(null))
                .withMessageMatching(PlayerErrors.PLAYER_REQUIRED_BASEBALLS);
    }

    @DisplayName("플레이어 정상적으로 생성 테스트")
    @Test
    void player_creation_test() {
        // given
        Baseballs baseballs = new Baseballs(4, 5, 6);

        // when, then
        assertThatCode(() -> new Player(baseballs)).doesNotThrowAnyException();
    }
}