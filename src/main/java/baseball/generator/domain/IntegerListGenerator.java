package baseball.generator.domain;

import baseball.generator.errors.GeneratorErrors;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerListGenerator {

    private final List<Integer> generated;

    private IntegerListGenerator(List<Integer> generated) {
        this.generated = generated;
    }

    public List<Integer> getAllGeneratedNumbers() {
        return new ArrayList<>(generated);
    }

    /**
     * 범위 내, 유일한 숫자를 생성한다.
     *
     * @param startInclusive 시작 숫자 (포함됨)
     * @param endInclusive 종료 숫자 (포함됨)
     * @param count 생성할 숫자
     *
     * @return 생성된 숫자의 List 를 갖고 있는 IntegerListGenerator
     */
    public static IntegerListGenerator pickRandomUniqueNumbersInRangeWithCount(
            int startInclusive, int endInclusive, int count
    ) {
        validateRandomUniqueNumbersInRangeWithCount(startInclusive, endInclusive, count);
        Set<Integer> generatedSet = new HashSet<>();

        while (generatedSet.size() < count) {
            generatedSet.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }

        return new IntegerListGenerator(new ArrayList<>(generatedSet));
    }

    private static void validateRandomUniqueNumbersInRangeWithCount(int startInclusive, int endInclusive, int count) {
        if (endInclusive < startInclusive) {
            throw new IllegalArgumentException(GeneratorErrors.START_NUMBER_CANNOT_BE_GREATER_THAN_END_NUMBER);
        }

        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException(GeneratorErrors.COUNT_CANNOT_BE_GREATER_BETWEEN_START_AND_END_NUMBER);
        }
    }
}
