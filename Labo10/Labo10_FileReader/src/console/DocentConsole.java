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
import java.util.Arrays;
import java.util.List;
import logica.Deeltraject;
import logica.Docent;
import logica.Opleiding;
import logica.Student;

/**
 *
 * @author Ruben
 */
public class DocentConsole {

    private String fileName = "C:\\Users\\Ruben\\Documents\\NetBeansProjects\\Labo10\\Labo10_FileReader\\src\\files\\Docenten.csv";

    List<Docent> docenten = new ArrayList<>();

    public List<Docent> leesDocenten() throws IOException, ParseException {

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
            try {
                String deeltraject = line.split(";")[3];
                d = getDeeltraject(deeltraject);
            } catch (Exception e) {

            }

            Opleiding o = getOpleiding(opleiding);

            Docent docent = new Docent(naam, voornaam, o, d);
            docenten.add(docent);
        }
        return docenten;
    }

    public Deeltraject getDeeltraject(String input) {
        Deeltraject d;
        if (input.equals("ICT")) {
            d = Deeltraject.ICT;

        } else if (input.equals("ELO")) {
            d = Deeltraject.ELO;

        } else if (input.equals("ICTINFRA")) {
            d = Deeltraject.ICTINFRA;

        } else if (input.equals("ICTWEB")) {
            d = Deeltraject.ICTWEB;

        } else {
            d = Deeltraject.NONE;

        }

        return d;
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

    public static void main(String[] args) throws IOException, ParseException {

        DocentConsole d = new DocentConsole();

        List<Docent> docenten = d.leesDocenten();

        String[] docents = new String[docenten.size()];

        int i = 0;
        for (Docent docentObject : docenten) {
            docents[i] = docentObject.getOpleiding() + "," + docentObject.getDeeltraject() + "," + docentObject.getNaam() + "," + docentObject.getVoornaam();
            i++;
        }

        Arrays.sort(docents);
        System.out.println("gesorteerde lijst van docenten :");
        for (int ii = 0; ii < docents.length; ii++) {
            System.out.println((docents[ii]));

        }
    }
}
