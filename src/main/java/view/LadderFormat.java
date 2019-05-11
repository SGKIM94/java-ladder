package view;

import domain.Ladder;

public class LadderFormat {
    public static final int EDGE_OF_LADDER_HORIZON = 1;

    public static void printLadder(Ladder ladder) {
        int verticalSize = ladder.getVerticalSize();
        StringBuilder ladderFormatter = new StringBuilder();

        for (int i = 0; i < verticalSize; i++) {
            makeFormatForHorizon(ladder, ladderFormatter, i);

            ladderFormatter.append("\n");
        }

        System.out.println(ladderFormatter);
    }

    private static void makeFormatForHorizon(Ladder ladder, StringBuilder ladderFormatter, int vertical) {
        int horizonSize = ladder.getHorizonSize();
        int verticalSize = ladder.getVerticalSize();

        for (int j = 0; j < horizonSize; j++) {
            if (j == (verticalSize - EDGE_OF_LADDER_HORIZON)) {
                ladder.makeSteppingStoneForPrint(ladderFormatter, vertical, j, "|-----|");
                continue;
            }

            ladder.makeSteppingStoneForPrint(ladderFormatter, vertical, j, "|-----");
        }
    }
}
