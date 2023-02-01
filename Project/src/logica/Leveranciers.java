/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 * @version mei 2019
 */
public class Leveranciers {

    private int id;
    private String naam;
    private String btwNr;
    private String email;

    public Leveranciers(int id, String naam, String btwNr, String email) {
        this.id = id;
        this.naam = naam;
        this.btwNr = btwNr;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getBtwNr() {
        return btwNr;
    }

    public String getEmail() {
        return email;
    }
}
