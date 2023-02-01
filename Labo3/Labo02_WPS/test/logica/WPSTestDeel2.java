package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class WPSTestDeel2 {
    private WPS wps;

    @Test //extra test op labo van vorige week
    public void testGetPincodeNotZeros() {
        System.out.println("testGetPincodeNotZeros");

        WPS instance = new WPS();
        String code = instance.getPincode();
        assertTrue(code.length() == 8 && !code.equals("00000000"));
    }

    @Test
    public void testConstructorValid() {
        System.out.println("testConstructorValid");
        WPS wps = new WPS("05863426");
        assertEquals("05863426", wps.getPincode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNotValid() {
        System.out.println("testConstructorNotValid");
        WPS wps = new WPS("12345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPincodeNotValid() {
        System.out.println("testSetPincodeNotValid");
        new WPS().setPincode("12345678");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNotValidBis() {
        System.out.println("testConstructorNotValidBis");
        wps = new WPS("paardjes");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPincodeNotValidBis() {
        System.out.println("testSetPincodeNotValidBis");
        new WPS().setPincode("paardjes");
    }
}
