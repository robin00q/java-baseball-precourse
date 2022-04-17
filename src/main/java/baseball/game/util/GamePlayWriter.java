package baseball.game.util;

import baseball.game.domain.GameResult;

public class GamePlayWriter {

    private GamePlayWriter() {
    }

    public static void printResult(GameResult gameResult) {
        System.out.println(gameResult.getGameResultAsString());
    }

    public static void printRequireNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
