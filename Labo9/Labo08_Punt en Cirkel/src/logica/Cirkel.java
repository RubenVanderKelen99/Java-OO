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
public class Cirkel extends Figuur {

    private double straal;

    public Cirkel() {
        this.straal = 50; //default 50
        super.setMiddelpunt(new Punt(0, 0)); //default in het midden
    }

    public Cirkel(double s) {
        setStraal(s);
        super.setMiddelpunt(new Punt(0, 0)); //default in het midden
    }

    public Cirkel(double s, Kleur k, Kleur kleurRand, int dikteRand) {
        super(k, kleurRand, dikteRand);
        setStraal(s);

    }

    public Cirkel(Punt mp, double s) {

        super.setMiddelpunt(mp);
        setStraal(s);
    }

    public Cirkel(Punt mp, double s, Kleur k, Kleur kleurRand, int dikteRand) {
        super(k, kleurRand, dikteRand);
        super.setMiddelpunt(mp);
        setStraal(s);
    }

    public double getStraal() {
        return straal;
    }

    public void setStraal(double straal) {

        if (straal < 0) {

            throw new IllegalArgumentException("Straal moet positief zijn");

        } else {
            this.straal = straal;
        }

    }

    @Override
    public double berekenOmtrek() {
        double result = (2 * getStraal()) * Math.PI; // s*2 * pi
        return result;
    }

    @Override
    public double berekenOppervlakte() {
        double result = Math.pow(getStraal(), 2) * Math.PI; //straal ^2 *^pi
        return result;
    }

    @Override
    public String toString() {

        return String.format("Cirkel met straal %.2f", getStraal());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Cirkel)) {
            return false;
        }

        Cirkel c = (Cirkel) o;

        return getStraal() == c.getStraal()
                && getKleur() == c.getKleur()
                && getKleurRand() == c.getKleurRand()
                && getDikteRand() == c.getDikteRand() //   && getMiddelpunt() == c.getMiddelpunt()
                ;

    }

    public static void main(String[] args) {

        Cirkel c = new Cirkel(7);
        Cirkel c2 = new Cirkel(new Punt(0, 0), (int) 7.0);

        System.err.println(c.getStraal() + "," + c2.getStraal() + "," + c.getMiddelpunt() + "," + c2.getMiddelpunt());
        System.err.println(c.getKleur() + "," + c2.getKleur() + "," + c.getKleurRand() + "," + c2.getKleurRand());
        System.err.println(c.getDikteRand() + "," + c2.getDikteRand());
        System.err.println(c.equals(c2));
    }

}
