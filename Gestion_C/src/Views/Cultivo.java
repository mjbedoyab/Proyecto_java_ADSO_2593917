package Views;


import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.cultivos;
import Principal.Dashboard;
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

public class Cultivo extends javax.swing.JPanel {
    private JButton etqBoton[];
    private JButton etqBotonE[];
    int variable ;
    public Cultivo() {
        initComponents();
        InitStyles();
        mostrar();
        init2();
    }
    
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.WHITE);
        bookSearch.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del cultivo a buscar.");
    }
    
    public void init2(){
        this.jTable1.getColumn("EDITAR").setCellRenderer(new ButtonRenderer());
        this.jTable1.getColumn("EDITAR").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        this.jTable1.getColumn("ELIMINAR").setCellRenderer(new ButtonRenderer());
        this.jTable1.getColumn("ELIMINAR").setCellEditor(new ButtonEditor(new JCheckBox()));
    }
   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        bookSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1033, 564));

        bg.setBackground(new java.awt.Color(51, 51, 51));

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setText("Cultivos");

        bookSearch.setBackground(new java.awt.Color(51, 51, 51));
        bookSearch.setForeground(new java.awt.Color(204, 204, 204));

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

        addButton.setBackground(new java.awt.Color(0, 51, 0));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Nuevo");
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 51, 51));
        jTable1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "TIPO", "EDITAR", "BORRAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(bookSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addGap(31, 31, 31))
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

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
    }//GEN-LAST:event_jTable1MousePressed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         cultivos cultivo = new cultivos(null, null, null, null);
        Dashboard.ShowJPanel(new UpCultivos("asignar", cultivo));
       
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
    }//GEN-LAST:event_searchButtonActionPerformed
    
    public void mostrar(){
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("TIPO");
        modelo.addColumn("EDITAR");
        modelo.addColumn("ELIMINAR");
        jTable1.setModel(modelo);
        ConsumoApi traer = new ConsumoApi();
        
        
        ImageIcon icon = new ImageIcon("src/img/eliminar.png");
        ImageIcon icon2 = new ImageIcon("src/img/editar.png");
        
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setRowHeight(35);
        String datos = traer.consumoGET("http://localhost/APIenPHP-agricultura/cultivos/Obtener.php");
        JsonObject listaCulti = JsonParser.parseString(datos).getAsJsonObject();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        if(listaCulti.has("registros")){
            JsonArray listaCultivos = listaCulti.getAsJsonArray("registros");
            etqBoton= new JButton[listaCultivos.size()];
            etqBotonE= new JButton[listaCultivos.size()];
            for(int i=0; i< listaCultivos.size();i++){
                //int i = Integer.parseInt(String.valueOf(registroElement));
                
                JsonObject temporal = listaCultivos.get(i).getAsJsonObject();
                etqBoton[i]= new JButton("",icon2);
                etqBoton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                etqBoton[i].setHorizontalTextPosition(SwingConstants.CENTER);
                etqBoton[i].setContentAreaFilled(false);  // Oculta el fondo del botón
                etqBoton[i].setBorderPainted(false);     // Oculta el borde del botón
                
                etqBotonE[i]= new JButton("",icon);
                etqBotonE[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                etqBotonE[i].setHorizontalTextPosition(SwingConstants.CENTER);
                etqBotonE[i].setContentAreaFilled(false);  // Oculta el fondo del botón
                etqBotonE[i].setBorderPainted(false);     // Oculta el borde del botón
                
                variable=i;
                String id_cultivo = temporal.get("id_cultivo").getAsString();
                String nombre = temporal.get("nombre").getAsString();
                String descripcion = temporal.get("descripcion").getAsString();
                String tipo = temporal.get("tipo").getAsString();
                
                
                   etqBoton[i].addActionListener(new ActionListener() {
                    @Override
                        public void actionPerformed(ActionEvent e) {
                            cultivos editCulti = new cultivos(id_cultivo, nombre, descripcion, tipo);
                            Dashboard.ShowJPanel(new UpCultivos("editar", editCulti));
                        }
                    });
            

            
                
                modelo.addRow(new Object[]{id_cultivo, nombre, descripcion, tipo, etqBoton[i], etqBotonE[i]});
                 
                }
                  
        }else{
            System.out.println("Views.Agricultores.mostrar()");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bg;
    private javax.swing.JTextField bookSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}