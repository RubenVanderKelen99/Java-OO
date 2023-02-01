package logica;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kristien.vanassche
 */
public class OdiseeMemberTest {
    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.OdiseeMember");

        Field[] fields = c.getDeclaredFields();
        assertEquals(4, fields.length);

        for (Field f : fields) {
            assert ((f.getModifiers() & Modifier.PRIVATE) != 0);
        }
    }

    @Test
    public void testMethodSignatureGetters() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureGetters");
        Class<?> c = Class.forName("logica.OdiseeMember");

        Field[] fields = c.getDeclaredFields();
        assertEquals(4, fields.length);
        for (Field f : fields) {
            Method m = c.getDeclaredMethod("get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1));
            assertEquals(0, m.getParameterCount());
            assertEquals(f.getType(), m.getReturnType());
            assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
            assertNotNull(m);
        }
    }

    @Test
    public void testMethodSignatureToString() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureToString");
        Class<?> c = Class.forName("logica.OdiseeMember");

        Method m = c.getDeclaredMethod("toString");
        assertEquals(0, m.getParameterCount());
        assertEquals(Class.forName("java.lang.String"), m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }

    @Test
    public void testMethodSignatureCompareTo() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testMethodSignatureCompareTo");
        Class<?> c = Class.forName("logica.OdiseeMember");

        Method m = c.getDeclaredMethod("compareTo", Class.forName("java.lang.Object"));
        assertEquals(1, m.getParameterCount());
        assertEquals(Integer.TYPE, m.getReturnType());
        assertTrue((m.getModifiers() & Modifier.PUBLIC) != 0);
        assertNotNull(m);
    }
    
    @Test
    public void testImplementationOfInterface() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("testImplementationOfInterfacec");
        Class<?> c = Class.forName("logica.OdiseeMember");

        AnnotatedType[] itf = c.getAnnotatedInterfaces();
        assertEquals(1, itf.length);
        assertEquals("java.lang.Comparable<logica.OdiseeMember>", itf[0].getType().getTypeName());
    }
}
