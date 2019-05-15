package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {
    private List<String> participants;

    public Participants(String names) {
        this.participants = setParticipant(names);
    }

    public ArrayList<String> setParticipant(String input) {
        String [] names = separatorNames(input);
        return new ArrayList<>(Arrays.asList(names));
    }

    public String[] separatorNames(String input) {
        checkNull(input);
        return input.split(",");
    }

    public void checkNull(String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    public Participants add(String name) {
        this.participants.add(name);

        return this;
    }

    public int getSize() {
        return this.participants.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String participant : participants) {
            stringBuilder.append(participant + "  ");
        }

        return String.valueOf(stringBuilder);
    }
}
