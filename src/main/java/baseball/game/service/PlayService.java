package baseball.game.service;

import baseball.game.domain.Baseballs;
import baseball.game.domain.GameResult;
import baseball.game.external.dto.ComputerThreeRandomNumberResponse;
import baseball.game.service.command.PlayerCommand;
import baseball.game.util.GamePlayWriter;
import camp.nextstep.edu.missionutils.Console;

public class PlayService {

    private final ComputerRequestThreeRandomNumber computerRequestThreeRandomNumber;

    public PlayService(ComputerRequestThreeRandomNumber computerRequestThreeRandomNumber) {
        this.computerRequestThreeRandomNumber = computerRequestThreeRandomNumber;
    }

    public void playUntilThreeStrike() {
        Baseballs computer = getRandomNumberComputer();

        GameResult gameResult;
        do {
            GamePlayWriter.printRequireNumber();
            gameResult = play(computer);
            GamePlayWriter.printResult(gameResult);
        } while (!gameResult.isThreeStrike());
    }

    // TODO : input validation
    private GameResult play(Baseballs computer) {
        PlayerCommand pCommand = new PlayerCommand(Console.readLine());
        Baseballs player = new Baseballs(pCommand.getFirst(), pCommand.getSecond(), pCommand.getThird());

        return GameResult.playAndGetGameResult(player, computer);
    }

    private Baseballs getRandomNumberComputer() {
        ComputerThreeRandomNumberResponse response = computerRequestThreeRandomNumber.requestRandomNumber();
        return new Baseballs(response.getFirst(), response.getSecond(), response.getThird());
    }

}
