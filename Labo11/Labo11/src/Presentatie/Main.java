/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentatie;

import data.FileStore;
import java.util.Scanner;
import logica.Quiz;

/**
 *
 * @author Ruben
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("Wat wil je doen?");
        System.out.println("1. Quiz maken");
        System.out.println("2. Quiz verwijderen");
        System.out.println("3. Quiz bewerken");
        System.out.println("4. Quiz spelen");
        System.out.println("5. programma stoppen");

        Scanner s = new Scanner(System.in);
        int selectie = s.nextInt();
        FileStore f = new FileStore("./quizData");
        switch (selectie) {
            case 1:
                System.out.println("Hoe wil je de quiz noemen");
                String naam = s.next();
                Quiz q = new Quiz(naam);
                f.schrijfQuiz(q);
                break;
            case 2:
                System.out.println("Welke quiz wil je verwijderen");
                String print = "";
                String[] namen = f.geefQuizNamen();
                for (int i = 0; i < namen.length; i++) {
                    print += i + 1 + ". " + namen[i] + "\n";
                }
                print += namen.length + 1 + ". " + "Cancel";
                System.out.println(print);
                int select = s.nextInt();
                for (int i = 0; i < namen.length; i++) {
                    if (i == select) {
                        System.out.println(f.geefQuizNamen()[i] + " is succesvol verwijderd.");
                        f.verwijderQuiz(f.geefQuizNamen()[i]);
                    }
                }
                break;
            case 3:
                while (true) {
                    System.out.println("Welke quiz wil je bewerken");
                    String a = "";
                    String[] n = f.geefQuizNamen();
                    for (int i = 0; i < n.length; i++) {
                        a += i + 1 + ". " + n[i] + "\n";
                    }
                    System.out.println(a);
                    int selected = s.nextInt();
                    Quiz selectedQuiz = null;
                    for (int i = 0; i < n.length; i++) {
                        if (i == selected) {
                            selectedQuiz = f.leesQuiz(f.geefQuizNamen()[i]);
                        }
                    }
                    System.out.println("a. vraag toevoegen");
                    System.out.println("b. vraag verwijderen");
                    System.out.println("c. cancel");
                    String s2 = s.next();
                    if (selectedQuiz != null) {
                        if (s2.equals("a")) {
                            System.out.println("Welke vraag wil je toevoegen");
                            String vraag = s.nextLine();
                            System.out.println("Wat is het antwoord");
                            String antwoord = s.nextLine();
                            selectedQuiz.voegVraagAntwoordToe(vraag, antwoord);
                            f.schrijfQuiz(selectedQuiz);
                        } else if (s2.equals("b")) {
                            String pr = "";
                            for (int i = 0; i < selectedQuiz.geefAlleVragen().size(); i++) {
                                pr += i + 1 + ". " + selectedQuiz.geefAlleVragen().get(i) + "\n";
                            }
                            System.out.println(pr);
                            int s3 = s.nextInt();
                            selectedQuiz.verwijderVraag(selectedQuiz.geefAlleVragen().get(s3 - 1));
                        }else{
                            break;
                        }
                    }
                }

            case 4:

            case 5:
        }
    }
}
