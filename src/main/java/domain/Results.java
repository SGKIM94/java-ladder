package domain;

import java.util.Arrays;
import java.util.List;

public class Results {
    private static final String DELIMITER = ",";
    private List<String> results;

    public Results(String results) {
        this.results = makeListFromArray(makeResult(results));
    }

    public String[] makeResult(String input) {
        checkInputResultsIsNull(input);

        return input.split(DELIMITER);
    }

    private void checkInputResultsIsNull(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLengthWithParticipant(int length, int participantSize) {
        if (length != participantSize) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> makeListFromArray(String [] array) {
        return Arrays.asList(array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String result : this.results) {
            stringBuilder.append(result + "    ");
        }

        return String.valueOf(stringBuilder);
    }
}
