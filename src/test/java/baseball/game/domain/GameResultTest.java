package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.game.errors.GameResultErrors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultTest {

    @ParameterizedTest(name = "게임결과를 생성하기 위해서는, 컴퓨터와 플레이어가 모두 필요하다.")
    @MethodSource("invalid_game_result_creation_parameter")
    void game_result_require_player_and_computer(Player player, Computer computer, String errorMessages) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult(player, computer))
                .withMessageMatching(errorMessages);
    }

    static Stream<Arguments> invalid_game_result_creation_parameter() {
        return Stream.of(
                Arguments.of(
                        new Player(new Baseballs(new Baseball(1), new Baseball(2), new Baseball(3))),
                        null,
                        GameResultErrors.GAME_RESULT_REQUIRE_COMPUTER),
                Arguments.of(
                        null,
                        new Computer(new Baseballs(new Baseball(1), new Baseball(2), new Baseball(3))),
                        GameResultErrors.GAME_RESULT_REQUIRE_PLAYER));
    }


}