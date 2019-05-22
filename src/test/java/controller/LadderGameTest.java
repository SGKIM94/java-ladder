package controller;

import org.junit.Test;

public class LadderGameTest {
    static final String NAMES = "kim,choi,pack,lee";
    static final int HEIGHT = 4;
    static final String RESULTS = "1,2,3,4";
    static final String RESULT_PARTICIPANT = "choi";
    public static final String ALL = "all";

    @Test
    public void 사다리_게임_테스트() {
        LadderGame.main(NAMES, HEIGHT, RESULTS, RESULT_PARTICIPANT);
    }

    @Test
    public void 사다리_게임_전체_출력_테스트() {
        LadderGame.main(NAMES, HEIGHT, RESULTS, ALL);
    }
}
