package baseball.baseball.domain;

import baseball.baseball.errors.BaseballErrors;
import java.util.Arrays;
import java.util.List;

public class Baseballs {

    private static final int REQUIRED_BASEBALL_COUNT = 3;

    private final List<Baseball> baseballs;

    public Baseballs(Baseball ball1, Baseball ball2, Baseball ball3) {
        validate(ball1, ball2, ball3);
        this.baseballs = Arrays.asList(ball1, ball2, ball3);
    }

    private void validate(Baseball ball1, Baseball ball2, Baseball ball3) {
        if (ball1 == null || ball2 == null || ball3 == null) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALLS_PREFIX +
                    REQUIRED_BASEBALL_COUNT + BaseballErrors.INVALID_BASEBALLS_POSTFIX);
        }
    }
}
