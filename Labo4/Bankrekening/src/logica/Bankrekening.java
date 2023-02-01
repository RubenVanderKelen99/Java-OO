/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben Van der Kelen
 * @version maart 2019
 */
public class Bankrekening {

    String naam ;
    String IBAN ;
    double acountBalance;

    public Bankrekening(String naam, String iban) {
        if (isIBANGeldig(iban) == true && checkIBAN(iban) == true && naam!=null  ) {
            this.IBAN = iban;
            this.naam = naam;
            this.acountBalance = 0;

        } else if (isIBANGeldig(iban) == false && checkIBAN(iban) == false && naam==null ) {
            throw new IllegalArgumentException("ongeldig bankrekening");
        }

    }

    public void stortBedrag(double getal) {

        this.acountBalance += getal;

    }

    public void haalBedragAf(double getal) {
        if (getal < this.acountBalance) {
            this.acountBalance = this.acountBalance - getal;
        }
        
    }

    public double getSaldo() {
        return this.acountBalance;
    }

    private boolean isIBANGeldig(String iban) {
        //BE68 5390 0754 7034

        int[] IB = convert(iban);
        int checksom = 0;
        boolean isgeldig = true;

        for (int i = 0; i < IB.length-2; i++) {
            checksom += IB[i];

        }

        double checkdeling = checksom % 97;

        if (checkdeling == checkdigit(iban)) {
            isgeldig = true;
        } else if (checkdeling != checkdigit(iban)) {
            isgeldig = false;
        }

        return isgeldig;
    }

    private static String IBANnospace(String s) {

        String ibannospace = s.replaceAll("\\s+", "");
        return ibannospace;

    }

    private static int[] convert(String s) {
        //BE68539007547034
        String ibannospace = IBANnospace(s);
        int[] iban = new int[ibannospace.length()];

        for (int i = 4; i < ibannospace.length(); i++) {
            iban[i] = Integer.parseInt("" + ibannospace.charAt(i));
        }

        return iban;
    }

    public static int checkdigit(String s) {
        //BE68539007547034
        String iban = "";
        String ibannospace = IBANnospace(s);
        for (int i = 2; i < 4; i++) {
           iban+=ibannospace.charAt(i);
        }
        
        int ibanint=Integer.parseInt(iban);
        return ibanint;
    }

    private boolean checkIBAN(String s) {
        
        boolean check = "BE".equals(s.substring(0, 2)) && !s.contains("-") && s.contains(" ");

        return check;

    }
}
