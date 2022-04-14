package baseball.generator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        assertThatIllegalArgumentException().isThrownBy(
                () -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(startInclusive, endInclusive, 1));
    }

    @DisplayName("endInclusive 와 startInclusive 사이의 숫자보다 더 많은 숫자를 생성하려 할 때")
    @Test
    void invalid_count_then_endInclusive_and_startInclusive() {
        // given
        int count = 10;
        int startInclusive = 1;
        int endInclusive = 9;

        // when, then
        assertThatIllegalArgumentException().isThrownBy(
                () -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                        startInclusive, endInclusive, count));
    }

    @DisplayName("endInclusive 가 Integer.MAX_VALUE 일 때")
    @Test
    void endInclusive_larger_than_INTEGER_MAX_VALUE() {
        // given
        int startInclusive = 123;
        int endInclusive = Integer.MAX_VALUE;
        int count = 1;

        // when, then
        assertThatIllegalArgumentException().isThrownBy(
                () -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                        startInclusive, endInclusive, count));
    }

    @DisplayName("endInclusive - startInclusive 가 Integer.MAX_VALUE 보다 많을때")
    @Test
    void endInclusive_minus_startInclusive_larger_than_INTEGER_MAX_VALUE() {
        // given
        int startInclusive = -1;
        int endInclusive = Integer.MAX_VALUE - 1;
        int count = 1;

        // when, then
        assertThatIllegalArgumentException().isThrownBy(
                () -> IntegerListGenerator.pickRandomUniqueNumbersInRangeWithCount(
                        startInclusive, endInclusive, count));
    }
}