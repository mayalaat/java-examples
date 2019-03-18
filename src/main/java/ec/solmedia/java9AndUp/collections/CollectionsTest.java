package ec.solmedia.java9AndUp.collections;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsTest {

    public static void main(String[] args) {
        // of - java 9
        List<Integer> list = List.of(1, 3, 5, 7);
//        list.add(9); // java.lang.UnsupportedOperationException java.util.ImmutableCollections
        Set<String> set = Set.of("a", "b", "c");
        Map<Integer, String> map = Map.of(1, "one", 2, "two");

        System.out.println(list); // [1, 3, 5, 7]

        // copyOf - java 10
        List copyOfList = List.copyOf(list);
        Set copyOfSet = Set.copyOf(set);
        Map copyOfMap = Map.copyOf(map);

        System.out.println(copyOfSet); // [c, a, b]
        System.out.println(copyOfMap); // {1=one, 2=two}

        List<String> mutableList = Arrays.asList("d", "e", "f", "g");
        List<String> falseInmutableList = Collections.unmodifiableList(mutableList);
        mutableList.set(0, "x");
        System.out.println(mutableList); // [x, e, f, g]
        System.out.println(falseInmutableList); // [x, e, f, g]

        // Collectors.toUnmodifiableList() - java 10
        mutableList.set(0, "d");
        System.out.println(mutableList); // [d, e, f, g]
        List<String> inmutableList = mutableList.stream().collect(Collectors.toUnmodifiableList());
        mutableList.set(0, "x");
        System.out.println(mutableList); // [x, e, f, g]
        System.out.println(inmutableList); // [d, e, f, g]
    }
}
