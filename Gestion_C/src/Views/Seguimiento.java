package Views;


import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.cultivos;
import Principal.Dashboard;
import apiDB.ConsumoApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Seguimiento extends javax.swing.JPanel {
    private JButton etqBoton[];
    public Seguimiento() {
        initComponents();
        InitStyles();
        init2();
        cargarCultivos();
        tareasFinalizadas();
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.WHITE);
    }
    
    public void init2(){
        this.jTable1.getColumn("TAREAS").setCellRenderer(new ButtonRenderer());
        this.jTable1.getColumn("TAREAS").setCellEditor(new ButtonEditor(new JCheckBox()));
        
    }
    
    public void tareasFinalizadas(){
        ConsumoApi traer = new ConsumoApi();
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/tareas/Obtener.php");
        int contador = 0;
        int totalTareas=0;
        JsonObject tareas = JsonParser.parseString(datos).getAsJsonObject();

         if(tareas.has("registros")){
            JsonArray listaTareas = tareas.getAsJsonArray("registros");
            for (int i = 0; i < listaTareas.size(); i++) {
                 JsonObject temporal = listaTareas.get(i).getAsJsonObject();
                 String estado = temporal.get("estado").getAsString();
                 if(estado.equals("Finalizado")){
                    contador++;
                }
                 totalTareas=i;
            }

        }
         jLabel1.setText("SE HA REALIZADO UN TOTAL DE "+ contador+" TAREAS DE "+totalTareas);

    }
    
    public void cargarCultivos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("TIPO");
        modelo.addColumn("TAREAS");
        jTable1.setModel(modelo);
        ConsumoApi traer = new ConsumoApi();
        
        ImageIcon icon_editar = new ImageIcon(getClass().getResource("/img/binoculars.png"));
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setRowHeight(35);
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/Obtener.php");
        JsonObject listaCulti = JsonParser.parseString(datos).getAsJsonObject();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        init2();
        
        if(listaCulti.has("registros")){
            JsonArray listaCultivos = listaCulti.getAsJsonArray("registros");
            etqBoton= new JButton[listaCultivos.size()];
           
            for(int i=0; i< listaCultivos.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
                
                JsonObject temporal = listaCultivos.get(i).getAsJsonObject();
                etqBoton[i]= new JButton(icon_editar);
                etqBoton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                etqBoton[i].setHorizontalTextPosition(SwingConstants.CENTER);
                etqBoton[i].setContentAreaFilled(false);  // Oculta el fondo del botón
                etqBoton[i].setBorderPainted(false);     // Oculta el borde del botón
                
               
               
                
                String id_cultivo = temporal.get("id_cultivo").getAsString();
                String nombre = temporal.get("nombre").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String tipo = temporal.get("tipo").getAsString();
                
                
                   etqBoton[i].addActionListener(new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent e) {
                            cultivos editCulti = new cultivos(id_cultivo, nombre, descripcion, tipo);
                            Dashboard.ShowJPanel(new SeguimientoTarea(id_cultivo));
                        }
                    });
            
                
                modelo.addRow(new Object[]{nombre, descripcion, tipo, etqBoton[i]});
                 
                }
                  
        }else{
            System.out.println("Views.Agricultores.mostrar()");
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bookSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setMinimumSize(new java.awt.Dimension(1033, 564));
        bg.setPreferredSize(new java.awt.Dimension(1033, 564));

        title.setText("Reportes");

        actualizar.setBackground(new java.awt.Color(0, 102, 0));
        actualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        actualizar.setForeground(new java.awt.Color(255, 255, 255));
        actualizar.setText("Actualizar");
        actualizar.setBorderPainted(false);
        actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 51, 51));
        jTable1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "DESCRIPCION", "TIPO", "TAREAS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        searchButton.setBackground(new java.awt.Color(0, 51, 0));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SE HA REALIZADO UN TOTAL DE 10 TAREAS DE 20");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(581, 581, 581)
                                .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                .addGap(646, 646, 646))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(bookSearch)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar)
                .addGap(25, 25, 25))
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

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        //nothing
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
       
    }//GEN-LAST:event_actualizarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}