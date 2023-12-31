package Views;


import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Tareas extends javax.swing.JPanel {

    private final int MAX_DAYS_RETURN = 5;
    private final int COST_DAY_SANC = 10;
    
    public Tareas() {
        initComponents();
        InitStyles();
        init2();
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        title.setForeground(Color.WHITE);
        nombre_tarea.putClientProperty("FlatLaf.styleClass", "large");
        nombre_tarea.setForeground(Color.WHITE);
        descripcion.putClientProperty("FlatLaf.styleClass", "large");
        descripcion.setForeground(Color.WHITE);
        campo_tarea.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de la tarea.");
    }
    
    public void init2(){
        ConsumoApi traerCultivos = new ConsumoApi();
        String datos = traerCultivos.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/Obtener.php");
        JsonObject cultivos = JsonParser.parseString(datos).getAsJsonObject();
        if(cultivos.has("registros")){
          JsonArray listaCultivos = cultivos.getAsJsonArray("registros");
          
          for(int i=0; i< listaCultivos.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
                
               JsonObject temporal = listaCultivos.get(i).getAsJsonObject();
               String nombre = temporal.get("nombre").getAsString();
               this.seleccion_cultivo.addItem(nombre);
               System.out.println("sasa"+nombre);
            }
        }
    }
    public void insertarTarea(String id_cultivo, String titulo, String descripcion){
       ConsumoApi insertarCuñtivo = new ConsumoApi();
        Map<String, String> insertData = new HashMap<>();
            insertData.put("id_cultivo", id_cultivo);
            insertData.put("titulo", titulo);
            insertData.put("descripcion", descripcion);
            insertData.put("estado", "Pendiente");
        
        
        
        
           String response = insertarCuñtivo.consumoPOST("http://localhost/APIenPHP-agricultura/tareas/Insertar.php", insertData);
    }
    public void ObetenerDatos(){
        ConsumoApi insertar = new ConsumoApi();
        
        
        
        
       
        String nombre=this.campo_tarea.getText();
        String desc=this.campo_descripcion.getText();
        String cultivo = String.valueOf(seleccion_cultivo.getSelectedItem());
        System.out.println(cultivo);
        LocalDate fechaHoy = LocalDate.now();
        String fecha = String.valueOf(fechaHoy);
        
        
        Map<String, String> getData = new HashMap<>();
        getData.put("nombre", cultivo);
        String traerCultivo =insertar.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/getCultivo.php",getData);
        
        
        JsonObject datos_cultivo = JsonParser.parseString(traerCultivo).getAsJsonObject();
        System.out.println(datos_cultivo);
        if(datos_cultivo.has("registros")){
            String id_cultivo="";
            
            JsonArray listaCultivos = datos_cultivo.getAsJsonArray("registros");
           
            
            for(int i=0; i< listaCultivos.size();i++){
                JsonObject temporal = listaCultivos.get(i).getAsJsonObject();
                id_cultivo = temporal.get("id_cultivo").getAsString();
                System.out.println("idddd"+ id_cultivo);
                
            }
           
            insertarTarea(id_cultivo, nombre, desc);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        nombre_tarea = new javax.swing.JLabel();
        campo_tarea = new javax.swing.JTextField();
        descripcion = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campo_descripcion = new javax.swing.JTextArea();
        seleccione_cultivo = new javax.swing.JLabel();
        seleccion_cultivo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        bg.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        title.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        title.setText("Ingresar Tarea");

        nombre_tarea.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nombre_tarea.setText("NOMBRE TAREA");

        descripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        descripcion.setText("DESCRIPCION");

        button.setBackground(new java.awt.Color(153, 0, 255));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enviar (2).png"))); // NOI18N
        button.setText("Ingresar");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        image.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agriculture-logo (1).png"))); // NOI18N

        campo_descripcion.setColumns(20);
        campo_descripcion.setRows(5);
        jScrollPane1.setViewportView(campo_descripcion);

        seleccione_cultivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seleccione_cultivo.setText("SELECCIONE CULTIVO");
        seleccione_cultivo.setToolTipText("");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(nombre_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(199, 199, 199))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(167, 167, 167))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(223, 223, 223))
                            .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campo_tarea))
                        .addGap(26, 26, 26))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(seleccion_cultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seleccione_cultivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_tarea, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_tarea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(seleccione_cultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(seleccion_cultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        ObetenerDatos();
    }//GEN-LAST:event_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JTextArea campo_descripcion;
    private javax.swing.JTextField campo_tarea;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombre_tarea;
    private javax.swing.JComboBox<String> seleccion_cultivo;
    private javax.swing.JLabel seleccione_cultivo;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
