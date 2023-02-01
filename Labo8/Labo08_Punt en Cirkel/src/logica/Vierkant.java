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
public class Vierkant extends Figuur {

    private double zijde;

    public Vierkant() {
        setZijde(50);
        super.setMiddelpunt(new Punt(0, 0)); //default in het midden
    }

    public Vierkant(double zijde) {
        setZijde(zijde);
        super.setMiddelpunt(new Punt(0, 0)); //default in het midden
    }

    public Vierkant(Punt mp, double zijde) {

        super.setMiddelpunt(mp);
        setZijde(zijde);
    }

    public Vierkant(double z, Kleur k, Kleur kleurRand, int dikteRand) {
        super(k, kleurRand, dikteRand);
        super.setMiddelpunt(new Punt(0, 0)); //default in het midden
        setZijde(z);

    }

    public Vierkant(Punt mp, double zijde, Kleur k, Kleur kleurRand, int dikteRand) {
        super(k, kleurRand, dikteRand);
        super.setMiddelpunt(mp);
        setZijde(zijde);
    }

    private void setZijde(double zijde) {

        if (zijde <= 0) {
            throw new IllegalArgumentException("zijde moet positief zijn en groter dan 0");
        } else {
            this.zijde = zijde;
        }
    }

    public double getZijde() {
        return zijde;
    }

    @Override
    public double berekenOmtrek() {

        return getZijde() * 4;
    }

    @Override
    public double berekenOppervlakte() {

        return getZijde() * zijde;
    }

    public String toString() {

        return String.format("vierkant met een zijde van  %.2f cm", zijde);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Vierkant)) {
            return false;
        }

        Vierkant v = (Vierkant) o;

        return getZijde() == v.getZijde()
                && getKleur() == v.getKleur()
                && getKleurRand() == v.getKleurRand()
                && getDikteRand() == v.getDikteRand();

    }

    public static void main(String[] args) {
        Vierkant v1 = new Vierkant(7.0);
        Vierkant v2 = new Vierkant(7.0);

        System.err.println(v1.equals(v2));

    }

}
