package baseball;

import baseball.game.service.PlayService;
import baseball.game.service.factory.PlayServiceFactory;

public class Application {
    public static void main(String[] args) {
        PlayService playService = PlayServiceFactory.getRandomNumberBaseballPlayService();
        playService.playUntilThreeStrike();
    }
}
