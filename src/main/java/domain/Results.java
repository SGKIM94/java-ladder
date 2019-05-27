package domain;

import java.util.Arrays;
import java.util.List;

public class Results {
    private static final String DELIMITER = ",";

    private List<String> results;

    public Results(String results) {
        this.results = makeListFromArray(initializeResult(results));
    }

    public String[] initializeResult(String input) {
        checkInputResultsIsNull(input);

        return input.split(DELIMITER);
    }

    private void checkInputResultsIsNull(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLengthWithParticipant(int length, int participantSize) {
        if (isNotParticipantSizeNotEqualTheLength(length, participantSize)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotParticipantSizeNotEqualTheLength(int length, int participantSize) {
        return length != participantSize;
    }

    private List<String> makeListFromArray(String [] array) {
        return Arrays.asList(array);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String resultFormat;
        for (String result : this.results) {
            resultFormat = result + "    ";
            stringBuilder.append(resultFormat);
        }

        return String.valueOf(stringBuilder);
    }

    public String getResult(int resultIndex) {
        return this.results.get(resultIndex);
    }
}
