package controller;

import domain.Participants;
import domain.Results;

import static view.LadderFormat.printLadder;
import static view.participantsFormat.printParticipants;
import static view.resultFormat.printResults;

public class LadderGame {

    public static void main(String names, int height, String result) {
        domain.LadderGame ladderGame = new domain.LadderGame(height, names);
        Participants participants = new Participants(names);
        Results results = new Results(result);

        printParticipants(participants);
        printLadder(ladderGame);
        printResults(results);
    }
}
