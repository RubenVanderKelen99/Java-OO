package logica;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class BoomTest {
    private Boom b1, b2;
    
    @Before
    public void setUp() {
        b1 = new Boom();
        b2 = new Boom(123);
    }

    @Test
    public void testGetHoogte() {
        System.out.println("groei");
        assertEquals(0, b1.huidigeHoogte());
        assertEquals(123, b2.huidigeHoogte());
    }

    @Test
    public void testGroei() {
        System.out.println("groei");
        b1.groei();
        assertEquals(25, b1.huidigeHoogte());
        b2.groei();
        assertEquals(148, b2.huidigeHoogte());
    }

    @Test
    public void testSnoei() {
        System.out.println("snoei");
        b1.snoei();
        assertEquals(0, b1.huidigeHoogte());
        b2.snoei();
        assertEquals(98, b2.huidigeHoogte());
    }
    
    @Test
    public void testGroeiBis() {
        System.out.println("groeiBis");
        
        for(int i = 0; i < 10; i++) {
            b1.groei();
            b2.groei();
        }
        
        assertEquals(250, b1.huidigeHoogte());
        assertEquals(250, b2.huidigeHoogte());
    }
    
    @Test
    public void testSnoeiBis() {
        System.out.println("snoeiBis");
        
        for(int i = 0; i < 4; i++) {
            b1.snoei();
            b2.snoei();
        }
        
        assertEquals(0, b1.huidigeHoogte());
        assertEquals(23, b2.huidigeHoogte());
    }
}