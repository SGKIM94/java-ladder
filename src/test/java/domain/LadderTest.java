package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    Points points = new Points(4);

    @Test
    public void Ladder_add_test() {
        Ladder ladder = new Ladder();
        ladder.add(points);

        assertThat(ladder.getSize()).isEqualTo(1);
    }
}
