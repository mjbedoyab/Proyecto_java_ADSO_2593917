package Views;


import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.agricultor;
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
import javax.swing.text.TabableView;

public class Asignar extends javax.swing.JPanel {
    public JButton etqBoton[];
    public Asignar() {
      
        initComponents();
        InitStyles();
        mostrarlCultivos();
        init2();
        
    }
    
    
    
    private void InitStyles() {
        folioLbl.putClientProperty("FlatLaf.styleClass", "h1");
        folioLbl.setForeground(Color.WHITE);
        
    }
    
    public void init2(){
        //renderiza los botones de las tablas
        this.TablaAgricultores.getColumn("ASIGNAR").setCellRenderer(new ButtonRenderer());
        this.TablaAgricultores.getColumn("ASIGNAR").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        
    }

    public void mostrarlCultivos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("CULTIVO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("TIPO");
        modelo.addColumn("ASIGNAR");
        
        TablaAgricultores.setModel(modelo);
        ConsumoApi traer = new ConsumoApi();
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();//
        center.setHorizontalAlignment(SwingConstants.CENTER);//le digo que me centre el contenido de mis celdas
        TablaAgricultores.setRowHeight(35);
        
        //traigo los datos de la base de datos
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/Obtener.php");
        JsonObject listaCultivos = JsonParser.parseString(datos).getAsJsonObject();
        
        //le asigno a cada celda el modelo llamado center ppara centrar el contenido
        for (int i = 0; i < TablaAgricultores.getColumnCount(); i++) {
            TablaAgricultores.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        
        ImageIcon icon = new ImageIcon("src/img/selection.png");
        if(listaCultivos.has("registros")){
            JsonArray listaAgricultores = listaCultivos.getAsJsonArray("registros");
            etqBoton= new JButton[listaAgricultores.size()];
            
            for(int i=0; i< listaAgricultores.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
                
                JsonObject temporal = listaAgricultores.get(i).getAsJsonObject();
                etqBoton[i]= new JButton(icon);
                etqBoton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                etqBoton[i].setHorizontalTextPosition(SwingConstants.CENTER);
                etqBoton[i].setContentAreaFilled(false);  // Oculta el fondo del botón
                etqBoton[i].setBorderPainted(false);     // Oculta el borde del botón
                
                //extraigo los datos que estan almacenados el obejto json tempporal
                String id = temporal.get("id_cultivo").getAsString();
                String nombre = temporal.get("nombre").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String tipo = temporal.get("tipo").getAsString();
                
                //agrego a cada boton el evento que cargara la siguien vista
                etqBoton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        Dashboard.ShowJPanel(new TareaAgric(id, nombre));
                    }
                });
                //agrego a la tabla el modelo con los datos
                modelo.addRow(new Object[]{id, nombre, descripcion, tipo,etqBoton[i]});
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        folioLbl = new javax.swing.JLabel();
        bookSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAgricultores = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1033, 564));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setMinimumSize(new java.awt.Dimension(1033, 564));
        bg.setPreferredSize(new java.awt.Dimension(1033, 564));

        folioLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        folioLbl.setText("Asignar Agricultor");

        bookSearch.setBackground(new java.awt.Color(51, 51, 51));
        bookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSearchActionPerformed(evt);
            }
        });

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

        TablaAgricultores.setBackground(new java.awt.Color(0, 51, 51));
        TablaAgricultores.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        TablaAgricultores.setForeground(new java.awt.Color(255, 255, 255));
        TablaAgricultores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CULTIVO", "DESCRIPCION", "TIPO", "ASIGNAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaAgricultores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TablaAgricultores.getTableHeader().setReorderingAllowed(false);
        TablaAgricultores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaAgricultoresMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAgricultores);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(folioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                            .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(9, 9, 9))
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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed

    private void TablaAgricultoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAgricultoresMousePressed

    }//GEN-LAST:event_TablaAgricultoresMousePressed

    private void bookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAgricultores;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
