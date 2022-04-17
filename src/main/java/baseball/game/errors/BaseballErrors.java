package baseball.game.errors;

public class BaseballErrors {

    public static final String INVALID_BASEBALL_PREFIX = "야구공의 공 번호는 ";
    public static final String INVALID_BASEBALL_NUMBER_MINIMUM_POSTFIX = " 보다 작을 수 없습니다.";
    public static final String INVALID_BASEBALL_NUMBER_MAXIMUM_POSTFIX = " 보다 클 수 없습니다.";

    public static final String INVALID_BASEBALL_POSITION_PREFIX = "야구공의 위치는 ";
    public static final String INVALID_BASEBALL_POSITION_MINIMUM_POSTFIX = " 보다 작을 수 없습니다.";
    public static final String INVALID_BASEBALL_POSITION_MAXIMUM_POSTFIX = " 보다 클 수 없습니다.";

    public static final String INVALID_BASEBALLS_CANNOT_HAVE_SAME_NUMBER = "야구공은 같은 숫자를 사용할 수 없습니다.";

    private BaseballErrors() {
    }
}
