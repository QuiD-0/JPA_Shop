package jpa.jpa_study.playGround.dotsGround;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DotsTest {

    public Dots dots = new Dots();

    @Test
    public void stringDotsTest() {
        String[] strings = dots.dotsArgs("one", "Two", "Three");
        assertEquals(strings.length, 3);
    }

    @Test
    public void intDotTest() {
        int[] ints = dots.intDots(1, 2, 3, 4);
        int i = Arrays.stream(ints).reduce(Integer::sum).orElseThrow(IllegalAccessError::new);
        assertEquals(i, 10);
    }

}