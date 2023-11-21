package Views;


import Clases.cultivos;
import Principal.Dashboard;
import apiDB.ConsumoApi;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class UpCultivos extends javax.swing.JPanel {

    boolean isEdition = false;
    public cultivos cultivo;
    private String titulo;
    
    
    public UpCultivos(String titulo, cultivos cultivo) {
        this.titulo= titulo;
        this.cultivo=cultivo;
        initComponents();
        InitStyles();
        mostrar_en_inputs();
    }

   

    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.WHITE);
        nomCultivo.putClientProperty("JTextField.placeholderText", "Ingrese el título del libro");

    }
     public void mostrar_en_inputs(){
        if(this.titulo.equals("asignar")){
            this.title.setText("Insertar Cultivo");
            this.id_cultivo.setVisible(false);
        }else{
             this.title.setText("Editar Cultivo");
             this.button.setText("Guardar");
             String id_cultivo = this.cultivo.getId_cultivo();
             String nombre = this.cultivo.getNombre();
             String descripcion = this.cultivo.getDescripcion();
             String tipo = this.cultivo.getTipo();
             
             this.id_cultivo.setText(id_cultivo);
             this.nomCultivo.setText(nombre);
             this.tipoCultivo.setSelectedItem(tipo);
             this.descCultivo.setText(descripcion);
             
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        nomCultivo = new javax.swing.JTextField();
        authorLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        langLbl = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descCultivo = new javax.swing.JTextArea();
        tipoCultivo = new javax.swing.JComboBox<>();
        id_cultivo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1033, 654));
        setPreferredSize(new java.awt.Dimension(1033, 654));

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setMinimumSize(new java.awt.Dimension(1033, 564));
        bg.setPreferredSize(new java.awt.Dimension(1033, 564));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("         Subir nuevo Cultivo");

        titleLbl.setBackground(new java.awt.Color(255, 255, 255));
        titleLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titleLbl.setText("          Nombre");

        authorLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        authorLbl.setText("             TIPO");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        langLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        langLbl.setText("Descripcion");

        button.setBackground(new java.awt.Color(0, 51, 0));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enviar (2).png"))); // NOI18N
        button.setText("Enviar");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        descCultivo.setColumns(20);
        descCultivo.setRows(5);
        jScrollPane1.setViewportView(descCultivo);

        tipoCultivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VERDURAS", "FRUTAS", "GRANOS" }));
        tipoCultivo.setSelectedItem(" ");
        tipoCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCultivoActionPerformed(evt);
            }
        });

        id_cultivo.setEnabled(false);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(authorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(301, 301, 301))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addGap(302, 302, 302))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(tipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nomCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(langLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addGap(300, 300, 300))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(id_cultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(id_cultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(langLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(button)
                        .addGap(75, 75, 75))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(authorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
           
            ConsumoApi insertar = new ConsumoApi();
            if(titulo.equals("editar")){
                 String nombreEdit = this.nomCultivo.getText();
                String tipoEdit = String.valueOf(this.tipoCultivo.getSelectedItem()) ;
                String descricionEdit = this.descCultivo.getText();
                String id_cultivo= this.id_cultivo.getText();
                
                 Map<String, String> updateData = new HashMap<>();
                updateData.put("id_cultivo", id_cultivo);
                updateData.put("nombre", nombreEdit);
                updateData.put("tipo", tipoEdit);
                updateData.put("descripcion", descricionEdit);
                String respuesta = insertar.consumoPOST("http://localhost/APIenPHP-agricultura/cultivos/Update.php", updateData);
                Dashboard.ShowJPanel(new Cultivo());
        
            }else{
                String nombre = this.nomCultivo.getText();
                String tipo = String.valueOf(this.tipoCultivo.getSelectedItem()) ;
                String descricion = this.descCultivo.getText();
                
                
                   Map<String, String> insertData = new HashMap<>();
                   insertData.put("nombre", nombre);
                   insertData.put("descripcion", descricion);
                   insertData.put("tipo", tipo);

                 String response = insertar.consumoPOST("http://localhost/APIenPHP-agricultura/cultivos/Insertar.php", insertData);
                  JOptionPane.showMessageDialog(null, "Insertado Correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }
           
            
      
    }//GEN-LAST:event_buttonActionPerformed

    private void tipoCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCultivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoCultivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JTextArea descCultivo;
    private javax.swing.JTextField id_cultivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel langLbl;
    private javax.swing.JTextField nomCultivo;
    private javax.swing.JComboBox<String> tipoCultivo;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}