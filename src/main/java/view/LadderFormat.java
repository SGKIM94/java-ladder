package view;

import domain.LadderGame;

public class LadderFormat {
    private static final int EDGE_OF_LADDER_HORIZON = 1;

    public static void printLadder(LadderGame ladderGame) {
        int verticalSize = ladderGame.getVerticalSize();
        StringBuilder ladderFormatter = new StringBuilder();

        for (int i = 0; i < verticalSize; i++) {
            ladderFormatter.append(makeFormatForHorizon(ladderGame, i));

            if (i == verticalSize - 1) {
                continue;
            }

            ladderFormatter.append("\n");
        }

        System.out.println(ladderFormatter);
    }

    private static StringBuilder makeFormatForHorizon(LadderGame ladderGame, int vertical) {
        StringBuilder ladderFormatter = new StringBuilder();
        int horizonSize = ladderGame.getHorizonSize();
        int verticalSize = ladderGame.getVerticalSize();

        for (int j = 0; j < horizonSize; j++) {
            if (j == (verticalSize - EDGE_OF_LADDER_HORIZON)) {
                ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(vertical, j, "|"));
                continue;
            }

            ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(vertical, j, "|-----"));
        }

        return ladderFormatter;
    }
}
