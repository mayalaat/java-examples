package ec.solmedia.java8.stream;


import ec.solmedia.java8.entities.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamApiExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("Alejandro", "Ayala", 33);
        Person p2 = new Person("Gonzalo", "Martinez", 30);
        Person p3 = new Person("Ana María", "Martínez", 34);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());

//        for (String name : names) {
//            System.out.println(name);
//        }

        Map<String, Integer> map = new HashMap();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);

        StringBuilder sb = new StringBuilder();
        map.forEach((letter, number) -> sb.append(letter.concat(String.valueOf(number))));
        System.out.println(sb.toString());
    }

}


