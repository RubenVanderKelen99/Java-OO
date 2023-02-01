package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;
import logica.Breuk;
import logica.Helper;

/**
 *
 * @author kristien.vanassche
 */
public class Deel2_BreukTest {

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Breuk");

        Field[] fields = c.getDeclaredFields();
        assertEquals(2, fields.length);

        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    /**
     * Test of constructor, of class Breuk.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        System.out.println("constructor");
        Breuk instance = new Breuk(0, 0);
    }

    /**
     * Test of default constructor and getter methods, of class Breuk.
     */
    @Test
    public void testDefaultConstructor() {
        System.out.println("getTeller");
        Breuk instance = new Breuk();

        //assertEquals(1, instance.getTeller()); // dit is niet opgelegd
        assertEquals(1, instance.getNoemer());
    }

    /**
     * Test of plus method, of class Breuk.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.plus(ander);
        //assertEquals(5/4, result.getTeller() / result.getNoemer());
        assertEquals((double) 5 / 4, (double) result.getTeller() / result.getNoemer(), 0);

        //verifieer dat de oorspronkelijke Breuk-objecten gelijk gebleven zijn
        assertEquals(1, instance.getTeller());
        assertEquals(2, instance.getNoemer());

        assertEquals(3, ander.getTeller());
        assertEquals(4, ander.getNoemer());
    }

    @Test
    public void testPlusMin() {
        System.out.println("plus en min");

        Breuk breuk1 = new Breuk(3, 8);
        Breuk breuk2 = new Breuk(1, 8);

        Breuk resultPlus = breuk1.plus(breuk2);
        Breuk resultMin = breuk1.min(breuk2);

        assertEquals((double) 1 / 2, (double) resultPlus.getTeller() / resultPlus.getNoemer(), 0);
        assertEquals((double) 1 / 4, (double) resultMin.getTeller() / resultMin.getNoemer(), 0);
    }

    /**
     * Test of min method, of class Breuk.
     */
    @Test
    public void testMin() {
        System.out.println("min");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.min(ander);
        assertEquals((double) -1 / 4, (double) result.getTeller() / result.getNoemer(), 0);
    }

    /**
     * Test of maal method, of class Breuk.
     */
    @Test
    public void testMaal() {
        System.out.println("maal");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.maal(ander);
        assertEquals((double) 3 / 8, (double) result.getTeller() / result.getNoemer(), 0);
    }

    /**
     * Test of deel method, of class Breuk.
     */
    @Test
    public void testDeel() {
        System.out.println("deel");

        Breuk instance = new Breuk(1, 2);
        Breuk ander = new Breuk(3, 4);
        Breuk result = instance.deel(ander);
        assertEquals((double) 2 / 3, (double) result.getTeller() / result.getNoemer(), 0);
    }

}
