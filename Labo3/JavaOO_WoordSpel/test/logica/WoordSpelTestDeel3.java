package logica;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author kristien.vanassche
 */
public class WoordSpelTestDeel3 {    
    @Test
    public void testWoordenlijstHaalWoord() {
        String woord = Woordenlijst.haalWoord();
        assertNotNull(woord);
        assertTrue(woord.length() > 0);
    }
    
    @Test
    public void testWoordenlijstHaalWoordBis() {
        String woord = Woordenlijst.haalWoord(100);
        assertNotNull(woord);
        assertTrue(woord.length() > 0);        
    }
    
    @Test (expected = Exception.class)
    public void testWoordenlijstHaalWoordTris() {
        Woordenlijst.haalWoord(-1);
    }
    
    @Test  (expected = Exception.class)
    public void testWoordSpelTris() {
        WoordSpel spel = new WoordSpel(1, 1);
    }

    @Test
    public void testWoordSpelBis() {
        WoordSpel spel = new WoordSpel(1, 10);
        spel.gok('a');        
        assertFalse(spel.nogBeurten());
    } 

    @Test
    public void testWoordSpel() {
        WoordSpel spel = new WoordSpel(1000, 10);
        char letter = 'a';
        String woord;
        while(spel.nogBeurten()) {
            woord = spel.gok(letter);
            if (letter == 'z') letter = 'A';
            else if (letter == 'Z') letter = '0';
            else letter++;
        }
        
        assertTrue(spel.isGeraden());
    }   
}
