package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class VierkantTest {

    private Vierkant v1, v2;

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Vierkant");

        Field[] fields = c.getDeclaredFields();
        assertEquals(1, fields.length);

        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    @Test
    public void testConstructorDefault() {
        System.out.println("testconstructorDefault");

        assertNotNull(v1 = new Vierkant());
        assertEquals(Kleur.wit, v1.getKleur());
        assertEquals(Kleur.zwart, v1.getKleurRand());
        assertEquals(1, v1.getDikteRand());
        assertEquals(50, v1.getZijde(), 0);
        assertEquals(new Punt(0, 0), v1.getMiddelpunt());
    }

    @Test
    public void testConstructorOrig() {
        System.out.println("testconstructorOrig");

        assertNotNull(v1 = new Vierkant(new Punt(1, 2), 3));
        assertEquals(Kleur.wit, v1.getKleur());
        assertEquals(Kleur.zwart, v1.getKleurRand());
        assertEquals(1, v1.getDikteRand());
        assertEquals(3, v1.getZijde(), 0);
        assertEquals(new Punt(1, 2), v1.getMiddelpunt());
    }

    @Test
    public void testConstructorBis() {
        System.out.println("testconstructorBis");

        assertNotNull(v1 = new Vierkant(3));
        assertEquals(Kleur.wit, v1.getKleur());
        assertEquals(Kleur.zwart, v1.getKleurRand());
        assertEquals(1, v1.getDikteRand());
        assertEquals(3, v1.getZijde(), 0);
        assertEquals(new Punt(0, 0), v1.getMiddelpunt());
    }

    @Test
    public void testConstructorTris() {
        System.out.println("testconstructorTris");

        assertNotNull(v1 = new Vierkant(13, Kleur.blauw, Kleur.geel, 12));
        assertEquals(Kleur.blauw, v1.getKleur());
        assertEquals(Kleur.geel, v1.getKleurRand());
        assertEquals(12, v1.getDikteRand());
        assertEquals(13, v1.getZijde(), 0);
        assertEquals(new Punt(0, 0), v1.getMiddelpunt());
    }

    @Test
    public void testGetterSetter() {
        System.out.println("testGetterSetter");

        assertNotNull(v1 = new Vierkant());
        v1.setMiddelpunt(new Punt(1, 2));
        assertEquals(new Punt(1, 2), v1.getMiddelpunt());
    }

    @Test
    public void testEquals() {
        System.out.println("test equals");
        v1 = new Vierkant(7.0);
        v2 = new Vierkant(7.0);
        assertEquals(true, v1.equals(v2));
        Vierkant instance = new Vierkant(2.0);
        assertEquals(false, instance.equals(v1));
    }

    @Test
    public void testEqualsBis() {
        System.out.println("test equalsBis");
        Vierkant c1 = new Vierkant(5, Kleur.blauw, Kleur.geel, 12);

        Vierkant instance = new Vierkant(5, Kleur.wit, Kleur.wit, 12);
        assertEquals(false, instance.equals(c1));
        instance = new Vierkant(5, Kleur.blauw, Kleur.geel, 111);
        assertEquals(false, instance.equals(c1));
        instance = new Vierkant(5, Kleur.blauw, Kleur.geel, 12);
        assertEquals(true, instance.equals(c1));
    }

    @Test
    public void testBerekenAfstand() {
        System.out.println("testBerekenAfstand");

        v1 = new Vierkant();
        v2 = new Vierkant();
        v2.setMiddelpunt(new Punt(2, 3));

        assertEquals(Math.sqrt(13), v1.getMiddelpunt().berekenAfstand(v2.getMiddelpunt()), 0);
        assertEquals(Math.sqrt(13), v1.berekenAfstand(v2), 0);
        assertEquals(Math.sqrt(13), v1.berekenAfstand(v2.getMiddelpunt()), 0);

        v1.setMiddelpunt(new Punt(-10, 3));
        assertEquals(12, v1.berekenAfstand(v2), 0);
    }
}
