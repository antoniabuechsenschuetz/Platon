/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.beans.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JDialog;
import login.DB;

public class Register extends javax.swing.JDialog {

    Connection c = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Register(JDialog parent) {
        super(parent, true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rusername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rpass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        remail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PlatonBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(91, 124, 124));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Papyrus", 0, 36)); // NOI18N
        jLabel2.setText("Registrieren");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Benutzer Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, 24));
        jPanel1.add(rusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 262, 43));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Passwort:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, 24));
        jPanel1.add(rpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 262, 43));

        jButton1.setText("Registrieren");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 143, 45));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 24));
        jPanel1.add(rname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 262, 43));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Email:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, 24));
        jPanel1.add(remail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 262, 43));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jLabel1.setText("Ich habe bereits einen Account");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, 26));

        PlatonBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/Platon2.jpg"))); // NOI18N
        PlatonBild.setText("jLabel7");
        jPanel1.add(PlatonBild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, 620, 1410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    String name = rname.getText();
    String username = rusername.getText();
    String email = remail.getText();
    String password = rpass.getText();
    
    if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus.");
        } else {
        DB db = new DB();
            // Registrieren aufrufen
            //Usercontroller userController = Usercontroller.getInstance();
            //boolean success = userController.register(name, username, email, password);
            boolean success = db.configurateUser(name, username, email, password);
            if (success) { //erfolgreiche Registrierung
                JOptionPane.showMessageDialog(rootPane, "Dein Account wurde erstellt.");
                rname.setText("");
                rusername.setText("");
                remail.setText("");
                rpass.setText("");
              
                this.setVisible(false);
            } else {
                // Fehler beim Erstellen des Kontos
                JOptionPane.showMessageDialog(rootPane, "Fehler beim Erstellen des Accounts");
            }
        }
    
    
      rname.setText("");
      rusername.setText("");
      remail.setText("");
      rpass.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // Login von der Registrieren Seite
        
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlatonBild;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField remail;
    private javax.swing.JTextField rname;
    private javax.swing.JTextField rpass;
    private javax.swing.JTextField rusername;
    // End of variables declaration//GEN-END:variables
}
