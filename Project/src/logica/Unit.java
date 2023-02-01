/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ruben
 * @version mei 2019
 */
public class Unit {
    private String verblijfsunit;
    private int aantalpersonen;
    private String eigenaar;
    private String email;

    public Unit (String verblijfsunit, int aantalpersonen, String eigenaar, String email){
        this.verblijfsunit = verblijfsunit;
        this.aantalpersonen = aantalpersonen;
        this.eigenaar = eigenaar;
        this.email = email;
    }

    public String getVerblijfsunit(){
        return verblijfsunit;
    }
    public int getAantalpersonen(){
        return aantalpersonen;
    }

    public String getEigenaar(){
        return eigenaar;
    }

    public String getEmail(){
        return email;
    }
}
