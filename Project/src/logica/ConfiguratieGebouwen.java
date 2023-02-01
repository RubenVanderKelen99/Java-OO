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
public class ConfiguratieGebouwen {

    private String gebouw;
    private ArrayList<Unit> units = new ArrayList<Unit>();
    private ArrayList<OnkostenCategorieen> onkostenCat = new ArrayList<OnkostenCategorieen>();


    public ConfiguratieGebouwen(String gebouw, ArrayList<Unit> units) {
        this.gebouw = gebouw;
        this.units = units;
    }

    public ConfiguratieGebouwen(String gebouw) {
        this.gebouw = gebouw;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }
    
    public void addOnkostenCategorieen(OnkostenCategorieen onkostenCat) {
        this.onkostenCat.add(onkostenCat);
    }
    
    public String getGebouw() {
        return gebouw;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }
    
    public ArrayList<OnkostenCategorieen> getOnkostenCategorieen() {
        return this.onkostenCat;
    }

}
