package baseball;

import baseball.game.service.PlayService;
import baseball.game.service.factory.PlayServiceFactory;
import baseball.game.util.GamePlayReader;
import baseball.game.util.GamePlayWriter;

public class Application {

    public static void main(String[] args) {
        PlayService playService = PlayServiceFactory.getRandomNumberBaseballPlayService();

        do {
            playService.playUntilThreeStrike();
            GamePlayWriter.printGameFinished();
            GamePlayWriter.askRetry();
        } while (PlayService.isRestart(GamePlayReader.readRetryInput()));
    }
}
