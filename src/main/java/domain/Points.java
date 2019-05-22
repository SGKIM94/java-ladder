package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.MovementGroup.*;

public class Points {

    List<Boolean> points;

    public Points(String horizon) {
        this(Integer.parseInt(horizon));
    }

    public Points(int horizon) {
        this.points = new ArrayList<>();
        initializePoints(horizon);
    }

    private void initializePoints(int horizon) {
        for (int i = 0; i < horizon; i++) {
            this.points.add(false);
        }
    }

    public Points add(boolean point) {
        this.points.add(point);
        return this;
    }

    public Points set(int index, boolean point) {
        this.points.set(index, point);
        return this;
    }

    public Boolean hasSteppingStone(int index) {
        checkIndexBiggerThanZero(index);

        return this.points.get(index);
    }

    public Boolean hasSteppingStoneWhereLeft(int index) {
        if (isFirstSteppingStone(index)) {
            return false;
        }

        return this.points.get(index - MOVE_LEFT.getValue());
    }

    public Boolean hasSteppingStoneWhereRight(int index) {
        return this.points.get(index);
    }


    private boolean isFirstSteppingStone(int index) {
        if (index < FIRST_STEPPING_STONE.getValue()) {
            return true;
        }
        return false;
    }

    public void checkIndexBiggerThanZero(int index) {
        if (index < POSSIBLE_INDEX_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkIndexBiggerThanOne(int index) {
        if (index - LEFT_STEPPING_STONE.getValue() < POSSIBLE_INDEX_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public Points deleteSteppingStoneWhenLeftHasSteppingStone(int index) {
        if (hasSteppingStoneWhereLeft(index)) {
            set(index, false);
        }

        return this;
    }

    public int getSize() {
        return this.points.size();
    }

    public boolean get(int index) {
        return this.points.get(index);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
