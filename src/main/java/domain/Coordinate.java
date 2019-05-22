package domain;

import static domain.MovementGroup.MOVE_LEFT;
import static domain.MovementGroup.MOVE_RIGHT;

public class Coordinate {
    public static final int EDGE_OF_START = 0;

    private int x;
    private int y;

    public Coordinate(int x) {
        this.x = x;
        this.y = 0;
    }

    public Coordinate moveLeft() {
        if (getX() == EDGE_OF_START) {
           return this;
        }

        setX(getX() - MOVE_LEFT.getValue());
        return this;
    }

    public Coordinate moveRight() {
        setX(getX() + MOVE_RIGHT.getValue());
        return this;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
