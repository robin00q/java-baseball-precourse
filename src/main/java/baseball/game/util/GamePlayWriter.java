package baseball.game.util;

import baseball.game.domain.GameResult;
import baseball.game.domain.RetryRule;

public class GamePlayWriter {

    private GamePlayWriter() {
    }

    public static void printResult(GameResult gameResult) {
        System.out.println(gameResult.getGameResultAsString());
    }

    public static void printRequireNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printGameFinished() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askRetry() {
        String retryOutputBuilder = "게임을 새로 시작하려면 "
                + RetryRule.RESTART.getRestartValue()
                + ","
                + "종료하려면 "
                + RetryRule.DONE.getRestartValue()
                + "를 입력하세요.";

        System.out.println(retryOutputBuilder);
    }
}
