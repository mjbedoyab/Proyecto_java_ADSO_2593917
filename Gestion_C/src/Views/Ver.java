package Views;

import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.cultivos;
import Clases.tareas;
import Principal.Dashboard;
import Principal.DashboardA;
import static Principal.Dashboard.ShowJPanel;
import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ver extends javax.swing.JPanel {
    
    private JButton etqBoton[];
    private String cedula;
    
    int variable ;
    
    public Ver(String cedula) {
        this.cedula = cedula;
        
        initComponents();
        InitStyles();
        mostrar();
        init2();
    }
    
    public void init2(){
        this.tablaTareas.getColumn("TAREAS").setCellRenderer(new ButtonRenderer());
        this.tablaTareas.getColumn("TAREAS").setCellEditor(new ButtonEditor(new JCheckBox()));
    }
    private void InitStyles() {
        jLabel1.putClientProperty("FlatLaf.styleClass", "h1");
        jLabel1.setForeground(Color.WHITE);
        inputBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de usuario a buscar.");
    }
    
    public void mostrar(){
        ConsumoApi traer = new ConsumoApi();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_CULTIVO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TIPO");
        modelo.addColumn("TAREAS");
        tablaTareas.setModel(modelo);
        
        ImageIcon iconVer = new ImageIcon("src/img/binoculars.png");
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        tablaTareas.setRowHeight(25); // cambia el esacio que hay entre las celdas de la 
        
        
        for (int i = 0; i < tablaTareas.getColumnCount(); i++) {
            tablaTareas.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        Map<String, String> getData = new HashMap<>();
        getData.put("id_agricultor", cedula);

        
        //traigo los datos de la persona buscada
        String getCultivo = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivo_agricultor/getAsignar.php",getData);
        JsonObject listaTareas = JsonParser.parseString(getCultivo).getAsJsonObject();
        
        
        if(listaTareas.has("registros")){
            JsonArray cultivoArray = listaTareas.getAsJsonArray("registros");
            
            
            for(int i=0; i< cultivoArray.size();i++){
                JsonObject temporal = cultivoArray.get(i).getAsJsonObject();
                String id_cultivo = temporal.get("id_cultivo").getAsString();
                
                System.out.println(id_cultivo);
                
                Map<String, String> getDatas = new HashMap<>();
                getDatas.put("id_cultivo", id_cultivo);
                String datosCultivo = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/getCultivo.php",getDatas);
                System.out.println(datosCultivo);
                JsonObject datos = JsonParser.parseString(datosCultivo).getAsJsonObject();
                
                if(datos.has("registros")){
                    JsonArray cultivoArray2 = datos.getAsJsonArray("registros");
                    etqBoton= new JButton[cultivoArray2.size()];
                    for(int j=0; j< cultivoArray2.size();j++){
                        JsonObject temporal2 = cultivoArray2.get(j).getAsJsonObject();
                        
                        System.out.println("Views.SeguimientoTarea.cargarCultivos() datos .has");
                        //BOTON VER
                        etqBoton[j]= new JButton(iconVer);
                        etqBoton[j].setVerticalTextPosition(SwingConstants.BOTTOM);
                        etqBoton[j].setHorizontalTextPosition(SwingConstants.CENTER);
                        etqBoton[j].setContentAreaFilled(false);  // Oculta el fondo del botón
                        etqBoton[j].setBorderPainted(false);     // Oculta el borde del botón
                
                
                        //GUARDO LOS DATOS DEL JSONOBJECT TEMPORAL EN VARIABLES
                        String id_cultivo2 = temporal2.get("id_cultivo").getAsString();
                        String nombre = temporal2.get("nombre").getAsString();
                        String tipo = temporal2.get("tipo").getAsString();
                        
                        System.out.println(nombre);
                    
                        etqBoton[j].addActionListener(new ActionListener() {
                        @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                DashboardA.ShowJPanel(new Tareas_hacer(id_cultivo2));
                            }
                        });
                        
                        modelo.addRow(new Object[]{id_cultivo2, nombre, tipo, etqBoton[j]});
                    }
                }
                //
            }
        }else{
            
        }
    }
    
    
    public void buscar(){
        
        String buscar = this.inputBuscar.getText();
        ConsumoApi traer = new ConsumoApi();
        Map<String, String> getData = new HashMap<>();
        getData.put("id_cultivo", buscar);
        String datoUsuario =traer.consumoGET("http://localhost/APIenPHP-agricultura/agricultor/getPersona.php",getData);
            
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("EMAIL");
        modelo.addColumn("PASS");
        modelo.addColumn("ESTADO");
        modelo.addColumn("EDITAR");
        modelo.addColumn("ELIMINAR");
        tablaTareas.setModel(modelo);
        
        
        
        JsonObject listaAgri = JsonParser.parseString(datoUsuario).getAsJsonObject();
        
//        if(listaAgri.has("registros")){
//            JsonArray listaAgricultores = listaAgri.getAsJsonArray("registros");
//            etqBoton= new JButton[listaAgricultores.size()];
//            etqBotonE= new JButton[listaAgricultores.size()];
//            for(int i=0; i< listaAgricultores.size();i++){
//                 JsonObject temporal = listaAgricultores.get(i).getAsJsonObject();
//                etqBoton[i]= new JButton("Editar");
//                etqBotonE[i]= new JButton("Eliminar");
//                String cedula = temporal.get("cedula").getAsString();
//                String nombre = temporal.get("nombre").getAsString();
//                String apellido = temporal.get("apellido").getAsString();
//                String telefono = temporal.get("telefono").getAsString();
//                String email = temporal.get("email").getAsString();
//                String estado = temporal.get("estado").getAsString();
//                
//                modelo.addRow(new Object[]{cedula, nombre, apellido, telefono, email, "*****", estado, "hola", "pedo"});
//                
//                
//            }
//        }else{
//            System.out.println("Views.Agricultores.mostrar()");
//        }
       
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1033, 564));
        jPanel1.setPreferredSize(new java.awt.Dimension(1033, 564));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VER CULTIVOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 1010, 60));

        inputBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(inputBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 850, 30));

        botonBuscar.setBackground(new java.awt.Color(153, 0, 153));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("BUSCAR");
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 80, 130, 30));

        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_CULTIVO", "NOMBRE", "TIPO", "TAREAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTareas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1010, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField inputBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTareas;
    // End of variables declaration//GEN-END:variables
}
