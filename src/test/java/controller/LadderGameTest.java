package controller;

import org.junit.Test;

public class LadderGameTest {
    static final String NAMES = "kim,choi,pack,lee";
    static final int HEIGHT = 4;

    @Test
    public void 사다리_게임_테스트() {
        LadderGame.main(NAMES, HEIGHT);
    }
}
