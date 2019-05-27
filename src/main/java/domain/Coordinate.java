package domain;

import static domain.MovementGroup.MOVE_LEFT;
import static domain.MovementGroup.MOVE_RIGHT;

public class Coordinate {
    public static final int EDGE_OF_START = 0;

    private int x;

    public Coordinate(int x) {
        this.x = x;
    }

    public Coordinate moveLeft() {
        if (isXCoordinationEdgeOfStart()) {
           return this;
        }

        return new Coordinate(this.x - MOVE_LEFT.getValue());
    }

    private boolean isXCoordinationEdgeOfStart() {
        return this.x == EDGE_OF_START;
    }

    public Coordinate moveRight() {
        return new Coordinate(this.x + MOVE_RIGHT.getValue());
    }

    public int getX() {
        return x;
    }
}
