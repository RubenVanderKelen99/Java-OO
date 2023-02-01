package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class ExtraTest {
    private OdiseeMember member1, member2, member3, member4, member5, member6, member7, member8;
    
    public ExtraTest() {
        member1 = new Student("Boelens", "Annemie", Opleiding.ELOICT, Deeltraject.ICTWEB); 
        member2 = new Docent("Coorevits", "Bas", Opleiding.ET, Deeltraject.NONE); 
        member3 = new Student("Dewever", "Charlotte", Opleiding.OPT, Deeltraject.NONE); 
        member4 = new Docent("Everaert", "Danny", Opleiding.OPT, Deeltraject.NONE);         
        member5 = new Student("Apers", "Evi", Opleiding.OPT, Deeltraject.NONE);         
        member6 = new Docent("Apers", "Evert", Opleiding.OPT, Deeltraject.NONE);         
        member7 = new Student("Apers", "Evert", Opleiding.OPT, Deeltraject.NONE);         
        member8 = new Docent("Boelens", "Annemie", Opleiding.ELOICT, Deeltraject.ICTINFRA); 
   }

    @Test
    public void testCompareTo() {
        System.out.println("testCompareTo");
        assertTrue(member2.compareTo(member1) < 0);
        assertTrue(member3.compareTo(member1) > 0);
        assertTrue(member3.compareTo(member2) > 0);
        assertTrue(member4.compareTo(member3) < 0);
        assertTrue(member5.compareTo(member4) > 0);
        assertTrue(member6.compareTo(member5) < 0);
        assertTrue(member7.compareTo(member6) > 0);
        assertTrue(member8.compareTo(member1) < 0);
    }
}
