package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class WoordSpelTestDeel2 {
    WoordSpel spel;

    @Before
    public void setUp() {
        spel = new WoordSpel();
    }

    @Test
    public void testVelden() throws ClassNotFoundException {
        Class<?> c = Class.forName("logica.WoordSpel");
        for (Field f : c.getDeclaredFields()) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }        
    }
    
    @Test
    public void testGetAantalBeurten() {
        assertEquals(0, spel.getAantalBeurten());
    }

    @Test
    public void testNogBeurten() {
        assertTrue(spel.nogBeurten());
    }

    @Test
    public void testNogBeurtenBis() {
        assertEquals(0, spel.getAantalBeurten());
        int i = 0;
        while(spel.nogBeurten()) {
            assertTrue(spel.nogBeurten());
            spel.gok('*');
            assertEquals((i+1), spel.getAantalBeurten());
            i++;
        }
    }
    
    @Test
    public void testGok() {
        int aantalTodo = spel.gok('_').length();
        char letter = 'a';
        String woord = "";
        
        while (aantalTodo > 0) {
            woord = spel.gok(letter);
            //System.out.println(woord);
            aantalTodo = telOnbekende(woord);
           
            if (letter == 'z') letter = 'A';
            else if (letter == 'Z') letter = '0';
            else letter++;
        }
        
        assertFalse(spel.gok("").contains("_"));        
        assertEquals(0, aantalTodo);
        assertEquals(spel.gok(woord), woord);
    }

    @Test
    public void testGokBis() {
        spel = new WoordSpel(1000);
        int aantalTodo = spel.gok('_').length();
        char letter = 'a';
        String woord = "";
        
        while (!spel.isGeraden() && spel.nogBeurten()) {
            woord = spel.gok(letter);
            //System.out.println(woord);
            aantalTodo = telOnbekende(woord);
           
            if (letter == 'z') letter = 'A';
            else if (letter == 'Z') letter = '0';
            else letter++;
        }
        
        assertFalse(spel.gok("").contains("_"));        
        assertEquals(0, aantalTodo);
        assertEquals(spel.gok(woord), woord);
    }
    
    private int telOnbekende(String woord) {
        int aantal = 0;
        for(int i = 0; i < woord.length(); i++) {
            if (woord.charAt(i) == '_') aantal++;
        }
        return aantal;
    }
}
