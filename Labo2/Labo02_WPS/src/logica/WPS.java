/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ruben.vanderkelen
 * @version februari 2019
 */
public class WPS {
    
    private String code;
    
    public WPS(){
        String code = "";
        int somEven = 0; int somOneven = 0; int rest = 0; int laatsteCijfer = 0;
        for(int i = 0; i < 7; i++){
            code += Integer.toString((int)((Math.random()) * 10));
            if((i + 1) % 2 != 0){
            somOneven += Integer.parseInt(code.substring(i, i + 1));
            }
            else if((i + 1) % 2 == 0){
            somEven += Integer.parseInt(code.substring(i, i + 1));    
            }
        }
        somOneven = somOneven * 3;
        somOneven = somOneven + somEven;
        rest = somOneven % 10;
        laatsteCijfer = 10 - rest;
        if(laatsteCijfer == 10){
            laatsteCijfer = 0;
        }
        code += Integer.toString(laatsteCijfer);
        this.code = code;
    }
    
    public WPS(String code){
        this.code = code;
        
    }
    
    public String getPincode(){
        return this.code;
    }
    
    public void setPincode(String code){
        if(code.length() == 8){
        this.code = code;
        }
    }
    
}
