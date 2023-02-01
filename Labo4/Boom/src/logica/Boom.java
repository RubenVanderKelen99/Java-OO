/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben Van der Kelen
 * @version maart 2019
 */
public class Boom {

    int grootte;

    public Boom() {
        this.grootte = 0;
    }

    public Boom(int grootte) {
        this.grootte = grootte;
    }

    public void groei() {
        this.grootte = this.grootte + 25;

    }

    public void snoei() {

        this.grootte = this.grootte - 25;

    }

    private int controle(int getal) {

        if (this.grootte > 250) {
            this.grootte = 250;
        } else if (this.grootte < 0) {
            this.grootte = 0;
        }

        return this.grootte;

    }
    
   

    public int huidigeHoogte() {
            
        return controle(this.grootte);

    }

}
