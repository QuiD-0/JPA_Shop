package jpa.jpa_study.playGround.streamGround;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class StreamsTest {

    Streams streams = new Streams();

    @Test
    public void filter_test() {
        System.out.println("streams = " + streams.filter());
    }

    @Test
    public void map_test() {
        System.out.println("streams = " + streams.map());
    }

    @Test
    public void reduce_test() {
        System.out.println("streams = " + streams.reduce());
    }

    @Test
    public void flatMap_test() {
        System.out.println("streams = " + streams.flatMap());
    }

    @Test
    public void nullCheck() {
        streams.nullCheck();
    }

    @Test
    void parallel() {
        System.out.println("streams = " + streams.parallel());
    }

    @Test
    void lotto() {
        System.out.println("streams = " + streams.lotto());
    }

    @Test
    void dice() {
        streams.dice6().forEach(a -> System.out.println(Arrays.toString(a)));
    }
}