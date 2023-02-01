/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meting;

/**
 *
 * @author Ruben
 * @version februari 2019
 */
public class DemoMeting {
    public static void main(String[] args) {
        
        final int[] DAGEN_IN_MAAND = { 31, 27, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final int[] MIN_TEMP_IN_MAAND = {-15,-10, -5, 0, 5, 10, 10, 5, 0, -5,-10,-15};
        final int[] MAX_TEMP_IN_MAAND = { 5, 10, 15, 20, 25, 30, 30, 25, 20, 15, 10, 5};
        
        double[][] temperatuursWaarden = new double[12][];
        for (int i = 0; i < DAGEN_IN_MAAND.length; i++){
           temperatuursWaarden[i] = new double[DAGEN_IN_MAAND[i]];
        for (int j = 0; j < DAGEN_IN_MAAND[i]; j++){
            temperatuursWaarden[i][j] = (double)((Math.round((Math.random() * MAX_TEMP_IN_MAAND[i]) - (Math.random() * Math.abs(MIN_TEMP_IN_MAAND[i])))* 100) /100);
        }
        }
        
        Meting Meting1 = new Meting("Temperatuur", 2019);
        Meting1.zetWaardenVoorMaand(0, temperatuursWaarden[0]);
        Meting1.zetWaardenVoorMaand(1, temperatuursWaarden[1]);
        Meting1.zetWaardenVoorMaand(2, temperatuursWaarden[2]);
        Meting1.zetWaardenVoorMaand(3, temperatuursWaarden[3]);
        Meting1.zetWaardenVoorMaand(4, temperatuursWaarden[4]);
        Meting1.zetWaardenVoorMaand(5, temperatuursWaarden[5]);
        Meting1.zetWaardenVoorMaand(6, temperatuursWaarden[6]);
        Meting1.zetWaardenVoorMaand(7, temperatuursWaarden[7]);
        Meting1.zetWaardenVoorMaand(8, temperatuursWaarden[8]);
        Meting1.zetWaardenVoorMaand(9, temperatuursWaarden[9]);
        Meting1.zetWaardenVoorMaand(10, temperatuursWaarden[10]);
        Meting1.zetWaardenVoorMaand(11, temperatuursWaarden[11]);
        System.out.println(Meting1.geefOverzichtMeetwaarden());
        System.out.println(Meting1.geefAnalyse());
        System.out.println("WARMSTE DAG = " + Meting1.geefDatumHoogsteMeting() + " (" + Meting1.geefWaardeHoogsteMeting() + "°C)");
        System.out.println("KOUDSTE DAG = " + Meting1.geefDatumLaagsteMeting() + " (" + Meting1.geefWaardeLaagsteMeting() + "°C)");
        System.out.println("WARMSTE MAAND = " + Meting1.geefMaandHoogsteMaandgemiddelde() + " (gem. temp. " + Meting1.geefWaardeHoogsteMaandgemiddelde()+ "°C)");
        System.out.println("KOUDSTE MAAND = " + Meting1.geefMaandLaagsteMaandgemiddelde() + " (gem. temp. " + Meting1.geefWaardeLaagsteMaandgemiddelde() + "°C)");
    }
    
}
