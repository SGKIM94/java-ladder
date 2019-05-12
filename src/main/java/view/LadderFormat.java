package view;

import domain.LadderGame;

public class LadderFormat {
    public static final int EDGE_OF_LADDER_HORIZON = 1;

    public static void printLadder(LadderGame ladderGame) {
        int verticalSize = ladderGame.getVerticalSize();
        StringBuilder ladderFormatter = new StringBuilder();

        for (int i = 0; i < verticalSize; i++) {
            makeFormatForHorizon(ladderGame, ladderFormatter, i);

            ladderFormatter.append("\n");
        }

        System.out.println(ladderFormatter);
    }

    private static void makeFormatForHorizon(LadderGame ladderGame, StringBuilder ladderFormatter, int vertical) {
        int horizonSize = ladderGame.getHorizonSize();
        int verticalSize = ladderGame.getVerticalSize();

        for (int j = 0; j < horizonSize; j++) {
            if (j == (verticalSize - EDGE_OF_LADDER_HORIZON)) {
                ladderGame.makeSteppingStoneForPrint(ladderFormatter, vertical, j, "|");
                continue;
            }

            ladderGame.makeSteppingStoneForPrint(ladderFormatter, vertical, j, "|-----");
        }
    }
}
