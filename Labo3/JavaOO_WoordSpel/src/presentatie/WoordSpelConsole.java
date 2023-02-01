/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentatie;

import java.util.Scanner;
import logica.WoordSpel;

/**
 *
 * @author Ruben
 * @version maart 2019
 */
public class WoordSpelConsole {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WoordSpel spel = new WoordSpel();
        String antwoord;
        do {
            System.out.println("Geef je letter of het volledige woord : ");
            antwoord = sc.nextLine();
            if (antwoord.length() == 1) {
                antwoord = spel.gok(antwoord.charAt(0));
            } else {
                antwoord = spel.gok(antwoord);
            }
            if (spel.isGeraden()) {
                System.out.println("Proficiat ! \nJe vond het woord in " + spel.getAantalBeurten() + " trials ");
                return;
            }
            System.out.println("Beurt " + spel.getAantalBeurten() + ": " + antwoord);
        } while (spel.nogBeurten());
        System.out.println("Helaas ! \nJe vond het woord niet in " + spel.getAantalBeurten() + " trials ");
    }
}
