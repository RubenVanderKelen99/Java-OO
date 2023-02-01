package logica;

import static java.lang.Integer.parseInt;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ruben
 */
public class Rapport {

    private String[] vakken = new String[6];
    private int[] scores = new int[6];
    public static final int DEFAUL_MAX_SCORE = 20;
    public static final int UNDEFINED_SCORE = 0;
    public int score;
    Helper helper;
    Graad graad;
    int maxScore;

    // private int a ;
    public Rapport(String[] vakken, int maxScore) {
        this.vakken = vakken;
        this.maxScore = maxScore;
    }

    public Rapport(String[] vakken) {
        this.vakken = vakken;

    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    private void initScores() {

    }

    public void resetScore(String vak) {
        int index = zoekIndexVak(vak);
        scores[index] = 0;

    }

    public double geefResultaatProcent() {

        double result = 0.0;
        int lengte = 0;

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] != (int) scores[i] || scores[i] == 0) { //als het geen int is, null dus
                // throw new IllegalStateException();
                //doe niks
            } else {

                result += scores[i]; //allemaal op 20
                lengte++;

            }

        }
        result = result / lengte; //delen door het aantal voor het gemiddelde op 20
        int multiplier = 100 / getMaxScore();
        result = result * multiplier; //maal 5 om het op 100 te zetten
        result = helper.afronden(result, 2);

        return result;
    }

    public String[] getVakken() {
        return vakken;
    }

    public int getScore(String vak) {

        if (Arrays.asList(vakken).contains(vak)) { //als vak in de array vakken zit

            int index = zoekIndexVak(vak);
            return scores[index];
        } else {
            return UNDEFINED_SCORE;
        }

    }

    public void setScore(String vak, int score) {
        int index = zoekIndexVak(vak);

        if (vak != null) { //als vak bestaat

            if (score > getMaxScore() || score < 0) {
                throw new IllegalArgumentException("error");
            } else {

                if (Arrays.asList(vakken).contains(vak)) { //als vak in de array vakken zit
                    scores[index] = score;
                }

            }

        }

    }

    private int zoekIndexVak(String vak) {

        int index = 0;

        for (int i = 0; i < vakken.length; i++) {

            if (vakken[i].matches(vak)) {
                index = i;

            } else {

            }

        }

        return index;

    }

    public Graad geefGraad() {

        if (geefResultaatProcent() < 50) {
            graad = graad.NIET_GESLAAGD;
        } else if (geefResultaatProcent() >= 50 && geefResultaatProcent() < 65) {

            graad = graad.VOLDOENING;
        } else if (geefResultaatProcent() >= 65 && geefResultaatProcent() < 75) {

            graad = graad.ONDERSCHEIDING;
        } else if (geefResultaatProcent() >= 75 && geefResultaatProcent() < 85) {

            graad = graad.GROTE_ONDERSCHEIDING;
        } else if (geefResultaatProcent() >= 78) {

            graad = graad.GROOTSTE_ONDERSCHEIDING;
        }

        return graad;
    }

    private boolean alleVakkenGeslaagd() {
        int total = 0;
        for (int i = 0; i < vakken.length; i++) {

            if (getScore(vakken[i]) > 9) {
                total++;
            }
        }
        return vakken.length == total;
    }

    private boolean alleScoresIgegeven() {

        return scores.length == vakken.length;
    }

    public static void main(String[] args) {

        String test = "SAasssdqs1";
        String out = test = test.replaceAll("[a-zA-Z]", "");
        int i = parseInt(out);
        System.out.println(i);
    }
}
