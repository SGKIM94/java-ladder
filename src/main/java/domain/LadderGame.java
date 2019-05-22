package domain;

public class LadderGame {
    public static final int MAKE_RANDOM_BOOLEAN_NUMBER = 2;
    public static final int TRUE_NUMBER = 1;
    public static final int EDGE_OF_LADDER_HORIZON = 1;

    private Ladder ladder;
    private Participants participants;

    public LadderGame(int vertical, String names) {
        this(String.valueOf(vertical), names);
    }

    public LadderGame(String vertical, String names) {
        this.ladder = new Ladder();
        this.participants = new Participants(names);
        this.ladder = makeLadder(parseInt(vertical), getHorizonLength(names));
    }

    public int getHorizonLength(String input) {
        return this.participants.separatorNames(input).length;
    }

    public Ladder makeLadder(int vertical, int horizon) {
        for (int i = 0; i < vertical; i++) {
            this.ladder.add(new Points(horizon));
        }

        for (int i = 0; i < vertical; i++) {
            makeHorizonLadder(horizon, i);
        }

        return this.ladder;
    }

    private void makeHorizonLadder(int horizon, int vertical) {
        for (int j = 0; j < horizon; j++) {
            putIfHavingPoint(vertical, j);
        }
    }

    private void putIfHavingPoint(int vertical, int index) {
        int random = (int)(Math.random() * MAKE_RANDOM_BOOLEAN_NUMBER);

        if (random == TRUE_NUMBER) {
            Points points = this.ladder.get(vertical);
            points.set(index, true);

            points.deleteSteppingStoneWhenLeftHasSteppingStone(index);
        }
    }

    private int parseInt(String vertical) {
        return Integer.parseInt(vertical);
    }

    public int getHorizonSize(){
        return this.ladder.getSize();
    }

    public int getVerticalSize() {
        return this.ladder.getLadderSize();
    }

    public StringBuilder makeSteppingStoneForPrint(int vertical, int horizon, String stone) {
        StringBuilder ladderFormatter = new StringBuilder();

        if (this.ladder.hasSteppingStone(vertical,horizon)) {
            ladderFormatter.append(stone);
            return ladderFormatter;
        }

        if (horizon == (getHorizonSize() - EDGE_OF_LADDER_HORIZON)) {
            ladderFormatter.append("|");
            return ladderFormatter;
        }

        ladderFormatter.append("|     ");
        return ladderFormatter;
    }

    public Points getPoints(int verticalIndex) {
        return this.ladder.get(verticalIndex);
    }
}
