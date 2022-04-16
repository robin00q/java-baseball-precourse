package baseball.game.domain;

import baseball.game.errors.BaseballErrors;

/**
 * VO for Baseballs (immutable)
 */
public class Baseball {

    private static final int MINIMUM_BASEBALL_NUMBER = 1;
    private static final int MAXIMUM_BASEBALL_NUMBER = 9;
    private static final int MINIMUM_BASEBALL_POSITION = 1;
    private static final int MAXIMUM_BASEBALL_POSITION = 3;

    private final int number;
    private final int position;

    public Baseball(int number, int position) {
        validate(number, position);
        this.number = number;
        this.position = position;
    }

    private void validate(int number, int position) {
        if (number < MINIMUM_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_PREFIX +
                    MINIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_NUMBER_MINIMUM_POSTFIX);
        }
        if (number > MAXIMUM_BASEBALL_NUMBER) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_PREFIX +
                    MAXIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_NUMBER_MAXIMUM_POSTFIX);
        }
        if (position < MINIMUM_BASEBALL_POSITION) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_POSITION_PREFIX +
                    MINIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_POSITION_MINIMUM_POSTFIX);
        }
        if (position > MAXIMUM_BASEBALL_POSITION) {
            throw new IllegalArgumentException(BaseballErrors.INVALID_BASEBALL_POSITION_PREFIX +
                    MINIMUM_BASEBALL_NUMBER + BaseballErrors.INVALID_BASEBALL_POSITION_MAXIMUM_POSTFIX);
        }
    }
}
