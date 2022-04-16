package baseball.game.util;

/**
 * immutable class for Integer
 *
 * this class supports only increaseIfTrue(boolean)
 */
public class IncreasingInteger {

    public static final IncreasingInteger INITIAL_VALUE_ZERO = new IncreasingInteger(0);

    private final int value;

    private IncreasingInteger(int value) {
        this.value = value;
    }

    public IncreasingInteger increaseIfTrue(boolean condition) {
        if (condition) {
            return new IncreasingInteger(value + 1);
        }
        return this;
    }

    public int getValue() {
        return value;
    }
}
