package logica;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kristien.vanassche
 */
public class QuizTest {
    private Quiz quiz;

    @Before
    public void init() throws IOException {
        quiz = new Quiz("NAAM");
        
        for(int i = 0; i < 3; i++) {
            quiz.voegVraagAntwoordToe("Q"+i, "A"+i);
        }
    }

    @Test
    public void testQA() {
        System.out.println("QA");        
        QA qa = new QA("Q", "A");
        assertEquals("Q", qa.getVraag());
        assertEquals("A", qa.getAntwoord());       
    }
    
    @Test
    public void testQAEquals() {
        System.out.println("QAequals");
        QA qa = new QA("Q", "A");
        assertEquals(new QA("Q", "A"), qa);
        assertEquals(new QA("Q", "AAAA"), qa);
        assertNotEquals(new QA("QQQQ", "A"), qa);
    }

    @Test
    public void testGetNaam() {
        System.out.println("getNaam");;
        assertEquals("NAAM", quiz.getNaam());
    }
    
    @Test
    public void testGeefAlleVragen() {
        System.out.println("geefAlleVragen");     
        List<String> vragen = quiz.geefAlleVragen();
        assertEquals(3, vragen.size());
    } 
    
    @Test
    public void testGetVraag() {
        System.out.println("getVraag");
        List<String> vragen = quiz.geefAlleVragen();
        for(int i = 0; i < vragen.size(); i++) {
            assertEquals("Q"+i, vragen.get(i));
        }        
    }
    
    @Test
    public void testVoegVraagAntwoordToe() {
        System.out.println("voegVraagAntwoordToe");
        assertEquals(3, quiz.geefAlleVragen().size());
        quiz.voegVraagAntwoordToe("Q3", "A3");
        assertEquals(4, quiz.geefAlleVragen().size());
        for(int i = 0; i < 4; i++) {
            assertEquals("Q"+i, quiz.getVraag(i));
        }        
    }

    @Test
    public void testVerwijderVraag() {
        System.out.println("verwijderVraag");
        assertEquals(3, quiz.geefAlleVragen().size());
        quiz.voegVraagAntwoordToe("Q", "A");
        assertEquals(4, quiz.geefAlleVragen().size());
        quiz.verwijderVraag("Q");
        assertEquals(3, quiz.geefAlleVragen().size());
    }

    @Test
    public void testGeefWillekeurigeVraag() {
        System.out.println("geefWillekeurigeVraag");
        String vraag = quiz.geefWillekeurigeVraag();
        int vraagNr = vraag.charAt(1) - '0'; 
        //assertTrue(quiz.checkAntwoordOpVraag(vraagNr, "A"+vraagNr));
        assertTrue(quiz.checkAntwoordOpVraag(vraag, "A"+vraagNr));
    }

    @Test
    public void testCheckAntwoordOpVraag() {
        System.out.println("checkAntwoordOpVraag");

        for (int i = 0; i < 3; i++) {
            assertTrue(quiz.checkAntwoordOpVraag("Q"+i, "A"+i));
            //assertTrue(quiz.checkAntwoordOpVraag(i, "A"+i));
        }
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String s = "";
        for (int i = 0; i < quiz.geefAlleVragen().size(); i++) {
            s += "Q" + i + "\t" + "A" + i + "\r\n";
        }
        assertEquals(s, quiz.toString());
    }  
}
