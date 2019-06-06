package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ParticipantTest {
    final String name = "kim";
    Participant participant = new Participant(name);

    @Test(expected = IllegalArgumentException.class)
    public void 참가자_입력값_Null_체크() {
        String name = "";
        participant.checkNull(name);
    }

    @Test
    public void 참가자_값_정상적으로_가져오는가() {
        participant.getName();
    }

    @Test
    public void 참가자_결과_출력_형태() {
        assertThat(participant.getNameFormat()).isEqualTo(participant.getName() + "  ");
    }
}
