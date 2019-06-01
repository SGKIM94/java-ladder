package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderGameTest {
    static final Level LEVEL = new Level("상");
    static final int VERTICAL = LEVEL.getVerticalByLevel();
    static final int HORIZON = 4;
    static final String NAMES = "kim,choi,pack,lee";
    static final int ADD_INDEX = 1;
    public static final int HIGH_LEVEL_PROBABILITY = 2;
    public static final int HIGH_LEVEL_VERTICAL = 20;
    final Points points = new Points("4");
    static final LadderSize LADDERSIZE = new LadderSize(VERTICAL, HORIZON);
    final LadderGame ladderGame = new LadderGame(LADDERSIZE, LEVEL);

    @Test
    public void 사다리_세로축_생성_테스트() {
        List<Boolean> horizon = new ArrayList<>(Arrays.asList(false, false, false, false, true));

        int horizonSize = NAMES.split(",").length;
        Points points = new Points(horizonSize);

        assertThat(points.add(true).toString()).isEqualTo(horizon.toString());
    }

    @Test
    public void 해당_Points가_징검다리가_존재하는지_테스트() {
        points.set(ADD_INDEX, true);

        assertThat(points.hasSteppingStone(ADD_INDEX)).isEqualTo(true);
    }

    @Test
    public void 본인의_사다리의_왼쪽이_true인지_검사하는_테스트() {
        points.set(ADD_INDEX, true);

        assertThat(points.hasSteppingStoneWhereLeft(2)).isEqualTo(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 인덱스로_0이하의_값이_들어갔을경우_에러처리하는지_테스트() {
        points.checkIndexBiggerThanZero(-1);
    }

    @Test
    public void 사다리의_행_개수가_정상적으로_생성되는지_테스트() {
        assertThat(ladderGame.getHorizonSize() * ladderGame.getVerticalSize()).isEqualTo(VERTICAL * HORIZON);
    }

    @Test
    public void 왼쪽에_징검다리가_존재하고_본인도_존재할경우_본인의_징검다리를_제거하는지_테스트() {
        Points points = new Points(HORIZON);

        points.set(0, true).set(1, true);

        points.deleteSteppingStoneWhenLeftHasSteppingStone(1);

        assertThat(points.getSize()).isEqualTo(4);
        assertThat(points.get(1)).isEqualTo(false);
    }

    @Test
    public void 상_난이도를_입력한경우_3의_확률을_리턴한다() {
        assertThat(ladderGame.makeProbability(LEVEL)).isEqualTo(HIGH_LEVEL_PROBABILITY);
    }

    @Test
    public void getVerticalSizeTest() {
        assertThat(ladderGame.getVerticalSize()).isEqualTo(HIGH_LEVEL_VERTICAL);
    }

    @Test
    public void getHorizonSizeTest() {
        assertThat(ladderGame.getHorizonSize()).isEqualTo(HORIZON);
    }
}
