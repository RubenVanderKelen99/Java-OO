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
public class Onkosten {

    private int CategorieNummer;
    private String CategorieNaam;
    private double bedrag;
    private int stukNrs;

    public Onkosten(int CategorieNummer, String CategorieNaam, double bedrag, int stukNrs) {
        this.CategorieNummer = CategorieNummer;
        this.CategorieNaam = CategorieNaam;
        this.bedrag = bedrag;
        this.stukNrs = stukNrs;
    }

    public int getCategorieNummer() {
        return CategorieNummer;
    }

    public String getCategorieNaam() {
        return CategorieNaam;
    }

    public int bedrag() {
        return CategorieNummer;
    }

    public int stukNrs() {
        return CategorieNummer;
    }

}
