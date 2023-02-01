package logica;

import logica.Helper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class Deel1_HelperTest {
    /**
     * Test of afronden method, of class Helper.
     */
    @Test
    public void testAfrondenPrecisie() {
        System.out.println("afronden volgens opgegeven precisie");
        assertEquals(16, Helper.afronden(15.749, 0),0);
        assertEquals(15.7, Helper.afronden(15.749, 1),0);
        assertEquals(15.75, Helper.afronden(15.749, 2),0);
        assertEquals(15.749, Helper.afronden(15.749, 3),0);
        assertEquals(15.749, Helper.afronden(15.749, 4),0);
    } 
    
    /**
     * Test of zoekGemiddelde method, of class Helper.
     */
    @Test
    public void testZoekGemiddelde() {
        System.out.println("zoekGemiddelde");
        assertEquals(2, Helper.zoekGemiddelde(new int[]{1,2,3}), 0);
        assertEquals(2.5, Helper.zoekGemiddelde(new int[]{1,2,3,4}), 0);
        assertEquals(3.3, Helper.zoekGemiddelde(new int[]{3,3,4}), 0.1);
        assertEquals(3.33, Helper.zoekGemiddelde(new int[]{3,3,4}), 0.01);
    } 
    
    /**
     * Test of ggd method, of class Helper.
     */
    @Test
    public void testGgd() {
        System.out.println("ggd");
        assertEquals(0, Helper.ggd(0, 0));
        assertEquals(5, Helper.ggd(15, 20));
        assertEquals(15, Helper.ggd(75, 105));
    }
    
    /**
     * Test of kgv method, of class Helper.
     */
    @Test 
    public void testKgv() {
        System.out.println("kgv");
        assertEquals(135, Helper.kgv(15, 27));
        assertEquals(12, Helper.kgv(3, 4));
        assertEquals(72, Helper.kgv(24, 72));
        assertEquals(480, Helper.kgv(30, 96));
    }
    
     /**
     * Test of kgv method, of class Helper.
     */
    @Test
    public void testKgv00() {
        System.out.println("kgv00");
        assertEquals(0, Helper.kgv(0, 0));
    } 
}
