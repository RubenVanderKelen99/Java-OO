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
public class StudentTest {
    private Student student1, student2, student3, student4, student5, student6, student7, student8;
    
    public StudentTest() {
        student1 = new Student("Boelens", "Annemie", Opleiding.ELOICT, Deeltraject.ICTWEB); 
        student2 = new Student("Coorevits", "Bas", Opleiding.ET, Deeltraject.NONE); 
        student3 = new Student("Dewever", "Charlotte", Opleiding.OPT, Deeltraject.NONE); 
        student4 = new Student("Everaert", "Danny", Opleiding.OPT, Deeltraject.NONE);         
        student5 = new Student("Apers", "Evi", Opleiding.OPT, Deeltraject.NONE);         
        student6 = new Student("Apers", "Evert", Opleiding.OPT, Deeltraject.NONE);         
        student7 = new Student("Apers", "Evert", Opleiding.OPT, Deeltraject.NONE);         
        student8 = new Student("Boelens", "Annemie", Opleiding.ELOICT, Deeltraject.ICTINFRA); 
   }

    @Test
    public void testDeclaredFieldsAndMethods() throws ClassNotFoundException {
        System.out.println("test fields and methods");
        Class<?> c = Class.forName("logica.Student");

        Field[] declFields = c.getDeclaredFields();
        assertEquals(0, declFields.length);
        
        Method[] declMethods = c.getDeclaredMethods();
        assertTrue(declMethods.length < 3);       
    }
    
    @Test
    public void testGetters() {
        System.out.println("testVelden");
        assertEquals("Boelens Annemie", student1.getNaam() + " " + student1.getVoornaam());
        assertEquals(Opleiding.ELOICT, student1.getOpleiding());
        assertEquals(Deeltraject.ICTWEB, student1.getDeeltraject());
    }


    @Test
    public void testToString() {
        System.out.println("testToString");
        assertTrue(student1.toString().contains("Annemie"));
    }

    @Test
    public void testCompareTo() {
        System.out.println("testCompareTo");
        assertTrue(student2.compareTo(student1) > 0);
        assertTrue(student3.compareTo(student1) > 0);
        assertTrue(student3.compareTo(student2) > 0);
        assertTrue(student4.compareTo(student3) > 0);
        assertTrue(student5.compareTo(student4) < 0);
        assertTrue(student6.compareTo(student5) < 0);
        assertTrue(student7.compareTo(student6) == 0);
        assertTrue(student8.compareTo(student1) < 0);
    }
    
    @Test
    public void testMethodSignatureCompareTo() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureCompareTo");
        Class<?> c = Class.forName("logica.Student");

        Method m = c.getMethod("compareTo", Class.forName("java.lang.Object"));
        assertEquals(1, m.getParameterCount());
        assertEquals(Integer.TYPE, m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
}
