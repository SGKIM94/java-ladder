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

    private static StringBuilder makeFormatForHorizon(LadderGame ladderGame, int vertical) {
        StringBuilder ladderFormatter = new StringBuilder();
        int horizonSize = ladderGame.getHorizonSize();
        int verticalSize = ladderGame.getVerticalSize();

        for (int j = 0; j < horizonSize; j++) {
            if (isItTheFarRight(verticalSize, j)) {
                ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(vertical, j, "|"));
                continue;
            }

            ladderFormatter.append(ladderGame.makeSteppingStoneForPrint(vertical, j, "|-----"));
        }

        return ladderFormatter;
    }


    private static boolean isItTheFarRight(int verticalSize, int index) {
        return index == (verticalSize - EXCEPTION_START_INDEX);
    }
}
