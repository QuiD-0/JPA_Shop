package jpa.jpa_study.playGround.streamGround;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import jpa.jpa_study.playGround.streamGround.Outer.Nested;
import jpa.jpa_study.playGround.streamGround.Outer.Nested.Inner;

public class Streams {

    List<Integer> integerList = IntStream.range(0, 10).boxed().toList();

    public static String IntToString(Integer num) {
        return num.toString() + "번";
    }

    public List<Integer> filter() {
        return integerList.stream().filter(a -> a % 2 == 0)
            .collect(Collectors.toList());
    }

    public List<String> map() {
        return integerList.stream().map(Streams::IntToString)
            .collect(Collectors.toList());
    }

    public Optional<Integer> reduce() {
        return integerList.stream().reduce(Integer::sum);
    }

    public List<String> flatMap() {
        return Arrays.asList(Arrays.asList("hello".split("")), Arrays.asList("wolrd".split("")))
            .stream().map(Arrays::asList)
            .flatMap(a -> a.stream())
            .flatMap(a -> a.stream())
            .distinct()
            .collect(Collectors.toList());
    }

    public void nullCheck() {
        Inner inner = new Inner("test");
        Nested nested = new Nested(inner);
        Optional.of(new Outer(nested))
            .flatMap(o -> Optional.ofNullable(o.nested))
            .flatMap(n -> Optional.ofNullable(n.inner))
            .flatMap(i -> Optional.ofNullable(i.foo))
            .ifPresent(System.out::println);
    }

    public List<String> parallel() {
        return IntStream.range(0, 7000).boxed()
            .filter(a -> a % 2 == 0)
            .toList()
            .parallelStream()
            .map(String::valueOf)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    public List<Integer> lotto() {
        return new Random().ints(1, 46).distinct().limit(6).boxed().toList();
    }

    public List<Integer[]> dice6() {
        return IntStream.range(1, 6).boxed()
            .flatMap(e -> IntStream.range(1, 6).boxed().map(k -> new Integer[]{e, k}))
            .filter(arr -> arr[0] + arr[1] == 6)
            .collect(Collectors.toList());
    }


}
