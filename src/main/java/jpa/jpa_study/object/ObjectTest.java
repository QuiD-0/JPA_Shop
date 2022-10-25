package jpa.jpa_study.object;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectTest {

    @Test
    public void immutable() {
        Immutable immutable = new Immutable(1);
        Immutable copy = immutable.copy();

        Assertions.assertEquals(copy, immutable);

        Immutable immutable2 = new Immutable(1);
        Immutable copy2 = immutable2.newCopy();

        Assertions.assertNotEquals(copy2, immutable2);
    }


    @Test
    public void mutable() {
        Mutable mutable = new Mutable(1);
        Mutable copy = mutable.copy();

        Assertions.assertEquals(copy, mutable);
        Assertions.assertEquals(copy, mutable);
    }

    @Test
    public void fun() {
        Mutable mutable = new Mutable(10);
        Integer add = mutable.add(1).apply(6);
        System.out.println(add);
        System.out.println(mutable);
    }

}
