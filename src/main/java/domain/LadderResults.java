package domain;

public class LadderResults {
    private Coordinate coordinate;
    private LadderSize ladderSize;

    public LadderResults(int participantIndex, LadderSize ladderSize) {
        this.coordinate = new Coordinate(participantIndex);
        this.ladderSize = ladderSize;
    }

    public int makeResult(LadderGame ladderGame) {
        int vertical = this.ladderSize.getVertical();
        for (int i = 0; i < vertical; i++) {
            moveHorizonAsMakingResult(this.coordinate.getX(), ladderGame.getPoints(i));
        }

        return coordinate.getX();
    }

    private void moveHorizonAsMakingResult(int startIndex, Points points) {
        moveLeftIfHasSteppingStone(points, startIndex);

        if (startIndex == this.ladderSize.getHorizon() - 1) {
            return;
        }

        moveRightIfHasSteppingStone(points, startIndex);
    }

    private void moveRightIfHasSteppingStone(Points points, int horizon) {
        if (isMoreThanMaxHorizon(horizon)) {
            return;
        }

        if (points.hasSteppingStoneWhereRight(horizon)) {
            coordinate.moveRight();
        }
    }

    private boolean isMoreThanMaxHorizon(int horizon) {
        return horizon >= this.ladderSize.getHorizon();
    }

    private void moveLeftIfHasSteppingStone(Points points, int horizon) {
        if (points.hasSteppingStoneWhereLeft(horizon)) {
            coordinate.moveLeft();
        }
    }
}
