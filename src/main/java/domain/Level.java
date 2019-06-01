package domain;

import static domain.LevelGroup.getVertical;

public class Level {
    private String level;

    public Level(String level) {
        checkLevelIsNull(level);
        this.level = level;
    }

    public int getVerticalByLevel() {
        return getVertical(this);
    }

    public void checkLevelIsNull(String level) {
        if (level.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String getLevel() {
        return this.level;
    }
}
