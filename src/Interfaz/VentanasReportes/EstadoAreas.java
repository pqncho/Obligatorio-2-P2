//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasReportes;

import Dominio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class EstadoAreas extends javax.swing.JFrame implements Observer {
    private Sistema sistema;
    
    public EstadoAreas(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Reporte estado de areas");
        setVisible(true);
        sistema.ordenarAreasPorPorcentaje();
        unSistema.addObserver(this);
       cargarAreas();
        
    }
    private void cargarAreas(){
    
     panelAreas.removeAll();
     panelAreas.setLayout(new GridLayout(0, 1));
     sistema.ordenarAreasPorPorcentaje();
     ArrayList<Area> listaAreas = new ArrayList<>(sistema.getListaAreas());
     
      for (Area unArea : listaAreas) {

        JButton btn = new JButton(unArea.getNombre());
        
         double p = unArea.getPorcentaje();

        if (p > 0.90) btn.setBackground(Color.RED);
        else if (p >= 0.70) btn.setBackground(Color.YELLOW);
        else btn.setBackground(Color.LIGHT_GRAY);

        btn.addActionListener(e -> mostrarArea(unArea)); 

        panelAreas.add(btn);
    }

    panelAreas.revalidate();
    panelAreas.repaint();
        
    }
    private void mostrarArea(Area unArea){
    
    double total = unArea.getPresupuesto();
    double asignado = 0;
    
     for (Empleado e : unArea.getListaEmpleados()) {
        asignado += e.getSalarioAnual(); 
    }

    double restante = total - asignado;

    labelPorcentaje.setText(unArea.getNombre() +" " + unArea.getPorcentaje() + " %");
    labelPresuTotal.setText("Presupuesto: $" + total);
    labelPresuAsignado.setText("Asignado: $" + asignado);
    labelPresuRestante.setText("Restante: $" + restante);
    
    panelEmpleados.removeAll();
    panelEmpleados.setLayout(new GridLayout(0, 3));
    
    ArrayList<Empleado> listaEmpleados = new ArrayList<>(unArea.getListaEmpleados());
    Collections.sort(listaEmpleados, new Comparator<Empleado>() {
    @Override
    public int compare(Empleado e1, Empleado e2) {
        return e1.getNombre().compareToIgnoreCase(e2.getNombre());
    }
});
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelAreas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelEmpleados = new javax.swing.JPanel();
        labelPorcentaje = new javax.swing.JLabel();
        labelPresuTotal = new javax.swing.JLabel();
        labelPresuAsignado = new javax.swing.JLabel();
        labelPresuRestante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Areas");

        panelAreas.setBackground(new java.awt.Color(204, 204, 204));
        panelAreas.setForeground(new java.awt.Color(30, 30, 30));
        panelAreas.setFocusCycleRoot(true);
        panelAreas.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(panelAreas);

        panelEmpleados.setLayout(new java.awt.GridLayout(0, 3));
        jScrollPane2.setViewportView(panelEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPresuTotal)
                            .addComponent(labelPresuAsignado)
                            .addComponent(labelPresuRestante)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(labelPorcentaje))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelPorcentaje)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPresuTotal)
                        .addGap(18, 18, 18)
                        .addComponent(labelPresuAsignado)
                        .addGap(22, 22, 22)
                        .addComponent(labelPresuRestante))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        setBounds(0, 0, 602, 433);
    }// </editor-fold>//GEN-END:initComponents

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPorcentaje;
    private javax.swing.JLabel labelPresuAsignado;
    private javax.swing.JLabel labelPresuRestante;
    private javax.swing.JLabel labelPresuTotal;
    private javax.swing.JPanel panelAreas;
    private javax.swing.JPanel panelEmpleados;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        sistema.ordenarAreasPorPorcentaje();
        
    }
}
