package baseball.generator.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 유일한 숫자를 가진 integer list 를 생성하는 Generator
 */
public class IntegerListGenerator {

    private final List<Integer> generated;

    private IntegerListGenerator(List<Integer> generated) {
        this.generated = generated;
    }

    public static IntegerListGenerator pickRandomUniqueNumbersInRangeWithCount(
            int startInclusive, int endInclusive, int count
    ) {
        return new IntegerListGenerator(Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count));
    }

    public List<Integer> getAllGeneratedNumbers() {
        return new ArrayList<>(generated);
    }
}
