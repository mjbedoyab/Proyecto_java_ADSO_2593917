/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import apiDB.ConsumoApi;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.login.setBackground(new Color(0, 0, 0, 128));
        setResizable(false);
    }
    
   public void cargarInterfaz(String nombre, String tipo, Boolean confirmar, String cedula){
       
       if(confirmar && tipo.equals("ADMIN")){
           Dashboard inter = new Dashboard(nombre, tipo);
           inter.setVisible(true);
           dispose();
        }else if(confirmar && tipo.equals("AGRICULTOR")){
           DashboardA interA = new DashboardA(nombre, tipo, cedula);
           interA.setVisible(true);
           dispose();
        }
       
       
   }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        login = new Clases.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        inputCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setForeground(new java.awt.Color(60, 63, 65));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(0, 255, 153));
        login.setRoundBottomLeft(50);
        login.setRoundBottomRight(50);
        login.setRoundTopLeft(50);
        login.setRoundTopRight(50);
        login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hombre (1).png"))); // NOI18N
        login.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, -1));

        inputCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCorreoActionPerformed(evt);
            }
        });
        login.add(inputCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 370, 40));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario");
        login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contraseña");
        login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 20));
        login.add(inputPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 370, 40));

        jButton1.setBackground(new java.awt.Color(0, 51, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("                                   Iniciar sesion");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setIconTextGap(13);
        jButton1.setInheritsPopupMenu(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        login.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 370, 40));

        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 430, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agricultura-sostenible.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 720));

        jLabel10.setForeground(new java.awt.Color(73, 80, 87));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Copyright_Container.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 620, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 204, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Card_Content.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 450, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCorreoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        if(this.inputCorreo.getText().isEmpty() || this.inputPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String correo= this.inputCorreo.getText().trim();
            String password = this.inputPassword.getText().trim();
            ConsumoApi verificacion = new ConsumoApi();
        
            Map<String, String> getData = new HashMap<>();
            getData.put("correo", correo);
            
            String datoUsuario = verificacion.consumoGET("http://localhost/APIenPHP-agricultura/admin/getPersona.php",getData);
            
           
        
        
            //TRAY PARA EL ADMIN
            try {
                JsonObject persona = JsonParser.parseString(datoUsuario).getAsJsonObject();
                
               
                
                if(persona.has("contrasenia")){
                    String contrasenia = persona.get("contrasenia").getAsString();
                    String email = persona.get("correo").getAsString();
                    System.out.println(contrasenia);
                    if(contrasenia.equals(password) && email.equals(correo) ){
                        String nombre = persona.get("nombre").getAsString();
                        String tipo = "ADMIN";
                        Boolean confirmacion = true;
                        cargarInterfaz(nombre, tipo, confirmacion,null);
                        
                    } else  {

                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Ups!!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            } catch (Exception e) {
               System.out.println("Error al verificar datos del administrador");
               
            }
            
            Map<String, String> getDatas = new HashMap<>();
            getDatas.put("correo", correo);
            
            String datoUsuario2 = verificacion.consumoGET("http://localhost/APIenPHP-agricultura/agricultor/getAgricDocument.php",getDatas);
            //TRY PARA EL AGRICULTOR
            try {
                JsonObject personaAgri = JsonParser.parseString(datoUsuario2).getAsJsonObject();
               
                
                
                if(personaAgri.has("email")){
                    String contrasenia = personaAgri.get("pass").getAsString();
                    String email = personaAgri.get("email").getAsString();
                    System.out.println(contrasenia);
                    if(contrasenia.equals(password) && email.equals(correo) ){
                        String tipo = "AGRICULTOR";
                        String nombre = personaAgri.get("nombre").getAsString();
                        String cedula = personaAgri.get("cedula").getAsString();
                        Boolean confirmacion = true;
                        cargarInterfaz(nombre, tipo, confirmacion,cedula);
                        
                    } else  {

                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Ups!!!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
               System.out.println("Error al verificar datos del agricultor");
               JOptionPane.showMessageDialog(null, "Ningun ususario con este correo", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
            }
       
            
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        FlatMaterialLighterIJTheme.setup();
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputCorreo;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private Clases.PanelRound login;
    // End of variables declaration//GEN-END:variables
}
