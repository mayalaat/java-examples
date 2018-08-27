
package ec.solmedia.java8.defaultMethod;

public interface IPersonaA {

    void caminar();

    /**
     * Comportamiento por defecto
     */
    default void hablar() {
        System.out.println("Hablando.....A");
    }

}
