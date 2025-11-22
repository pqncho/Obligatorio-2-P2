//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasAreas;

import Dominio.*;
import Interfaz.*;
import java.util.*;
import javax.swing.JOptionPane;

public class AltaArea extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public AltaArea(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        setTitle("Alta de Areas");
        setVisible(true);
        listaAltaAreas.setListData(sistema.getListaAreas().toArray());
        unSistema.addObserver(this);
    }

    private void limpiarCajas() {
        textoNombreArea.setText("");
        textoDescArea.setText("");
        textoPresuArea.setText("");
    }

    private void agregarArea() {
        boolean existente = false;
        try {
            ArrayList<Area> listaAreas = sistema.getListaAreas();

            String nombre = textoNombreArea.getText();

            for (int i = 0; i < sistema.getListaAreas().size(); i++) {
                if (listaAreas.get(i).getNombre().equals(nombre)) {
                    JOptionPane.showMessageDialog(this, "Area existente.");
                    limpiarCajas();
                    existente = true;
                }

            }
            if (!existente) {
                String descripcion = textoDescArea.getText();
                int presupuesto = Integer.parseInt(textoPresuArea.getText());
                Area area = new Area(nombre, descripcion, presupuesto);
                sistema.agregarArea(area);
                sistema.ordenarAreasPorNombre();
                listaAltaAreas.setListData(sistema.getListaAreas().toArray());
                JOptionPane.showMessageDialog(this, "El area fue agregada correctamente.");
                limpiarCajas();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Presupuesto invalido");
            limpiarCajas();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAltaAreas = new javax.swing.JList();
        textoNombreArea = new javax.swing.JTextField();
        textoDescArea = new javax.swing.JTextField();
        textoPresuArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonRegistrarArea = new javax.swing.JButton();
        botonCancelarArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaAltaAreas.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAltaAreas);

        textoNombreArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreAreaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripción");

        jLabel3.setText("Presupuesto");

        botonRegistrarArea.setText("Registrar");
        botonRegistrarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarAreaActionPerformed(evt);
            }
        });

        botonCancelarArea.setText("Cancelar");
        botonCancelarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(botonRegistrarArea))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoPresuArea, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(textoNombreArea, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoDescArea, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelarArea)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNombreArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoDescArea, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoPresuArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarArea)
                    .addComponent(botonCancelarArea))
                .addGap(49, 49, 49))
        );

        setBounds(0, 0, 557, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void textoNombreAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreAreaActionPerformed
        
    }//GEN-LAST:event_textoNombreAreaActionPerformed

    private void botonRegistrarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarAreaActionPerformed
        agregarArea();
    }//GEN-LAST:event_botonRegistrarAreaActionPerformed

    private void botonCancelarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarAreaActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarArea;
    private javax.swing.JButton botonRegistrarArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAltaAreas;
    private javax.swing.JTextField textoDescArea;
    private javax.swing.JTextField textoNombreArea;
    private javax.swing.JTextField textoPresuArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("areas")) {
            sistema.ordenarAreasPorNombre();
            listaAltaAreas.setListData(sistema.getListaAreas().toArray());
        }
    }
}
