package ec.solmedia.java8.funtionalInterface;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        FunctionalInterfaceExample fi = new FunctionalInterfaceExample();
        fi.realizarOperacion(32, 32);

    }

    private void realizarOperacion(long v1, long v2) {
        Operacion operacion = (n1, n2) -> n1 + n2;
        double suma = operacion.sumar(v1, v2);
        System.out.println("Suma es: " + suma);
    }
}
