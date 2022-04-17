package baseball.game.domain;

import baseball.game.errors.RetryErrors;

public enum RetryRule {

    RESTART("1"),
    DONE("2");

    private final String restartValue;

    RetryRule(String restartValue) {
        this.restartValue = restartValue;
    }

    public String getRestartValue() {
        return restartValue;
    }

    public static RetryRule findByRestartValue(String restartValue) {
        if (RESTART.restartValue.equals(restartValue)) {
            return RESTART;
        }
        if (DONE.restartValue.equals(restartValue)) {
            return DONE;
        }
        throw new IllegalArgumentException(RetryErrors.INVALID_RESTART_INPUT);
    }
}
