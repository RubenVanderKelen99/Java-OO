/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Ruben
 * @version mei 2019
 */
public class OnkostenCategorieen {

    private int CategorieNummer;
    private String CategorieNaam;
    private ArrayList<Onkosten> onkosten = new ArrayList<Onkosten>();

    public OnkostenCategorieen(int CategorieNummer, String CategorieNaam) {
        this.CategorieNummer = CategorieNummer;
        this.CategorieNaam = CategorieNaam;
    }

    public int getCategorieNummer() {
        return CategorieNummer;
    }
    
    public void addOnkosten(Onkosten onkosten) {
        this.onkosten.add(onkosten);
    }

    public String getCategorieNaam() {
        return CategorieNaam;
    }
}
