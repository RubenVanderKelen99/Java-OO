/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import be.odisee.ikdoeict.TextFile;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import logica.Deeltraject;
import logica.Docent;
import logica.EtStudent;
import logica.Opleiding;

/**
 *
 * @author Ruben
 */
public class ET_Console {

    private String fileName = "C:\\Users\\Ruben\\Documents\\NetBeansProjects\\Labo10\\Labo10_FileReader\\src\\files\\StudentenET.csv";

    List<EtStudent> studenten = new ArrayList<>();

    public List<EtStudent> leesEtStudenten() throws IOException, ParseException {

        TextFile tf = new TextFile();
        String txt = tf.read(fileName);
        String[] lines = txt.split("\n");
        for (int i = 0; i < lines.length; i++) {
            //  System.out.println("volledige lijn : " + lines[i]);
            String line = lines[i];
            String naam = line.split(";")[0];
            String voornaam = line.split(";")[1];
            String opleiding = line.split(";")[2];
            Deeltraject d;
            d = Deeltraject.NONE;
            Opleiding o = getOpleiding(opleiding);
            EtStudent et = new EtStudent(naam, voornaam, o, d);
            studenten.add(et);
        }
        return studenten;
    }

    public Opleiding getOpleiding(String input) {
        Opleiding o;
        if (input.equals("ET")) {
            o = Opleiding.ET;

        } else if (input.equals("ELOICT")) {

            o = Opleiding.ELOICT;
        } else {
            o = Opleiding.OPT;
        }
        return o;
    }

}
