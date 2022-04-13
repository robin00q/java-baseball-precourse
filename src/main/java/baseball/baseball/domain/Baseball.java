package baseball.baseball.domain;

import baseball.baseball.errors.BaseballErrors;

public class Baseball {

    private static final int MINIMUM_BASEBALL_NUMBER = 1;
    private static final int MAXIMUM_BASEBALL_NUMBER = 9;

    private final int number;

    public Baseball(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_PREFIX +
                    MINIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_MINIMUM_POSTFIX);
        }
        if (number > MAXIMUM_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_PREFIX +
                    MAXIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_MAXIMUM_POSTFIX);
        }
    }
}
