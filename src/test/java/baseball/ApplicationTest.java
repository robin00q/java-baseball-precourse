package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.game.util.GamePlayReader;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터의_숫자가_123인경우_맞춰보는테스트_이후_즉시종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "213", "231", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "2볼 1스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 올바르지않은_숫자야구공을입력하면_바로종료() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching(GamePlayReader.BASEBALL_CAN_HAVE_THREE_BETWEEN_ONE_TO_NINE)
        );
    }

    @Test
    void 올바르지않은_재시도를하면_바로종료() {
        // given
        String invalidRetryInput = "123";

        // when, then
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("456", "789", "213", "231", "123", invalidRetryInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageMatching(GamePlayReader.RETRY_CAN_HAVE_ONLY_ONE_CHARACTER),
                1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
