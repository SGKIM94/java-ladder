package controller;

import domain.*;

import static view.InputResultFormat.printInputResult;
import static view.LadderFormat.printLadder;
import static view.ParticipantsFormat.printParticipants;
import static view.ResultFormat.printResults;

public class LadderGame {
    private static final String SHOW_ALL_RESULTS = "all";

    /**
     * 최종 결과를 출력하는 메서드
     * @param names
     * @param inputLevel
     * @param result
     * @param wantToShowResult
     */
    public static void main(String names, String inputLevel, String result, String wantToShowResult) {
        //*************************************************
        // 참가자 객체를 생성한다
        //*************************************************
        Participants participants = new Participants(names);
        //*************************************************
        // 난이도 객체를 생성한다
        //*************************************************
        Level level = new Level(inputLevel);
        int vertical = level.getVerticalByLevel();
        //*************************************************
        // 사다리 사이즈 객체를 생성한다
        //*************************************************
        int horizonSize = participants.getSize();
        LadderSize ladderSize = new LadderSize(vertical, horizonSize);
        //*************************************************
        // 사다리게임 객체를 생성한다
        //*************************************************
        domain.LadderGame ladderGame = new domain.LadderGame(ladderSize, level);
        //*************************************************
        // 결과 객체를 생성한다
        //*************************************************
        Results results = new Results(result);
        //*************************************************
        // 결과를 출력한다
        //*************************************************
        printParticipants(participants);
        printLadder(ladderGame);
        printResults(results);

        System.out.println("결과를 보고싶은 사람은?");
        System.out.println(wantToShowResult);

        //*************************************************
        // 모든 참가자의 결과를 출력한다
        //*************************************************
        if (SHOW_ALL_RESULTS.equals(wantToShowResult)) {
            ladderGame.showAllResult(participants, results, ladderSize);
            return;
        }

        //*************************************************
        // 보고자하는 참가자를 입력한 경우 입력된 참가자의 결과만 출력한다
        //*************************************************
        int resultIndex = new LadderResults(participants.getParticipantIndex(wantToShowResult), ladderSize)
                            .makeResult(ladderGame);
        printInputResult(results, resultIndex, wantToShowResult);
    }
}
