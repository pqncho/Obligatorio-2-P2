//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasEmpleados;

import Dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class AltaEmpleado extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    
    public AltaEmpleado(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        setTitle("Alta de Empleados");
        setVisible(true);
        unSistema.addObserver(this);
        ArrayList<Empleado> listaEmpleados = sistema.getListaEmpleados();
        sistema.ordenarAreasPorNombre();
        sistema.ordenarEmpleadosPorSalario();
        sistema.ordenarManagersPorAntiguedad();
        listaEmpleadosAltaEmp.setListData(listaEmpleados.toArray());
        listaAreasAltaEmp.setListData(sistema.getListaAreas().toArray());
        listaManagersAltaEmp.setListData(sistema.getListaManagers().toArray());
    }
    
    private void guardarCVEnArchivo(String cedula, String textoCV) {
        try {
            
            File carpeta = new File("cvs");
            if (!carpeta.exists()) {
                carpeta.mkdir();                
            }
            
            JOptionPane.showMessageDialog(this, "Archivo del CV guardado correctamente.");
            File archivoCV = new File(carpeta, "CV" + cedula + ".txt");
            
            FileWriter fw = new FileWriter(archivoCV);
            fw.write(textoCV);
            fw.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar el archivo de CV.");
        }
    }
    
    private void limpiarCajas() {
        textoNombreAltaEmp.setText("");
        textoCedulaAltaEmp.setText("");
        textoCelAltaEmp.setText("");
        textoCVAltaEmp.setText("");
        textoSalAltaEmp.setText("");
    }

    private void agregarEmpleado() {
        boolean datosValidos = true;
        boolean cedulaRepetida = false;
        boolean alcanzaPresupuesto = true;
        try {
            String nombre = textoNombreAltaEmp.getText();
            String cedula = textoCedulaAltaEmp.getText();
            int salario = Integer.parseInt(textoSalAltaEmp.getText());
            String celular = textoCelAltaEmp.getText();
            String curriculum = textoCVAltaEmp.getText();
            if (nombre.isEmpty() || cedula.isEmpty() || curriculum.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hay campos vacíos.");
                datosValidos = false;
            }
            for (int i = 0; i < sistema.getListaEmpleados().size(); i++) {
                if (sistema.getListaEmpleados().get(i).getCedula().equals(cedula)) {
                    cedulaRepetida = true;
                }
                
            }
            for (int i = 0; i < sistema.getListaManagers().size(); i++) {
                if (sistema.getListaManagers().get(i).getCedula().equals(cedula)) {
                    cedulaRepetida = true;
                }
                
            }
            
            if (datosValidos && !cedulaRepetida) {
                Manager manager = (Manager) listaManagersAltaEmp.getSelectedValue();
                Area area = (Area) listaAreasAltaEmp.getSelectedValue();
                if (manager != null && area != null) {
                    if (salario < area.getPresupuestoActual()) {
                        Empleado empleado = new Empleado(nombre, cedula, celular, curriculum, salario, manager, area);
                        sistema.agregarEmpleado(empleado);
                        area.setPresupuestoActual(area.getPresupuestoActual() - empleado.SalarioAnualRes());
                        guardarCVEnArchivo(cedula, curriculum);
                        area.getListaEmpleados().add(empleado);
                        sistema.ordenarEmpleadosPorSalario();
                        listaEmpleadosAltaEmp.setListData(sistema.getListaEmpleados().toArray());
                        JOptionPane.showMessageDialog(this, "El empleado fue agregado correctamente.");
                        limpiarCajas();
                    } else {
                        JOptionPane.showMessageDialog(this, "El salario supera el presupuesto actual.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un area y un manager.");
                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe una persona con esta cedula.");
                
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salario invalido.");
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollManagerAltaEmp = new javax.swing.JScrollBar();
        scrollAreaAltaEmp = new javax.swing.JScrollBar();
        textoCedulaAltaEmp = new javax.swing.JTextField();
        textoNombreAltaEmp = new javax.swing.JTextField();
        textoCelAltaEmp = new javax.swing.JTextField();
        textoSalAltaEmp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoCVAltaEmp = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEmpleadosAltaEmp = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonRegistrarAltaEmp = new javax.swing.JButton();
        botonCancelarAltaEmp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaManagersAltaEmp = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaAreasAltaEmp = new javax.swing.JList();

        scrollAreaAltaEmp.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textoNombreAltaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreAltaEmpActionPerformed(evt);
            }
        });

        textoCelAltaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCelAltaEmpActionPerformed(evt);
            }
        });

        textoSalAltaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoSalAltaEmpActionPerformed(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel3.setText("Celular");

        jLabel4.setText("Salario");

        jLabel5.setText("Texto CV");

        textoCVAltaEmp.setColumns(20);
        textoCVAltaEmp.setRows(5);
        jScrollPane1.setViewportView(textoCVAltaEmp);

        jScrollPane2.setViewportView(listaEmpleadosAltaEmp);

        jLabel6.setText("Manager");

        jLabel7.setText("Area");

        botonRegistrarAltaEmp.setText("Registrar");
        botonRegistrarAltaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarAltaEmpActionPerformed(evt);
            }
        });

        botonCancelarAltaEmp.setText("Cancelar");
        botonCancelarAltaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarAltaEmpActionPerformed(evt);
            }
        });

        listaManagersAltaEmp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaManagersAltaEmp);

        listaAreasAltaEmp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaAreasAltaEmp.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane4.setViewportView(listaAreasAltaEmp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textoNombreAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(textoCedulaAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoCelAltaEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(textoSalAltaEmp))))
                                .addGap(148, 148, 148)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(botonRegistrarAltaEmp)
                        .addGap(75, 75, 75)
                        .addComponent(botonCancelarAltaEmp)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCedulaAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoNombreAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCelAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoSalAltaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistrarAltaEmp)
                    .addComponent(botonCancelarAltaEmp))
                .addGap(46, 46, 46))
        );

        setBounds(0, 0, 565, 523);
    }// </editor-fold>//GEN-END:initComponents

    private void textoNombreAltaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreAltaEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreAltaEmpActionPerformed

    private void textoCelAltaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCelAltaEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCelAltaEmpActionPerformed

    private void textoSalAltaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoSalAltaEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoSalAltaEmpActionPerformed

    private void botonCancelarAltaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarAltaEmpActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarAltaEmpActionPerformed

    private void botonRegistrarAltaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarAltaEmpActionPerformed
        agregarEmpleado();
    }//GEN-LAST:event_botonRegistrarAltaEmpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarAltaEmp;
    private javax.swing.JButton botonRegistrarAltaEmp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaAreasAltaEmp;
    private javax.swing.JList listaEmpleadosAltaEmp;
    private javax.swing.JList listaManagersAltaEmp;
    private javax.swing.JScrollBar scrollAreaAltaEmp;
    private javax.swing.JScrollBar scrollManagerAltaEmp;
    private javax.swing.JTextArea textoCVAltaEmp;
    private javax.swing.JTextField textoCedulaAltaEmp;
    private javax.swing.JTextField textoCelAltaEmp;
    private javax.swing.JTextField textoNombreAltaEmp;
    private javax.swing.JTextField textoSalAltaEmp;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("areas")) {
            sistema.ordenarAreasPorNombre();
            listaAreasAltaEmp.setListData(sistema.getListaAreas().toArray());
        } else if (arg.equals("managers")) {
            sistema.ordenarManagersPorAntiguedad();
            listaManagersAltaEmp.setListData(sistema.getListaManagers().toArray());
        }
    }
}
