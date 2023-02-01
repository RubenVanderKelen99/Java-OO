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
public class Student extends OdiseeMember implements Comparable<OdiseeMember> {

    public Student(String naam, String voornaam, Opleiding opleiding, Deeltraject deeltraject) {
        super(naam, voornaam, opleiding, deeltraject);
    }


    /*@Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        int comp = this.getOpleiding().toString().compareTo(s.getOpleiding().toString());
        System.err.println("a" + comp);
        if (comp != 0) { //als er dus een verschil is, mocht het 0 zijn is er een verschil

            return comp;
        }
        comp = this.getDeeltraject().toString().compareTo(s.getDeeltraject().toString());
        System.err.println("b" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getNaam().compareTo(s.getNaam());
        System.err.println("c" + comp);
        if (comp != 0) {

            return comp;
        }
        comp = this.getVoornaam().compareTo(s.getVoornaam());
        System.err.println("d" + comp);
        if (comp != 0) {

            return comp;
        }

        return this.getDeeltraject().compareTo(s.getDeeltraject());
    }*/
    @Override
    public String toString() {
        return String.format("naam = %s voornaam = %s  opleiding = %S  onderdeel = %S", getNaam(), getVoornaam(), getOpleiding(), getDeeltraject());
    }

    /* public static void main(String[] args) {

        Student student1 = new Student("Boelens", "Annemie", Opleiding.ELOICT, Deeltraject.ICTWEB);
        Student student2 = new Student("Coorevits", "Bas", Opleiding.ET, Deeltraject.NONE);
        int a = student2.compareTo(student1);
        System.err.println("compare = " + a);
        System.err.println(student1.toString());
        System.err.println(student2.toString());
    }*/
}
