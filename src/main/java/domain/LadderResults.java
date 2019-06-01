package domain;

import static domain.MovementGroup.MOVE_LEFT;

public class LadderResults {
    public static final int ONE_DIFFERENCE_BETWEEN_INDEX_AND_SIZE = 1;
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

        if (isStartIndexWhenMoveLeft(startIndex)) {
            return;
        }

        moveRightIfHasSteppingStone(points, startIndex);
    }

    private boolean isStartIndexWhenMoveLeft(int startIndex) {
        return startIndex == (this.ladderSize.getHorizon() - MOVE_LEFT.getValue());
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
        return horizon >= this.ladderSize.getHorizon() - ONE_DIFFERENCE_BETWEEN_INDEX_AND_SIZE;
    }

    private void moveLeftIfHasSteppingStone(Points points, int horizon) {
        if (points.hasSteppingStoneWhereLeft(horizon)) {
            coordinate.moveLeft();
        }
    }
}
