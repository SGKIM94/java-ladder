package domain;

import static domain.EdgeNumberGroup.*;
import static domain.LevelGroup.getProbability;
import static domain.LevelGroup.getVertical;
import static view.InputResultFormat.printInputResult;

public class LadderGame {
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
        return random == TRUE_NUMBER.getNumber();
    }

    public int getHorizonSize(){
        return this.ladder.get(FIRST_INDEX.getNumber()).getSize();
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

        if (horizonIndex == (getHorizonSize() - EDGE_OF_LADDER_HORIZON.getNumber())) {
            ladderFormatter.append("|");
            return ladderFormatter;
        }

        ladderFormatter.append("|     ");
        return ladderFormatter;
    }

    /**
     * 모든 참가자의 결과를 출력한다
     * @param participants
     * @param results
     * @param ladderSize
     */
    public void showAllResult(Participants participants, Results results, LadderSize ladderSize) {
        int horizonSize = ladderSize.getHorizon();
        for (int i = 0; i < horizonSize; i++) {
            printInputResult(results, new LadderResults(i, ladderSize).makeResult(this), participants.getParticipant(i));
        }
    }

    public Points getPoints(int verticalIndex) {
        return this.ladder.get(verticalIndex);
    }

    public int makeProbability(Level level) {
        return getProbability(level);
    }
}
