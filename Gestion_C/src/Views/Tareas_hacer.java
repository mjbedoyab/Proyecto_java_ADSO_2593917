package Views;

import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Principal.DashboardA;
import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tareas_hacer extends javax.swing.JPanel {
    
    public String id_cultivo2;
    public JCheckBox check[];
    public String lista_hecha[];
    //private tareas tareas;
    public String cedula;
    
    public Tareas_hacer(String id_cultivo2,String cedula) {
        this.id_cultivo2 = id_cultivo2;
        this.cedula=cedula;
        //this.tareas = tareas;
        initComponents();
        
        MostrarHacer();
        init2();
    }
    
    public void MostrarHacer(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NOMBRE_TAREA");
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("FECHA_LIMITE");
        modelo.addColumn("CHECKBOX");
        tablaHacer.setModel(modelo);
        ConsumoApi traer = new ConsumoApi();

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        tablaHacer.setRowHeight(25); // cambia el esacio que hay entre las celdas de la tabla
        Map<String, String> getData = new HashMap<>();
        getData.put("id_cultivo", id_cultivo2);
        getData.put("id_agricultor", cedula);
        
            
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/joins/joinTarea.php",getData);
        System.out.println(datos);
        JsonObject listaHacer = JsonParser.parseString(datos).getAsJsonObject();
        for (int i = 0; i < tablaHacer.getColumnCount(); i++) {
            tablaHacer.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        if(listaHacer.has("registros")){
            
            JsonArray hacer = listaHacer.getAsJsonArray("registros");
            check = new JCheckBox[hacer.size()];
            lista_hecha= new String [hacer.size()];
            
            for(int i=0; i< hacer.size();i++){
                
                //int i = Integer.parseInt(String.valueOf(registroElement));
                check[i]= new JCheckBox("FINALIZADO");
                JsonObject temporal = hacer.get(i).getAsJsonObject();
                String nombre_tarea = temporal.get("titulo").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String fecha_limite = temporal.get("fecha_fin").getAsString();
                String id_tarea = temporal.get("id_tarea").getAsString();
                String estado = temporal.get("estado").getAsString();
                lista_hecha[i]= id_tarea;
                if (estado.equalsIgnoreCase("Pendiente")) {
                    
                    modelo.addRow(new Object[]{nombre_tarea, descripcion, fecha_limite, check[i]});
                } else {
                    
                    modelo.addRow(new Object[]{nombre_tarea, descripcion, fecha_limite, "Tarea Completada"});
                    System.out.println("Tareas Completadas");
                }
                
            }
        }
        
        System.out.println(id_cultivo2);
    }
    
    public void init2(){
        this.tablaHacer.getColumn("CHECKBOX").setCellRenderer(new ButtonRenderer());
        this.tablaHacer.getColumn("CHECKBOX").setCellEditor(new ButtonEditor(new JCheckBox()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHacer = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1033, 564));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAREAS POR HACER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1030, 70));

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tablaHacer.setBackground(new java.awt.Color(0, 102, 102));
        tablaHacer.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        tablaHacer.setForeground(new java.awt.Color(255, 255, 255));
        tablaHacer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE_TAREA", "DESCRIPCIÓN", "FECHA_LIMITE", "CHECKBOX"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaHacer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1010, 340));

        jButton2.setBackground(new java.awt.Color(153, 0, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enviar (2).png"))); // NOI18N
        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void tareasFinalizadas(String estado) {
        for (int i = 0; i < lista_hecha.length; i++) {
            if (lista_hecha[i] != null && check[i].isSelected()) {
                String id_tarea = lista_hecha[i];
                Map<String, String> updateData = new HashMap<>();

                updateData.put("id_tarea", id_tarea);
                updateData.put("estado", estado);

                ConsumoApi update = new ConsumoApi();

                String actualiza_estado = update.consumoPOST("http://localhost/APIenPHP-agricultura/joins/updateTarea.php", updateData);
            }
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String estado1 = "Finalizado";
        
        tareasFinalizadas(estado1);
        DashboardA.ShowJPanel(new Tareas_hacer(id_cultivo2, cedula));
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHacer;
    // End of variables declaration//GEN-END:variables
}
