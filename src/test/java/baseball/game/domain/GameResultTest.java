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
    void game_result_require_player_and_computer(Baseballs player, Baseballs computer, String errorMessages) {
        // given: none

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameResult.playAndGetGameResult(player, computer))
                .withMessageMatching(errorMessages);
    }

    static Stream<Arguments> invalid_game_result_creation_parameter() {
        return Stream.of(
                Arguments.of(
                        new Baseballs(1, 2, 3),
                        null,
                        GameResultErrors.GAME_RESULT_REQUIRE_COMPUTER),
                Arguments.of(
                        null,
                        new Baseballs(1, 2, 3),
                        GameResultErrors.GAME_RESULT_REQUIRE_PLAYER));
    }

    @ParameterizedTest(name = "플레이어와 컴퓨터가 게임을해서 결과를 반환한다.")
    @MethodSource("play_and_get_game_result_parameter")
    void play_and_get_game_result(Baseballs player, Baseballs computer, GameResult expected) {
        // given: none

        // when, then
        assertThat(GameResult.playAndGetGameResult(player, computer)).isEqualTo(expected);

    }

    static Stream<Arguments> play_and_get_game_result_parameter(){
        return Stream.of(
                Arguments.of(
                        new Baseballs(1, 2, 3),
                        new Baseballs(1, 2, 3),
                        new GameResult(3, 0)),
                Arguments.of(
                        new Baseballs(1, 2, 3),
                        new Baseballs(2, 1, 3),
                        new GameResult(1, 2)),
                Arguments.of(
                        new Baseballs(4, 5, 6),
                        new Baseballs(5, 6, 4),
                        new GameResult(0, 3)));
    }

    @ParameterizedTest(name = "게임결과가 3스트라이크인지 판별한다.")
    @MethodSource("is_game_result_three_strike_parameter")
    void is_game_result_three_strike(GameResult gameResult, boolean expected) {
        // given: none

        // when, then
        assertThat(gameResult.isThreeStrike()).isEqualTo(expected);
    }

    static Stream<Arguments> is_game_result_three_strike_parameter() {
        return Stream.of(
                Arguments.of(new GameResult(3, 0), true),
                Arguments.of(new GameResult(2, 0), false),
                Arguments.of(new GameResult(0, 3), false));
    }

    @ParameterizedTest(name = "게임결과를 문자열로 반환하는 경우, 어떤 문자열이 반환되는지 확인한다.")
    @MethodSource("game_result_as_string_parameter")
    void game_result_as_string(GameResult gameResult, StringBuilder expected) {
        // given: none

        // when, then
        assertThat(gameResult.getGameResultAsString()).isEqualTo(expected.toString());
    }

    static Stream<Arguments> game_result_as_string_parameter() {
        return Stream.of(
                Arguments.of(new GameResult(3, 0),
                        new StringBuilder().append("3").append(BaseballRule.STRIKE.getDescription())),
                Arguments.of(new GameResult(1, 1),
                        new StringBuilder().append("1").append(BaseballRule.BALL.getDescription())
                                .append(" ")
                                .append("1").append(BaseballRule.STRIKE.getDescription())),
                Arguments.of(new GameResult(0, 2),
                        new StringBuilder().append("2").append(BaseballRule.BALL.getDescription())),
                Arguments.of(new GameResult(0, 0),
                        new StringBuilder().append(BaseballRule.NOTHING.getDescription())));
    }


}