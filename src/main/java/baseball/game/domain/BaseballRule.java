package baseball.game.domain;

public enum BaseballRule {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    BaseballRule(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
