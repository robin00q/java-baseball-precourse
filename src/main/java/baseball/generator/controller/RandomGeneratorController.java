package baseball.generator.controller;

import baseball.generator.controller.response.ThreeRandomNumberResponse;
import baseball.generator.service.RandomGeneratorService;
import baseball.generator.service.command.UniqueRandomNumberCommand;
import baseball.generator.service.result.UniqueRandomNumberResult;

public class RandomGeneratorController {

    private final RandomGeneratorService randomGeneratorService;

    public RandomGeneratorController(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    /**
     * 3개의 랜덤한 숫자를 1과 9 사이에서 생성하여 반환한다.
     *
     * @return ThreeRandomNumberResponse 1과 9 사이의 랜덤하게 생성되었으며, 중복되지 않은 숫자 3개
     */
    public ThreeRandomNumberResponse pickThreeUniqueRandomNumbersFromOneToNine() {
        UniqueRandomNumberResult result = randomGeneratorService.pickUniqueRandomNumbers(
                new UniqueRandomNumberCommand(1, 9, 3));

        return ThreeRandomNumberResponse.from(result);
    }
}
