package view;

import domain.Ladder;

public class LadderFormat {

    public static void printLadder(Ladder ladder) {
        int horizonSize = ladder.getHorizonSize();
        int verticalSize = ladder.getVerticalSize();
        StringBuilder ladderFormatter = new StringBuilder();

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizonSize; j++) {

                if (j == verticalSize - 1) {
                    ladder.makeSteppingStoneForPrint(ladderFormatter, i, j, "|-----|");
                    continue;
                }

                ladder.makeSteppingStoneForPrint(ladderFormatter, i, j, "|-----");
            }

            ladderFormatter.append("\n");
        }

        System.out.println(ladderFormatter);
    }
}
