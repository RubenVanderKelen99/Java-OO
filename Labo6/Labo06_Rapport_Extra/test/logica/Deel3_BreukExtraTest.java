package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class Deel3_BreukExtraTest {

    /**
     * Test of vereenvoudig method, of class Breuk.
     */
    @Test
    public void testVereenvoudig() {
        System.out.println("vereenvoudig");
        Breuk instance = new Breuk(2, 4);

        assertEquals(1, instance.getTeller());
        assertEquals(2, instance.getNoemer());
    }

    /**
     * Test of vereenvoudig method, of class Breuk.
     */
    @Test
    public void testVereenvoudigBis() {
        System.out.println("vereenvoudig bis");
        Breuk instance = new Breuk(2, 4);

        assertEquals(new Breuk(1, 2), instance); //werkt enkel op vw van aanwezigheid van equals methode in klasse Breuk
    }

    /**
     * Test of plus method, of class Breuk.
     */
    @Test
    public void testPlusDeel2() {
        System.out.println("plus deel2");

        Breuk instance = new Breuk(3, 2);
        Breuk ander = new Breuk(8, 4);
        Breuk result = instance.plus(ander);

        assertEquals(7, result.getTeller());
        assertEquals(2, result.getNoemer());
        assertEquals(new Breuk(7, 2), result); //werkt enkel op vw van aanwezigheid van equals methode in klasse Breuk

        //verifieer dat de oorspronkelijke Breuk-objecten gelijk gebleven zijn
        assertEquals(new Breuk(3, 2), instance);
        assertEquals(new Breuk(2, 1), ander);
    }

    /* @Test
    public void testPlusMinDeel2() {
        System.out.println("plus en min deel2");   
        
        Breuk breuk1 = new Breuk(3,8);
        Breuk breuk2 = new Breuk(1,8);
        
        Breuk resultPlus = breuk1.plus(breuk2);
        Breuk resultMin = breuk1.min(breuk2);

        assertEquals(new Breuk(1,2), resultPlus);
        assertEquals(new Breuk(1,4), resultMin);
    }*/
    /**
     * Test of min method, of class Breuk.
     */
    @Test
    public void testMinDeel2() {
        System.out.println("min deel2");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.min(ander);

        assertEquals(new Breuk(-1, 4), result);
    }

    /**
     * Test of maal method, of class Breuk.
     */
    @Test
    public void testMaalDeel2() {
        System.out.println("maal deel2");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.maal(ander);

        assertEquals(new Breuk(3, 8), result);
    }

    /**
     * Test of deel method, of class Breuk.
     */
    @Test
    public void testDeelDeel2() {
        System.out.println("deel deel2");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.deel(ander);

        assertEquals(new Breuk(2, 3), result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 6);
        assertEquals(instance, ander);
    }

    @Test
    public void testEqualsBis() {
        System.out.println("equalsBis");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = null;
        assertNotEquals(instance, ander);
    }

    @Test
    public void testToString() {
        System.out.println("toString");

        Breuk instance = new Breuk(1, 2);
        String s = instance.toString().replace(" ", "");
        assertEquals("1/2(0.5)", s);

        instance = new Breuk(3, 6);
        s = instance.toString().replace(" ", "");
        assertEquals("1/2(0.5)", s);

        instance = new Breuk(1, -2);
        s = instance.toString().replace(" ", "");
        assertEquals("1/-2(-0.5)", s);

        instance = new Breuk(3, 9);
        s = instance.toString().replace(" ", "");
        assertEquals("1/3(0.33)", s);
    }
}
