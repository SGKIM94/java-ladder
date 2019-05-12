package controller;

import domain.Participants;

import static view.LadderFormat.printLadder;
import static view.participantsFormat.printParticipants;

public class LadderGame {

    public static void main(String names, int height) {
        domain.LadderGame ladderGame = new domain.LadderGame(height, names);
        Participants participants = new Participants(names);

        printParticipants(participants);
        printLadder(ladderGame);
    }
}
