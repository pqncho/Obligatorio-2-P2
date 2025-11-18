//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasAreas;

import Dominio.*;
import java.util.*;
import javax.swing.JOptionPane;

public class RealizarMovimiento extends javax.swing.JFrame implements Observer {
    private Sistema sistema;
   
    public RealizarMovimiento(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Movimiento de Empleados");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Area> listaAreas = sistema.getListaAreas();
        
        sistema.ordenarAreasPorNombre();
        listaOrigenMov.setListData(listaAreas.toArray());
        listaDestinoMov.setListData(listaAreas.toArray());
        cargarMeses();
    }
    private void cargarMeses(){
        
    boxMesesMov.addItem("Enero");
    boxMesesMov.addItem("Febrero");
    boxMesesMov.addItem("Marzo");
    boxMesesMov.addItem("Abril");
    boxMesesMov.addItem("Mayo");
    boxMesesMov.addItem("Junio");
    boxMesesMov.addItem("Julio");
    boxMesesMov.addItem("Agosto");
    boxMesesMov.addItem("Setiembre");
    boxMesesMov.addItem("Octubre");
    boxMesesMov.addItem("Noviembre");
    boxMesesMov.addItem("Diciembre");
    
    
    }
    
    private void realizarMov(){
      try{
        Area areaOrigen=(Area)listaOrigenMov.getSelectedValue();
        Area areaDestino=(Area)listaDestinoMov.getSelectedValue();
        Empleado empleado=(Empleado)listaEmpleadosMov.getSelectedValue();
        String mes= (String)boxMesesMov.getSelectedItem();
        int numMes=0;
       
        int presuAreaDestino=areaDestino.getPresupuesto();
        int presuAreaOrigen=areaOrigen.getPresupuesto();
        boolean repetido=false;
        
        switch (mes){
            case "Enero":
                numMes=1;
                break;
                
                case "Febrero":
                numMes=2;
                break;
                
                case "Marzo":
                numMes=3;
                break;
                
                case "Abril":
                numMes=4;
                break;
                
                case "Mayo":
                numMes=5;
                break;
                
                case "Junio":
                numMes=6;
                break;
                
                case "Julio":
                numMes=7;
                break;
                
                case "Agosto":
                numMes=8;
                break;
                
                case "Setiembre":
                numMes=9;
                break;
                
                case "Octubre":
                numMes=10;
                break;
                
                case "Noviembre":
                numMes=11;
                break;
                
                case "Diciembre":
                numMes=12;
                break;             
        }
         int numMesRestante=12-numMes +1;
        int salarioRestante= empleado.getSalarioMensual()*numMesRestante;
        int presuReintegro=numMesRestante*empleado.getSalarioMensual();
        
        if(areaDestino==areaOrigen){
        repetido=true;
        JOptionPane.showMessageDialog(this, "Las areas seleccionadas son las mismas.");
        }
            if(presuAreaDestino>=salarioRestante && !repetido){
             areaDestino.setPresupuesto(presuAreaDestino-salarioRestante);
                areaOrigen.setPresupuesto(presuAreaOrigen + presuReintegro);
                empleado.setArea(areaDestino);
                areaOrigen.getListaEmpleados().remove(empleado);
                sistema.ordenarAreasPorNombre();
                sistema.ordenarEmpleadosPorSalario();
                listaEmpleadosMov.setListData(areaOrigen.getListaEmpleados().toArray());
                listaEmpleadosMov.clearSelection();
                listaOrigenMov.setListData(sistema.getListaAreas().toArray());
                listaDestinoMov.setListData(sistema.getListaAreas().toArray());
                areaDestino.getListaEmpleados().add(empleado);
                MovimientosArea unMovArea= new MovimientosArea(mes,areaOrigen,areaDestino,empleado);
                sistema.agregarMovArea(unMovArea);
                JOptionPane.showMessageDialog(this, "Movimiento exitoso.");
        
            }else{
            JOptionPane.showMessageDialog(this, "El presupuesto del Area de destino no es suficiente.");
            }
        
        
        
        
    }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Alguna de las listas no tiene ningun valor seleccionado.");
}

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boxMesesMov = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaOrigenMov = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEmpleadosMov = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDestinoMov = new javax.swing.JList();
        botonRegistrarMov = new javax.swing.JButton();
        botonCancelarMov = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mes");

        boxMesesMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesesMovActionPerformed(evt);
            }
        });

        listaOrigenMov.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaOrigenMov.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaOrigenMovValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaOrigenMov);

        listaEmpleadosMov.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEmpleadosMovValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaEmpleadosMov);

        listaDestinoMov.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaDestinoMov);

        botonRegistrarMov.setText("Registrar");
        botonRegistrarMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarMovActionPerformed(evt);
            }
        });

        botonCancelarMov.setText("Cancelar");
        botonCancelarMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarMovActionPerformed(evt);
            }
        });

        jLabel2.setText("Area origen");

        jLabel3.setText("Empleados");

        jLabel4.setText("Area destino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxMesesMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(botonRegistrarMov)
                        .addGap(92, 92, 92)
                        .addComponent(botonCancelarMov))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boxMesesMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarMov)
                    .addComponent(botonCancelarMov))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxMesesMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesesMovActionPerformed
        
    }//GEN-LAST:event_boxMesesMovActionPerformed

    private void botonCancelarMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarMovActionPerformed
      this.dispose();
    }//GEN-LAST:event_botonCancelarMovActionPerformed

    private void listaEmpleadosMovValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEmpleadosMovValueChanged
        
    }//GEN-LAST:event_listaEmpleadosMovValueChanged

    private void listaOrigenMovValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaOrigenMovValueChanged
      
        Area unArea= (Area)listaOrigenMov.getSelectedValue();
        if(unArea!=null){
           listaEmpleadosMov.setListData(unArea.getListaEmpleados().toArray());
        }
    }//GEN-LAST:event_listaOrigenMovValueChanged

    private void botonRegistrarMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarMovActionPerformed
        realizarMov();
    }//GEN-LAST:event_botonRegistrarMovActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarMov;
    private javax.swing.JButton botonRegistrarMov;
    private javax.swing.JComboBox<String> boxMesesMov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaDestinoMov;
    private javax.swing.JList listaEmpleadosMov;
    private javax.swing.JList listaOrigenMov;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("areas")){
        sistema.ordenarAreasPorNombre();
        listaOrigenMov.setListData(sistema.getListaAreas().toArray());
        listaDestinoMov.setListData(sistema.getListaAreas().toArray());
        }else if(arg.equals("empleados")){
            sistema.ordenarEmpleadosPorSalario();
            listaEmpleadosMov.setListData(sistema.getListaEmpleados().toArray());
        }
    }
}
