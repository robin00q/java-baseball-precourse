package baseball.game.external;

import baseball.game.external.dto.ComputerThreeRandomNumberResponse;
import baseball.game.service.ComputerRequestThreeRandomNumber;
import baseball.generator.controller.RandomGeneratorController;
import baseball.generator.controller.response.ThreeRandomNumberResponse;
import baseball.generator.service.RandomGeneratorService;

public class ComputerRequestThreeRandomNumberImpl implements ComputerRequestThreeRandomNumber {

    @Override
    public ComputerThreeRandomNumberResponse requestRandomNumber() {
        ThreeRandomNumberResponse response = new RandomGeneratorController(new RandomGeneratorService())
                .pickThreeUniqueRandomNumbersFromOneToNine();

        return new ComputerThreeRandomNumberResponse(response.getFirst(), response.getSecond(), response.getThird());
    }
}
