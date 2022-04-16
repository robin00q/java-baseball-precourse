package baseball.game.domain;

import baseball.game.errors.BaseballErrors;
import java.util.List;
import java.util.Objects;

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

    public boolean isBallStatus(List<Baseball> anotherBaseballs) {
        boolean isBall = false;

        for (int i = 0 ; i < anotherBaseballs.size() ; i++) {
            isBall = isBall || this.isSameBallButDifferentPosition(anotherBaseballs.get(i));
        }

        return isBall;
    }

    public boolean isStrikeStatus(List<Baseball> anotherBaseballs) {
        boolean isStrike = false;

        for (int i = 0 ; i < anotherBaseballs.size() ; i++) {
            isStrike = isStrike || this.isSameBallAndSamePosition(anotherBaseballs.get(i));
        }

        return isStrike;
    }

    private boolean isSameBallButDifferentPosition(Baseball anotherBaseball) {
        return this.number == anotherBaseball.number && this.position != anotherBaseball.position;
    }

    private boolean isSameBallAndSamePosition(Baseball anotherBaseball) {
        return this.equals(anotherBaseball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return number == baseball.number && position == baseball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
