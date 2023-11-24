package Views;


import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.agricultor;
import Principal.Dashboard;
import static Principal.Dashboard.ShowJPanel;
import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SeguimientoTarea extends javax.swing.JPanel {

    
    public String id_cultivo;
    private JButton etqBoton[];
    public SeguimientoTarea(String id_cultivo) {
        this.id_cultivo=id_cultivo;
        initComponents();
        InitStyles();
        init2();
        cargarAgricultores();
        
    }
    
     public void init2(){
        this.jTable1.getColumn("VER TAREAS").setCellRenderer(new ButtonRenderer());
        this.jTable1.getColumn("VER TAREAS").setCellEditor(new ButtonEditor(new JCheckBox()));
        
         
    }
    
    public void cargarAgricultores(){
        ConsumoApi traer = new ConsumoApi();
        Map<String, String> getData = new HashMap<>();
        getData.put("id_cultivo", id_cultivo);
        System.out.println("Views.SeguimientoTarea.cargarAgricultores()");
        
        //traigo los datos de la persona buscada
        String traerCedulas = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivo_agricultor/getAsignar.php",getData);
        System.out.println(traerCedulas);
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("VER TAREAS");
        jTable1.setModel(modelo);
        
        
        //cargo las imagenes del boton
        ImageIcon icon = new ImageIcon("src/img/ver.png");
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setRowHeight(25); // cambia el esacio que hay entre las celdas de la 
        
        JsonObject listaCedulas = JsonParser.parseString(traerCedulas).getAsJsonObject();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        init2();
        
        if(listaCedulas.has("registros")){
            JsonArray cedulasArray = listaCedulas.getAsJsonArray("registros");
            etqBoton= new JButton[cedulasArray.size()];
            
            for(int i=0; i< cedulasArray.size();i++){
                JsonObject temporal = cedulasArray.get(i).getAsJsonObject();
                String cedula = temporal.get("id_agricultor").getAsString();
                System.out.println(cedula);
                Map<String, String> getDatas = new HashMap<>();
                getDatas.put("cedula", cedula);
                String datosAgri = traer.consumoGET("http://localhost/APIenPHP-agricultura/agricultor/getPersona.php",getDatas);
                System.out.println(datosAgri+"gbhrth");
                JsonObject datos = JsonParser.parseString(datosAgri).getAsJsonObject();
                if(datos.has("registros")){
                    JsonArray agricultoresArray2 = datos.getAsJsonArray("registros");
                    for(int j=0; j< agricultoresArray2.size();j++){
                        JsonObject temporal2 = agricultoresArray2.get(j).getAsJsonObject();
                        etqBoton[i]= new JButton(icon);
                        etqBoton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                        etqBoton[i].setHorizontalTextPosition(SwingConstants.CENTER);
                        etqBoton[i].setContentAreaFilled(false);  // Oculta el fondo del botón
                        etqBoton[i].setBorderPainted(false);     // Oculta el borde del botón
                        System.out.println("Views.SeguimientoTarea.cargarAgricultores() datos .has");
                        
                
                
                        //GUARDO LOS DATOS DEL JSONOBJECT TEMPORAL EN VARIABLES
                        String cedula2 = temporal2.get("cedula").getAsString();
                        String nombre = temporal2.get("nombre").getAsString();
                        String apellido = temporal2.get("apellido").getAsString();
                        String telefono = temporal2.get("telefono").getAsString();
                        String email = temporal2.get("email").getAsString();
                        String estado = temporal2.get("estado").getAsString();
                        System.out.println(cedula2+nombre);
                    
                        etqBoton[i].addActionListener(new ActionListener() {
                           @Override
                               public void actionPerformed(ActionEvent e) {
                                   
                                   mostrarTareas(cedula2);
                               }
                           });
                        modelo.addRow(new Object[]{cedula2, nombre,etqBoton[i]});
                    }
                }
                    
            }
        }else{
            System.out.println("No se obtuvieron registros de la api");
        }
    }
    
    private void InitStyles() {
       
        
    }
    
    public void mostrarTareas(String cedula){
        ConsumoApi traer = new ConsumoApi();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("TAREA");
        modelo.addColumn("ESTADO");
        modelo.addColumn("MOSTRAR");
        jTable2.setModel(modelo);
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        jTable2.setRowHeight(25); // cambia el esacio que hay entre las celdas de la 
        
        
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(center);
        }

         
        Map<String, String> getDatass = new HashMap<>();
        getDatass.put("id_agricultor", cedula);
        getDatass.put("id_cultivo", id_cultivo);

        
        //traigo las tareas del trabajador con join en el cultivo
        String join = traer.consumoGET("http://localhost/APIenPHP-agricultura/joins/joinsTareasCultivo.php",getDatass);
        JsonObject listaTareas = JsonParser.parseString(join).getAsJsonObject();
        
      
        
        
        if(listaTareas.has("registros")){
            JsonArray tareasArray = listaTareas.getAsJsonArray("registros");
            
            
            for(int i=0; i< tareasArray.size();i++){
                JsonObject temporal = tareasArray.get(i).getAsJsonObject();
                
                String nombre_tarea = temporal.get("titulo").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String estado = temporal.get("estado").getAsString();
                
                modelo.addRow(new Object[]{nombre_tarea, descripcion,estado});
                    
            }
        }else{
            System.out.println("Error al traer las tareas");
        }
    }
    
    
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        bg.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "VER TAREAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 102));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        jTable2.setBackground(new java.awt.Color(0, 51, 51));
        jTable2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TAREA", "ESTADO", "MOSTRAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAREAS");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TRABAJADORES");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
