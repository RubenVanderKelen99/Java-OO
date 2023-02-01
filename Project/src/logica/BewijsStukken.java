/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 * @version mei 2019
 */
public class BewijsStukken {

    private int stukNr;
    private String factuurNr;
    private String datum;
    private int leverancier;
    private String mededeling;
    private double bedrag;

    public BewijsStukken(int stukNr, String factuurNr, int leverancier, String mededeling, double bedrag) {
        this.stukNr = stukNr;
        this.factuurNr = factuurNr;
        this.leverancier = leverancier;
        this.mededeling = mededeling;
        this.bedrag = bedrag;
    }

    public int getStukNr() {
        return stukNr;
    }

    public String getFactuurNr() {
        return factuurNr;
    }
    
     public String datum() {
        return datum;
    }

    public int getLeverancier() {
        return leverancier;
    }

    public String getMededeling() {
        return mededeling;
    }

    public double getBedrag() {
        return bedrag;
    }
}
