package baseball.generator.controller.response;

import baseball.generator.service.result.UniqueRandomNumberResult;

public class ThreeRandomNumberResponse {

    private final int first;
    private final int second;
    private final int third;

    private ThreeRandomNumberResponse(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static ThreeRandomNumberResponse from(UniqueRandomNumberResult result) {
        return new ThreeRandomNumberResponse(result.getGenerated().get(0), result.getGenerated().get(1),
                result.getGenerated().get(2));
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
