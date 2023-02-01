package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class BankrekeningTest {

    private Bankrekening rek;

    @Test(expected = Exception.class)
    public void testConstructor() {
        System.out.println("testConstructor");
        rek = new Bankrekening("Jan", "091-0002777-90");
    }

    @Test
    public void testConstructorBis() {
        System.out.println("testConstructorBis");
        rek = new Bankrekening("Piet", "BE12 0910 0027 7790");
        assertNotNull(rek);
        assertEquals(0, rek.getSaldo(), 0);
    }

    @Test
    public void testStortBedrag() {
        System.out.println("stortBedrag");

        testConstructorBis();

        for (int i = 0; i < 10; i++) {
            rek.stortBedrag(100);
        }
        assertEquals(1000, rek.getSaldo(), 0);
    }

    @Test
    public void testHaalBedragAf() {
        System.out.println("haalBedragAf");
        testConstructorBis();

        for (int i = 0; i < 10; i++) {
            rek.haalBedragAf(100);
        }
        assertEquals(0, rek.getSaldo(), 0);
    }

    @Test
    public void testHaalBedragAfBis() {
        System.out.println("haalBedragAfBis");
        testConstructorBis();

        double[] verrichtingen = {100, -50, 75, -25, 150};
        for (int i = 0; i < verrichtingen.length; i++) {
            rek.stortBedrag(verrichtingen[i]);
        }
        assertEquals(250, rek.getSaldo(), 0);
    }
}
