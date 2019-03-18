package ec.solmedia.java9AndUp.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 7, 9);
        System.out.println(list); // [1, 3, 5, 7]

        // .takeWhile - java 9
        List takenList = list.stream().takeWhile(value -> value < 4).collect(Collectors.toList());
        System.out.println(takenList); // [1, 3]

        // .dropWhile - java 9
        List dropList = list.stream().dropWhile(value -> value < 4).collect(Collectors.toList());
        System.out.println(dropList); // [5, 7, 9]

        // Stream.iterate - java 9
        var collection = Stream.iterate(1L, value -> value + 1).limit(10).collect(Collectors.toList());
        System.out.println(collection); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        var iterate = Stream.iterate(1L, value -> value <= 8, value -> value + 1).collect(Collectors.toList());
        System.out.println(iterate); // [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
