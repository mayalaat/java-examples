package ec.solmedia.java8.stream;


import ec.solmedia.java8.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamApiExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("Alejandro", "Ayala", 88);
        Person p2 = new Person("Arturo", "Suarez", 73);
        Person p3 = new Person("Ana María", "Martínez", 34);
        Person p4 = new Person("Alan", "Perez", 6);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());

        names.forEach(System.out::println);

        Supplier<Stream<Person>> streamSupplier = people::stream;
        List<Predicate<Person>> predicates = new ArrayList<>();

        //add dynamic predicates
        predicates.add(byFirstName());
        predicates.add(byOldAge());

        Predicate<Person> predicate = predicates.stream().reduce(person -> true, Predicate::and);

        List<Person> collect = streamSupplier.get().filter(predicate).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    private static Predicate<Person> byFirstName() {
        return (Person person) -> person.getName().startsWith("A");
    }

    private static Predicate<Person> byOldAge() {
        return (Person person) -> person.getAge() > 65;
    }

}


