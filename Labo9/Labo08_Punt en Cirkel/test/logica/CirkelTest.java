package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kristien.vanassche
 */
public class CirkelTest {

    private Cirkel instance;
    private Cirkel c1, c2;

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Cirkel");

        Field[] fields = c.getDeclaredFields();
        assertEquals(1, fields.length);

        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    @Before
    public void setUp() throws Exception {
        instance = new Cirkel(new Punt(1, 2), (int) 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNok1() {
        System.out.println("testconstructorNok1");
        c1 = new Cirkel(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNok2() {
        System.out.println("testconstructorNok2");
        c1 = new Cirkel(new Punt(0, 0), -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNok3() {
        System.out.println("testconstructorNok3");
        c1 = new Cirkel(-3, Kleur.blauw, Kleur.blauw, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNok4() {
        System.out.println("testconstructorNok4");
        c1 = new Cirkel(new Punt(0, 0), -3, Kleur.blauw, Kleur.blauw, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNok5() {
        System.out.println("testconstructorNok5");
        c1 = new Cirkel(new Punt(-1, -1), 3, Kleur.blauw, Kleur.blauw, -2);
    }

    @Test
    public void testConstructor() {
        System.out.println("testconstructor");

        assertNotNull(new Cirkel(new Punt(0, 0), 0));
        assertNotNull(new Cirkel(new Punt(-1, -1), 0));
    }

    @Test
    public void testConstructorExtraParDefault() {
        System.out.println("testconstructor ExtraParDefault");

        assertNotNull(c1 = new Cirkel(new Punt(1, 2), 3));
        assertEquals(Kleur.wit, c1.getKleur());
        assertEquals(Kleur.zwart, c1.getKleurRand());
        assertEquals(1, c1.getDikteRand());
        assertEquals(3, c1.getStraal(), 0);
    }

    @Test
    public void testConstructorExtraPar() {
        System.out.println("testconstructorExtraPar");

        assertNotNull(c2 = new Cirkel(new Punt(3, 4), 5, Kleur.blauw, Kleur.geel, 12));
        assertEquals(Kleur.blauw, c2.getKleur());
        assertEquals(Kleur.geel, c2.getKleurRand());
        assertEquals(12, c2.getDikteRand());
        assertEquals(5, c2.getStraal(), 0);
    }

    @Test
    public void testConstructorenDeel1Deel2Revised() {
        System.out.println("testconstructorDeel1Deel2Revised");

        assertNotNull(c1 = new Cirkel(new Punt(-1, -5), 13));
        assertEquals(Kleur.wit, c1.getKleur());
        assertEquals(Kleur.zwart, c1.getKleurRand());
        assertEquals(1, c1.getDikteRand());
        assertEquals(13, c1.getStraal(), 0);
        assertEquals(new Punt(-1, -5), c1.getMiddelpunt());

        assertNotNull(c2 = new Cirkel(new Punt(10, 11), 12, Kleur.blauw, Kleur.geel, 13));
        assertEquals(Kleur.blauw, c2.getKleur());
        assertEquals(Kleur.geel, c2.getKleurRand());
        assertEquals(13, c2.getDikteRand());
        assertEquals(12, c2.getStraal(), 0);
        assertEquals(new Punt(10, 11), c2.getMiddelpunt());

        assertFalse(c1.equals(c2));
    }

    @Test
    public void testConstructorDefault() {
        System.out.println("testconstructorDefault");

        assertNotNull(c1 = new Cirkel());
        assertEquals(Kleur.wit, c1.getKleur());
        assertEquals(Kleur.zwart, c1.getKleurRand());
        assertEquals(1, c1.getDikteRand());
        assertEquals(50, c1.getStraal(), 0);
        assertEquals(new Punt(0, 0), c1.getMiddelpunt());
    }

    @Test
    public void testConstructorenExtra() {
        System.out.println("testconstructorenExtra");

        assertEquals(new Cirkel(50),
                new Cirkel());

        //assertEquals(new Cirkel(123, Kleur.blauw, Kleur.geel, 12),
        //             new Cirkel(new Punt(0,0), 123, Kleur.blauw, Kleur.geel, 12));      
    }

    @Test
    public void testGetterSetterMiddelpunt() {
        System.out.println("testGetterSetterMiddelpunt");

        assertNotNull(c1 = new Cirkel());
        c1.setMiddelpunt(new Punt(1, 2));
        assertEquals(new Punt(1, 2), c1.getMiddelpunt());
    }

    @Test
    public void testEqualsDeel2() {
        System.out.println("testEqualsDeel2");

        assertEquals(true, new Cirkel(7).equals(new Cirkel(new Punt(0, 0), 7.0)));
        assertEquals(true, new Cirkel(7).equals(new Cirkel(7)));
        assertEquals(false, new Cirkel(7).equals(new Cirkel(8)));

        c1 = new Cirkel(5, Kleur.blauw, Kleur.geel, 12);
        c2 = new Cirkel(5, Kleur.blauw, Kleur.geel, 12);
        assertEquals(true, c1.equals(c2));

        c2.setMiddelpunt(new Punt(1, 3));
        assertEquals(false, c1.equals(c2));
    }

    @Test
    public void testBerekenAfstand() {
        System.out.println("test berekenAfstand");

        Punt punt1 = new Punt(1, 0);
        Punt punt2 = new Punt(5, 2);
        assertEquals(2.0, instance.berekenAfstand(punt1), 0);
        assertEquals(4.0, instance.berekenAfstand(punt2), 0);
    }

    @Test
    public void testBerekenAfstandBis() {
        System.out.println("testBerekenAfstandBis");

        c1 = new Cirkel();
        c2 = new Cirkel();
        c2.setMiddelpunt(new Punt(1, 2));

        assertEquals(Math.sqrt(5), c1.getMiddelpunt().berekenAfstand(c2.getMiddelpunt()), 0);
        assertEquals(Math.sqrt(5), c1.berekenAfstand(c2), 0);
        assertEquals(Math.sqrt(5), c1.berekenAfstand(c2.getMiddelpunt()), 0);

        c1.setMiddelpunt(new Punt(10, 2));
        assertEquals(9, c1.berekenAfstand(c2), 0);
    }

    /**
     * Test of berekenOmtrek method, of class Cirkel.
     */
    @Test
    public void testBerekenOmtrek() {
        System.out.println("test berekenOmtrek");

        double expResultOmtrek = 12.566370614359172;
        double resultOmtrek = instance.berekenOmtrek();
        assertEquals(expResultOmtrek, resultOmtrek, 0.0);
    }

    /**
     * Test of berekenOppervlakte method, of class Cirkel.
     */
    @Test
    public void testBerekenOppervlakte() {
        System.out.println("test berekenOppervlakte");

        double expResultOpp = 12.566370614359172;
        double resultOpp = instance.berekenOppervlakte();
        assertEquals(expResultOpp, resultOpp, 0.0);
    }

    /**
     * Test of toString method, of class Punt.
     */
    @Test
    public void testToString() {
        System.out.println("test toString");

        Cirkel c1 = new Cirkel(new Punt(1, 2), (int) 7.0);
        Cirkel c2 = new Cirkel(new Punt(1, 2), (int) 7.0);
        assertEquals(true, c1.toString().equals(c2.toString()));
        assertEquals(false, instance.toString().equals(c1.toString()));
    }

    /**
     * Test of equals method, of class Punt.
     */
    @Test
    public void testEquals() {
        System.out.println("test equals");
        c1 = new Cirkel(new Punt(1, 2), (int) 7.0);

        c2 = new Cirkel(new Punt(1, 2), (int) 7.0);
        assertEquals(true, c1.equals(c2));

        c2 = new Cirkel(new Punt(1, 2), (int) 2.0);
        assertEquals(false, c2.equals(c1));
    }

    @Test
    public void testEqualsBis() {
        System.out.println("test equalsBis");
        c1 = new Cirkel(new Punt(3, 4), 5, Kleur.blauw, Kleur.geel, 12);
        c2 = new Cirkel(new Punt(3, 4), 5, Kleur.wit, Kleur.wit, 12);

        assertEquals(false, c2.equals(c1));

        c2 = new Cirkel(new Punt(3, 4), 5, Kleur.blauw, Kleur.geel, 111);
        assertEquals(false, c2.equals(c1));

        c2 = new Cirkel(new Punt(3, 4), 5, Kleur.blauw, Kleur.geel, 12);
        assertEquals(true, c2.equals(c1));
    }

    @Test
    public void testMethodSignatureEquals() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureEquals");
        Class<?> c = Class.forName("logica.Cirkel");

        Method m = c.getDeclaredMethod("equals", Class.forName("java.lang.Object"));
        assertEquals(1, m.getParameterCount());
        assertEquals(Boolean.TYPE, m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }

    @Test
    public void testMethodSignatureToString() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureToString");
        Class<?> c = Class.forName("logica.Cirkel");

        Method m = c.getDeclaredMethod("toString");
        assertEquals(0, m.getParameterCount());
        assertEquals(Class.forName("java.lang.String"), m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
}
