/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 */
public class QA {
    private String vraag;
    private String antwoord;
    
    public QA(String vraag,String antwoord){
        this.vraag = vraag;
        this.antwoord = antwoord;
    }
    
    public String getVraag(){
        return vraag;
    }
    public String getAntwoord(){
        return antwoord;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof QA){
            QA qa = (QA) o;
            if (this.vraag.equals(qa.getVraag())) {
                return true;
            }
        }
        return false;
    }
}
