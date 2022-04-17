package baseball.generator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.generator.errors.GeneratorErrors;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IntegerListGeneratorTest {

    @ParameterizedTest(name = "랜덤한 숫자를 생성할 시, 중복되지 않는지 테스트")
    @CsvSource(value = {
            "1:9:3",
            "1:3:3",
            "1:100:99",
            "1:1:1"
    }, delimiter = ':')
    void pick_random_unique_number(int startInclusive, int endInclusive, int count) {
        // given
        IntegerListGenerator generator = IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                startInclusive, endInclusive, count);

        // when, then
        List<Integer> generatedNumbers = generator.getAllGeneratedNumbers();

        for (Integer generatedNumber : generatedNumbers) {
            assertThat(generatedNumber).isBetween(startInclusive, endInclusive);
        }
        assertThat(generatedNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("endInclusive 보다 startInclusive 가 큰 경우")
    @Test
    void errorInclusive_larger_than_startInclusive() {
        // given
        int startInclusive = 2;
        int endInclusive = 1;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                        startInclusive, endInclusive, 1))
                .withMessageMatching(GeneratorErrors.START_NUMBER_CANNOT_BE_GREATER_THAN_END_NUMBER);
    }

    @DisplayName("endInclusive 와 startInclusive 사이의 숫자보다 더 많은 숫자를 생성하려 할 때")
    @Test
    void invalid_count_then_endInclusive_and_startInclusive() {
        // given
        int count = 10;
        int startInclusive = 1;
        int endInclusive = 9;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                        startInclusive, endInclusive, count))
                .withMessageMatching(GeneratorErrors.COUNT_CANNOT_BE_GREATER_BETWEEN_START_AND_END_NUMBER);
    }
}