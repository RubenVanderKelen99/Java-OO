package logica;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kristien.vanassche
 */
public class WoordSpelTestDeel1 {
    WoordSpel spel;
    
    @Before
    public void setUp() {
        spel = new WoordSpel();
    }

    @Test
    public void testIsGeraden() {
        assertFalse(spel.isGeraden());  
    }

    @Test
    public void testGok_char() {
        assertNotSame("", spel.gok('*'));
        assertTrue(spel.gok('*').contains("_"));        
    }

    @Test
    public void testGok_String() {
        assertNotSame("", spel.gok(""));
        assertTrue(spel.gok("").contains("_"));
    }
    
    @Test
    public void testGok_charBis() {
        int aantalTodo = spel.gok('_').length();
        char letter = 'a';
        String woord = "";
        
        while (aantalTodo > 0) {
            woord = spel.gok(letter);
            aantalTodo = telOnbekendeLetters(woord);
            
            if (letter == 'z') letter = 'A';
            else if (letter == 'Z') letter = '0';
            else letter++;
        }
        
        assertFalse(spel.gok("").contains("_"));        
        assertEquals(0, aantalTodo);
        assertTrue(spel.isGeraden());
        assertEquals(spel.gok(woord), woord);
    }
    
    private int telOnbekendeLetters(String woord) {
        int aantal = 0;
        for(int i = 0; i < woord.length(); i++) {
            if (woord.charAt(i) == '_') aantal++;
        }
        return aantal;
    }
}
