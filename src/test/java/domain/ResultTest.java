package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {
    static final String input = "꽝,500,꽝,1000";
    final Participants participants = new Participants("김,혜,박");
    Results result = new Results(input);

    @Test
    public void 결과_입력_값_분리_테스트() {
        assertThat(result.makeResult(input)).isEqualTo(new String[]{"꽝", "500", "꽝", "1000"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력값_Null_체크() {
        result.makeResult("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력값_공백시_Null_예외_체크() {
        result.makeResult("   ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이값이_사람수와_일치하는지_않는경우_예외_테스트() {
        result.checkLengthWithParticipant(result.makeResult(input).length, participants.getSize());
    }
}
