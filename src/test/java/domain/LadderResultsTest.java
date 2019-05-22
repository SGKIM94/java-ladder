package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultsTest {
    static final String NAMES = "hye,sang,jae,jun";
    static final int VERTICAL = 4;
    static final Participants PARTICIPANTS = new Participants(NAMES);
    static final int HORIZON = PARTICIPANTS.getSize();
    static final String INPUT_RESULTS = "100,500,200,400";

    @Test
    public void 참가자와_결과를_매칭하도록_만든다() {
        Results result = new Results(INPUT_RESULTS);
        LadderGame ladderGame = new LadderGame(VERTICAL, NAMES);
        LadderSize ladderSize = new LadderSize(VERTICAL, HORIZON);

        int participantsIndex = PARTICIPANTS.getParticipantIndex("hye");
        LadderResults ladderResults = new LadderResults(participantsIndex, ladderSize);

        int resultIndex = ladderResults.makeResult(ladderGame);

        assertThat(INPUT_RESULTS.split(",")).contains(result.getResult(resultIndex));
    }

    @Test
    public void 모든_참가자의_결과를_리턴한다() {

    }
}
