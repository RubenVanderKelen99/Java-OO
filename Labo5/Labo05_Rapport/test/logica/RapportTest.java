package logica;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author kristien.vanassche
 */
public class RapportTest {
    @Test
    public void test1() {
        Rapport r = new Rapport(new String[] {"a", "b", "c",},20);
        r.setScore("a", 1); //1/20
        r.setScore("b", 2); //2/20
        r.setScore("c", 3); //3/20 == 6/60
        double expectedResult = 10; // = 10 / 100
        assertEquals(expectedResult, r.geefResultaatProcent(), 0.0);
    }
    
    @Test
    public void test2() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        r.setScore("a", 19);
        r.setScore("b", 12);
        r.setScore("c", 13);
        double expectedResult = 73.33;
        assertEquals(expectedResult, r.geefResultaatProcent(), 0.01);
        assertEquals(expectedResult, r.geefResultaatProcent(), 0.001);         
    }

    @Test
    public void test3() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        String[] vakken = r.getVakken();
        assertEquals(3, vakken.length);
        for(String v : vakken) {
            assertEquals(Rapport.UNDEFINED_SCORE, r.getScore(v));
        }
    }
    
    @Test
    public void test4() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        String[] vakken = r.getVakken();
        for(String v : vakken) {
            r.setScore(v, 10);
        }        
        assertEquals(Graad.VOLDOENING, r.geefGraad());

        r.setScore(vakken[0], 3);
        assertEquals(Graad.NIET_GESLAAGD, r.geefGraad()); // moet  NIET_GESLAAGD zijn
    }
    
    @Test
    public void test5() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        String[] vakken = r.getVakken();
        
        for (int score = 0; score <= 20; score++) {
            for (String v : vakken) {
                r.setScore(v, score);
            }
            
            assertEquals(bepaalGraad(score), r.geefGraad());            
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void test6() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        r.setScore("a", 10);
        r.setScore("b", 20);
        r.setScore("c", 30);
    }

    @Test (expected = IllegalStateException.class)
    public void test7() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        r.setScore("a", 1);
        r.setScore("b", 2);
        
        System.out.println(r.geefResultaatProcent());       
    }
    
    @Test
    public void test8() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        r.setScore("a", 1);
        r.setScore("b", 2);
        r.setScore("c", 3);
        r.setScore("d", 4); //no effect
        assertEquals(10, r.geefResultaatProcent(), 0.0);        
    }

    @Test
    public void test9() {
        Rapport r = new Rapport(new String[] {"a", "b", "c"},20);
        r.setScore("a", 1);
        r.setScore("b", 2);
        r.setScore("x", 3); //no effect 
        assertEquals(1, r.getScore("a"));
        assertEquals(2, r.getScore("b"));
        assertEquals(Rapport.UNDEFINED_SCORE, r.getScore("c"));      
        assertEquals(Rapport.UNDEFINED_SCORE, r.getScore("x"));  // moet nul zijn
    }

    @Test
    public void testVelden() throws ClassNotFoundException {
        System.out.println("testVelden");
        
        Class c = Class.forName("logica.Rapport");
        
        
        int countFields = 0;
        int countPrivateFields = 0;
        int countPublicStaticFinal = 0;
        
        for (Field f : c.getDeclaredFields()) {
            countFields++;
            if ((f.getModifiers() & Modifier.PUBLIC) != 0 && (f.getModifiers() & Modifier.STATIC) != 0 && (f.getModifiers() & Modifier.FINAL) != 0) {
                countPublicStaticFinal++;
            }
            else if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                countPrivateFields++;
            }
        }
        
        System.out.println("-->> Je hebt " + countFields + " velden gedefinieerd, waarvan " + countPrivateFields + " private en " + countPublicStaticFinal + " publieke constanten.");
        //assertEquals(4, countFields);
        assertEquals(2, countPrivateFields);  
        assertEquals(2, countPublicStaticFinal);  
    }
    
    @Test
    public void testMethoden() throws ClassNotFoundException {
        System.out.println("testMethoden");
        
        Class c = Class.forName("logica.Rapport");
        
        int countMeth = c.getDeclaredMethods().length;

        int countMethPriv = 0;
        for (Method f : c.getDeclaredMethods()) {
            if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                countMethPriv++;
            }
        }
        System.out.println("-->> Je hebt " + countMeth + " methoden gedefinieerd, waarvan " + countMethPriv + " private.");
        
        assertTrue(countMeth >= 9);
        assertTrue(countMethPriv >= 4);
    }
    
    @Test
    public void testConstructor() throws ClassNotFoundException {
        System.out.println("testConstructor");
        
        Class c = Class.forName("logica.Rapport");
        assertTrue(c.getDeclaredConstructors().length >= 1);
        
        for(Constructor constr : c.getDeclaredConstructors()) {
            if (constr.getParameterCount() == 1) {
                Class[] parameterTypes = constr.getParameterTypes();
                assertEquals(1, parameterTypes.length);
                assertEquals("java.lang.String[]", parameterTypes[0].getTypeName());
            }
        }
    }
    
    private Graad bepaalGraad(int score) {
        return score < 10 ? Graad.NIET_GESLAAGD : 
                score < 13 ? Graad.VOLDOENING : 
                score < 15 ? Graad.ONDERSCHEIDING : 
                score < 17 ? Graad.GROTE_ONDERSCHEIDING : 
                Graad.GROOTSTE_ONDERSCHEIDING;
    }
}