package domain;

import static domain.LevelGroup.getProbability;
import static domain.LevelGroup.getVertical;

public class LadderGame {
    public static final int TRUE_NUMBER = 1;
    public static final int EDGE_OF_LADDER_HORIZON = 1;
    public static final int FIRST_INDEX = 0;

    private Ladder ladder;
    private Level level;

    public LadderGame(LadderSize ladderSize, Level level) {
        this.ladder = new Ladder();
        this.level = level;
        this.ladder = makeLadder(ladderSize);
    }

    public Ladder makeLadder(LadderSize ladderSize) {
        int vertical = ladderSize.getVertical();
        int horizon = ladderSize.getHorizon();

        for (int i = 0; i < vertical; i++) {
            this.ladder.add(new Points(horizon));
        }

        for (int i = 0; i < vertical; i++) {
            makeHorizonLadder(horizon, i);
        }

        return this.ladder;
    }

    private void makeHorizonLadder(int horizon, int verticalIndex) {
        for (int j = 0; j < horizon; j++) {
            putIfExistLadder(verticalIndex, j);
        }
    }

    private void putIfExistLadder(int verticalIndex, int horizonIndex) {
        int random = (int)(Math.random() * makeProbability(this.level));

        if (isLadderExist(random)) {
            Points points = this.ladder.get(verticalIndex);
            points.set(horizonIndex, true);

            points.deleteSteppingStoneWhenLeftHasSteppingStone(horizonIndex);
        }
    }

    private boolean isLadderExist(int random) {
        return random == TRUE_NUMBER;
    }

    public int getHorizonSize(){
        return this.ladder.get(FIRST_INDEX).getSize();
    }

    public int getVerticalSize() {
        return getVertical(this.level);
    }

    public StringBuilder makeSteppingStoneForPrint(int verticalIndex, int horizonIndex, String stone) {
        StringBuilder ladderFormatter = new StringBuilder();

        if (this.ladder.hasSteppingStone(verticalIndex, horizonIndex)) {
            ladderFormatter.append(stone);
            return ladderFormatter;
        }

        if (horizonIndex == (getHorizonSize() - EDGE_OF_LADDER_HORIZON)) {
            ladderFormatter.append("|");
            return ladderFormatter;
        }

        ladderFormatter.append("|     ");
        return ladderFormatter;
    }

    public Points getPoints(int verticalIndex) {
        return this.ladder.get(verticalIndex);
    }

    public int makeProbability(Level level) {
        return getProbability(level);
    }
}
