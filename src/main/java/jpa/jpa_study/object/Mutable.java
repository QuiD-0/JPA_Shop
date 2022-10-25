package jpa.jpa_study.object;

import java.util.function.Function;

public class Mutable {

    int number;

    public Mutable(int number) {
        this.number = number;
    }

    public Mutable copy() {
        return this;
    }

    public void plus(int value) {
        this.number += value;
    }

    Function<Integer, Integer> add(final int x) {
        return y -> x + y;
    }
}
