package baseball.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
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
                .isThrownBy(() -> GameResult.playAndGetGameResult(player, computer))
                .withMessageMatching(errorMessages);
    }

    static Stream<Arguments> invalid_game_result_creation_parameter() {
        return Stream.of(
                Arguments.of(
                        new Player(new Baseballs(1, 2, 3)),
                        null,
                        GameResultErrors.GAME_RESULT_REQUIRE_COMPUTER),
                Arguments.of(
                        null,
                        new Computer(new Baseballs(1, 2, 3)),
                        GameResultErrors.GAME_RESULT_REQUIRE_PLAYER));
    }

    @ParameterizedTest(name = "플레이어와 컴퓨터가 게임을해서 결과를 반환한다.")
    @MethodSource("play_and_get_game_result_parameter")
    void play_and_get_game_result(Player player, Computer computer, GameResult expected) {
        // given: none

        // when, then
        assertThat(GameResult.playAndGetGameResult(player, computer)).isEqualTo(expected);

    }

    static Stream<Arguments> play_and_get_game_result_parameter(){
        return Stream.of(
                Arguments.of(
                        new Player(new Baseballs(1, 2, 3)),
                        new Computer(new Baseballs(1, 2, 3)),
                        new GameResult(3, 0)),
                Arguments.of(
                        new Player(new Baseballs(1, 2, 3)),
                        new Computer(new Baseballs(2, 1, 3)),
                        new GameResult(1, 2)),
                Arguments.of(
                        new Player(new Baseballs(4, 5, 6)),
                        new Computer(new Baseballs(5, 6, 4)),
                        new GameResult(0, 3)));
    }


}