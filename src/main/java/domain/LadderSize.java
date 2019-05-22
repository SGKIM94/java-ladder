package domain;

public class LadderSize {
    private int vertical;
    private int horizon;

    public LadderSize(int vertical, int horizon) {
        this.vertical = vertical;
        this.horizon = horizon;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizon() {
        return horizon;
    }
}
