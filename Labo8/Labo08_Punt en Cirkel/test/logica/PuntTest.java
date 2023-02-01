package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class PuntTest {

    private Punt punt1, punt2, punt3;

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Punt");

        Field[] fields = c.getDeclaredFields();
        assertEquals(2, fields.length);

        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    @Before
    public void setUp() {
        punt1 = new Punt(12, 13);
        punt2 = new Punt(12, 13);
        punt3 = new Punt(12, 14);
    }

    @Test
    public void testGettersSetters() {
        System.out.println("getters");

        assertEquals(12, punt1.getX());
        assertEquals(13, punt1.getY());

        punt1.setX(21);
        punt1.setY(22);

        assertEquals(21, punt1.getX());
        assertEquals(22, punt1.getY());
    }

    /**
     * Test of toString method, of class Punt.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        assertEquals(true, punt1.toString().equals(punt2.toString()));
        assertEquals(false, punt1.toString().equals(punt3.toString()));
    }

    /**
     * Test of equals method, of class Punt.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        assertEquals(true, punt1.equals(punt2));
        assertEquals(false, punt1.equals(punt3));
    }

    /**
     * Test of berekenAfstand method, of class Punt.
     */
    @Test
    public void testBerekenAfstand() {
        System.out.println("berekenAfstand");

        assertEquals(0, punt1.berekenAfstand(punt2), 0.0);
        assertEquals(1, punt1.berekenAfstand(punt3), 0.0);
        assertEquals(Math.sqrt(50), new Punt(0, 0).berekenAfstand(new Punt(5, 5)), 0);
        assertEquals(Math.hypot(2, 6), new Punt(1, 1).berekenAfstand(new Punt(3, 7)), 0);
    }

    @Test
    public void testMethodSignatureEquals() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureEquals");
        Class<?> c = Class.forName("logica.Punt");

        Method m = c.getDeclaredMethod("equals", Class.forName("java.lang.Object"));
        assertEquals(1, m.getParameterCount());
        assertEquals(Boolean.TYPE, m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }

    @Test
    public void testMethodSignatureToString() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureToString");
        Class<?> c = Class.forName("logica.Punt");

        Method m = c.getDeclaredMethod("toString");
        assertEquals(0, m.getParameterCount());
        assertEquals(Class.forName("java.lang.String"), m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
}
