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
public class Docent extends OdiseeMember implements Comparable<OdiseeMember> {

    public Docent(String naam, String voornaam, Opleiding opleiding, Deeltraject deeltraject) {
        super(naam, voornaam, opleiding, deeltraject);
    }

    /*@Override
    public int compareTo(Object o) {
        Docent d = (Docent) o;

        int comp = this.getOpleiding().toString().compareTo(d.getOpleiding().toString());
        System.err.println("a" + comp);
        if (comp != 0) { //als er dus een verschil is, mocht het 0 zijn is er een verschil

            return comp;
        }
        comp = this.getDeeltraject().toString().compareTo(d.getDeeltraject().toString());
        System.err.println("b" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getNaam().compareTo(d.getNaam());
        System.err.println("c" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getVoornaam().compareTo(d.getVoornaam());
        System.err.println("d" + comp);
        if (comp != 0) {

            return comp;
        }

        return this.getDeeltraject().compareTo(d.getDeeltraject());
    }*/

}
