package baseball.game.service;

import baseball.game.domain.Baseballs;
import baseball.game.domain.GameResult;
import baseball.game.domain.RetryRule;
import baseball.game.external.dto.ComputerThreeRandomNumberResponse;
import baseball.game.service.command.PlayerCommand;
import baseball.game.util.GamePlayReader;
import baseball.game.util.GamePlayWriter;

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

    private GameResult play(Baseballs computer) {
        PlayerCommand pCommand = new PlayerCommand(GamePlayReader.readPlayerBaseballInput());
        Baseballs player = new Baseballs(pCommand.getFirst(), pCommand.getSecond(), pCommand.getThird());

        return GameResult.playAndGetGameResult(player, computer);
    }

    private Baseballs getRandomNumberComputer() {
        ComputerThreeRandomNumberResponse response = computerRequestThreeRandomNumber.requestRandomNumber();
        return new Baseballs(response.getFirst(), response.getSecond(), response.getThird());
    }

    public static boolean isRestart(String restartInput) {
        return RetryRule.RESTART == RetryRule.findByRestartValue(restartInput);
    }

}
