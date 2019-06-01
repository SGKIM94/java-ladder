package view;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderFormatTest {

    @Test
    public void isItTheFarRightTest() {
        assertThat(LadderFormat.isItTheFarRight(4, 3)).isEqualTo(true);
    }
}
