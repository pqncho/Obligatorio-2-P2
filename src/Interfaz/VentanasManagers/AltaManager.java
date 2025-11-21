//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasManagers;

import Dominio.*;
import java.util.*;
import javax.swing.JOptionPane;

public class AltaManager extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public AltaManager(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        setTitle("Alta de Managers");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Manager> listaManagers = sistema.getListaManagers();
        sistema.ordenarManagersPorAntiguedad();
        listaManagersAltaMan.setListData(sistema.getListaManagers().toArray());
    }

    private void limpiarCajas() {
        textoNombreAltaMan.setText("");
        textoCedulaAltaMan.setText("");
        textoCelularAltaMan.setText("");
        textoAntAltaMan.setText("");

    }

    private void agregarManager() {
        boolean hayError = false;
        try {
            String nombre = textoNombreAltaMan.getText();
            String cedula = textoCedulaAltaMan.getText();
            String celular = textoCelularAltaMan.getText();
            int antiguedad = Integer.parseInt(textoAntAltaMan.getText());

            for (Manager m : sistema.getListaManagers()) {
                if (!hayError && m.getCedula().equals(cedula)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un manager con esta cédula.");
                    hayError = true;
                }
            }
            for (Empleado e : sistema.getListaEmpleados()) {
                if (!hayError && e.getCedula().equals(cedula)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una persona ingresada con esta cédula.");
                    hayError = true;
                }
            }
            if (!hayError) {
                Manager manager = new Manager(nombre, cedula, celular, antiguedad);
                sistema.agregarManagers(manager);
                sistema.ordenarManagersPorAntiguedad();
                listaManagersAltaMan.setListData(sistema.getListaManagers().toArray());
                JOptionPane.showMessageDialog(this, "El manager fue agregado correctamente.");
            }

            limpiarCajas();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Antiguedad invalida");
            limpiarCajas();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonRegistrarAltaMan = new javax.swing.JButton();
        botonCancelarAltaMan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaManagersAltaMan = new javax.swing.JList();
        textoCedulaAltaMan = new javax.swing.JTextField();
        textoNombreAltaMan = new javax.swing.JTextField();
        textoCelularAltaMan = new javax.swing.JTextField();
        textoAntAltaMan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Celular");

        jLabel4.setText("Antiguedad");

        botonRegistrarAltaMan.setText("Registrar");
        botonRegistrarAltaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarAltaManActionPerformed(evt);
            }
        });

        botonCancelarAltaMan.setText("Cancelar");
        botonCancelarAltaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarAltaManActionPerformed(evt);
            }
        });

        listaManagersAltaMan.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaManagersAltaMan);

        textoCedulaAltaMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCedulaAltaManActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(botonRegistrarAltaMan)
                .addGap(71, 71, 71)
                .addComponent(botonCancelarAltaMan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoCedulaAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textoAntAltaMan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addComponent(textoCelularAltaMan, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(textoNombreAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(textoCedulaAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoNombreAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textoCelularAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textoAntAltaMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarAltaMan)
                    .addComponent(botonCancelarAltaMan))
                .addGap(50, 50, 50))
        );

        setBounds(0, 0, 416, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void textoCedulaAltaManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCedulaAltaManActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCedulaAltaManActionPerformed

    private void botonCancelarAltaManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarAltaManActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarAltaManActionPerformed

    private void botonRegistrarAltaManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarAltaManActionPerformed
        agregarManager();
    }//GEN-LAST:event_botonRegistrarAltaManActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarAltaMan;
    private javax.swing.JButton botonRegistrarAltaMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaManagersAltaMan;
    private javax.swing.JTextField textoAntAltaMan;
    private javax.swing.JTextField textoCedulaAltaMan;
    private javax.swing.JTextField textoCelularAltaMan;
    private javax.swing.JTextField textoNombreAltaMan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("managers")) {
            sistema.ordenarManagersPorAntiguedad();
            listaManagersAltaMan.setListData(sistema.getListaManagers().toArray());
        }
    }
}
