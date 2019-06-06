package domain;

import java.util.Objects;

public class Participant {
    private String name;

    public Participant(String name) {
        checkNull(name);
        this.name = name;
    }

    public void checkNull(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("참가자의 이름이 존재하지 않습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getNameFormat() {
        return this.name + "  ";
    }

    public boolean equals(String name) {
        if (name.isEmpty()) {
            return false;
        }

        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
