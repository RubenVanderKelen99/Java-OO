package logica;

import java.lang.reflect.Constructor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kristien.vanassche
 */
public class RapportTestDeel2 {

    @Test
    public void test1() {
        Rapport r = new Rapport(new String[]{"a", "b", "c"}, 10);
        r.setScore("a", 1);
        r.setScore("b", 2);
        r.setScore("c", 3);
        double expectedResult = 20;
        assertEquals(expectedResult, r.geefResultaatProcent(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        Rapport r = new Rapport(new String[]{"a", "b", "c"}, 10);
        r.setScore("a", 19);
        r.setScore("b", 12);
        r.setScore("c", 13);
    }

    @Test
    public void test3() {
        Rapport r = new Rapport(new String[]{"a", "b", "c"}, 10);
        r.setScore("a", 8);
        r.setScore("b", 8);
        r.setScore("c", 8);
        assertEquals(Graad.GROTE_ONDERSCHEIDING, r.geefGraad());
    }

    @Test
    public void test4() {
        Rapport r = new Rapport(new String[]{"a", "b", "c"}, 10);
        String[] vakken = r.getVakken();
        for (String v : vakken) {
            r.setScore(v, 10);
        }

        assertEquals(100, r.geefResultaatProcent(), 0);
        assertEquals(Graad.GROOTSTE_ONDERSCHEIDING, r.geefGraad());

        r.setScore(vakken[0], 1);
        assertEquals(70, r.geefResultaatProcent(), 0);
        assertEquals(Graad.ONDERSCHEIDING, r.geefGraad()); //WANT 70% IS ONDERSCHEIDING
    }

    @Test
    public void test5() {
        Rapport r = new Rapport(new String[]{"a", "b", "c"}, 10);
        r.setScore("a", 10);
        assertEquals(10, r.getScore("a"));

        r.resetScore("a");
        assertEquals(Rapport.UNDEFINED_SCORE, r.getScore("a"));
    }

    @Test
    public void testConstructor() throws ClassNotFoundException {
        System.out.println("testConstructor");

        Class c = Class.forName("logica.Rapport");
        assertEquals(2, c.getDeclaredConstructors().length);

        for (Constructor constr : c.getDeclaredConstructors()) {
            Class[] parameterTypes = constr.getParameterTypes();
            assertEquals("java.lang.String[]", parameterTypes[0].getTypeName());

            if (constr.getParameterCount() == 2) {
                assertEquals(2, parameterTypes.length);
                assertEquals("int", parameterTypes[1].getTypeName());
            }
        }
    }
}
