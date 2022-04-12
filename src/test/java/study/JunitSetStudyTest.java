package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class JunitSetStudyTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set 의 크기를 확인하는 학습테스트")
    @Test
    void set_size_test() {
        // given: none
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 Set 에 존재하는지 확인하는 테스트 (@ValueSource 사용)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains_test_value_source(int input) {
        // given: none
        // when : none
        // then
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 활용해 Set 에 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @MethodSource("methodSourceFunction")
    void set_contains_test_csv_source(int input, boolean expected) {
        // given: none
        // when : none
        // then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    static Stream<Arguments> methodSourceFunction() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(4, false),
                Arguments.of(5, false)
        );
    }
}
