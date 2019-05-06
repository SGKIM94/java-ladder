package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointsTest {

    @Test
    public void points_생성_테스트() {
        Points points = new Points(5);

        assertThat(points.getSize()).isEqualTo(5);
    }
}
