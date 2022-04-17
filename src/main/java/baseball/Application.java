package baseball;

import baseball.game.service.PlayService;
import baseball.game.service.factory.PlayServiceFactory;
import baseball.game.util.GamePlayWriter;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        PlayService playService = PlayServiceFactory.fixedNumberBaseballPlayService();

        do {
            playService.playUntilThreeStrike();
            GamePlayWriter.printGameFinished();
            GamePlayWriter.askRetry();
        } while (PlayService.isRestart(Console.readLine()));
    }
}
