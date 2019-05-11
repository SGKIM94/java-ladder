package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    static final int NUMBER_FOR_MAKING_HORIZON = 1;
    public static final int MAKE_RANDOM_BOOLEAN_NUMBER = 2;
    public static final int TRUE_NUMBER = 1;
    public static final int EDGE_OF_LADDER_HORIZON = 1;

    private List<Points> ladder;

    public Ladder(int vertical, String names) {
        this(String.valueOf(vertical), names);
    }

    public Ladder(String vertical, String names) {
        this.ladder = new ArrayList<>();

        this.ladder = makeLadder(parseInt(vertical), makeHorizon(names));
    }

    public static int makeHorizon(String input) {
        String [] names = separatorNames(input);
        return names.length;
    }

    public static String[] separatorNames(String input) {
        checkNull(input);
        return input.split(",");
    }

    public static void checkNull(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Points> makeLadder(int vertical, int horizon) {
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
        return this.ladder.size();
    }

    public int getVerticalSize() {
        return this.ladder.get(0).getSize();
    }

    public void makeSteppingStoneForPrint(StringBuilder ladderFormatter, int vertical, int horizon, String stone) {
        if (this.ladder.get(vertical).hasSteppingStone(horizon)) {
            ladderFormatter.append(stone);
            return;
        }

        if (horizon == getHorizonSize() - EDGE_OF_LADDER_HORIZON) {
            ladderFormatter.append("|     |");
            return;
        }

        ladderFormatter.append("|     ");
    }
}
