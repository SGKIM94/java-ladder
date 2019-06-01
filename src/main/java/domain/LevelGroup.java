package domain;

import java.util.Arrays;

public enum LevelGroup {
    HIGH_LEVEL("상", 20, 2),
    MIDDLE_LEVEL("중", 15, 3),
    LOW_LEVEL("하", 10, 4);

    private String level;
    private int vertical;
    private int probability;

    LevelGroup(String level, int vertical, int probability) {
        this.level = level;
        this.vertical = vertical;
        this.probability = probability;
    }

    public static LevelGroup findByLevel(Level level) {
        return Arrays.stream(LevelGroup.values())
                .filter(e -> e.level.equals(level.getLevel()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 난이도를 입력하셨습니다."));
    }

    public static int getVertical(Level level) {
        return findByLevel(level).vertical;
    }

    public static int getProbability(Level level) {
        return findByLevel(level).probability;
    }
}
