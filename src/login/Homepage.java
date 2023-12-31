package login;

/**
 *
 * @author lisas freunde ausählen können aus freundeliste was passiert wenn man
 * auf freunde klickt? Software sagen wer meine Freunde sind -> 1. add Freunde
 * macht dialog auf, mit liste aller user (bis auf alle, die bereits meine
 * freunde sind & man selbst) 2. alle Freunde die man bereits geaddet hat danach
 * erst um feed kümmern im panelFreind wird suchfeld benötigt (Textfeld)
 * provisorisch einen weiteren button "button", sobald man tippt & er sucht zu
 * schwierig klicken auf suchen => dann erst, funktioniert mit präfix FR ->
 * Franziska (soll merken neuer Buchstaben & direkt suchen noch zu schwierig)
 */
public class Homepage extends javax.swing.JFrame {

    public Homepage() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(169, 199, 199));

    }

    public void setLoggedInUsername(String username) {
        jLabelUsername.setText(username);
        
        displayFeed();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBelowToolBar = new javax.swing.JPanel();
        jPanelFeed = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelHeadline = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonProfile = new javax.swing.JButton();
        jButtonFeed = new javax.swing.JButton();
        jButtonClubs = new javax.swing.JButton();
        jButtonFriends = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(169, 199, 199));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBelowToolBar.setOpaque(false);
        jPanelBelowToolBar.setPreferredSize(new java.awt.Dimension(750, 500));
        getContentPane().add(jPanelBelowToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 750, 570));

        jPanelFeed.setBackground(new java.awt.Color(37, 81, 81));
        jPanelFeed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setFont(new java.awt.Font("Krungthep", 0, 26)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsername.setText("Name");
        jPanelFeed.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 113, 30));

        jLabelHeadline.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        jLabelHeadline.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeadline.setText("PLATON");
        jPanelFeed.add(jLabelHeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jButtonLogout.setBackground(new java.awt.Color(0, 51, 51));
        jButtonLogout.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonLogout.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogout.setText("Abmelden");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });
        jPanelFeed.add(jButtonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/Banner.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(674, 116));
        jPanelFeed.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        jButtonProfile.setBackground(new java.awt.Color(148, 186, 186));
        jButtonProfile.setFont(new java.awt.Font("Krungthep", 0, 14)); // NOI18N
        jButtonProfile.setText("Profil");
        jButtonProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProfileMouseClicked(evt);
            }
        });
        jButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileActionPerformed(evt);
            }
        });
        jPanelFeed.add(jButtonProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, -1));

        jButtonFeed.setBackground(new java.awt.Color(171, 203, 203));
        jButtonFeed.setFont(new java.awt.Font("Krungthep", 0, 14)); // NOI18N
        jButtonFeed.setText("Feed");
        jButtonFeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFeedMouseClicked(evt);
            }
        });
        jButtonFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFeedActionPerformed(evt);
            }
        });
        jPanelFeed.add(jButtonFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 140, -1));

        jButtonClubs.setBackground(new java.awt.Color(156, 193, 193));
        jButtonClubs.setFont(new java.awt.Font("Krungthep", 0, 14)); // NOI18N
        jButtonClubs.setText("Gruppen");
        jButtonClubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClubsActionPerformed(evt);
            }
        });
        jPanelFeed.add(jButtonClubs, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 140, -1));

        jButtonFriends.setBackground(new java.awt.Color(165, 200, 200));
        jButtonFriends.setFont(new java.awt.Font("Krungthep", 0, 14)); // NOI18N
        jButtonFriends.setText("Freunde");
        jButtonFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFriendsMouseClicked(evt);
            }
        });
        jButtonFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFriendsActionPerformed(evt);
            }
        });
        jPanelFeed.add(jButtonFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 140, -1));

        getContentPane().add(jPanelFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFeedActionPerformed

    }//GEN-LAST:event_jButtonFeedActionPerformed

    private void jButtonClubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClubsActionPerformed
        jPanelBelowToolBar.removeAll();
        jPanelBelowToolBar.add(new PanelClubs(this));
        jPanelBelowToolBar.repaint();
        pack();
    }//GEN-LAST:event_jButtonClubsActionPerformed

    private void jButtonFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFriendsActionPerformed
        jPanelBelowToolBar.removeAll();
        jPanelBelowToolBar.add(new PanelFriends(this));
        jPanelBelowToolBar.repaint();
        pack();
    }//GEN-LAST:event_jButtonFriendsActionPerformed

    private void jButtonFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFriendsMouseClicked
        new PanelFriends(this).setVisible(true);
    }//GEN-LAST:event_jButtonFriendsMouseClicked

    private void jButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileActionPerformed
        jPanelBelowToolBar.removeAll();
        jPanelBelowToolBar.add(new PanelProfile(this));
        jPanelBelowToolBar.repaint();
        pack();
    }//GEN-LAST:event_jButtonProfileActionPerformed

    private void jButtonProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProfileMouseClicked
        new PanelProfile(this).setVisible(true);
    }//GEN-LAST:event_jButtonProfileMouseClicked

    private void jButtonFeedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFeedMouseClicked
        jPanelBelowToolBar.removeAll();
        jPanelBelowToolBar.add(new PanelFeed(this));
        jPanelBelowToolBar.repaint();
        pack();
    }//GEN-LAST:event_jButtonFeedMouseClicked

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        Usercontroller.getInstance().logout();
        Loginform loginForm = new Loginform(this);
        loginForm.setVisible(true); //Login sichtbar machen
        if (Usercontroller.getInstance().getLoggedInUser() != null) {
                    setLoggedInUsername(Usercontroller.getInstance().getLoggedInUser().getUsername());
        } else {
            System.exit(0); //in else case kommt nur, wenn Login abgebrochen wird
        }
        //this.dispose(); //schließen der Homepage
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Homepage homepage = new Homepage();
                new Loginform(homepage).setVisible(true);
                if (Usercontroller.getInstance().getLoggedInUser() != null) {
                    homepage.setLoggedInUsername(Usercontroller.getInstance().getLoggedInUser().getUsername());
                    homepage.setVisible(true);
                } else {
                    System.exit(0);
                }
            }
        });
    }

    public void displayFeed() {
        if (Usercontroller.getInstance().getLoggedInUser() != null) {
            jPanelBelowToolBar.removeAll();
            jPanelBelowToolBar.add(new PanelFeed(this));
            jPanelBelowToolBar.repaint();
            pack();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClubs;
    private javax.swing.JButton jButtonFeed;
    private javax.swing.JButton jButtonFriends;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHeadline;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelBelowToolBar;
    private javax.swing.JPanel jPanelFeed;
    // End of variables declaration//GEN-END:variables
}
