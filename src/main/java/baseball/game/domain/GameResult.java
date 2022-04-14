package baseball.game.domain;

import baseball.game.errors.GameResultErrors;

public class GameResult {

    private final int strikeCount;

    private final int ballCount;

    // TODO : implement constructor
    public GameResult(Player player, Computer computer) {
        validatePlayer(player);
        validateComputer(computer);

        strikeCount = 0;
        ballCount = 0;
    }

    private void validatePlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException(GameResultErrors.GAME_RESULT_REQUIRE_PLAYER);
        }
    }

    private void validateComputer(Computer computer) {
        if (computer == null) {
            throw new IllegalArgumentException(GameResultErrors.GAME_RESULT_REQUIRE_COMPUTER);
        }
    }

}
