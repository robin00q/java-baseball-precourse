package baseball.generator.service.result;

import java.util.List;

public class UniqueRandomNumberResult {

    private final List<Integer> generated;

    public UniqueRandomNumberResult(List<Integer> generated) {
        this.generated = generated;
    }

    public List<Integer> getGenerated() {
        return generated;
    }
}
