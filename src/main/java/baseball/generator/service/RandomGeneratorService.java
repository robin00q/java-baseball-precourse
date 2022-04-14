package baseball.generator.service;

import baseball.generator.domain.IntegerListGenerator;
import baseball.generator.service.command.UniqueRandomNumberCommand;
import baseball.generator.service.result.UniqueRandomNumberResult;

public class RandomGeneratorService {

    public UniqueRandomNumberResult pickUniqueRandomNumbers(UniqueRandomNumberCommand command) {
        IntegerListGenerator integerListGenerator = IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                command.getStartInclusive(), command.getEndInclusive(), command.getCount());

        return new UniqueRandomNumberResult(integerListGenerator.getAllGeneratedNumbers());
    }

}
