package ec.solmedia.java8.MetodosReferenciados;


import java.util.Arrays;

public class MetodosReferenciados {

    public static void metodoReferenciado() {
        System.out.println("Metodo Static referenciado");
    }

    public void objetoArbitrario() {
        String[] cadena = {"IPA", "Stouch", "PALE ALE"};

        Arrays.sort(cadena, (s1, s2) -> s1.compareToIgnoreCase(s2));
        Arrays.sort(cadena, String::compareToIgnoreCase);
    }

    public void metodoParticular() {
        System.out.println("metodo particular");
    }

    public void objetoParticular() {
        IPerson iPerson = Person::new;
    }

    public static void main(String[] args) {
        MetodosReferenciados mr = new MetodosReferenciados();
        mr.ejecutar();

        Costumbres costumbres = mr::metodoParticular;
        //costumbres.saludar();
    }

    private void ejecutar() {
        Costumbres costumbres = () -> MetodosReferenciados.metodoReferenciado();
        costumbres.saludar();
        //se reemplaza la lambda por un metodor referencia
        Costumbres costumbres2 = MetodosReferenciados::metodoReferenciado;
        costumbres2.saludar();
    }
}
