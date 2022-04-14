package baseball.generator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.generator.controller.response.ThreeRandomNumberResponse;
import baseball.generator.service.RandomGeneratorService;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorControllerTest {

    @DisplayName("랜덤한 숫자를 3개 생성하는 컨트롤러를 테스트한다.")
    @Test
    void test() {
        // given
        RandomGeneratorController controller = new RandomGeneratorController(new RandomGeneratorService());

        // when
        ThreeRandomNumberResponse response = controller.pickThreeUniqueRandomNumbersFromOneToNine();

        // then
        int first = response.getFirst();
        int second = response.getSecond();
        int third = response.getThird();

        assertThat(first).isBetween(1, 9);
        assertThat(second).isBetween(1, 9);
        assertThat(third).isBetween(1, 9);
        assertThat(Arrays.asList(first, second, third)).doesNotHaveDuplicates();
    }

}