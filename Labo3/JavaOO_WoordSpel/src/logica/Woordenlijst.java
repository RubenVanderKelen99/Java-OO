/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 */
public class Woordenlijst {

    private final static String[] WOORDEN = new String[]{"paddenstoel", "breedsmoelkikker", "paardenmelk",
        "hoefsmid", "huisjesmelker",
        "aardbei", "zeepaardje", "sinterklaas", "tovenaar",
        "armoedebestrijding"};


    public static String haalWoord(){
        String woord =  WOORDEN[(int) (Math.random() * WOORDEN.length)];
        return woord;
}
    
     public static String haalWoord(int maxLetters){
        String[] mogelijkeWoorden = maakSubset(maxLetters);
        if(mogelijkeWoorden.length != 0){
        String woord =  mogelijkeWoorden[(int) (Math.random() * mogelijkeWoorden.length)];
        return woord;
        }
        else{
          throw new IllegalArgumentException("Geen woord gevonden die voldoet aan het gestelde criterium");  
        }
}
     
     private static String[] maakSubset(int maxLetters){
         String correctePlaatsen = "";
         for(int i = 0; i < WOORDEN.length; i++){
             if(WOORDEN[i].length() <= maxLetters){ 
                 correctePlaatsen += i;
             }
         }
         String[] subset = new String[correctePlaatsen.length()];
         for(int i = 0; i < correctePlaatsen.length(); i++){
             subset[i] = WOORDEN[Integer.parseInt(correctePlaatsen.substring(i, i + 1))];
         }
         return subset;
     }
}
