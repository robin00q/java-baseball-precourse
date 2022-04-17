package baseball.game.service.command;

public class PlayerCommand {

    private final int first;

    private final int second;

    private final int third;

    public PlayerCommand(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public PlayerCommand(String readLine) {
        this.first = Character.getNumericValue(readLine.charAt(0));
        this.second = Character.getNumericValue(readLine.charAt(1));
        this.third = Character.getNumericValue(readLine.charAt(2));
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }
}
