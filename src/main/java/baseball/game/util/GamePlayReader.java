package baseball.game.util;

import baseball.game.domain.Baseballs;
import camp.nextstep.edu.missionutils.Console;

public class GamePlayReader {

    public static final String BASEBALL_CAN_HAVE_THREE_BETWEEN_ONE_TO_NINE = "야구공은 3개만 가능하며, 1~9 숫자만 가능합니다.";
    public static final String RETRY_CAN_HAVE_ONLY_ONE_CHARACTER = "재시도 요청은 한글자만 가능합니다.";
    private GamePlayReader() {
    }

    public static String readPlayerBaseballInput() {
        String playerInput = Console.readLine();

        if (playerInput == null || !playerInput.matches(Baseballs.VALID_BASEBALLS_REGEX)) {
            throw new IllegalArgumentException(BASEBALL_CAN_HAVE_THREE_BETWEEN_ONE_TO_NINE);
        }

        return playerInput;
    }

    public static String readRetryInput() {
        String retryInput = Console.readLine();

        if (retryInput == null || retryInput.length() != 1) {
            throw new IllegalArgumentException(RETRY_CAN_HAVE_ONLY_ONE_CHARACTER);
        }

        return retryInput;
    }

}
