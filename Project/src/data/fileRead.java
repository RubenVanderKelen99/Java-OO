
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.io.IOException;
import be.odisee.ikdoeict.TextFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.*;

/**
 *
 * @author Ruben
 * @version mei 2019
 */
public class fileRead {

    private String[] gebouwInfo;
    private String[] onkostCatInfo;
    private String[] onkostenDahlia;
    private String[] verblijfsUnitInfo;
    private ArrayList<ConfiguratieGebouwen> gebouwen = new ArrayList<ConfiguratieGebouwen>();
    private ArrayList<OnkostenCategorieen> onkostCat = new ArrayList<OnkostenCategorieen>();
    private ArrayList<Unit> veblijfsUnit = new ArrayList<Unit>();

    public fileRead() {
        getGebouwInfo();
        getonkostCatInfo();
    }

    public void getGebouwInfo() {
        try {
            gebouwInfo = TextFile.readLines("../data/ConfiguratieGebouwen.csv");
        } catch (IOException io) {
            System.out.println("Error");
        }

        fillConfiguratieGebouwen();
        addUnits();

        /*if (!gebouw.contains(split[0])) {
                gebouw.add(split[0]);
            }*/
    }

    ArrayList<String> gebouwNamen = new ArrayList<String>();

    public void fillConfiguratieGebouwen() {
        String gebouw;
        String[] split;

        for (int i = 1; i < gebouwInfo.length; i++) {
            split = gebouwInfo[i].split(";");
            gebouw = split[0];
            if (!gebouwNamen.contains(gebouw)) {
                gebouwNamen.add(gebouw);
            }
        }

        for (int i = 0; i < gebouwNamen.size(); i++) {
            gebouwen.add(new ConfiguratieGebouwen(gebouwNamen.get(i)));
        }
    }

    public void addUnits() {
        int aantal;
        String naam;
        String eigenaar;
        String email;
        String[] split;
        for (int i = 1; i < gebouwInfo.length; i++) {
            split = gebouwInfo[i].split(";");
            naam = split[1];
            aantal = Integer.parseInt(split[2]);
            if (split.length > 4) {
                eigenaar = split[3];
                email = split[4];
            } else {
                eigenaar = "Onbekend";
                email = "Onbekend";
            }
            Unit unit = new Unit(naam, aantal, eigenaar, email);

            for (int j = 0; j < gebouwen.size(); j++) {
                if (gebouwNamen.get(j).equals(split[0])) {
                    gebouwen.get(j).addUnit(unit);
                }
            }

        }
    }

    public String[] giveGebouwNamen() {
        String[] gebouwNamen = new String[gebouwen.size()];
        for (int i = 0; i < gebouwen.size(); i++) {
            gebouwNamen[i] = gebouwen.get(i).getGebouw();
        }
        return gebouwNamen;
    }

    public String[] giveonkostenCategorieen() {
        String[] onkostCatInfo = new String[onkostCat.size()];
        for (int i = 0; i < onkostCat.size(); i++) {
            onkostCatInfo[i] = Integer.toString(onkostCat.get(i).getCategorieNummer());
            onkostCatInfo[i] += " " + onkostCat.get(i).getCategorieNaam();
        }
        return onkostCatInfo;

    }

    public String[] giveUnits(String gebouwnaam) {
        ArrayList<Unit> unitArray = new ArrayList<Unit>();
        String[] output = {" "};
        for (int i = 0; i < gebouwen.size(); i++){
            if(gebouwen.get(i).getGebouw().equals(gebouwnaam)){
                for (int j = 0; j < gebouwen.get(i).getUnits().size(); j++) {
                    String[] unit = new String[gebouwen.get(i).getUnits().size()];
                    unit[j] = gebouwen.get(i).getUnits().get(j).getVerblijfsunit() + " (" + Integer.toString(gebouwen.get(i).getUnits().get(j).getAantalpersonen()) + "-Pers)";
                    output = unit;
                }
            }
            
        }      
       
        return output;
    }

    public void getonkostCatInfo() {
        try {
            onkostCatInfo = TextFile.readLines("../data/OnkostenCategorieen.csv");
        } catch (IOException io) {
            System.out.println("Error");
        }

        fillonkostenCategorie();
        addonkostenCategorie();

        String[] onkostenNrs = {"6100", "6101", "6103", "6105", "6105", "6106", "6107", "6108", "6109", "6120", "6121", "6123", "6124", "6130", "6131", "6140", "6150", "6160", "6161", "6166", "6200", "6400", "6500"};
        /*for(int i = 1; i <= onkostCatInfo.length; i++){
            try {
                addonkosten(Integer.toString(onkostNr.get(i)));
            } catch (IOException ex) {
                Logger.getLogger(fileRead.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        //addonkosten("6101");
        for (int i = 0; i < onkostenNrs.length; i++) {
            try {
                addonkosten(onkostenNrs[i]);
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

    ArrayList<Integer> onkostNr = new ArrayList<Integer>();

    public void fillonkostenCategorie() {
        int nummer;
        String beschrijving;
        String[] split;

        for (int i = 1; i < onkostCatInfo.length; i++) {
            split = onkostCatInfo[i].split(";");
            nummer = Integer.parseInt(split[0]);
            beschrijving = split[1];

            if (!onkostCat.contains(nummer)) {
                onkostCat.add(new OnkostenCategorieen(nummer, beschrijving));
                onkostNr.add(nummer);
            }
        }
    }

    public void addonkostenCategorie() {
        int nummer;
        String beschrijving;
        String[] split;
        for (int i = 1; i < onkostCatInfo.length; i++) {
            split = onkostCatInfo[i].split(";");
            nummer = Integer.parseInt(split[0]);
            beschrijving = (split[1]);

            OnkostenCategorieen onkostenCat = new OnkostenCategorieen(nummer, beschrijving);

            for (int j = 0; j < gebouwen.size(); j++) {
                if (gebouwNamen.get(j).equals("Dahlia")) {
                    gebouwen.get(j).addOnkostenCategorieen(onkostenCat);
                }
            }
        }
    }

    public void addonkosten(String bestand) throws IOException {
        String[] split;
        int nummer;
        String type;
        String stringBedrag;
        double bedrag;
        int stukNrs;
        onkostenDahlia = TextFile.readLines("../data/OnkostenDahlia2018/" + bestand + ".csv");

        for (int i = 1; i < onkostenDahlia.length; i++) {
            split = onkostenDahlia[i].split(";");

            nummer = Integer.parseInt(split[0]);
            type = split[1];
            stringBedrag = split[2];
            stukNrs = Integer.parseInt(split[3]);

            stringBedrag = stringBedrag.replace(",", ".");
            bedrag = Double.parseDouble(stringBedrag);

            Onkosten onkosten = new Onkosten(nummer, type, bedrag, stukNrs);

            for (int j = 0; j < onkostCat.size(); j++) {
                if (onkostNr.get(j).equals(Integer.parseInt(bestand))) {
                    onkostCat.get(j).addOnkosten(onkosten);
                }
            }

        }
    }
}

/*public void getVerblijfsUnitInof() {
        String[] onkostenFiles = {"6100" , "6200"};
        for(int i = 0; i <= onkostenFiles.length; i++){
            for (int j = 0; j < onkostenFiles[i].length(); j++) {
                try {
                    onkostenDahlia = TextFile.readLines("../data/ConfiguratieGebouwen.csv");
                } catch (IOException ex) {
                    System.out.println("Error");
                }
               
            }
        
        }

    }*/
