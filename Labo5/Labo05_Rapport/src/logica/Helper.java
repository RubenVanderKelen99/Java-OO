/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.DecimalFormat;


/**
 *
 * @author Ruben
 * @version maart 2019
 */

public class Helper {

    public static double afronden(double getal, int digitsNaKomma) {

        int X = (int) Math.pow(10, digitsNaKomma); //10 tot het getal

        getal = getal * X;
        getal = Math.round(getal);
        getal = getal / X;

        return getal;
    }

    public static double zoekGemiddelde(int[] getallen) {
        int total = 0;
        double outcome = 0;
        int length = getallen.length;

        for (int i = 0; i < length; i++) { //lenght is bv 4
            total += getallen[i];  // 1 + 2 + 3 + 4 = 10
        }

        total = total * 100; // 1000
        outcome = total / length;
        outcome = outcome / 100;
        return outcome;
    }

    public static int ggd(int a, int b) {

        do {
            if (a > b) {

                a = a - b;
            } else {
                b = b - a;
            }

        } while (a != b);

        return a;
    }

    public static int kgv(int a, int b) {

        if (a == 0 && b == 0) {
            return 0;
        } else {

            return (a * b) / ggd(a, b);
        }

    }

    public static void main(String[] args) {

        // System.out.println(afronden(72.5426, 2));
        //System.out.println(ggd(100, 25));
        // System.out.println(kgv(100, 25));
        System.err.println(zoekGemiddelde(new int[]{1, 2, 3, 4}));
    }
}
