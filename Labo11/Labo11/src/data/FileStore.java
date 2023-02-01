/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import be.odisee.ikdoeict.TextFile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.*;

/**
 *
 * @author Ruben
 */
public class FileStore {

    private File datamap;

    public FileStore(String mapNaam) {
        datamap = new File("./"+mapNaam);
        datamap.mkdir();
        
    }

    public String[] geefQuizNamen() {
        File[] files = datamap.listFiles();
        String[] stringFiles = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            stringFiles[i] = files[i].getName().substring(0,files[i].getName().indexOf(".csv"));
        }
        return stringFiles;
    }

    public Quiz leesQuiz(String quizNaam) {
        Quiz q = new Quiz(quizNaam);
        try {
            String[] lines = TextFile.readLines(datamap+"\\"+quizNaam + ".csv");
            for (int i = 0; i < lines.length; i++) {
                String vraag;
                String antwoord;
                String lijn = lines[i];
                int index = lijn.indexOf("\t");
                
                vraag = lijn.substring(0,index);
                antwoord = lijn.substring(index+1);
                q.voegVraagAntwoordToe(vraag, antwoord);
            }

        } catch (IOException ex) {
            Logger.getLogger(FileStore.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //q.voegVraagAntwoordToe(vraag, antwoord);
        return q;
    }

    public void schrijfQuiz(Quiz q) {
        String naamQuiz = q.getNaam();
        try {
            File datamap = new File("./"+this.datamap);
            File bestand = new File(datamap+"\\"+naamQuiz + ".csv");
            if (!bestand.exists()) {
                bestand.createNewFile();
            }
            for (int i = 0; i < q.geefAlleVragen().size(); i++) {
                TextFile.write(bestand.toString(), q.getVraag(i)+"\t"+q.getAntwoord(i));
            }
        } catch (Exception e) {

        }

    }

    public void verwijderQuiz(String quizNaam) {
        File bestand = new File(datamap, quizNaam + ".csv");
        bestand.delete();
    }
    
}
