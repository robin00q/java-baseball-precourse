package baseball.game.domain;

import baseball.game.errors.GameResultErrors;
import java.util.Objects;

public class GameResult {

    private final int strikeCount;

    private final int ballCount;

    private GameResult(Player player, Computer computer) {
        validatePlayer(player);
        validateComputer(computer);

        strikeCount = player.getBaseballs().getStrikeCount(computer.getBaseballs());
        ballCount = player.getBaseballs().getBallCount(computer.getBaseballs());
    }

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult playAndGetGameResult(Player player, Computer computer) {
        return new GameResult(player, computer);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
