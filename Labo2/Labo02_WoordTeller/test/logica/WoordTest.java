package logica;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class WoordTest {
    @Test
    public void testTelLetterStatisch() {
        System.out.println("test telLetter statisch");

        assertEquals(0, Woord.telLetter("Hallo", ' '));
        assertEquals(2, Woord.telLetter("Hallo", 'l'));
    } 

    @Test
    public void testTelLetterDynamisch() {
        System.out.println("test telLetter dynamisch");

        Woord instance = new Woord("Hallo");
        assertEquals(0, instance.telLetter(' '));        
        assertEquals(2, instance.telLetter('l'));
    }

    @Test
    public void testOverzichtStatus() {
        System.out.println("test overzicht status");
        
        Woord instance = new Woord("Hallo");
        assertEquals("Hallo", instance.geefOverzichtStatus());
        assertEquals(0, instance.telLetter(' '));        
        assertEquals("Hallo", instance.geefOverzichtStatus());
        assertEquals(2, instance.telLetter('l'));
        assertEquals("Ha**o", instance.geefOverzichtStatus());
    }  
    
    @Test
    public void testDatavelden() throws ClassNotFoundException {
        System.out.println("test Datavelden");
        
        Class<?> w = Class.forName("logica.Woord");
        assertEquals(2, w.getDeclaredFields().length);
        
        int countPrivate = 0;
        for (Field f : w.getDeclaredFields()) {
            if ((f.getModifiers() & Modifier.PRIVATE) != 0) {
                countPrivate++;
            }
        }
        assertEquals(2, countPrivate);  
    }
    
    @Test
    public void testMethoden() throws ClassNotFoundException {
        System.out.println("test Methoden");
        
        Class<?> w = Class.forName("logica.Woord");
        assertEquals(3, w.getDeclaredMethods().length);

        int countPrivate = 0;
        int countStatic = 0;
        for (Method m : w.getDeclaredMethods()) {
            if ((m.getModifiers() & Modifier.PRIVATE) != 0) {
                countPrivate++;
            }
            if ((m.getModifiers() & Modifier.STATIC) != 0) {
                countStatic++;
            }            
        }
        assertEquals(0, countPrivate);
        assertEquals(1, countStatic);
    }
    
    @Test
    public void testConstructor() throws ClassNotFoundException {
        System.out.println("test Constructor");
        
        Class<?> w = Class.forName("logica.Woord");
        assertEquals(1, w.getDeclaredConstructors().length);
        assertEquals(1, w.getDeclaredConstructors()[0].getParameterCount());
    }
}
