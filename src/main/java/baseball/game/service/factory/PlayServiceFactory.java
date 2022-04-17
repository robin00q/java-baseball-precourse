package baseball.game.service.factory;

import baseball.game.external.ComputerRequestThreeRandomNumberImpl;
import baseball.game.service.PlayService;

/**
 * 플레이 서비스를 생성하는 팩토리
 */
public class PlayServiceFactory {

    private PlayServiceFactory() {
    }

    /**
     * ComputerRequestThreeRandomNumberImpl 을 주입하여 PlayService 를 반환한다.
     * - 랜덤으로 생성된 컴퓨터의 야구공을 플레이어가 맞추는 게임이다.
     *
     * @return ComputerRequestThreeRandomNumberImpl 이 주입된 PlayService
     */
    public static PlayService getRandomNumberBaseballPlayService() {
        return new PlayService(new ComputerRequestThreeRandomNumberImpl());
    }

}
