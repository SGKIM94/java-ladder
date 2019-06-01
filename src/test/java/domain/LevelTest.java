package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LevelTest {

    @Test
    public void Level_설정에따라_높이가_변한다() {
        final String level = "상";

        assertThat(Level.checkLevel(level)).isEqualTo(15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void level_input_오류() {
        Level.checkLevel("");
    }
}
