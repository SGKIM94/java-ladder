package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoordinateTest {
    static final int X_COORDINATE = 3;
    final Coordinate coordinate = new Coordinate(X_COORDINATE);

    @Test
    public void 왼쪽으로_이동() {
        coordinate.moveLeft();
        assertThat(coordinate.getX()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void X가_0일떄_왼쪽으로_이동한경우() {
        coordinate.setX(0);
        coordinate.moveLeft();
    }

    @Test
    public void 오른쪽으로_이동() {
        coordinate.moveRight();
        assertThat(coordinate.getX()).isEqualTo(4);
    }
}
