package domain;

public enum EdgeNumberGroup {
    TRUE_NUMBER(1),
    EDGE_OF_LADDER_HORIZON(1),
    FIRST_INDEX(0);

    private int number;

    EdgeNumberGroup(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
