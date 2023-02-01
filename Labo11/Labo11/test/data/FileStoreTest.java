package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import logica.Quiz;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author kristien.vanassche
 */
public class FileStoreTest {

    private FileStore fileStore;

    @BeforeClass
    public static void init() throws IOException {    
        clear();
        populate();
    }
    
    public FileStoreTest() {
        String datamap = "./test/JunitTestData";
        fileStore = new FileStore(datamap);     
    }

    private static void clear() {
        String datamap = "./test/JunitTestData";
        File[] listFiles = new File(datamap).listFiles();
        if (listFiles != null) {
            for (File f : listFiles) {
                f.delete();
            }
            new File(datamap).delete();
        }
        new File(datamap).mkdir();
    }

    private static void populate() throws IOException {
        String datamap = "./test/JunitTestData";
        File f;
        for (int i = 1; i <= 3; i++) {
            f = new File(datamap, "Test" + i + ".csv");
            f.createNewFile();

            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
                for (int j = 0; j < i; j++) {
                    pw.println("Q" + j + "\t" + "A" + j);
                }
            }
        }
    }

    @Test
    public void testGeefQuizNamen() {
        System.out.println("geefQuizNamen");
        String[] expResult = new String[]{"Test1", "Test2", "Test3"};
        String[] result = fileStore.geefQuizNamen();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testLeesQuizNaam() throws IOException {
        System.out.println("leesQuizNaam");
        for (int i = 1; i <= 3; i++) {
            assertEquals("Test" + i, fileStore.leesQuiz("Test" + i).getNaam());
        }
    }

    @Test
    public void testLeesQuizAantalVragen() throws IOException {
        System.out.println("leesQuizAantalVragen");
        for (int i = 1; i <= 3; i++) {
            assertEquals(i, fileStore.leesQuiz("Test" + i).geefAlleVragen().size());
        }
    }

    @Test
    public void testLeesQuizVragen() throws Exception {
        System.out.println("leesQuizVragen");
        for (int i = 1; i <= 3; i++) {
            assertEquals("Q" + (i - 1), fileStore.leesQuiz("Test" + i).getVraag(i - 1));
        }
    }

    @Test
    public void testLeesQuizBis() throws Exception {
        System.out.println("leesQuiz");
        String expResult;
        for (int i = 1; i <= 3; i++) {
            expResult = "";
            for (int j = 0; j < i; j++) {
                expResult += "Q" + j + "\t" + "A" + j + "\r\n";
            }
            assertEquals(expResult, fileStore.leesQuiz("Test" + i).toString());
        }
    }

    @Test
    public void testSchrijfQuizEnVerwijderQuiz() throws Exception {
        System.out.println("schrijfQuiz");
        Quiz q = new Quiz("XTRA");
        q.voegVraagAntwoordToe("QX", "AQ");
        fileStore.schrijfQuiz(q);
        assertEquals(4, fileStore.geefQuizNamen().length);

        System.out.println("verwijderQuiz");
        String quizNaam = "XTRA";
        fileStore.verwijderQuiz(quizNaam);
        assertEquals(3, fileStore.geefQuizNamen().length);
    }
}
