package baseball.game.external.dto;

public class ComputerThreeRandomNumberResponse {

    private final int first;
    private final int second;
    private final int third;

    public ComputerThreeRandomNumberResponse(int first, int second, int third) {
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
