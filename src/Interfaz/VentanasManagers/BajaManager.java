//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasManagers;

import Dominio.*;
import java.util.*;

public class BajaManager extends javax.swing.JFrame {
     private Sistema sistema;
    
    public BajaManager(Sistema unSistema) {
         this.sistema = unSistema;
        initComponents();
        setTitle("Baja de Managers");
        setVisible(true);
           
           ArrayList<Manager> listaManagers = sistema.getListaManagers();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonEliminarBajaMan = new javax.swing.JButton();
        botonCancelarBajaMan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Managers sin empleados");

        botonEliminarBajaMan.setText("Eliminar");

        botonCancelarBajaMan.setText("Cancelar");
        botonCancelarBajaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBajaManActionPerformed(evt);
            }
        });

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEliminarBajaMan)
                                .addGap(67, 67, 67)
                                .addComponent(botonCancelarBajaMan)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarBajaMan)
                    .addComponent(botonCancelarBajaMan))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setBounds(0, 0, 416, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarBajaManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarBajaManActionPerformed
       this.dispose();
    }//GEN-LAST:event_botonCancelarBajaManActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarBajaMan;
    private javax.swing.JButton botonEliminarBajaMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
