//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz;
import Dominio.*;
import Interfaz.VentanasAreas.*;
import Interfaz.VentanasEmpleados.*;
import Interfaz.VentanasManagers.*;
import Interfaz.VentanasReportes.*;
import Recursos.VentanaAutores;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;


public class VentanaMenu extends javax.swing.JFrame {
    private Sistema sistema;    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaMenu.class.getName());

   
    public VentanaMenu(Sistema unSistema) {
        sistema=unSistema;
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
        
         configurarAtajoF1();
         
 }
   
        
        private void configurarAtajoF1() {
        // Vincula F1 a la acción "mostrarAutores"
        JRootPane rootPane = this.getRootPane();
        KeyStroke teclaF1 = KeyStroke.getKeyStroke("F1");

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(teclaF1, "mostrarAutores");

        rootPane.getActionMap()
                .put("mostrarAutores", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarVentanaAutores();
                    }
                });
    }

    private void mostrarVentanaAutores() {
        new VentanaAutores().setVisible(true);
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
        itemReporteMov = new javax.swing.JMenuItem();

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
        itemAreaBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAreaBajaActionPerformed(evt);
            }
        });
        jMenu1.add(itemAreaBaja);

        itemAreaModificacion.setText("Modificacion");
        itemAreaModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAreaModificacionActionPerformed(evt);
            }
        });
        jMenu1.add(itemAreaModificacion);

        itemAreaMovimiento.setText("Realizar movimiento");
        itemAreaMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAreaMovimientoActionPerformed(evt);
            }
        });
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
        itemManagersBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManagersBajaActionPerformed(evt);
            }
        });
        jMenu2.add(itemManagersBaja);

        itemManagersModificacion.setText("Modificacion");
        itemManagersModificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemManagersModificacionActionPerformed(evt);
            }
        });
        jMenu2.add(itemManagersModificacion);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Empleados");

        itemEmpleadosAlta.setText("Alta");
        itemEmpleadosAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpleadosAltaActionPerformed(evt);
            }
        });
        jMenu3.add(itemEmpleadosAlta);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");

        itemReporteInteligente.setText("Reporte inteligente");
        itemReporteInteligente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteInteligenteActionPerformed(evt);
            }
        });
        jMenu4.add(itemReporteInteligente);

        itemReporteAreas.setText("Reporte de estado de areas");
        itemReporteAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteAreasActionPerformed(evt);
            }
        });
        jMenu4.add(itemReporteAreas);

        itemReporteMov.setText("Reporte de movimientos");
        itemReporteMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteMovActionPerformed(evt);
            }
        });
        jMenu4.add(itemReporteMov);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 416, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void itemAreaAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAreaAltaActionPerformed
       
        AltaArea ventanaAlta= new AltaArea(sistema);
       
    }//GEN-LAST:event_itemAreaAltaActionPerformed

    private void itemManagersAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManagersAltaActionPerformed
        AltaManager ventanaAltaManager =new AltaManager(sistema);
    }//GEN-LAST:event_itemManagersAltaActionPerformed

    private void itemAreaMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAreaMovimientoActionPerformed
        RealizarMovimiento ventanaRealizarMovimiento= new RealizarMovimiento(sistema);
        
    }//GEN-LAST:event_itemAreaMovimientoActionPerformed

    private void itemEmpleadosAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpleadosAltaActionPerformed
       AltaEmpleado ventanaAltaEmpleado = new AltaEmpleado(sistema);
    }//GEN-LAST:event_itemEmpleadosAltaActionPerformed

    private void itemManagersBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManagersBajaActionPerformed
        BajaManager ventanaBajaManager = new BajaManager(sistema);
    }//GEN-LAST:event_itemManagersBajaActionPerformed

    private void itemAreaBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAreaBajaActionPerformed
       BajaArea ventanaBajaArea = new BajaArea(sistema);
    }//GEN-LAST:event_itemAreaBajaActionPerformed

    private void itemAreaModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAreaModificacionActionPerformed
        ModificacionArea ventanaModifArea= new ModificacionArea(sistema);
    }//GEN-LAST:event_itemAreaModificacionActionPerformed

    private void itemManagersModificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemManagersModificacionActionPerformed
        ModificacionManager ventanaModifMan= new ModificacionManager(sistema);
    }//GEN-LAST:event_itemManagersModificacionActionPerformed

    private void itemReporteInteligenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteInteligenteActionPerformed
       Inteligente ventanaInt= new Inteligente(sistema);
    }//GEN-LAST:event_itemReporteInteligenteActionPerformed

    private void itemReporteAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteAreasActionPerformed
        EstadoAreas ventanaEstAreas= new EstadoAreas(sistema);
    }//GEN-LAST:event_itemReporteAreasActionPerformed

    private void itemReporteMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteMovActionPerformed
        ReporteMovimientos ventanaRepMov= new ReporteMovimientos(sistema);
    }//GEN-LAST:event_itemReporteMovActionPerformed


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
    private javax.swing.JMenuItem itemReporteMov;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

                
}

