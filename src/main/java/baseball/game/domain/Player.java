package baseball.game.domain;

import baseball.game.errors.PlayerErrors;

public class Player {

    private final Baseballs baseballs;

    public Player(Baseballs baseballs) {
        validate(baseballs);
        this.baseballs = baseballs;
    }

    private void validate(Baseballs baseballs) {
        if (baseballs == null) {
            throw new IllegalArgumentException(PlayerErrors.PLAYER_REQUIRED_BASEBALLS);
        }
    }

    public Baseballs getBaseballs() {
        return baseballs;
    }
}
