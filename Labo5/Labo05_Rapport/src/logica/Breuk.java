/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 * @version maart 2019
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
    }

    public Breuk plus(Breuk ander) {
        Breuk result = new Breuk(0, 0);
        int teller = getTeller();
        int noemer = getNoemer();
        int anderTeller = ander.getTeller();
        int anderNoemer = ander.getNoemer();

        int kgv = Helper.kgv(noemer, anderNoemer); //zoekt kgv om de noemer te bepalen

        int noemer_base = kgv / noemer;
        int andere_noemer_base = kgv / anderNoemer;
        int nieuweTeller_base = teller * noemer_base;
        int nieuwe_andere_Teller_base = anderTeller * andere_noemer_base;

        int som = nieuweTeller_base + nieuwe_andere_Teller_base;
        result.teller = som;
        result.noemer = kgv;
        return result;
    }

    public Breuk min(Breuk ander) {
        Breuk result = new Breuk(0, 0);
        int teller = getTeller();
        int noemer = getNoemer();
        int anderTeller = ander.getTeller();
        int anderNoemer = ander.getNoemer();

        int kgv = Helper.kgv(noemer, anderNoemer); //zoekt kgv om de noemer te bepalen

        int noemer_base = kgv / noemer;
        int andere_noemer_base = kgv / anderNoemer;
        int nieuweTeller_base = teller * noemer_base;
        int nieuwe_andere_Teller_base = anderTeller * andere_noemer_base;

        int som = nieuweTeller_base - nieuwe_andere_Teller_base;
        result.teller = som;
        result.noemer = kgv;
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

        int teller = getTeller();
        int noemer = getNoemer();
        int anderTeller = ander.getTeller();
        int anderNoemer = ander.getNoemer();

        teller = teller * anderNoemer;
        noemer = noemer * anderTeller;

        Breuk result = new Breuk(teller, noemer);
        result = vereenvoudig(result);
        return result;
    }

    public static void main(String[] args) {

        Breuk base = new Breuk(2, 4);
        Breuk second = new Breuk(5, 8);
        Breuk result = base.deel(second);
        System.out.println("result : " + result.getTeller() + "/" + result.getNoemer());
        // System.err.println(result.toString());
    }

    private Breuk vereenvoudig(Breuk breuk) {  // 4/10
        int teller = breuk.getTeller();
        int noemer = breuk.getNoemer();
        int k = Helper.ggd(teller, noemer); // 2 

        int nieuweTeller = teller / k; //4/2
        int nieuweNoemer = teller / k; //10/2
        Breuk br = new Breuk(nieuweTeller, nieuweNoemer); //2/5
        return br;
    }

    @Override
    public String toString() {
        double res;
        res = getTeller() / getNoemer();
        res = Helper.afronden(res, 2);
        return String.format("%d/%d %.2f", getTeller(), getNoemer(), res);
    }

}
