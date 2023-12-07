package login;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Loginform extends javax.swing.JDialog {

    public Loginform(JFrame parent) {
        super(parent, true);
        initComponents();
        resetPassword();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jLabelHeadline = new javax.swing.JLabel();
        jLabelUsernameFont = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JTextField();
        jLabelPasswordFont = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JPasswordField();
        jLabelQuote = new javax.swing.JLabel();
        jLabelPlaton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBackground.setBackground(new java.awt.Color(169, 199, 199));

        jLabelHeadline.setFont(new java.awt.Font("Papyrus", 0, 48)); // NOI18N
        jLabelHeadline.setText("Login");

        jLabelUsernameFont.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabelUsernameFont.setText("Benutzername:");

        jLabelUsername.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabelPasswordFont.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabelPasswordFont.setText("Passwort:");

        jButtonLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonLogin.setText("Einloggen");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabelRegister.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRegister.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelRegister.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRegister.setText("Registrieren");
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });

        jLabelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/IMG_platon.jpg"))); // NOI18N
        jLabelPhoto.setText("jLabel5");

        jLabelPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabelPassword.setText("jPasswordField1");

        jLabelQuote.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelQuote.setText("\"Freunde sind Geschwister, die man sich selbst aussucht.\"");

        jLabelPlaton.setFont(new java.awt.Font("Papyrus", 0, 36)); // NOI18N
        jLabelPlaton.setText("-Platon");

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelPasswordFont)
                                            .addComponent(jLabelUsernameFont))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                            .addComponent(jLabelUsername)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBackgroundLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabelQuote)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelPlaton)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabelHeadline)
                                .addGap(192, 192, 192))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabelRegister)
                                .addGap(197, 197, 197)))))
                .addComponent(jLabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabelHeadline)
                .addGap(30, 30, 30)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsernameFont, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPasswordFont, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRegister)
                .addGap(87, 87, 87)
                .addComponent(jLabelQuote)
                .addGap(18, 18, 18)
                .addComponent(jLabelPlaton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addComponent(jLabelPhoto)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        String username = jLabelUsername.getText();
        char[] passwordChars = jLabelPassword.getPassword();
        String password = new String(passwordChars);

        if (Usercontroller.getInstance().login(username, password)) {
            this.setVisible(false); //öffnen des neuen Fensters
         } else {
            JOptionPane.showMessageDialog(rootPane, "Logindaten sind falsch");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void resetPassword() {
        jLabelPassword.setText(""); //sonst Field voll mit *
        jLabelPassword.setEchoChar('\u2022'); //setzt Echo auf runden Punkt
    }
    
    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegisterMouseClicked
        new Register(this).setVisible(true);
    }//GEN-LAST:event_jLabelRegisterMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelHeadline;
    private javax.swing.JPasswordField jLabelPassword;
    private javax.swing.JLabel jLabelPasswordFont;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JLabel jLabelPlaton;
    private javax.swing.JLabel jLabelQuote;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JTextField jLabelUsername;
    private javax.swing.JLabel jLabelUsernameFont;
    private javax.swing.JPanel jPanelBackground;
    // End of variables declaration//GEN-END:variables
}
