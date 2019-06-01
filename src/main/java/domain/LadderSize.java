package domain;

public class LadderSize {
    private int vertical;
    private int horizon;

    //TODO : Level 이 정해져 있으면 ladderSize 에 vertical 을 따로 추가할 필요가 없음
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
