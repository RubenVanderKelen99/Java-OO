/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruben.vanderkelen
 * @version februari 2019
 */
public class WPSDemo {
    public static void main(String[] args) {
        WPS test = new WPS();
        System.out.println(test.getPincode());
            test.setPincode("90830501");
        System.out.println(test.getPincode());
    }
}
