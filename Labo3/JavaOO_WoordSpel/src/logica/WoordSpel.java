package logica;

/**
 *
 * @author Ruben
 * @version maart 2019
 */
public class WoordSpel {

    private final int MAX;
    private int aantalBeurten;
    //private final String[] WOORDEN;
    private String teRadenWoord;
    private boolean[] geradenLetters;

    public WoordSpel() {
        aantalBeurten = 0;
        MAX = 5;
        /* WOORDEN = new String[]{"paddenstoel", "breedsmoelkikker", "paardenmelk",
            "hoefsmid", "huisjesmelker",
            "aardbei", "zeepaardje", "sinterklaas", "tovenaar",
            "armoedebestrijding"};
        teRadenWoord = WOORDEN[(int) (Math.random() * WOORDEN.length)]; */
        teRadenWoord = Woordenlijst.haalWoord();
        geradenLetters = new boolean[teRadenWoord.length()];
    }

    public WoordSpel(String[] woorden) {
        MAX = 5;
        aantalBeurten = 0;
        //WOORDEN = woorden;
        teRadenWoord = woorden[(int) (Math.random() * woorden.length)];
        geradenLetters = new boolean[teRadenWoord.length()];
    }

    public WoordSpel(int maxBeurten) {
        MAX = maxBeurten;
        aantalBeurten = 0;
        /*WOORDEN = new String[]{"paddenstoel", "breedsmoelkikker", "paardenmelk",
            "hoefsmid", "huisjesmelker",
            "aardbei", "zeepaardje", "sinterklaas", "tovenaar",
            "armoedebestrijding"};
        teRadenWoord = WOORDEN[(int) (Math.random() * WOORDEN.length)];*/
        teRadenWoord = Woordenlijst.haalWoord();
        geradenLetters = new boolean[teRadenWoord.length()];
    }
    
    public WoordSpel(int maxBeurten, int maxLetters) {
        MAX = maxBeurten;
        aantalBeurten = 0;
        /*WOORDEN = new String[]{"paddenstoel", "breedsmoelkikker", "paardenmelk",
            "hoefsmid", "huisjesmelker",
            "aardbei", "zeepaardje", "sinterklaas", "tovenaar",
            "armoedebestrijding"};
        teRadenWoord = WOORDEN[(int) (Math.random() * WOORDEN.length)];*/
        teRadenWoord = Woordenlijst.haalWoord(maxLetters);
        geradenLetters = new boolean[teRadenWoord.length()];
    }

    public boolean isGeraden() {
        for (boolean letter : geradenLetters) {
            if (letter) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public String gok(char letter) {
        for (int i = 0; i < teRadenWoord.length(); i++) {
            if (teRadenWoord.charAt(i) == letter) {
                geradenLetters[i] = true;
            }
        }
        aantalBeurten++;
        return maskeerWoord();
    }

    private String maskeerWoord() {
        String antwoord = "";
        for (int i = 0; i < geradenLetters.length; i++) {
            antwoord += geradenLetters[i] ? teRadenWoord.charAt(i) : "_";
        }
        return antwoord;
    }

    public String gok(String woord) {
        if (teRadenWoord.equals(woord)) {
            for (int i = 0; i < teRadenWoord.length(); i++) {
                geradenLetters[i] = true;
            }
            return teRadenWoord;
        } else {
            aantalBeurten++;
            return maskeerWoord();
        }
    }

    public int getAantalBeurten() {
        return aantalBeurten;
    }

    public boolean nogBeurten() {
        int resterendeBeurten = MAX - aantalBeurten;
        if (resterendeBeurten == 0) {
            return false;
        }
        return true;
    }

}
