package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class JunitExceptionStudyTest {

    @DisplayName("assertThatIllegalArgumentException 테스트")
    @Test
    void assertThatIllegalArgumentException_테스트() {
        // given
        String errorMessage = "Illegal Argument Exception!!";

        // when: none
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    throw new IllegalArgumentException(errorMessage);
                })
                .withMessageMatching(errorMessage);
    }

    @DisplayName("assertThatNullPointerException 테스트")
    @Test
    void assertThatNullPointerException_테스트() {
        // given
        String errorMessage = "NPE!!";

        // when: none
        // then
        assertThatNullPointerException()
                .isThrownBy(() -> {
                    throw new NullPointerException(errorMessage);
                })
                .withMessageMatching(errorMessage);
    }
}
