package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Points> ladder;

    public Ladder() {
        this.ladder = new ArrayList<>();
    }

    public Ladder add(Points points) {
        this.ladder.add(points);
        return this;
    }

    public Points get(int index) {
        return this.ladder.get(index);
    }
    public Boolean hasSteppingStone(int index, int horizon) {
        return this.ladder.get(index).hasSteppingStone(horizon);
    }

    public int getSize() {
        return this.ladder.size();
    }

    public int getLadderSize() {
        return this.ladder.get(0).getSize();
    }
}
