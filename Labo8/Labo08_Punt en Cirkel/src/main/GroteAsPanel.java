/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Ruben
 */
public class GroteAsPanel extends javax.swing.JPanel {

    private Color kleurtje;

    /**
     * Creates new form NewJPanel
     */
    public GroteAsPanel() {
        initComponents();
        kleurtje = Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        super.paintComponent(g);
        int breedte = this.getWidth();
        int hoogte = this.getHeight();
        g.setColor(Color.BLACK);
        g.drawRect(10, 10, breedte - 20, hoogte - 20);
        g.setColor(Color.BLACK);

        g.drawLine(0, hoogte / 2, breedte, hoogte / 2);
        
        
         g.drawLine(breedte / 2, hoogte, breedte / 2, hoogte - hoogte);
         
         
         
        //    g.drawLine(0 + 10, hoogte / 2, breedte - 10, hoogte / 2); //punt 1 //punt 2
        //   g.drawLine(breedte / 2, 0 + 10, breedte / 2, hoogte - 10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    void setKleur(Color kleur) {
        kleurtje = kleur;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
