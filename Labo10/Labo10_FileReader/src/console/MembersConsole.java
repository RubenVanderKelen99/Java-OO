/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import logica.Docent;
import logica.EtStudent;
import logica.OdiseeMember;
import logica.Student;

/**
 *
 * @author Ruben
 */
public class MembersConsole {

    DocentConsole d = new DocentConsole();
    StudentConsole s = new StudentConsole();
    ET_Console et = new ET_Console();

    List<OdiseeMember> members = new ArrayList<>();

    public void addMembers() throws IOException, ParseException { //voegt Studenten en Etstudenten toe

        List<Student> studenten = s.leesStudentenMetLib();
        List<EtStudent> etstudenten = et.leesEtStudenten();

        for (Student s : studenten) {
            members.add(s);
        }

        for (EtStudent et : etstudenten) {
            members.add(et);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        MembersConsole m = new MembersConsole();
        List<Docent> docenten = m.d.leesDocenten();

        String[] docs = new String[docenten.size()];

        int j = 0;
        for (Docent d : docenten) {
            docs[j] = d.getOpleiding() + "," + d.getDeeltraject() + "," + d.getNaam() + "," + d.getVoornaam();
            j++;
        }

        Arrays.sort(docs);

        System.err.println("Docenten : ");
        System.out.println("-----------------------");
        for (int ii = 0; ii < docs.length; ii++) {
            System.out.println((docs[ii]));

        }
        System.out.println("-----------------------");

        m.addMembers();
        String[] membs = new String[m.members.size()];
        int i = 0;
        for (OdiseeMember ods : m.members) {
            membs[i] = ods.getOpleiding() + "," + ods.getDeeltraject() + "," + ods.getNaam() + "," + ods.getVoornaam();
            i++;
        }
        Arrays.sort(membs);
        System.err.println("Studenten :");
        System.out.println("-----------------------");
        for (int ii = 0; ii < membs.length; ii++) {
            System.out.println((membs[ii]));

        }
    }
}
