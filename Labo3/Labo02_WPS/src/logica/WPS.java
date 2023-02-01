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
    
    public WPS() {
        code = "";
        int[] getallen = new int[8];
        for (int i = 0; i < 7; i++) {
            getallen[i] = (int) (Math.random() * 10);
        }
        int laatste = this.laatsteGetal(getallen);
        getallen[7] = laatste;
        for (int i = 0; i < 8; i++) {
            code += (getallen[i] + "");
        }
    }

    public WPS(String code) {
        if (this.analyseerCode(code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Ongeldige code");
        }

    }

    public String getPincode() {
        return this.code;
    }

    public void setPincode(String code) {
        if (this.analyseerCode(code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Ongeldige code");
        }

    }

    private int laatsteGetal(int[] getallen) {
        int oneven = getallen[0] + getallen[2] + getallen[4] + getallen[6];
        int even = getallen[1] + getallen[3] + getallen[5];
        int laatsteGetal = 10 - ((oneven * 3 + even) % 10);
        if (laatsteGetal == 10) {
            laatsteGetal = 0;
        } else {

        }
        return laatsteGetal;
    }

    public boolean analyseerCode(String code) {
        try { 
        int[] getallen = new int[8];
        for (int i = 0; i < 7; i++) {
            getallen[i] = Integer.parseInt(code.substring(i, i + 1));
        }
        int laatste = this.laatsteGetal(getallen);
        getallen[7] = Integer.parseInt(code.substring(7));
        if (getallen[7] == laatste) {
            return true;
        } else {
            return false;
        }
        }catch(NumberFormatException e){
            return false;
        }
    }

}
