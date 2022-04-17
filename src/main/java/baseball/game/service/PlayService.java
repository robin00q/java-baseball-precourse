package baseball.game.service;

import baseball.game.domain.Baseballs;
import baseball.game.domain.GameResult;
import baseball.game.service.command.ComputerCommand;
import baseball.game.service.command.PlayerCommand;
import baseball.game.util.GamePlayWriter;
import camp.nextstep.edu.missionutils.Console;

public class PlayService {

    public void playUntilThreeStrike(ComputerCommand cCommand) {
        Baseballs computer = new Baseballs(cCommand.getFirst(), cCommand.getSecond(), cCommand.getThird());

        GameResult gameResult;
        do {
            GamePlayWriter.printRequireNumber();
            gameResult = play(computer);
            GamePlayWriter.printResult(gameResult);
        } while(!gameResult.isThreeStrike());
    }

    // TODO : input validation
    private GameResult play(Baseballs computer) {
        PlayerCommand pCommand = new PlayerCommand(Console.readLine());
        Baseballs player = new Baseballs(pCommand.getFirst(), pCommand.getSecond(), pCommand.getThird());

        return GameResult.playAndGetGameResult(player, computer);
    }

}
