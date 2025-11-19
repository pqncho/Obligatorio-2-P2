//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasAreas;

import Dominio.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ModificacionArea extends javax.swing.JFrame implements Observer{
    private Sistema sistema;
   
    public ModificacionArea(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Modificacion de Areas");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Area> listaAreas = sistema.getListaAreas();
        sistema.ordenarAreasPorNombre();
        listaAreasModArea.setListData(sistema.getListaAreas().toArray());
       
}
    public void modificar(){
        
        Area unArea= (Area)listaAreasModArea.getSelectedValue();
        if(unArea!=null){
        if(!((Area)listaAreasModArea.getSelectedValue()).getDescripcion().equals(textoDescModArea.getText())){
            ((Area)listaAreasModArea.getSelectedValue()).setDescripcion(textoDescModArea.getText());
            JOptionPane.showMessageDialog(this, "Modificacion exitosa.");
        }else{
            JOptionPane.showMessageDialog(this, "No se han realizado modificaciones.");
        }
        } else{JOptionPane.showMessageDialog(this, "Debe seleccionar un area.");}
            
        }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAreasModArea = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoNombreModArea = new javax.swing.JTextField();
        textoDescModArea = new javax.swing.JTextField();
        textoPresuModArea = new javax.swing.JTextField();
        botonModifArea = new javax.swing.JButton();
        botonCancelarModifArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Areas");

        listaAreasModArea.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaAreasModArea.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAreasModAreaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaAreasModArea);

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Presupuesto");

        botonModifArea.setText("Modificar");
        botonModifArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModifAreaActionPerformed(evt);
            }
        });

        botonCancelarModifArea.setText("Cancelar");
        botonCancelarModifArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarModifAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(textoNombreModArea, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoDescModArea))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoPresuModArea))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(botonModifArea)
                        .addGap(67, 67, 67)
                        .addComponent(botonCancelarModifArea)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoNombreModArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoDescModArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoPresuModArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModifArea)
                    .addComponent(botonCancelarModifArea))
                .addGap(38, 38, 38))
        );

        setBounds(0, 0, 420, 313);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarModifAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarModifAreaActionPerformed
      this.dispose();
    }//GEN-LAST:event_botonCancelarModifAreaActionPerformed

    private void listaAreasModAreaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAreasModAreaValueChanged
        Area unArea= (Area)listaAreasModArea.getSelectedValue();
        if(unArea!=null){
        textoNombreModArea.setText(unArea.getNombre());
        textoDescModArea.setText(unArea.getDescripcion());
        textoPresuModArea.setText(""+unArea.getPresupuestoActual());
        
        }
    }//GEN-LAST:event_listaAreasModAreaValueChanged

    private void botonModifAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModifAreaActionPerformed
        modificar();
    }//GEN-LAST:event_botonModifAreaActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarModifArea;
    private javax.swing.JButton botonModifArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAreasModArea;
    private javax.swing.JTextField textoDescModArea;
    private javax.swing.JTextField textoNombreModArea;
    private javax.swing.JTextField textoPresuModArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("areas")){
        sistema.ordenarAreasPorNombre();
       listaAreasModArea.setListData(sistema.getListaAreas().toArray());
        }
        
    }
}
