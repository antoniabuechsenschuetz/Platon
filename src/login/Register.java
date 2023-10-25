/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Register extends javax.swing.JDialog {

    public Register(JDialog parent) {
        super(parent, true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelHeadline = new javax.swing.JLabel();
        jLabelUsernameFont = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JTextField();
        jLabelPasswordFont = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JTextField();
        jButtonRegister = new javax.swing.JButton();
        jLabelNameFont = new javax.swing.JLabel();
        jLabelName = new javax.swing.JTextField();
        jLabelEmailFont = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PlatonBild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(91, 124, 124));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHeadline.setFont(new java.awt.Font("Papyrus", 0, 36)); // NOI18N
        jLabelHeadline.setText("Registrieren");
        jPanel1.add(jLabelHeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        jLabelUsernameFont.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelUsernameFont.setText("Benutzer Name:");
        jPanel1.add(jLabelUsernameFont, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, 24));
        jPanel1.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 262, 43));

        jLabelPasswordFont.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPasswordFont.setText("Passwort:");
        jPanel1.add(jLabelPasswordFont, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, 24));
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 262, 43));

        jButtonRegister.setText("Registrieren");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 143, 45));

        jLabelNameFont.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelNameFont.setText("Name:");
        jPanel1.add(jLabelNameFont, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, 24));
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 262, 43));

        jLabelEmailFont.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmailFont.setText("Email:");
        jPanel1.add(jLabelEmailFont, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, 24));
        jPanel1.add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 262, 43));

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

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed

    String name = jLabelName.getText();
    String username = jLabelUsername.getText();
    String email = jLabelEmail.getText();
    String password = jLabelPassword.getText();
    
    if (name.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bitte füllen Sie alle Felder aus.");
        } else {
        DB db = new DB();
            boolean success = db.configurateUser(name, username, email, password);
            if (success) { //erfolgreiche Registrierung
                JOptionPane.showMessageDialog(rootPane, "Dein Account wurde erstellt.");
                jLabelName.setText("");
                jLabelUsername.setText("");
                jLabelEmail.setText("");
                jLabelPassword.setText("");
                this.setVisible(false);
            } else {
                // Fehler beim Erstellen des Kontos
                JOptionPane.showMessageDialog(rootPane, "Fehler beim Erstellen des Accounts");
            }
        }
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // Login von der Registrieren Seite
        
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PlatonBild;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jLabelEmail;
    private javax.swing.JLabel jLabelEmailFont;
    private javax.swing.JLabel jLabelHeadline;
    private javax.swing.JTextField jLabelName;
    private javax.swing.JLabel jLabelNameFont;
    private javax.swing.JTextField jLabelPassword;
    private javax.swing.JLabel jLabelPasswordFont;
    private javax.swing.JTextField jLabelUsername;
    private javax.swing.JLabel jLabelUsernameFont;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
