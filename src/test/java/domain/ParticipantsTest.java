package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    static final String NAMES = "hye,sang,jae,jun";
    static final int HORIZON = 4;

    Participants participants = new Participants(NAMES);

    @Test(expected = IllegalArgumentException.class)
    public void null_체크_테스트() {
        participants.checkNull("");
    }

    @Test
    public void 이름_입력_자르는_테스트() {
        String [] names = participants.separatorNames(NAMES);

        assertThat(names.length).isEqualTo(HORIZON);
    }

    @Test
    public void 참여자의_이름을_전부_출력하는가() {
        String [] names = NAMES.split(",");

        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name + "  ");
        }

        assertThat(participants.toString().trim()).isEqualTo(String.valueOf(stringBuilder).trim());
    }

}
