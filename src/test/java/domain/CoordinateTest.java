package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoordinateTest {
    static final int X_COORDINATE = 3;
    final Coordinate coordinate = new Coordinate(X_COORDINATE);

    @Test
    public void 왼쪽으로_이동() {
        assertThat(coordinate.moveLeft().getX()).isEqualTo(2);
    }

    @Test
    public void X가_0일떄_왼쪽으로_이동한경우() {
        Coordinate zeroCoordinate = new Coordinate(0);
        zeroCoordinate.moveLeft();

        assertThat(zeroCoordinate.getX()).isEqualTo(0);
    }

    @Test
    public void 오른쪽으로_이동() {
        assertThat(coordinate.moveRight().getX()).isEqualTo(4);
    }
}
