package jpa.jpa_study.object;

public class Immutable {

    private final int number;

    public Immutable(int number) {
        this.number = number;
    }

    public Immutable copy() {
        return this;
    }

    public Immutable newCopy() {
        return new Immutable(this.number);
    }

    public Immutable plus(int value) {
        return new Immutable(this.number + value);
    }
}

