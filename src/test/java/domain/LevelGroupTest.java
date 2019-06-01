package domain;

import org.junit.Test;

import static domain.LevelGroup.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LevelGroupTest {

    public static final String HIGH_LEVEL = "상";
    public static final String MIDDLE_LEVEL = "중";
    public static final String LOW_LEVEL = "하";

    @Test
    public void  HIGH_LEVEL_정상적으로_가져오는지_테스트() {
        assertThat(findByLevel(new Level(HIGH_LEVEL))).isEqualTo(LevelGroup.HIGH_LEVEL);
    }

    @Test
    public void  MIDDEL_LEVEL_정상적으로_가져오는지_테스트() {
        assertThat(findByLevel(new Level(MIDDLE_LEVEL))).isEqualTo(LevelGroup.MIDDLE_LEVEL);
    }

    @Test
    public void  LOW_LEVEL_정상적으로_가져오는지_테스트() {
        assertThat(findByLevel(new Level(LOW_LEVEL))).isEqualTo(LevelGroup.LOW_LEVEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 정상적은_난이도를_입력하지_않은경우() {
        final String inputLevel = "굿";
        findByLevel(new Level(inputLevel));
    }

    @Test
    public void  getVerticalTest() {
        assertThat(getVertical(new Level(LOW_LEVEL))).isEqualTo(10);
    }

    @Test
    public void  getProbabilityTest() {
        assertThat(getProbability(new Level(LOW_LEVEL))).isEqualTo(4);
    }
}
