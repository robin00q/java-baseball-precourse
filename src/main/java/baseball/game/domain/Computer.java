package baseball.game.domain;

import baseball.game.errors.ComputerErrors;

public class Computer {

    private final Baseballs baseballs;

    public Computer(Baseballs baseballs) {
        validate(baseballs);
        this.baseballs = baseballs;
    }

    public Baseballs getBaseballs() {
        return baseballs;
    }

    private void validate(Baseballs baseballs) {
        if (baseballs == null) {
            throw new IllegalArgumentException(ComputerErrors.COMPUTER_REQUIRED_BASEBALLS);
        }
    }
}
