package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private List<Participant> participants;

    public Participants(String names) {
        this.participants = new ArrayList<>();
        setParticipants(names);
    }

    public void setParticipants(String input) {
        String [] names = separatorNames(input);

        for (String name : names) {
            this.participants.add(new Participant(name));
        }
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

    public int getSize() {
        return this.participants.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String participantFormat;

        for (Participant participant : participants) {
            participantFormat = participant.getNameFormat();
            stringBuilder.append(participantFormat);
        }

        return String.valueOf(stringBuilder);
    }

    public int getParticipantIndex(String name) {
        checkParticipantsHasTheName(name);

        int participantsSize = getSize();
        for (int i = 0; i < participantsSize; i++) {
            if (getParticipant(i).equals(name)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    private void checkParticipantsHasTheName(String name) {
        if (!contains(name)) {
            throw new IllegalArgumentException();
        }
    }

    public String getParticipant(int index) {
        return this.participants.get(index).getName();
    }

    public boolean contains(String name) {
        for (Participant participant : participants) {
            if (participant.equals(name)) {
                return true;
            }
        }
        return false;
    }
}
