package baseball.game.util;

import baseball.game.domain.Baseballs;
import camp.nextstep.edu.missionutils.Console;

public class GamePlayReader {

    private GamePlayReader() {
    }

    public static String readPlayerBaseballInput() {
        String playerInput = Console.readLine();

        if (playerInput == null
                || !playerInput.matches(Baseballs.VALID_BASEBALLS_REGEX)) {
            throw new IllegalArgumentException("야구공은 3개만 가능하며, 1~9 숫자만 가능합니다.");
        }

        return playerInput;
    }

    public static String readRetryInput() {
        String retryInput = Console.readLine();

        if (retryInput == null || retryInput.length() != 1) {
            throw new IllegalArgumentException("재시도 요청은 한글자만 가능합니다.");
        }

        return retryInput;
    }

}
