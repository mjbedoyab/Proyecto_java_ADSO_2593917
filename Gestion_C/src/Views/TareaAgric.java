/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vision
 */
public class TareaAgric extends javax.swing.JPanel {


    public String id_cultivo;
    public JCheckBox check[];
    public String lista_tareas[];
    String nombre_cult;
    public TareaAgric(String id_cultivo, String nombre_cult) {
        this.id_cultivo=id_cultivo;
        this.nombre_cult=nombre_cult;
        initComponents();
        init2();
        MostrarTareas();
        init3();
        cargarNombreCultivo();
    }
    
    public void cargarNombreCultivo(){
        System.out.println(nombre_cult);
        this.labelCultivo.setText(nombre_cult.toUpperCase()); 
    }
    
    public void MostrarTareas(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("TAREA");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("ASIGNAR");
        tablaTareas.setModel(modelo);
        ConsumoApi traer = new ConsumoApi();

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        tablaTareas.setRowHeight(25); // cambia el esacio que hay entre las celdas de la tabla
        Map<String, String> getData = new HashMap<>();
        getData.put("id_cultivo", id_cultivo);
            
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/tareas/getTarea.php",getData);
        JsonObject listaTareas = JsonParser.parseString(datos).getAsJsonObject();
        for (int i = 0; i < tablaTareas.getColumnCount(); i++) {
            tablaTareas.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        if(listaTareas.has("registros")){
            JsonArray tareas = listaTareas.getAsJsonArray("registros");
            check= new JCheckBox[tareas.size()];
            lista_tareas= new String [tareas.size()];
            for(int i=0; i< tareas.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
                check[i]= new JCheckBox("Asignar");
                JsonObject temporal = tareas.get(i).getAsJsonObject();
                String tarea = temporal.get("titulo").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String id_tarea = temporal.get("id_tarea").getAsString();
                lista_tareas[i]= id_tarea;
                modelo.addRow(new Object[]{tarea,descripcion, check[i]});
                
            }
        }
        
        System.out.println(id_cultivo);
    }
    
    public void init3(){
        this.tablaTareas.getColumn("ASIGNAR").setCellRenderer(new ButtonRenderer());
        this.tablaTareas.getColumn("ASIGNAR").setCellEditor(new ButtonEditor(new JCheckBox()));
    }
    
    public void init2(){
        ConsumoApi traerAgricultor = new ConsumoApi();
        String datos = traerAgricultor.consumoGET("http://localhost/APIenPHP-agricultura/agricultor/Obtener.php");
        JsonObject agricultores = JsonParser.parseString(datos).getAsJsonObject();
        if(agricultores.has("registros")){
          JsonArray listaAgrArray = agricultores.getAsJsonArray("registros");
          
          for(int i=0; i< listaAgrArray.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
               
               JsonObject temporal = listaAgrArray.get(i).getAsJsonObject();
               String estado = temporal.get("estado").getAsString();
               if(!"INACTIVO".equals(estado)){
                String nombre = temporal.get("nombre").getAsString();
                String apellido = temporal.get("apellido").getAsString();
                String cedula = temporal.get("cedula").getAsString();
                this.SelectAgri.addItem( cedula+" ---> "+nombre+" "+apellido );
                System.out.println("sasa"+nombre);
               }
            }
        }
    }
    
    public void insertar_tareaAgricultor(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelCultivo = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SelectAgri = new javax.swing.JComboBox<>();
        SelectFecha = new com.toedter.calendar.JDateChooser();
        labelCultivo1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1033, 564));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelCultivo.setFont(new java.awt.Font("Segoe UI Variable", 1, 36)); // NOI18N
        labelCultivo.setForeground(new java.awt.Color(0, 153, 0));
        labelCultivo.setText("NOMBRE CULTIVO");
        jPanel1.add(labelCultivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 690, 60));

        panelRound1.setBackground(new java.awt.Color(102, 102, 102));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TAREAS");

        tablaTareas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TAREA", "DESCIRPCION", "ASIGNAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaTareas.getTableHeader().setReorderingAllowed(false);
        tablaTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaTareasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTareas);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 430, 410));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SELECCIONE PLAZO FINAL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 260, 40));

        jButton1.setBackground(new java.awt.Color(0, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enviar (2).png"))); // NOI18N
        jButton1.setText("  Subir");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 280, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELECCIONE AGRICULTOR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 260, 40));

        SelectAgri.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        SelectAgri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectAgriActionPerformed(evt);
            }
        });
        jPanel1.add(SelectAgri, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 210, 40));
        jPanel1.add(SelectFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 312, 220, 40));

        labelCultivo1.setFont(new java.awt.Font("Segoe UI Variable", 1, 36)); // NOI18N
        labelCultivo1.setForeground(new java.awt.Color(204, 204, 204));
        labelCultivo1.setText("CULTIVO : ");
        jPanel1.add(labelCultivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTareasMousePressed

    }//GEN-LAST:event_tablaTareasMousePressed

    private void SelectAgriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectAgriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectAgriActionPerformed
    public void tareasSeleccionadas(String id_agricultor, String fecha_inicio, String fecha_fin ){
        for(int i=0;i<lista_tareas.length;i++){
            if(lista_tareas[i]!=null){
                    
                if(check[i].isSelected()){
                    String id_tarea = lista_tareas[i];
                    Map<String, String> insertData = new HashMap<>();
                    insertData.put("id_agricultor", id_agricultor);
                    insertData.put("id_tarea",id_tarea );
                    insertData.put("fecha_inicio", fecha_inicio);
                    insertData.put("fecha_fin", fecha_fin);

        
                    ConsumoApi insertar = new ConsumoApi();

                    String response = insertar.consumoPOST("http://localhost/APIenPHP-agricultura/tareas_agricultor/Insertar.php", insertData);
                        
                        
                    Map<String, String> insertDat = new HashMap<>();
                    insertDat.put("id_agricultor", id_agricultor);
                    insertDat.put("id_cultivo",id_cultivo );
                        
                        
                    String respuesta = insertar.consumoPOST("http://localhost/APIenPHP-agricultura/cultivo_agricultor/Insertar.php", insertDat);
                }
            }
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date var=this.SelectFecha.getDate();
        
        
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("yyyy-MM-dd");
        String formateddate= nuevoFormato.format(var);
        LocalDate fechaHoy = LocalDate.now();
        String fecha = String.valueOf(fechaHoy);
        
        
        
        String agricultor = String.valueOf(this.SelectAgri.getSelectedItem());
        String cedula ="";
        
        // Iterar sobre cada carácter en la cadena
        for (int i = 0; i < agricultor.length(); i++) {
            char caracter = agricultor.charAt(i);
            if(caracter!='-'){
                 cedula += String.valueOf(caracter);
            }else{
                break;
            }
            
        }
        
        
        tareasSeleccionadas(cedula, fecha, formateddate);
        
        System.out.println(formateddate);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> SelectAgri;
    private com.toedter.calendar.JDateChooser SelectFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCultivo;
    private javax.swing.JLabel labelCultivo1;
    private Clases.PanelRound panelRound1;
    private javax.swing.JTable tablaTareas;
    // End of variables declaration//GEN-END:variables
}
