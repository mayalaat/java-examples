/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.solmedia.java8.lambda;

/**
 * @author Alejandro Ayala
 */
public class Scopes {
    public static double n3;
    public double n4;

    public double probarLocalVariable() {
        double v3 = 3;
        IOperacion op = new IOperacion() {
            @Override
            public double calcular(double n1, double n2) {
                return n1 + n2 + n3;
            }
        };
        //return op.calcular(10, 2);

        IOperacion lamba = (n1, n2) -> n1 + n2 + v3;

        return lamba.calcular(6, 2);
    }

    public double probarStaticVariable() {
        IOperacion lambada = (x, y) -> {
            n3 = 2;
            n4 = 4;
            return x + y + n3 + n4;
        };
        return lambada.calcular(32, 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scopes s = new Scopes();
        //System.out.println(s.probarLocalVariable());
        System.out.println(s.probarStaticVariable());
    }

}
