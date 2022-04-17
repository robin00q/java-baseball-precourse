package baseball.game.domain;

import baseball.game.errors.GameResultErrors;
import java.util.Objects;

public class GameResult {

    private static final int THREE_STRIKE = 3;

    private final int strikeCount;

    private final int ballCount;

    private GameResult(Baseballs player, Baseballs computer) {
        validatePlayer(player);
        validateComputer(computer);

        strikeCount = player.getStrikeCount(computer);
        ballCount = player.getBallCount(computer);
    }

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult playAndGetGameResult(Baseballs player, Baseballs computer) {
        return new GameResult(player, computer);
    }

    private void validatePlayer(Baseballs player) {
        if (player == null) {
            throw new IllegalArgumentException(GameResultErrors.GAME_RESULT_REQUIRE_PLAYER);
        }
    }

    private void validateComputer(Baseballs computer) {
        if (computer == null) {
            throw new IllegalArgumentException(GameResultErrors.GAME_RESULT_REQUIRE_COMPUTER);
        }
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE_STRIKE;
    }

    public String getGameResultAsString() {
        if (hasStrikeCount() && hasBallCount()) {
            return ballCountString() + " " + strikeCountString();
        }
        if (hasBallCount()) {
            return ballCountString();
        }
        if (hasStrikeCount()) {
            return strikeCountString();
        }
        return BaseballRule.NOTHING.getDescription();
    }

    private boolean hasBallCount() {
        return ballCount != 0;
    }

    private boolean hasStrikeCount() {
        return strikeCount != 0;
    }

    private String strikeCountString() {
        return strikeCount + BaseballRule.STRIKE.getDescription();
    }

    private String ballCountString() {
        return ballCount + BaseballRule.BALL.getDescription();
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
