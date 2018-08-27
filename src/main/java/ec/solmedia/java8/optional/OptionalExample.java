/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.solmedia.java8.optional;

import java.util.Optional;

/**
 *
 * @author maaa220817
 */
public class OptionalExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = null;

        if (name != null) {
            System.out.println("Name: " + name);
        }

        Optional<String> optionalName = Optional.ofNullable(name);
        optionalName.ifPresent(value -> System.out.println("Name" + value));

        //orElse
        System.out.println(optionalName.orElse("Alejandro")); //: Alejandro

        //orElseGet
        System.out.println(optionalName.orElseGet(() -> "Alejandro"));
        System.out.println("");

        //Difference Between orElse and orElseGet
        Optional<String> optionalLastName = Optional.ofNullable("Ayala");
        System.out.println("===== orElse() =====");
        System.out.println(optionalLastName.orElse(getName()));
        System.out.println("===== orElseGet() =====");
        System.out.println(optionalLastName.orElseGet(() -> getName()));
        /**
         * ****** Result:************** 
         * ===== orElse() ===== 
         * Call method getName 
         * Ayala 
         * ===== orElseGet() ===== 
         * Ayala
         */

        //orElseThrow
        try {
            optionalName.orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException excepcion) {
            System.err.println(excepcion);
        }

        //get WILL DEPRECATED
        /*
        Throws: NoSuchElementException - if there is no value present
         */
        //optionalName.get();
        //filter
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println("is 2016 " + is2016); //: is 2016 true
        System.out.println("OLD Price is in range 10: " + priceIsInRangeOld(new Article(10.0)));
        System.out.println("OLD Price is in range 9.9: " + priceIsInRangeOld(new Article(9.9)));
        System.out.println("OLD Price is in range null: " + priceIsInRangeOld(null));
        System.out.println("OLD Price is in range 15.5: " + priceIsInRangeOld(new Article(15.5)));

        System.out.println("Optional Price is in range 10: " + priceIsInRangeOptional(new Article(10.0)));
        System.out.println("Optional Price is in range 9.9: " + priceIsInRangeOptional(new Article(9.9)));
        System.out.println("Optional Price is in range null: " + priceIsInRangeOptional(null));
        System.out.println("Optional Price is in range 15.5: " + priceIsInRangeOptional(new Article(15.5)));

        //map
        String password = " password";
        Optional passwordOptional = Optional.ofNullable(password);
        System.out.println("Shoud be equal " + passwordOptional.filter(pass -> pass.equals("password")).isPresent());
        //System.out.println("Is equal " + passwordOptional.map(String::trim).filter(pass -> pass.equals("password")).isPresent());

        //flatMap
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);
        //without flatmap
        System.out.println("Person name: " + personOptional.map(Person::getName).get());//: Person name: Optional[john]
        System.out.println("Person name: " + personOptional.map(Person::getName).get().get());//: Person name: john
        //with flatmap
        System.out.println("Person name: " + personOptional.flatMap(Person::getName).get());//: Person name: john

        //Refs
        //http://www.baeldung.com/java-optional
    }

    public static String getName() {
        System.out.println("Call method getName");
        return "Default name";
    }

    public static boolean priceIsInRangeOld(Article article) {
        boolean isInRange = false;

        if (article != null && article.getPrice() != null
                && article.getPrice() >= 10 && article.getPrice() <= 15) {
            isInRange = true;
        }
        return isInRange;
    }

    public static boolean priceIsInRangeOptional(Article article) {
        Optional<Article> articleOptional = Optional.ofNullable(article);

        return articleOptional.map(Article::getPrice)
                .filter(valor -> valor >= 10)
                .filter(valor -> valor <= 15)
                .isPresent();
    }

}
