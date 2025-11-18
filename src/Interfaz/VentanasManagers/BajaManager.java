//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasManagers;

import Dominio.*;
import java.util.*;
import javax.swing.*;

public class BajaManager extends javax.swing.JFrame implements Observer {
     private Sistema sistema;
    
    public BajaManager(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Baja de Managers");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Manager> listaManagers = sistema.getListaManagers();
        cargarLista();
           
    }
    private void cargarLista(){
        boolean esta=false;
    ArrayList<Manager> managersSin = new ArrayList<>();
        ArrayList<Manager> managers= sistema.getListaManagers();
        for (int i = 0; i < sistema.getListaManagers().size(); i++) {
            Manager unManager= sistema.getListaManagers().get(i);
            esta=false;
            for (int j = 0; j <sistema.getListaEmpleados().size() ; j++) {
                Manager empManager= sistema.getListaEmpleados().get(j).getManager();
                
                
                if(unManager==empManager){
                    esta=true;
                }
                
            }
        if(!esta){
            managersSin.add(unManager);
        }
        }
        sistema.ordenarManagersPorAntiguedad();
        listaEliminarMan.setListData(managersSin.toArray());
    }
    private void eliminarManager(){
        if(listaEliminarMan.getSelectedValue()!=null){
        sistema.getListaManagers().remove((Manager)listaEliminarMan.getSelectedValue());
        listaEliminarMan.setListData(sistema.getListaManagers().toArray());
        JOptionPane.showMessageDialog(this, "Manager eliminado correctamente.");
        }else{
             JOptionPane.showMessageDialog(this, "Debe seleccionar un Manager a eliminar.");
        }
    }
           
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonEliminarBajaMan = new javax.swing.JButton();
        botonCancelarBajaMan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEliminarMan = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Managers sin empleados");

        botonEliminarBajaMan.setText("Eliminar");
        botonEliminarBajaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarBajaManActionPerformed(evt);
            }
        });

        botonCancelarBajaMan.setText("Cancelar");
        botonCancelarBajaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBajaManActionPerformed(evt);
            }
        });

        listaEliminarMan.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaEliminarMan);

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
                        .addComponent(botonEliminarBajaMan)
                        .addGap(67, 67, 67)
                        .addComponent(botonCancelarBajaMan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void botonEliminarBajaManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarBajaManActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,"¿Confirma la eliminacion de este manager?","SI",JOptionPane.YES_NO_OPTION);
    
    if (opcion == JOptionPane.YES_OPTION) {
        eliminarManager();
    }
    }//GEN-LAST:event_botonEliminarBajaManActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarBajaMan;
    private javax.swing.JButton botonEliminarBajaMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaEliminarMan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("managers")){
            sistema.ordenarManagersPorAntiguedad();
            listaEliminarMan.setListData(sistema.getListaManagers().toArray());
        }
    }
}
