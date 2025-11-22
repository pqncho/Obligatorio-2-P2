//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasReportes;

import Dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReporteMovimientos extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReporteMovimientos.class.getName());

    public ReporteMovimientos(Sistema unSistema) {
        initComponents();
        sistema = unSistema;
        setTitle("Reporte movimientos");
        setVisible(true);
        unSistema.addObserver(this);
        DefaultTableModel modelo = (DefaultTableModel) tablaRepoMov.getModel();
        modelo.setRowCount(0);
        cargarCombos();
        cargarMovimientos(sistema.getListaMovArea());

    }

    private void aplicarFiltro() {
        DefaultTableModel modelo = (DefaultTableModel) tablaRepoMov.getModel();
        modelo.setRowCount(0);
        String mesSel = boxMesRepMov.getSelectedItem().toString();
        String aOriSel = boxAOriRepMov.getSelectedItem().toString();
        String aDestSel = boxADestRepMov.getSelectedItem().toString();
        String empSel = boxEmpRepMov.getSelectedItem().toString();

        for (MovimientosArea mov : sistema.getListaMovArea()) {

            boolean coincideMes = mesSel.equals("Todos") || mov.getMes().equals(mesSel);
            boolean coincideOri = aOriSel.equals("Todos") || mov.getAreaOrigen().getNombre().equals(aOriSel);
            boolean coincideDest = aDestSel.equals("Todos") || mov.getAreaDestino().getNombre().equals(aDestSel);
            boolean coincideEmp = empSel.equals("Todos") || mov.getEmpleado().getNombre().equals(empSel);

            if (coincideMes && coincideOri && coincideDest && coincideEmp) {
                modelo.addRow(new Object[]{
                    mov.getMes(),
                    mov.getAreaOrigen().getNombre(),
                    mov.getAreaDestino().getNombre(),
                    mov.getEmpleado().getNombre()
                });
            }
        }

    }

    private void cargarCombos() {
        boolean estaMes = false;
        boolean estaAOrigen = false;
        boolean estaADestino = false;
        boolean estaEmpleado = false;

        for (int i = 0; i < sistema.getListaMovArea().size(); i++) {
            String unMes = sistema.getListaMovArea().get(i).getMes();
            estaMes = false;

            for (int j = 0; j < boxMesRepMov.getItemCount(); j++) {
                if (boxMesRepMov.getItemAt(j).equals(unMes)) {
                    estaMes = true;
                }

            }
            if (!estaMes) {
                boxMesRepMov.addItem(unMes);
            }
        }

        for (int i = 0; i < sistema.getListaMovArea().size(); i++) {
            Area unAOrigen = sistema.getListaMovArea().get(i).getAreaOrigen();
            estaAOrigen = false;

            for (int j = 0; j < boxAOriRepMov.getItemCount(); j++) {
                if (boxAOriRepMov.getItemAt(j).equals(unAOrigen.getNombre())) {
                    estaAOrigen = true;
                }

            }
            if (!estaAOrigen) {
                boxAOriRepMov.addItem(unAOrigen.getNombre());
            }
        }

        for (int i = 0; i < sistema.getListaMovArea().size(); i++) {
            Area unADestino = sistema.getListaMovArea().get(i).getAreaDestino();
            estaADestino = false;

            for (int j = 0; j < boxADestRepMov.getItemCount(); j++) {
                if (boxADestRepMov.getItemAt(j).equals(unADestino.getNombre())) {
                    estaADestino = true;
                }

            }
            if (!estaADestino) {
                boxADestRepMov.addItem(unADestino.getNombre());
            }
        }

        for (int i = 0; i < sistema.getListaMovArea().size(); i++) {
            Empleado unEmpleado = sistema.getListaMovArea().get(i).getEmpleado();
            estaEmpleado = false;

            for (int j = 0; j < boxEmpRepMov.getItemCount(); j++) {
                if (boxEmpRepMov.getItemAt(j).equals(unEmpleado.getNombre())) {
                    estaEmpleado = true;
                }

            }
            if (!estaEmpleado) {
                boxEmpRepMov.addItem(unEmpleado.getNombre());
            }
        }

    }

    private void cargarMovimientos(ArrayList<MovimientosArea> listaMovArea) {
        DefaultTableModel modelo = (DefaultTableModel) tablaRepoMov.getModel();
        modelo.setRowCount(0);

        for (MovimientosArea movArea : listaMovArea) {
            modelo.addRow(new Object[]{
                movArea.getMes(),
                movArea.getAreaOrigen().getNombre(),
                movArea.getAreaDestino().getNombre(),
                movArea.getEmpleado().getNombre(),});
        }
    }

    public void exportarCSV() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como CSV");

        fileChooser.setSelectedFile(new java.io.File("reporteMovimientos.csv"));
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            if (!archivo.getName().toLowerCase().endsWith(".csv")) {
                archivo = new File(archivo.getAbsolutePath() + ".csv");
            }

            try (PrintWriter pw = new PrintWriter(archivo)) {

                DefaultTableModel modelo = (DefaultTableModel) tablaRepoMov.getModel();

                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    pw.print(modelo.getColumnName(i));
                    if (i < modelo.getColumnCount() - 1) {
                        pw.print(",");
                    }
                }
                pw.println();

                for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                    for (int col = 0; col < modelo.getColumnCount(); col++) {
                        Object valor = modelo.getValueAt(fila, col);
                        if (valor == null) {
                            pw.print("");
                        } else {
                            pw.print(valor.toString());
                        }

                        if (col < modelo.getColumnCount() - 1) {
                            pw.print(",");
                        }
                    }
                    pw.println();
                }

                JOptionPane.showMessageDialog(this, "Archivo CSV guardado correctamente.");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRepoMov = new javax.swing.JTable();
        boxMesRepMov = new javax.swing.JComboBox<>();
        boxAOriRepMov = new javax.swing.JComboBox<>();
        boxADestRepMov = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boxEmpRepMov = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonExp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaRepoMov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null}
            },
            new String [] {
                "Mes", "Área origen", "Área destino", "Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaRepoMov);

        boxMesRepMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        boxMesRepMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesRepMovActionPerformed(evt);
            }
        });

        boxAOriRepMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        boxAOriRepMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAOriRepMovActionPerformed(evt);
            }
        });

        boxADestRepMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        boxADestRepMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxADestRepMovActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtros:");

        jLabel2.setText("Mes");

        jLabel3.setText("Área origen");

        boxEmpRepMov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        boxEmpRepMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEmpRepMovActionPerformed(evt);
            }
        });

        jLabel5.setText("Empleado");

        jLabel6.setText("Área destino");

        botonExp.setText("Exportar como CSV");
        botonExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boxMesRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxADestRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxAOriRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxEmpRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(botonExp))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(15, 15, 15))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boxADestRepMov, boxAOriRepMov, boxEmpRepMov, boxMesRepMov});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxMesRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxAOriRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxADestRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxEmpRepMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(botonExp)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxADestRepMov, boxAOriRepMov, boxEmpRepMov, boxMesRepMov, jLabel2, jLabel3, jLabel5, jLabel6});

        setBounds(0, 0, 737, 328);
    }// </editor-fold>//GEN-END:initComponents

    private void botonExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExpActionPerformed
        exportarCSV();
    }//GEN-LAST:event_botonExpActionPerformed

    private void boxAOriRepMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAOriRepMovActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_boxAOriRepMovActionPerformed

    private void boxMesRepMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesRepMovActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_boxMesRepMovActionPerformed

    private void boxADestRepMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxADestRepMovActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_boxADestRepMovActionPerformed

    private void boxEmpRepMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEmpRepMovActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_boxEmpRepMovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonExp;
    private javax.swing.JComboBox<String> boxADestRepMov;
    private javax.swing.JComboBox<String> boxAOriRepMov;
    private javax.swing.JComboBox<String> boxEmpRepMov;
    private javax.swing.JComboBox<String> boxMesRepMov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRepoMov;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("MovArea")) {
            DefaultTableModel modelo = (DefaultTableModel) tablaRepoMov.getModel();
            modelo.setRowCount(0);
            cargarMovimientos(sistema.getListaMovArea());
            cargarCombos();
        }
    }
}
