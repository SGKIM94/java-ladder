package domain;

import java.util.Arrays;

public enum LevelGroup {
    HIGH_LEVEL("상", 15),
    MIDDLE_LEVEL("중", 10),
    LOW_LEVEL("하", 5);

    LevelGroup(String level, int vertical) {
        this.level = level;
        this.vertical = vertical;
    }

    private String level;
    private int vertical;

    public static LevelGroup findByLevel(String level) {
        return Arrays.stream(LevelGroup.values())
                .filter(e -> e.level.equals(level))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 난이도를 입력하셨습니다."));
    }

    public int getVertical() {
        return this.vertical;
    }
}
