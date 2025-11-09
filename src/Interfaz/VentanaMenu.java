//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz;
import Dominio.*;
import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaMenu.class.getName());

   
    public VentanaMenu(Sistema unSistema) {
        initComponents();
        setTitle("ERP Empresarial");
        setVisible(true);
       JPanel panelFondo = new JPanel() {
            private Image fondo = new ImageIcon(
                getClass().getResource("/Recursos/fondoERP.jpg")
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
             
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panelFondo.setLayout(new BorderLayout());

       
        setContentPane(panelFondo);
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAreaAlta = new javax.swing.JMenuItem();
        itemAreaBaja = new javax.swing.JMenuItem();
        itemAreaModificacion = new javax.swing.JMenuItem();
        itemAreaMovimiento = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemManagersAlta = new javax.swing.JMenuItem();
        itemManagersBaja = new javax.swing.JMenuItem();
        itemManagersModificacion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemEmpleadosAlta = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemReporteInteligente = new javax.swing.JMenuItem();
        itemReporteAreas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jMenu1.setText("Areas");

        itemAreaAlta.setText("Alta");
        itemAreaAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAreaAltaActionPerformed(evt);
            }
        });
        jMenu1.add(itemAreaAlta);

        itemAreaBaja.setText("Baja");
        jMenu1.add(itemAreaBaja);

        itemAreaModificacion.setText("Modificacion");
        jMenu1.add(itemAreaModificacion);

        itemAreaMovimiento.setText("Realizar movimiento");
        jMenu1.add(itemAreaMovimiento);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Managers");

        itemManagersAlta.setText("Alta");
        itemManagersAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManagersAltaActionPerformed(evt);
            }
        });
        jMenu2.add(itemManagersAlta);

        itemManagersBaja.setText("Baja");
        jMenu2.add(itemManagersBaja);

        itemManagersModificacion.setText("Modificacion");
        jMenu2.add(itemManagersModificacion);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Empleados");

        itemEmpleadosAlta.setText("Alta");
        jMenu3.add(itemEmpleadosAlta);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");

        itemReporteInteligente.setText("Reporte inteligente");
        jMenu4.add(itemReporteInteligente);

        itemReporteAreas.setText("Reporte de estado de areas");
        jMenu4.add(itemReporteAreas);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 416, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void itemAreaAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAreaAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAreaAltaActionPerformed

    private void itemManagersAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManagersAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemManagersAltaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAreaAlta;
    private javax.swing.JMenuItem itemAreaBaja;
    private javax.swing.JMenuItem itemAreaModificacion;
    private javax.swing.JMenuItem itemAreaMovimiento;
    private javax.swing.JMenuItem itemEmpleadosAlta;
    private javax.swing.JMenuItem itemManagersAlta;
    private javax.swing.JMenuItem itemManagersBaja;
    private javax.swing.JMenuItem itemManagersModificacion;
    private javax.swing.JMenuItem itemReporteAreas;
    private javax.swing.JMenuItem itemReporteInteligente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

                
}
