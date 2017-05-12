package ec.solmedia.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 * Examples Java 8 Streams, filter, Collectors, map, etc
 * </p>
 *
 * @author Alejandro Ayala
 */
public class Java8Streams {

    public static void main(String[] args) {
        // Count the empty strings
        List<String> strList = Arrays.asList("abc", "", "ghi", "jkl", "",
                "pqrs");
        long count = strList.stream().filter(x -> x.isEmpty()).count();
        System.out.printf("List %s has %d empty strings %n", strList, count);

        // Count the strins length more 3
        long num = strList.stream().filter(x -> x.length() > 3).count();
        System.out.printf("List %s has %d strins length more than 3 %n",
                strList, num);

        // create other list strins length more than 3
        List<String> filtered = strList.stream().filter(x -> x.length() > 3)
                .collect(Collectors.toList());
        System.out.printf("List %s %n", filtered);

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.", "Canada");
        String G7String = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.printf("G7 are %s %n", G7String);

        List<Integer> numbers = Arrays.asList(5, 7, 1, 2, 5, 7, 3, 9, 7, 8);
        List<Integer> filteredNum = numbers.stream().distinct().map(i -> i * i)
                .collect(Collectors.toList());
        System.out.printf("Original list %s, Filtered list %s %n", numbers,
                filteredNum);

        List<Integer> primes = Arrays
                .asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
                .summaryStatistics();
        System.out.printf("Sum of all numbers %d %n %n", stats.getSum());

        G7.forEach(n -> System.out.println(n));
        System.out.println();

        /**
         * :: (double colon) operator looks similar to score resolution operator
         * of C++
         */
        G7.forEach(System.out::println);
        System.out.println();

        List<String> languages = Arrays.asList("Java", "Scala", "C++",
                "Haskell", "Lisp");
        // filtro(languages, (str) -> str.startsWith("J"));
        // filtro(languages, (str) -> true);
        // filtro(languages, (str) -> str.length() > 4);

        Predicate<String> startWithJ = n -> n.startsWith("S");
        Predicate<String> endsWitha = n -> n.endsWith("a");

        /**
         * We can even combine Predicate using and(), or() And xor() logical
         * functions for example to find names, which starts with J and four
         * letters long, you can pass combination of two Predicate
         */
        languages.stream().filter(startWithJ.or(endsWitha))
                .forEach(t -> System.out.println(t));

        /**
         * applying 12% VAT on each purchase Without lambda expressions:
         */
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        costBeforeTax
                .stream()
                .map((costo) -> costo + .12 * costo)
                .forEach(
                        s -> System.out
                                .printf("El valor con iva es %.2f %n", s));

        double total = costBeforeTax.stream()
                .map((costo) -> costo + .12 * costo)
                .reduce((sum, costo) -> sum + costo).get();

    }

    public static void filtro(List<String> names, Predicate<String> condition) {
        // for(String name : names) {
        // if(condition.test(name)) {
        // System.out.println(name);
        // }
        // }

        names.stream().filter(n -> condition.test(n))
                .forEach(t -> System.out.println(t));
    }

}
