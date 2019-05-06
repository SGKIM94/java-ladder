package controller;

import domain.Ladder;

import static view.LadderFormat.printLadder;

public class LadderGame {

    public static void main(String names, int height) {
        Ladder ladder = new Ladder(height, names);

        printLadder(ladder);
    }
}
