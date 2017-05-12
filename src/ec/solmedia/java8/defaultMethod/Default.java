package ec.solmedia.java8.defaultMethod;

public class Default implements IPersonaA, IPersonaB {

    @Override
    public void caminar() {
        System.out.println("Caminando...");
    }

    @Override
    public void hablar() {
        IPersonaB.super.hablar();
    }

    public static void main(String[] args) {
        Default d = new Default();
        d.caminar();
        d.hablar();
    }
}
