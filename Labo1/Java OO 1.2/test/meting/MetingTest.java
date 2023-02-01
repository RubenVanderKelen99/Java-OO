package meting;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author kristien.vanassche
 */
public class MetingTest {
    private Meting meting;
    Class<?> m;

    public MetingTest() throws ClassNotFoundException {
        meting = new Meting("TEST", 2017);
    }

    private void vulMeting() {
        double[] tempWaarden = {0, 0.5, 1, 1.5, 2, 2.5, 3};

        for (int i = 0; i < 12; i++) {
            meting.zetWaardenVoorMaand(i, tempWaarden);
        }
    }

    private void vulMeting2() {
        double[] tempWaarden = {-1, 1, -2, 2, -3, 3, -4, 4, 0};

        for (int i = 0; i < 12; i++) {
            meting.zetWaardenVoorMaand(i, tempWaarden);
        }
    }

    private void vulMeting3() {
        vulMeting();
        meting.zetWaardenVoorMaand(6, new double[]{15, 16, 17, 18, 19, 20});
        meting.zetWaardenVoorMaand(1, new double[]{-8, -7, -6, -5, -4, -3, -2});
    }
    
    private void vulMeting4() {
        meting.zetWaardenVoorMaand(0, new double[]{1,2,3,4,5,6});
    }
        
    @Test
    public void testGeefOverzichtMeetwaarden() {
        System.out.println("geefOverzichtMeetwaarden");

        vulMeting();
        String result = meting.geefOverzichtMeetwaarden();
        //System.out.println(result);

        for (double d = 0; d <= 3; d += 0.5) {
            assertTrue(result.contains(Double.toString(d)));
        }
        for (double d = 3.5; d <= 6; d += 0.5) {
            assertFalse(result.contains(Double.toString(d)));
        }

        vulMeting2();
        result = meting.geefOverzichtMeetwaarden();
        //System.out.println(result);

        for (double d = -4; d <= 4; d += 1) {
            assertTrue(result.contains(Double.toString(d)));
        }
        for (double d = -4; d <= 4; d += 0.5) {
            if (d != (int) d) {
                assertFalse(result.contains(Double.toString(d)));
            }
        }
    }

    @Test
    public void testGeefOverzichtMeetwaardenBis() {
        System.out.println("geefOverzichtMeetwaarden");

        vulMeting4();
        String result = meting.geefOverzichtMeetwaarden();
        //System.out.println(result);

        for (double d = 1; d <= 6; d += 1) {
            assertTrue(result.contains(Double.toString(d)));
        }
    }

    @Test
    public void testGeefAnalyse() {
        System.out.println("geefAnalyse");

        vulMeting();
        String result = meting.geefAnalyse();
        //System.out.println(result);

        String[] parts = result.split("\t|\n");
        int countMin = 0, countMax = 0, countAvg = 0;
        for (String part : parts) {
            if (part.equals("0.0")) {
                countMin++;
            }
            if (part.equals("3.0")) {
                countMax++;
            }
            if (part.equals("1.5")) {
                countAvg++;
            }
        }
        assertEquals(12, countMin);
        assertEquals(12, countMax);
        assertEquals(12, countAvg);

        vulMeting2();
        result = meting.geefAnalyse();
        //System.out.println(result);

        parts = result.split("\t|\n");
        countMin = countMax = countAvg = 0;
        for (String part : parts) {
            if (part.equals("-4.0")) {
                countMin++;
            }
            if (part.equals("4.0")) {
                countMax++;
            }
            if (part.equals("0.0")) {
                countAvg++;
            }
        }
        assertEquals(12, countMin);
        assertEquals(12, countMax);
        assertEquals(12, countAvg);
    }

    @Test
    public void testGeefDagHoogsteRespLaagsteMeting() {
        System.out.println("geefDagHoogsteRespLaagsteMeting");

        vulMeting3();
        String result = meting.geefDatumHoogsteMeting().toString();
        assertEquals("2017-07-06", result);
        result = meting.geefDatumLaagsteMeting().toString();
        assertEquals("2017-02-01", result);
    }

    @Test
    public void testGeefWaardeHoogsteRespLaagsteMeting() {
        System.out.println("geefWaardeHoogsteRespLaagsteMeting");

        vulMeting3();
        double result = meting.geefWaardeHoogsteMeting();
        assertEquals(20, result, 0.0);
        result = meting.geefWaardeLaagsteMeting();
        assertEquals(-8, result, 0.0);
    }

    @Test
    public void testGeefMaandHoogsteRespLaagsteMaandgemiddelde() {
        System.out.println("geefMaandHoogsteRespLaagsteMaandgemiddelde");

        vulMeting3();
        String result = meting.geefMaandHoogsteMaandgemiddelde();
        assertEquals("JUL'17", result);
        result = meting.geefMaandLaagsteMaandgemiddelde();
        assertEquals("FEB'17", result);
    }

    @Test
    public void testGeefWaardeHoogsteRespLaagsteMaandgemiddelde() {
        System.out.println("geefWaardeHoogsteRespLaagsteMaandgemiddelde");

        vulMeting3();
        double result = meting.geefWaardeHoogsteMaandgemiddelde();
        assertEquals(17.5, result, 0.0);
        result = meting.geefWaardeLaagsteMaandgemiddelde();
        assertEquals(-5, result, 0.0);
    }

    @Test
    public void testDatavelden() throws ClassNotFoundException {
        System.out.println("testDatavelden");
        
        m = Class.forName("meting.Meting");
        assertEquals(3, m.getDeclaredFields().length);
        
        int count = 0;
        for (Field f : m.getDeclaredFields()) {
            if ((f.getModifiers() & Modifier.FINAL) != 0) {
                count++;
            }
        }
        assertEquals(2, count);  
    }
    
    @Test
    public void testMethoden() throws ClassNotFoundException {
        System.out.println("testMethoden");
        
        m = Class.forName("meting.Meting");
        assertTrue(m.getDeclaredMethods().length > 11);

        int count = 0;
        for (Method f : m.getDeclaredMethods()) {
            if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                //System.out.println("private methode -->>" + f.getName());
                count++;
            }
        }
        System.out.println("-->> " + count + " private methoden!");
        assertTrue(count >= 3);
    }
    
    @Test
    public void testConstructor() throws ClassNotFoundException {
        System.out.println("testConstructor");
        
        assertNotNull(meting);
        
        m = Class.forName("meting.Meting");
        assertTrue(m.getDeclaredConstructors().length == 1);
        assertEquals(2, m.getDeclaredConstructors()[0].getParameterCount());
    }
}
