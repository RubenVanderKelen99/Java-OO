package console;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import be.odisee.ikdoeict.TextFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import logica.Deeltraject;
import logica.Opleiding;
import logica.Student;

/**
 *
 * @author Ruben
 */
public class StudentConsole {

    private String fileName = "C:\\Users\\Ruben\\Documents\\NetBeansProjects\\Labo10\\Labo10_FileReader\\src\\files\\StudentenELOICT.csv";

    List<Student> studenten = new ArrayList<>();

    public List<Student> leesStudentenMetLib() throws IOException, ParseException {

        TextFile tf = new TextFile();
        String txt = tf.read(fileName);
        String[] lines = txt.split("\n");
        for (int i = 0; i < lines.length; i++) {
            //  System.out.println("volledige lijn : " + lines[i]);
            String line = lines[i];
            String naam = line.split(";")[0];
            String voornaam = line.split(";")[1];
            String opleiding = line.split(";")[2];
            String deeltraject = line.split(";")[3];

            Opleiding o = getOpleiding(opleiding);
            Deeltraject d = getDeeltraject(deeltraject);
            // System.out.println("ontleede lijn :  Naam = " + naam + ", voornaam = " + voornaam + ", opleiding = " + o + ", onderdeel = " + d);
            Student student = new Student(naam, voornaam, o, d);
            studenten.add(student);
        }
        return studenten;
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
        StudentConsole s = new StudentConsole();

        List<Student> studenten = s.leesStudentenMetLib();

        String[] students = new String[studenten.size()];

        int i = 0;
        for (Student studentObject : studenten) {
            students[i] = studentObject.getOpleiding() + "," + studentObject.getDeeltraject() + "," + studentObject.getNaam() + "," + studentObject.getVoornaam();
            i++;
        }

        Arrays.sort(students);
        System.out.println("gesorteerde lijst van studenten :");
        for (int ii = 0; ii < students.length; ii++) {
            System.out.println((students[ii]));

        }

    }

}
