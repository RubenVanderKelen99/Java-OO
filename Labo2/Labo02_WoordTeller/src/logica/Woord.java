/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 * @version februari 2019
 */
public class Woord {

    private String woord;

    private boolean[] letterStatus;

    public static int telLetter(String woord, char letter) {
        int teller = 0;
        for (int i = 0; i < woord.length(); i++) {
            if (woord.charAt(i) == letter) {
                teller++;
            }
        }
        return teller;
    }

    public Woord(String woord) {
        this.woord = woord;
        this.letterStatus = new boolean[woord.length()];
    }

    public int telLetter(char letter) {
        int teller = 0;
        for (int i = 0; i < this.woord.length(); i++) {
            if (this.woord.charAt(i) == letter) {
                teller++;
                this.letterStatus[i] = true;
            }
        }
        return teller;
    }

    public String geefOverzichtStatus() {
        String nieuw = "";
        for (int i = 0; i < this.woord.length(); i++) {
            if (this.letterStatus[i] == true) {
                nieuw += "*";
            } else {
                nieuw += this.woord.charAt(i);
            }
        }
        return nieuw;
    }
}
