//Marcos Coszion(332945), Francisco Lino(347691)
package Interfaz.VentanasReportes;

import Dominio.*;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.*;

public class Inteligente extends javax.swing.JFrame implements Observer{
    private Sistema sistema;
   
    
    public Inteligente(Sistema unSistema) {
         sistema = unSistema;
        initComponents();
        setTitle("Reporte inteligente");
        setVisible(true);
        
        listaAreaOrInt.setListData(sistema.getListaAreas().toArray());
        listaAreaDestInt.setListData(sistema.getListaAreas().toArray());
        sistema.addObserver(this);
    }
    
   private String construirPrompt(Area origen, Area destino, Empleado emp) {
    StringBuilder sb = new StringBuilder();

    sb.append("Genera un reporte profesional sobre la conveniencia de trasladar un empleado entre áreas.\n");
    sb.append("Incluye obligatoriamente ventajas, desventajas y una recomendación final.\n\n");

    sb.append("Área de Origen:\n");
    sb.append("- Nombre: ").append(origen.getNombre()).append("\n");
    sb.append("- Descripción: ").append(origen.getDescripcion()).append("\n\n");

    sb.append("Empleado:\n");
    sb.append("- Nombre: ").append(emp.getNombre()).append("\n");
    sb.append("- Curriculum: ").append(emp.getCurriculum()).append("\n\n");

    sb.append("Área de Destino:\n");
    sb.append("- Nombre: ").append(destino.getNombre()).append("\n");
    sb.append("- Descripción: ").append(destino.getDescripcion()).append("\n\n");

    sb.append("Redacta el reporte en lenguaje claro, profesional, en 3 secciones: ventajas, desventajas y recomendación.\n");

    return sb.toString();
}

   private String extraerTextoDeRespuesta(String json) {
    try {
        Gson gson = new Gson();

        // Estructura mínima esperada por Gemini
        Map respuesta = gson.fromJson(json, Map.class);
        List candidates = (List) respuesta.get("candidates");
        if (candidates == null || candidates.isEmpty()) return "No hubo respuesta.";

        Map candidate0 = (Map) candidates.get(0);
        List content = (List) ((Map) candidate0.get("content")).get("parts");

        if (content != null && !content.isEmpty()) {
            Map part0 = (Map) content.get(0);
            Object text = part0.get("text");
            return text != null ? text.toString() : "Sin texto recibido.";
        }

        return "No se pudo interpretar la respuesta.";
    } catch (Exception e) {
        return "Error al procesar JSON: " + e.getMessage();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAreaOrInt = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaEmpleadosInt = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaAreaDestInt = new javax.swing.JList();
        botonConsultarInt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoAreaInt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Área origen");

        jLabel2.setText("Empleados");

        jLabel3.setText("Área destino");

        listaAreaOrInt.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaAreaOrInt.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAreaOrIntValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaAreaOrInt);

        jScrollPane2.setViewportView(listaEmpleadosInt);

        listaAreaDestInt.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listaAreaDestInt);

        botonConsultarInt.setText("Consultar");
        botonConsultarInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarIntActionPerformed(evt);
            }
        });

        textoAreaInt.setColumns(20);
        textoAreaInt.setRows(5);
        jScrollPane4.setViewportView(textoAreaInt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(botonConsultarInt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2, jScrollPane3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonConsultarInt)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2, jScrollPane3});

        setBounds(0, 0, 506, 469);
    }// </editor-fold>//GEN-END:initComponents

    private void listaAreaOrIntValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAreaOrIntValueChanged
        Area unArea= (Area)listaAreaOrInt.getSelectedValue();
        if(unArea!=null){
           listaEmpleadosInt.setListData(unArea.getListaEmpleados().toArray());
        }
    }//GEN-LAST:event_listaAreaOrIntValueChanged

    private void botonConsultarIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarIntActionPerformed
       Area origen = (Area) listaAreaOrInt.getSelectedValue();
    Area destino = (Area) listaAreaDestInt.getSelectedValue();
    Empleado emp = (Empleado) listaEmpleadosInt.getSelectedValue();

    // Validar
    if (origen == null || destino == null || emp == null) {
        JOptionPane.showMessageDialog(this,
                "Debe seleccionar área de origen, empleado y área de destino.",
                "Datos incompletos",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Construir prompt
    String prompt = construirPrompt(origen, destino, emp);

    // 3. Llamar a la IA
    geminiAI ia = new geminiAI();

    try {
        textoAreaInt.setText("Consultando IA... espere unos segundos\n");

        String respuestaJSON = ia.consultarIA(prompt);

        // 4. EXTRAER SOLO EL TEXTO, no el JSON entero
        String textoLimpio = extraerTextoDeRespuesta(respuestaJSON);

        // 5. Mostrarlo en el textarea
        textoAreaInt.setText(textoLimpio);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Error al consultar Gemini: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_botonConsultarIntActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultarInt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaAreaDestInt;
    private javax.swing.JList listaAreaOrInt;
    private javax.swing.JList listaEmpleadosInt;
    private javax.swing.JTextArea textoAreaInt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("areas")){
            sistema.ordenarAreasPorNombre();
        listaAreaOrInt.setListData(sistema.getListaAreas().toArray());
        listaAreaDestInt.setListData(sistema.getListaAreas().toArray());
        }
    }
}
