package baseball;

import baseball.game.service.PlayService;
import baseball.game.service.command.ComputerCommand;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayService playService = new PlayService();
        playService.playUntilThreeStrike(new ComputerCommand(1, 2, 3));
    }
}
