//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz;

import Dominio.*;
import java.io.*;

public class VentanaInicio extends javax.swing.JFrame {

    private Sistema sistema;

    public VentanaInicio() {
        initComponents();
        setTitle("Comenzar con...");
        setVisible(true);

    }

    private void cargarSistemaPorDefecto() {

        sistema = new Sistema();
        sistema.cargarDatosPorDefecto();
        VentanaMenu ventanaMenu = new VentanaMenu(sistema);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSistemaNuevo = new javax.swing.JButton();
        botonSistemaGuardado = new javax.swing.JButton();
        botonSistemaPrecargado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonSistemaNuevo.setText("Sistema nuevo");
        botonSistemaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSistemaNuevoActionPerformed(evt);
            }
        });

        botonSistemaGuardado.setText("Sistema guardado");
        botonSistemaGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSistemaGuardadoActionPerformed(evt);
            }
        });

        botonSistemaPrecargado.setText("Sistema con datos precargados");
        botonSistemaPrecargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSistemaPrecargadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(botonSistemaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSistemaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSistemaPrecargado)
                .addGap(45, 45, 45))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonSistemaGuardado, botonSistemaNuevo, botonSistemaPrecargado});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSistemaNuevo)
                    .addComponent(botonSistemaGuardado)
                    .addComponent(botonSistemaPrecargado))
                .addGap(60, 60, 60))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonSistemaGuardado, botonSistemaNuevo, botonSistemaPrecargado});

        setBounds(0, 0, 729, 166);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSistemaGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSistemaGuardadoActionPerformed
        try {
            FileInputStream arch = new FileInputStream("DATOS");
            ObjectInputStream leer = new ObjectInputStream(arch);
            sistema = (Sistema) leer.readObject();
            leer.close();
            VentanaMenu ventanaMenu = new VentanaMenu(sistema);
            this.dispose();
        } catch (IOException ex) {
            System.out.println("Error de archivo");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de clase");
        }
    }//GEN-LAST:event_botonSistemaGuardadoActionPerformed

    private void botonSistemaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSistemaNuevoActionPerformed
        this.dispose();
        sistema = new Sistema();
        VentanaMenu ventanaMenu = new VentanaMenu(sistema);
    }//GEN-LAST:event_botonSistemaNuevoActionPerformed

    private void botonSistemaPrecargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSistemaPrecargadoActionPerformed
        this.dispose();
        cargarSistemaPorDefecto();
    }//GEN-LAST:event_botonSistemaPrecargadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSistemaGuardado;
    private javax.swing.JButton botonSistemaNuevo;
    private javax.swing.JButton botonSistemaPrecargado;
    // End of variables declaration//GEN-END:variables

}
