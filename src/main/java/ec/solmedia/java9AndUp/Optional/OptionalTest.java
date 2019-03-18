package ec.solmedia.java9AndUp.Optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> op1 = Optional.of("Optional 1");
        Optional<String> op2 = Optional.ofNullable("Optional 2");
        Optional<String> op3 = Optional.empty();
        Optional<String> op4 = Optional.ofNullable(null);


        // Optional::stream - java 9
        List<String> list = Stream.of(op1, op2, op3, op4).flatMap(Optional::stream).collect(Collectors.toList());
        System.out.println(list); // [Optional 1, Optional 2]

        // ifPresentOrElse - java 9
        op1.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")); // Optional 1
        op2.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")); // Optional 2
        op3.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")); // Empty
        op4.ifPresentOrElse(System.out::println, () -> System.out.println("Empty")); // Empty

        // or - java 9
        System.out.println(op1.or(() -> Optional.of("Empty"))); // Optional[Optional 1]
        System.out.println(op2.or(() -> Optional.of("Empty"))); // Optional[Optional 2]
        System.out.println(op3.or(() -> Optional.of("Empty"))); // Optional[Empty]
        System.out.println(op4.or(() -> Optional.of("Empty"))); // Optional[Empty]

        // orElseThrow
        try {
            System.out.println(op4.orElseThrow(() -> new Exception("Optional null")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
