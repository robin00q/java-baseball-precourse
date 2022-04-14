package baseball.generator.service.command;

public class UniqueRandomNumberCommand {

    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public UniqueRandomNumberCommand(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public int getStartInclusive() {
        return startInclusive;
    }

    public int getEndInclusive() {
        return endInclusive;
    }

    public int getCount() {
        return count;
    }
}
