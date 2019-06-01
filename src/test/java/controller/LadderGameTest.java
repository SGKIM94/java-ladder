package controller;

import org.junit.Test;

public class LadderGameTest {
    private static final String NAMES = "kim,choi,pack,lee";
    private static final String RESULTS = "1,2,3,4";
    private static final String RESULT_PARTICIPANT = "choi";
    private static final String ALL = "all";
    private static final String INPUT_LEVEL = "상";

    @Test
    public void 사다리_게임_테스트() {
        LadderGame.main(NAMES, INPUT_LEVEL, RESULTS, RESULT_PARTICIPANT);
    }

    @Test
    public void 사다리_게임_전체_출력_테스트() {
        LadderGame.main(NAMES, INPUT_LEVEL, RESULTS, ALL);
    }
}
