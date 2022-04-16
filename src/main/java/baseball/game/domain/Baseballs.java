package baseball.game.domain;

import java.util.Arrays;
import java.util.List;

public class Baseballs {

    private static final int FIRST_POSITION = 1;
    private static final int SECOND_POSITION = 2;
    private static final int THIRD_POSITION = 3;

    private final List<Baseball> baseballs;

    public Baseballs(int ball1, int ball2, int ball3) {
        this.baseballs = Arrays.asList(
                new Baseball(ball1, FIRST_POSITION),
                new Baseball(ball2, SECOND_POSITION),
                new Baseball(ball3, THIRD_POSITION));
    }
}
