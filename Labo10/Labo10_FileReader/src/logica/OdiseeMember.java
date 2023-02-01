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
public class OdiseeMember implements Comparable<OdiseeMember> {

    private Opleiding opleiding;
    private String naam;
    private String voornaam;
    private Deeltraject deeltraject;

    public OdiseeMember(String naam, String voornaam, Opleiding opleiding, Deeltraject deeltraject) {
        this.opleiding = opleiding;
        this.naam = naam;
        this.voornaam = voornaam;
        this.deeltraject = deeltraject;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public Deeltraject getDeeltraject() {
        return deeltraject;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setDeeltraject(Deeltraject deeltraject) {
        this.deeltraject = deeltraject;
    }

    @Override
    public int compareTo(OdiseeMember o) {
        OdiseeMember od = (OdiseeMember) o;

        int comp = this.getOpleiding().toString().compareTo(od.getOpleiding().toString());
        //System.err.println("a" + comp);
        if (comp != 0) { //als er dus een verschil is, mocht het 0 zijn is er een verschil

            return comp;
        }
        comp = this.getDeeltraject().toString().compareTo(od.getDeeltraject().toString());
        //System.err.println("b" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getNaam().compareTo(od.getNaam());
        //System.err.println("c" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getVoornaam().compareTo(od.getVoornaam());
        //System.err.println("d" + comp);
        if (comp != 0) {

            return comp;
        }

        return this.getDeeltraject().compareTo(od.getDeeltraject());
    }

    public String toString() {
        return String.format("naam = %s voornaam = %s  opleiding = %S  onderdeel = %S", getNaam(), getVoornaam(), getOpleiding(), getDeeltraject());
    }

}
