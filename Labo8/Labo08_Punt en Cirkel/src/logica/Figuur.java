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
public abstract class Figuur {
    
    private Punt middelpunt;
    private Kleur kleur;
    private Kleur kleurRand;
    private int dikteRand;
    
    public Figuur() {
        this.kleur = Kleur.wit;
        this.kleurRand = Kleur.zwart;
        this.dikteRand = 1;
    }
    
    public Figuur(Kleur k1, Kleur k2, int d) {
        this.kleur = k1;
        this.kleurRand = k2;
        setDikteRand(d);
    }
    
    public void setMiddelpunt(Punt middelpunt) {

        /* if (middelpunt.getX() < 1 || middelpunt.getY() < 1) {
            throw new IllegalArgumentException("middelpunt mag niet 0 of negatief zijn");
        } else {*/
        this.middelpunt = middelpunt;
        /* }*/
        
    }
    
    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }
    
    public void setKleurRand(Kleur kleurRand) {
        this.kleurRand = kleurRand;
    }
    
    public void setDikteRand(int dikteRand) {
        
        if (dikteRand < 0) {
            
            throw new IllegalArgumentException("dikte van rand moet positief zijn");
        } else {
            this.dikteRand = dikteRand;
        }
        
    }
    
    public Punt getMiddelpunt() {
        return middelpunt;
    }
    
    public Kleur getKleur() {
        return kleur;
    }
    
    public Kleur getKleurRand() {
        return kleurRand;
    }
    
    public int getDikteRand() {
        return dikteRand;
    }
    
    public double berekenAfstand(Punt p) {
        
        Punt middelpunt = getMiddelpunt();
        double afstand = p.berekenAfstand(middelpunt);
        
        return afstand;
    }
    
    public double berekenAfstand(Figuur f) {
        
        Punt middelpunt = getMiddelpunt();
        Punt middelpuntf = f.getMiddelpunt();
        double afstand = middelpunt.berekenAfstand(middelpuntf);
        
        return afstand;
    }
    
    public abstract double berekenOmtrek();
    
    public abstract double berekenOppervlakte();
    
    public String toString() {
        
        return String.format("");
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Figuur)) {
            return false;
        }
        
        Figuur f = (Figuur) o;
        
        return getMiddelpunt() == f.getMiddelpunt()
                && getKleur() == f.getKleur()
                && getKleurRand() == f.getKleurRand()
                && getDikteRand() == f.getDikteRand();
        
    }
    
}
