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
public class Breuk {

    private int teller;
    private int noemer;

    public int getTeller() {

        return teller;
    }

    public int getNoemer() {
        return noemer;
    }

    public void setTeller(int teller) {

        if (teller == 0) {

            throw new IllegalArgumentException();
        } else {

            this.teller = teller;

        }

    }

    public void setNoemer(int noemer) {

        if (noemer == 0) {

            throw new IllegalArgumentException();

        } else {

            this.noemer = noemer;

        }

    }

    public Breuk() {
        setTeller(1);
        setNoemer(1);

    }

    public Breuk(int teller, int noemer) {
        setTeller(teller);
        setNoemer(noemer);
        vereenvoudig(); //weg doen om test 2&3 te doen slagen
    }

    public Breuk plus(Breuk ander) { // 3/8 1/8

        int tell = (teller * ander.getNoemer()) + (ander.getTeller() * noemer);   // 3 * 8  + 1*8 = 32
        int noem = noemer * ander.getNoemer(); //
        return new Breuk(tell, noem);

    }

    public Breuk min(Breuk ander) { //1/2 - 3/4

        int newTeller = (teller * ander.getNoemer()) - (ander.getTeller() * noemer); // 1 * 4 - 3 * 2 =  -2
        int newNoemer = noemer * ander.getNoemer(); // 1 *4 = 4
        Breuk result = new Breuk(newTeller, newNoemer);

        return result;

    }

    public Breuk maal(Breuk ander) {

        int teller = getTeller();
        int noemer = getNoemer();
        int anderTeller = ander.getTeller();
        int anderNoemer = ander.getNoemer();

        Breuk result = new Breuk(teller * anderTeller, noemer * anderNoemer);
        result = vereenvoudig(result);
        return result;
    }

    public Breuk deel(Breuk ander) {

        int tellerBase = getTeller(); //1
        int noemerBase = getNoemer(); //2
        int anderTeller = ander.getTeller(); //3
        int anderNoemer = ander.getNoemer(); //4

        int nieuweteller = tellerBase * anderNoemer; //1*4 = 4
        int nieuwenoemer = noemerBase * anderTeller; // 2 * 3 = 6

        Breuk result = new Breuk(nieuweteller, nieuwenoemer);
        result = vereenvoudig(result);
        return result;
    }

    public static void main(String[] args) {
        Breuk instance = new Breuk(3, 9);
        System.out.println(instance.toString());
    }

    private Breuk vereenvoudig(Breuk breuk) {  // 4/6
        int tellerB = breuk.getTeller(); //4
        int noemerB = breuk.getNoemer(); //6
        int k = Helper.ggd(tellerB, noemerB); // 2 

        int nieuweTeller = tellerB / k; //4/2 = 2
        int nieuweNoemer = noemerB / k; //6/2 = 3
        breuk.setNoemer(nieuweNoemer);
        breuk.setTeller(nieuweTeller);
        return breuk;
    }

    private void vereenvoudig() {

        int k = Helper.ggd(teller, noemer);
        teller /= k;
        noemer /= k;

    }

    @Override
    public String toString() {
        double res;
        res = (double) getTeller() / (double) getNoemer();
        res = Helper.afronden(res, 2);
        String deling = "(" + res + ")";

        return String.format("%d/%d%S", getTeller(), getNoemer(), deling);
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || !(o instanceof Breuk)) {
            return false;
        }

        Breuk b = (Breuk) o;

        return getTeller() == b.getTeller() && getNoemer() == b.getNoemer();
    }

}
