package baseball.game.service.command;

public class ComputerCommand {

    private final int first;

    private final int second;

    private final int third;

    public ComputerCommand(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
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
