package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class JunitStringStudyTest {

    @Test
    void String_클래스에_대한_학습_테스트_split() {
        // given
        String source = "1,2";

        // when
        String[] split = source.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).contains("2");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void String_클래스에_대한_학습_테스트_substring() {
        // given
        String source = "(1,2)";

        // when
        String substring = source.substring(1, source.length() - 1);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드를 사용하여 특정 위치의 문자를 가져온다.")
    @Test
    void String_클래스에_대한_학습_테스트_charAt() {
        // given
        String source = "abc";

        // when: none
        // then
        assertThat(source.charAt(0)).isEqualTo('a');
        assertThat(source.charAt(1)).isEqualTo('b');
        assertThat(source.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> source.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
        // withMessageMatching 은 에러문자열과 완전히 동일해야한다.
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> source.charAt(3))
                .withMessageMatching("String index out of range: 3");
    }



}
