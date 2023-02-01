/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentatie;

import logica.Boom;

/**
 *
 * @author Ruben Van der Kelen
 * @version maart 2019
 */
public class BoomConsole {

    public static void main(String[] args) {

        Boom boom = new Boom(50);

        for (int i = 0; i < 12; i++) {
            boom.groei();
            System.out.println(boom.huidigeHoogte());

        }

    }
}
