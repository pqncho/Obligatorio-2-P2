//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasAreas;

import Dominio.*;
import java.util.*;
import java.util.*;
import javax.swing.JOptionPane;

public class BajaArea extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public BajaArea(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        setTitle("Baja de Areas");
        setVisible(true);
        ArrayList<Area> listaAreas = sistema.getListaAreas();
        sistema.addObserver(this);
        sistema.ordenarAreasPorNombre();
        listaAreasEliminar.setListData(sistema.getListaAreas().toArray());

    }

    private void eliminarArea() {
        boolean sePuede = true;
        Area unArea = (Area) listaAreasEliminar.getSelectedValue();
        if (listaAreasEliminar.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un elemento antes de eliminar.");
            sePuede = false;
        }
        for (int i = 0; i < sistema.getListaAreas().size() && sePuede; i++) {
            if ((Area) sistema.getListaAreas().get(i) == unArea) {
                sistema.getListaAreas().remove(i);
                sistema.ordenarAreasPorNombre();
                listaAreasEliminar.setListData(sistema.getListaAreas().toArray());

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAreasEliminar = new javax.swing.JList();
        botonEliminarBajaArea = new javax.swing.JButton();
        botonCancelarBajaArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Areas sin empleados");

        listaAreasEliminar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAreasEliminar);

        botonEliminarBajaArea.setText("Eliminar");
        botonEliminarBajaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarBajaAreaActionPerformed(evt);
            }
        });

        botonCancelarBajaArea.setText("Cancelar");
        botonCancelarBajaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBajaAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEliminarBajaArea)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCancelarBajaArea)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarBajaArea)
                    .addComponent(botonCancelarBajaArea))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        setBounds(0, 0, 416, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarBajaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarBajaAreaActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarBajaAreaActionPerformed

    private void botonEliminarBajaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarBajaAreaActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Confirma la eliminacion de esta area?", "SI", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            eliminarArea();
        }

    }//GEN-LAST:event_botonEliminarBajaAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarBajaArea;
    private javax.swing.JButton botonEliminarBajaArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAreasEliminar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("areas")) {
            sistema.ordenarAreasPorNombre();
            listaAreasEliminar.setListData(sistema.getListaAreas().toArray());
        }
    }
}
