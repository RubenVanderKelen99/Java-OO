/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meting;

import java.time.LocalDate;
import java.time.Month;

/**
 * Documentatie van de klasse
 *
 * @author Ruben
 * @version februari 2019
 */
public class Meting {
    
    /**
    * welk soort meting wordt er gedaan
    */
    final String NAAM;

    /**
     * het jaar van de meting
     */
    final int JAAR;

    /**
     * de waarden van de metingen
     */
    double[][] meetwaarden;

    /**
     * Constructor methode
     * 
     * @param naam de soort meting
     * @param jaartal het jaar van de meting
     */
    public Meting(String naam, int jaartal) {

        this.NAAM = naam;
        this.JAAR = jaartal;
        this.meetwaarden = new double[12][];
    }

    /**
     * Methode om de waarden van de metingen in te geven
     * 
     * @param maand de maand waarop de metingen plaatsvonden
     * @param tempWaarden de temperatuurswaarden van de metingen
     */
    public void zetWaardenVoorMaand(int maand, double[] tempWaarden) {
        meetwaarden[maand] = tempWaarden;
    }

    // er niet van uitgaan dat de gebruiker de maanden mooi opeenvolgend zal meegeven (bvb. enkel jan en jun worden gegeven...)

    /**
     * Deze methode geeft de opgenomen meetwaarden weer
     * 
     * @return een overzicht van de waarden van de metingen
     */
    public String geefOverzichtMeetwaarden() {
        String output = "OVERZICHT MEETWAARDEN: \n";
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i)) {
                output += geefMaandEnJaar(i) + ": ";
                for (int j = 0; j < meetwaarden[i].length; j++) {
                    output += meetwaarden[i][j] + "\t";
                }
                output += "\n";
            } else {

            }
        }
        return output;

    }

    /**
     * private-methode met deelfunctionaliteit, bepaalt of de maand al dan niet ingevuld werd
     * 
     * @param maand de maand van de metingen
     * @return true of false (voorwaarde)
     */
    private boolean gevuldeMaand(int maand) {
        boolean gevuld = false;
        if (meetwaarden[maand] != null) {
            gevuld = true;
        } else {

        }
        return gevuld;
    }

    /**
     * private-methode met deelfunctionaliteit, geeft maand en jaar van de metingen waar voor in overzicht
     * 
     * @param maand de maand van de metingen
     * @return String met de maand en het jaar van de metingen
     */
    private String geefMaandEnJaar(int maand) {
        String output = "";
        switch (maand) {
            case 0:
                output += "JAN'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 1:
                output += "FEB'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 2:
                output += "MAA'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 3:
                output += "APR'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 4:
                output += "MEI'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 5:
                output += "JUN'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 6:
                output += "JUL'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 7:
                output += "AUG'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 8:
                output += "SEP'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 9:
                output += "OKT'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 10:
                output += "NOV'" + Integer.toString(JAAR).substring(2, 4);
                break;
            case 11:
                output += "DEC'" + Integer.toString(JAAR).substring(2, 4);
                break;
        }
        return output;
    }

    /**
     * Deze methode geeft een analyse van de opgenomen metingen, het geeft per maand
     * de minimum, maximum en gemiddelde waarden weer
     * 
     * @return String met de minimum, maximum en gemiddelde waarden per maand
     */
    public String geefAnalyse() {
        String output = "ANALYSE: \nmaand\tminimum\tmaximum\tgemiddelde\n-----\t------\t------\t----------\n";
        double minimum, maximum, gemiddelde;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i)) {
                output += geefMaandEnJaar(i) + ":\t" + geefMinimum(i) + "\t" + geefMaximum(i) + "\t" + geefGemiddelde(i) + "\n";
            }
        }
        return output;
    }

    /**
     * private-methode met deelfunctionaliteit, berekend het minimum voor de maand
     * 
     * @param maand de maand van de metingen
     * @return de waarde van de laagste meting als double
     */
    private double geefMinimum(int maand) {
        double minimum = 0;
        for (int i = 0; i < meetwaarden[maand].length; i++) {
            if (i == 0) {
                minimum = meetwaarden[maand][i];
            } else if (meetwaarden[maand][i] < minimum) {
                minimum = meetwaarden[maand][i];
            } else {

            }
        }
        return minimum;
    }

    /**
     * private-methode met deelfunctionaliteit, berekend het minimum voor de maand
     * 
     * @param maand de maand van de metingen
     * @return de waarde van de hoogste meting als double
     */
    private double geefMaximum(int maand) {
        double maximum = 0;
        for (int i = 0; i < meetwaarden[maand].length; i++) {
            if (i == 0) {
                maximum = meetwaarden[maand][i];
            } else if (meetwaarden[maand][i] > maximum) {
                maximum = meetwaarden[maand][i];
            } else {

            }
        }
        return maximum;
    }

    /**
     * private-methode met deelfunctionaliteit, berekend het gemiddelde voor de maand
     * 
     * @param maand de maand van de metingen
     * @return de waarde van het gemiddelde als double
     */
    private double geefGemiddelde(int maand) {
        double gemiddelde = 0;
        double somGetallen = 0;
        double aantalGetallen = 0;
        for (int i = 0; i < meetwaarden[maand].length; i++) {
            somGetallen += meetwaarden[maand][i];
            aantalGetallen++;
        }
        gemiddelde = (double) Math.round(somGetallen / aantalGetallen * 100.00) / 100.00;
        return gemiddelde;
    }

    /**
     * Deze methode geeft de hoogst gemeten waarde weer van het jaar
     * 
     * @return de hoogst gemeten waarde van het jaar als double
     */
    public double geefWaardeHoogsteMeting() {
        double hoogste = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                hoogste = geefMaximum(i);
            } else if (gevuldeMaand(i) && geefMaximum(i) > hoogste) {
                hoogste = geefMaximum(i);
            }
        }
        return hoogste;
    }

    /**
     * Deze methode geeft de laagst gemeten waarde weer van het jaar
     * 
     * @return de laagst gemeten waarde van het jaar als double
     */
    public double geefWaardeLaagsteMeting() {
        double laagste = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                laagste = geefMinimum(i);
            } else if (gevuldeMaand(i) && geefMinimum(i) < laagste) {
                laagste = geefMinimum(i);
            }

        }
        return laagste;
    }

    /**
     * Deze methode geeft de datum waarop de hoogste waarde van het jaar gemeten werd
     * 
     * @return de datum wan de hoogst gemeten waarde van het jaar
     */
    public LocalDate geefDatumHoogsteMeting() {
        LocalDate datumHoogste;
        int jaar, maand, dag;
        jaar = this.JAAR;
        maand = 0;
        dag = 0;
        double hoogste = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                for (int j = 0; j < meetwaarden[i].length; j++) {
                    if (j == 0) {
                        hoogste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    } else if (meetwaarden[i][j] > hoogste) {
                        hoogste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    }
                }
            } else if (gevuldeMaand(i)) {
                for (int j = 0; j < meetwaarden[i].length; j++) {
                    if (meetwaarden[i][j] > hoogste) {
                        hoogste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    }
                }
            }
        }
        datumHoogste = LocalDate.of(jaar, maand, dag);
        return datumHoogste;
    }

    /**
     * Deze methode geeft de datum waarop de laagste waarde van het jaar gemeten werd
     * 
     * @return de datum wan de laagst gemeten waarde van het jaar
     */
    public LocalDate geefDatumLaagsteMeting() {
        LocalDate datumLaagste;
        int jaar, maand, dag;
        jaar = this.JAAR;
        maand = 0;
        dag = 0;
        double laagste = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                for (int j = 0; j < meetwaarden[i].length; j++) {
                    if (j == 0) {
                        laagste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    } else if (meetwaarden[i][j] < laagste) {
                        laagste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    }
                }
            } else if (gevuldeMaand(i)) {
                for (int j = 0; j < meetwaarden[i].length; j++) {
                    if (meetwaarden[i][j] < laagste) {
                        laagste = meetwaarden[i][j];
                        maand = i + 1;
                        dag = j + 1;
                    }
                }
            }
        }
        datumLaagste = LocalDate.of(jaar, maand, dag);
        return datumLaagste;
    }

    /**
     * Deze methode geeft de hoogste gemiddelde waarde van alle maanden weer
     * 
     * @return de hoogste gemiddelde waarde van alle maanden weer als double
     */
    public double geefWaardeHoogsteMaandgemiddelde() {
        double hoogsteGemiddelde = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                hoogsteGemiddelde = geefGemiddelde(i);
            } else if (gevuldeMaand(i)) {
                if (geefGemiddelde(i) > hoogsteGemiddelde) {
                    hoogsteGemiddelde = (geefGemiddelde(i));
                }
            }
        }
        return hoogsteGemiddelde;
    }

    /**
     * Deze methode geeft de laagste gemiddelde waarde van alle maanden weer
     * 
     * @return de laagste gemiddelde waarde van alle maanden weer als double
     */
    public double geefWaardeLaagsteMaandgemiddelde() {
        double laagsteGemiddelde = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                laagsteGemiddelde = geefGemiddelde(i);
            } else if (gevuldeMaand(i)) {
                if (geefGemiddelde(i) < laagsteGemiddelde) {
                    laagsteGemiddelde = (geefGemiddelde(i));
                }
            }
        }
        return laagsteGemiddelde;
    }

    /**
     * Deze methode geeft de maand met de hoogste gemiddelde waarde weer
     * 
     * @return String met de maand met de hoogste gemiddelde waarde
     */
    public String geefMaandHoogsteMaandgemiddelde() {
        String maandHoogsteGemiddelde = "";
        double hoogsteGemiddelde = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                hoogsteGemiddelde = geefGemiddelde(i);
                maandHoogsteGemiddelde = geefMaandEnJaar(i);
            } else if (gevuldeMaand(i)) {
                if (geefGemiddelde(i) > hoogsteGemiddelde) {
                    hoogsteGemiddelde = (geefGemiddelde(i));
                    maandHoogsteGemiddelde = geefMaandEnJaar(i);
                }
            }
        }
        return maandHoogsteGemiddelde;
    }

    /**
     * Deze methode geeft de maand met de laagste gemiddelde waarde weer
     * 
     * @return String met de maand met de laagste gemiddelde waarde
     */
    public String geefMaandLaagsteMaandgemiddelde() {
        String maandLaagsteGemiddelde = "";
        double laagsteeGemiddelde = 0;
        boolean eersteMaand = true;
        for (int i = 0; i < meetwaarden.length; i++) {
            if (gevuldeMaand(i) && eersteMaand) {
                eersteMaand = false;
                laagsteeGemiddelde = geefGemiddelde(i);
                maandLaagsteGemiddelde = geefMaandEnJaar(i);
            } else if (gevuldeMaand(i)) {
                if (geefGemiddelde(i) < laagsteeGemiddelde) {
                    laagsteeGemiddelde = (geefGemiddelde(i));
                    maandLaagsteGemiddelde = geefMaandEnJaar(i);
                }
            }
        }
        return maandLaagsteGemiddelde;
    }

}
