package domain;

public enum MovementGroup {
    POSSIBLE_INDEX_NUMBER(0),
    LEFT_STEPPING_STONE(1),
    FIRST_STEPPING_STONE(1),
    MOVE_LEFT(1),
    MOVE_RIGHT(1);

    private int value;

    MovementGroup(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
