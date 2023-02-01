package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kristien.vanassche
 */
public class FiguurTestDeel2 {
    private Figuur[] fig;

    @Before
    public void setUp() throws Exception {
        fig = new Figuur[4];
        Punt middelpunt = new Punt(1,2); 
        fig[0] = new Cirkel(middelpunt, 2.0);
        fig[1] = new Vierkant(middelpunt, 2.0);
        fig[2] = new Vierkant(middelpunt, 2.0);
        fig[3] = new Vierkant(middelpunt, 3.0);
    }

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Figuur");

        Field[] fields = c.getDeclaredFields();
        assertEquals(4, fields.length);
        
        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    /**
     * Test overerving
     */
    @Test
    public void testOvererving() {
        System.out.println("test overerving");
        for (Figuur f : fig) {
            if (f instanceof Cirkel)
                System.out.println("Cirkel");
            else if (f instanceof Vierkant) {
                System.out.println("Vierkant");
            }
            else assertFalse(true);
        }
    }

    /**
     * Test of getMiddelpunt method, of class Figuur.
     */
    @Test
    public void testGetMiddelpunt() {
        System.out.println("getMiddelpunt");
        for (Figuur f : fig) {
            Punt mp = f.getMiddelpunt();
            assertEquals(mp, new Punt(1,2));
        }
    }

    /**
     * Test of setMiddelpunt method, of class Figuur.
     */
    @Test
    public void testSetMiddelpunt() {
        System.out.println("setMiddelpunt");
        Figuur f1 = fig[0];
        Punt mp = f1.getMiddelpunt();
        mp.setY(3);
        assertEquals(f1.getMiddelpunt(), new Punt(1,3));
        f1.setMiddelpunt(new Punt(1,4));
        assertEquals(f1.getMiddelpunt(), new Punt(1,4));        
    }

    /**
     * Test of berekenAfstand method, of class Figuur.
     */
    @Test
    public void testBerekenAfstand() {
        System.out.println("berekenAfstand");

        assertEquals(0, fig[0].berekenAfstand(fig[1]), 0.0);
        
        for(int i = 0; i < 10; i++) {
           fig[0].setMiddelpunt(new Punt(1,2+i));            
           assertEquals(i, fig[0].berekenAfstand(fig[1]), 0.0);
        }
    }

    @Test
    public void testBerekenOmtrek() {
        System.out.println("test berekenOmtrek");

        assertEquals(12.56, fig[0].berekenOmtrek(), 0.01);        
        assertEquals(8, fig[1].berekenOmtrek(), 0.0);
    }

    /**
     * Test of berekenOppervlakte method, of class Cirkel.
     */
    @Test
    public void testBerekenOppervlakte() {
        System.out.println("test berekenOppervlakte");
        
        assertEquals(12.56, fig[0].berekenOppervlakte(), 0.1);
        assertEquals(4, fig[1].berekenOppervlakte(), 0.0);
    }

    /**
     * Test of equals method, of class Figuur.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertNotEquals(fig[0],fig[1]);
        assertEquals(fig[0].getMiddelpunt(), fig[1].getMiddelpunt());
        
        assertEquals(fig[1],fig[2]);
        assertEquals(fig[1].getMiddelpunt(), fig[2].getMiddelpunt());

        assertNotEquals(fig[2],fig[3]);        
        assertEquals(fig[1].getMiddelpunt(), fig[2].getMiddelpunt());
    }  
}
