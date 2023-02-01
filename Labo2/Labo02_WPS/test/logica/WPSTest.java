package logica;

import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class WPSTest {
 
    @Test
    public void testGetPincode() {
        System.out.println("getPincode");
        String code;
        WPS instance;
        
        for (int i = 0; i < 100; i++) {
            instance = new WPS();
            code = instance.getPincode();
            System.out.println("get >> " + code);

            assertTrue(isGeldig(code));
        }
    }

    @Test
    public void testConstructor() {
        System.out.println("default constructor");

        WPS instance = new WPS();
        String code = instance.getPincode();
        
        assertEquals(8, code.length());        
        assertTrue(code.matches("\\d+"));  //match an integer number 
    }    
    
    @Test
    public void testConstructorBis() {
        System.out.println("niet-default constructor");

        String code = "12345678";
        WPS instance = new WPS(code);
        assertEquals(code, instance.getPincode());        
    } 

    @Test
    public void testSetPincodeString() {
        System.out.println("setPincodeString");

        WPS instance = new WPS();
        
        instance.setPincode("39635297");
        assertTrue(isGeldig(instance.getPincode()));
        
        instance.setPincode("39635290");
        assertFalse(isGeldig(instance.getPincode()));
    }
    
    @Test
    public void testSetPincodeStringBis() {
        assertTrue(isGeldig(new WPS("10101018").getPincode()));
        assertTrue(isGeldig(new WPS("01010107").getPincode()));
        assertTrue(isGeldig(new WPS("00000000").getPincode()));
        assertTrue(isGeldig(new WPS("00000017").getPincode()));
        assertTrue(isGeldig(new WPS("00000109").getPincode()));
        assertTrue(isGeldig(new WPS("06755683").getPincode()));
    }

    @Test
    public void testSetPincodeRandom() {
        System.out.println("setPincodeRandom");

        WPS instance = new WPS();

        for (int i = 0; i < 100; i++) {
            instance.setPincode(generateWifiPincode());
            //System.out.println("set>> " + instance.getPincode());
            assertTrue(isGeldig(instance.getPincode()));
        }
    }

    private String generateWifiPincode() {
        int[] pincode = new int[8];

        for (int i = 0; i < 7; i++) {
            pincode[i] = (int) (Math.random() * 10);
        }

        zetChecksumDigit(pincode);

        return convert(pincode);
    }

    private void zetChecksumDigit(int[] pincode) {
        int somEven = 0;
        int somOneven = 0;
        for (int i = 0; i < 7; i += 2) {
            somOneven += pincode[i];
        }

        for (int i = 1; i < 7; i += 2) {
            somEven += pincode[i];
        }

        pincode[7] = (10 - ((somOneven * 3 + somEven) % 10))%10;
    }

    private boolean isGeldig(String code) {
        int[] pincode = convert(code);

        int somEven = 0;
        int somOneven = 0;
        for (int i = 0; i < 7; i += 2) {
            somOneven += pincode[i];
        }

        for (int i = 1; i < 7; i += 2) {
            somEven += pincode[i];
        }

        int controleBit = (10 - ((somOneven * 3 + somEven) % 10)) % 10;

        return pincode[7] == controleBit;
    }

    private static int[] convert(String s) {
        int[] rij = new int[8];
        
        for (int i = 0; i < s.length(); i++) {
            rij[i] = Integer.parseInt("" + s.charAt(i));
        }

        return rij;
    }

    private static String convert(int[] rij) {
        String s = "";
        for (int i = 0; i < rij.length; i++) {
            s += Integer.toString(rij[i]);
        }

        return s;
    }
    
    @Test
    public void testDatavelden() throws ClassNotFoundException {
        System.out.println("testDatavelden");
        
        Class<?> m = Class.forName("logica.WPS");
        assertEquals(1, m.getDeclaredFields().length);
        assertTrue((m.getDeclaredFields()[0].getModifiers() & Modifier.PRIVATE) != 0);  
    }
}
