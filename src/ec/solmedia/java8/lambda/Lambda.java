/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.solmedia.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alejandro Ayala
 */
public class Lambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.ordenar();
        lambda.calcular();

    }

    public void ordenar() {
        List<String> lista = new ArrayList<>();
        lista.add("Alemania");
        lista.add("Zuriname");
        lista.add("Ecuador");


        /*OLD JAVA 6*/
        /*Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/

        /*LAMDA*/
        //Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
        //Collections.sort(lista, Comparator.naturalOrder());
        //Collections.sort(lista, Comparator.reverseOrder());
        //Collections.sort(lista, String::compareTo);
        lista.sort(String::compareTo);

        for (String string : lista) {
            System.out.println(string);
        }
    }

    public void calcular() {
        /*IOperacion iOperacion = new IOperacion() {
            @Override
            public double calcular(double n1, double n2) {
                return (n1 + n2) / 2;
            }
        };
        
        System.out.println("Calcular calcular: " + iOperacion.calcular(23, 4));*/


        //IOperacion iOperacion = (double x, double y) -> (x + y) / 2;
        IOperacion iOperacion = (x, y) -> (x + y) / 2;

        System.out.println("Calcular promedio: " + iOperacion.calcular(32, 2));
    }
}
