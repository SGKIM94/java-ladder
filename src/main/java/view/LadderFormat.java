package view;

import domain.LadderGame;

public class LadderFormat {
    public static final String LINE_BREAK = "\n";
    public static final int EXCEPTION_START_INDEX = 1;

    public static void printLadder(LadderGame ladderGame) {
        int verticalSize = ladderGame.getVerticalSize();
        StringBuilder ladderFormatter = new StringBuilder();

        for (int i = 0; i < verticalSize; i++) {
            ladderFormatter.append(makeFormatForHorizon(ladderGame, i));

            if (isItTheFarRight(verticalSize, i)) {
                continue;
            }

            ladderFormatter.append(LINE_BREAK);
        }

        System.out.println(ladderFormatter);
    }

    private static StringBuilder makeFormatForHorizon(LadderGame ladderGame, int verticalIndex) {
        StringBuilder ladderFormatter = new StringBuilder();
        int horizonSize = ladderGame.getHorizonSize();

        for (int j = 0; j < horizonSize; j++) {
            if (isItTheFarRight(horizonSize, j)) {
                ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(verticalIndex, j, "|"));
                continue;
            }

            ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(verticalIndex, j, "|-----"));
        }

        return ladderFormatter;
    }


    public  static boolean isItTheFarRight(int horizonSize, int horizonIndex) {
        return horizonIndex == (horizonSize - EXCEPTION_START_INDEX);
    }
}
