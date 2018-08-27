package ec.solmedia.java8.funtionalInterface;

import java.util.function.Function;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        Operacion operacion = (n1, n2) -> n1 + n2;
        double sum = operacion.sumar(31, 10);
        System.out.println("Suma es: " + sum);

        //Foo foo = (string) -> "Hello, ".concat(string);
        Foo foo = ("Hello, "::concat);
        System.out.println(foo.method("World"));

        add("Hello", foo);

    }

    private static void add(String string, Foo foo) {

    }

    private static void add2(String string, Function<String, String> fn) {
        fn.apply(string);
    }
}
