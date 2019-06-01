package domain;

public class Level {
    public static int checkLevel(String level) {
        checkLevelIsNull(level);

        return LevelGroup.findByLevel(level).getVertical();
    }

    private static void checkLevelIsNull(String level) {
        if (level.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
