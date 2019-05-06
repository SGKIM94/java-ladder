package domain;

import domain.Ladder;
import domain.Points;
import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {
    static final int VERTICAL = 4;
    static final int HORIZON = 4;
    static final String NAMES = "kim,choi,pack,lee";
    static final int ADD_INDEX = 1;
    final Points points = new Points("4");

    @Test(expected = IllegalArgumentException.class)
    public void null_체크_테스트() {
        Ladder.checkNull("");
    }

    @Test
    public void 이름_입력_자르는_테스트() {
        String [] names = Ladder.separatorNames(NAMES);

        assertThat(names.length).isEqualTo(HORIZON);
    }

    @Test
    public void 참여자_길이_테스트() {
        assertThat(Ladder.makeHorizon(NAMES)).isEqualTo(HORIZON);
    }

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
        Ladder ladder = new Ladder(VERTICAL, NAMES);

        assertThat(ladder.getHorizonSize() * ladder.getVerticalSize()).isEqualTo(VERTICAL * HORIZON);
    }

    @Test
    public void 왼쪽에_징검다리가_존재하고_본인도_존재할경우_본인의_징검다리를_제거하는지_테스트() {
        Points points = new Points(HORIZON);

        points.set(0, true);
        points.set(1, true);

        points.deleteSteppingStoneWhenLeftHasSteppingStone(1);

        assertThat(points.getSize()).isEqualTo(4);
        assertThat(points.get(1)).isEqualTo(false);
    }
}
