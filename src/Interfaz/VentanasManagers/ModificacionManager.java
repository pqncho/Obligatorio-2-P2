//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasManagers;

import Dominio.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ModificacionManager extends javax.swing.JFrame implements Observer {
    private Sistema sistema;
   
    public ModificacionManager(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Modificacion de Managers");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Manager> listaManagers = sistema.getListaManagers();
        sistema.ordenarManagersPorAntiguedad();
        listaManMod.setListData(sistema.getListaManagers().toArray());
    }
    
   private void modificarManager(){
        Manager unManager= (Manager)listaManMod.getSelectedValue();
        if(unManager!=null){
        if(!((Manager)listaManMod.getSelectedValue()).getCelular().equals(textoCelularModMan.getText())){
            ((Manager)listaManMod.getSelectedValue()).setCelular(textoCelularModMan.getText());
            JOptionPane.showMessageDialog(this, "Modificacion exitosa.");
        }else{
            JOptionPane.showMessageDialog(this, "No se han realizado modificaciones.");
        }
        } else{JOptionPane.showMessageDialog(this, "Debe seleccionar un area.");}
            
   }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoNombreModMan = new javax.swing.JTextField();
        textoCedulaModMan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textoCelularModMan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaManMod = new javax.swing.JList();
        botonModifMan = new javax.swing.JButton();
        botonCancelarModifMan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textoAntiModMan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEmpACargo = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nombre");

        jLabel3.setText("Cedula");

        jLabel4.setText("Celular");

        jLabel1.setText("Managers");

        listaManMod.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaManModValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaManMod);

        botonModifMan.setText("Modificar");
        botonModifMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModifManActionPerformed(evt);
            }
        });

        botonCancelarModifMan.setText("Cancelar");
        botonCancelarModifMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarModifManActionPerformed(evt);
            }
        });

        jLabel5.setText("Antiguedad");

        jLabel6.setText("Empleados a cargo");

        jScrollPane2.setViewportView(listaEmpACargo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(textoNombreModMan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoCedulaModMan))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoCelularModMan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoAntiModMan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(botonModifMan)
                        .addGap(94, 94, 94)
                        .addComponent(botonCancelarModifMan)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoNombreModMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoCedulaModMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoCelularModMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(textoAntiModMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonModifMan)
                            .addComponent(botonCancelarModifMan))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );

        setBounds(0, 0, 543, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarModifManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarModifManActionPerformed
       this.dispose();
    }//GEN-LAST:event_botonCancelarModifManActionPerformed

    private void listaManModValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaManModValueChanged
       Manager unManager= (Manager)listaManMod.getSelectedValue();
       ArrayList<Empleado> listaEmpleadosACargo = new ArrayList<>();
        if(unManager!=null){
        textoNombreModMan.setText(unManager.getNombre());
        textoCedulaModMan.setText(unManager.getCedula());
        textoCelularModMan.setText(unManager.getCelular());
        textoAntiModMan.setText(""+unManager.getAntiguedad());
            for (int i = 0; i < sistema.getListaEmpleados().size(); i++) {
                if(sistema.getListaEmpleados().get(i).getManager()==unManager){
                    listaEmpleadosACargo.add(sistema.getListaEmpleados().get(i));
                }
                
            }
        sistema.ordenarEmpleadosPorSalario();
        listaEmpACargo.setListData(listaEmpleadosACargo.toArray());
        }
    }//GEN-LAST:event_listaManModValueChanged

    private void botonModifManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModifManActionPerformed
      modificarManager();
    }//GEN-LAST:event_botonModifManActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarModifMan;
    private javax.swing.JButton botonModifMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaEmpACargo;
    private javax.swing.JList listaManMod;
    private javax.swing.JTextField textoAntiModMan;
    private javax.swing.JTextField textoCedulaModMan;
    private javax.swing.JTextField textoCelularModMan;
    private javax.swing.JTextField textoNombreModMan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("managers")){
            sistema.ordenarManagersPorAntiguedad();
            listaManMod.setListData(sistema.getListaManagers().toArray());
        }
    }
}
    

