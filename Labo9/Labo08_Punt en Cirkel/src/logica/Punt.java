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
public class Punt {

    /**
     * @param args the command line arguments
     */
    private int x;
    private int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double berekenAfstand(Punt p) {

        double result = 0.0;

        int x = getX();
        int y = getY();

        int pX = p.getX();
        int pY = p.getY();

        double svdm = Math.pow((x - pX), 2) + Math.pow((y - pY), 2);
        return Math.sqrt(svdm);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Punt)) {
            return false;
        }

        Punt p = (Punt) o;

        return getX() == p.getX() && getY() == p.getY();

    }

    public String toString() {

        return String.format("Punt met x = %d en y = %d", getX(), getY());
    }
}
