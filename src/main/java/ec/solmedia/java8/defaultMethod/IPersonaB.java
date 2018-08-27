package ec.solmedia.java8.defaultMethod;

public interface IPersonaB {

    /**
     * Comportamiento por defecto
     */
    default void hablar() {
        System.out.println("Hablando.....B");
    }

}
