/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentatie;

import java.util.Scanner;
import static logica.Woord.telLetter;

/**
 *
 * @author Ruben
 * @version februari 2019
 */
public class ConsoleStatisch {

    public static void main(String[] args) {
        char karakter = 'a';
        String woord = "";
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Geef woord: ");
            woord = scan.next();
            if (!woord.equals(".")) {
                do {
                    System.out.println("Geef een letter: ");
                    karakter = scan.next().charAt(0);
                    if (karakter != '.') {
                        System.out.println("De letter " + karakter + " komt " + telLetter(woord, karakter) + " keer voor in woord " + woord);
                    }
                } while (karakter != '.');
            }
        } while (!woord.equals("."));
    }
}
