package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LevelTest {
    private static String HIGH_LEVEL = "상";
    final Level level = new Level(HIGH_LEVEL);

    @Test
    public void Level_설정에따라_높이가_변한다() {
        assertThat(level.getVerticalByLevel()).isEqualTo(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void level_input_오류() {
        level.checkLevelIsNull("");
    }
}
