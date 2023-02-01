/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class Quiz {
    private String naam;
    private ArrayList<QA> vragenlijst = new ArrayList<QA>();
    
    public Quiz(String naam){
        this.naam = naam;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public String getVraag(int index){
        return vragenlijst.get(index).getVraag(); 
    }
    
    public void voegVraagAntwoordToe(String vraag,String antwoord){
        vragenlijst.add(new QA(vraag,antwoord));
    }
    public void verwijderVraag(String vraag){
        
        for (int i = 0; i < vragenlijst.size(); i++) {
            if (vragenlijst.get(i).getVraag().equalsIgnoreCase(vraag)) {
                vragenlijst.remove(i);
            }
        }
        
    }
    
    public String geefWillekeurigeVraag(){
        int index = (int) (Math.random()* vragenlijst.size());
        return vragenlijst.get(index).getVraag();
    }
    
    public boolean checkAntwoordOpVraag(String vraag,String antwoord){
        for (int i = 0; i < vragenlijst.size(); i++) {
            if (vragenlijst.get(i).getVraag().equalsIgnoreCase(vraag)) {
                return vragenlijst.get(i).getAntwoord().equals(antwoord);
            }
        }
        return false;
    }
    public String getAntwoord(int index){
        return vragenlijst.get(index).getAntwoord(); 
    }
    @Override 
    public String toString(){
        String returnString = "";
        for (int i = 0; i < vragenlijst.size(); i++) {
            returnString += vragenlijst.get(i).getVraag()+"\t"+vragenlijst.get(i).getAntwoord()+"\r\n";

        }
        return returnString;
    }
    public ArrayList<String> geefAlleVragen(){
        ArrayList<String> vragen = new ArrayList<String>();
        vragen.add(vragenlijst.get(0).getVraag());
        for (int i = 1; i < vragenlijst.size(); i++) {
            vragen.add(vragenlijst.get(i).getVraag());
        }
        return vragen;
    }
}
