package controller;

import domain.*;

import static view.InputResultFormat.printInputResult;
import static view.LadderFormat.printLadder;
import static view.ParticipantsFormat.printParticipants;
import static view.ResultFormat.printResults;

public class LadderGame {
    private static final String SHOW_ALL_RESULTS = "all";

    public static void main(String names, int height, String result, String wantToShowResult) {
        domain.LadderGame ladderGame = new domain.LadderGame(height, names);
        Participants participants = new Participants(names);
        Results results = new Results(result);
        int horizonSize = participants.getSize();
        LadderSize ladderSize = new LadderSize(height, horizonSize);

        printParticipants(participants);
        printLadder(ladderGame);
        printResults(results);

        System.out.println("결과를 보고싶은 사람은?");
        System.out.println(wantToShowResult);

        if (SHOW_ALL_RESULTS.equals(wantToShowResult)) {
            showAllResult(ladderGame, participants, results, ladderSize);
            return;
        }

        int resultIndex = new LadderResults(participants.getParticipantIndex(wantToShowResult), ladderSize)
                            .makeResult(ladderGame);
        printInputResult(results, resultIndex, wantToShowResult);
    }

    private static void showAllResult(domain.LadderGame ladderGame, Participants participants, Results results, LadderSize ladderSize) {
        int horizonSize = ladderSize.getHorizon();
        for (int i = 0; i < horizonSize; i++) {
            printInputResult(results, new LadderResults(i, ladderSize).makeResult(ladderGame), participants.get(i));
        }
    }
}
