/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class test {
    public static void main(String[] args) {
        
        fileRead test = new fileRead();
        
        test.getGebouwInfo();
        test.getonkostCatInfo();
        for (int i = 0; i < test.giveonkostenCategorieen().length; i++) {
              System.out.println(test.giveonkostenCategorieen()[i]);
   
        }       
        System.out.println("succes");
    }
}
