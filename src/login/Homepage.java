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

        jLabelHeadline = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelLeftHeadliner = new javax.swing.JLabel();
        jPanelAll = new javax.swing.JPanel();
        jLabelRightHeadliner = new javax.swing.JLabel();
        jPanelFeed = new javax.swing.JPanel();
        jButtonProfile = new javax.swing.JButton();
        jButtonFeed = new javax.swing.JButton();
        jButtonClubs = new javax.swing.JButton();
        jButtonFriends = new javax.swing.JButton();
        jPanelBelowToolBar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHeadline.setFont(new java.awt.Font("Papyrus", 0, 48)); // NOI18N
        jLabelHeadline.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeadline.setText("PLATON");
        getContentPane().add(jLabelHeadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabelUsername.setBackground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setFont(new java.awt.Font("Krungthep", 0, 24)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Name");
        getContentPane().add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 113, 30));

        jLabelLeftHeadliner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/startseiteLeiste.JPEG"))); // NOI18N
        jLabelLeftHeadliner.setText("jLabel2");
        getContentPane().add(jLabelLeftHeadliner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 338, -1));

        jPanelAll.setBackground(new java.awt.Color(169, 199, 199));

        jLabelRightHeadliner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/startseiteLeiste.JPEG"))); // NOI18N
        jLabelRightHeadliner.setText("jLabel3");

        jPanelFeed.setBackground(new java.awt.Color(37, 81, 81));

        jButtonProfile.setBackground(new java.awt.Color(148, 186, 186));
        jButtonProfile.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
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

        jButtonFeed.setBackground(new java.awt.Color(171, 203, 203));
        jButtonFeed.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
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

        jButtonClubs.setBackground(new java.awt.Color(156, 193, 193));
        jButtonClubs.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
        jButtonClubs.setText("Gruppen");
        jButtonClubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClubsActionPerformed(evt);
            }
        });

        jButtonFriends.setBackground(new java.awt.Color(165, 200, 200));
        jButtonFriends.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout jPanelFeedLayout = new javax.swing.GroupLayout(jPanelFeed);
        jPanelFeed.setLayout(jPanelFeedLayout);
        jPanelFeedLayout.setHorizontalGroup(
            jPanelFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFeedLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jButtonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonClubs, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanelFeedLayout.setVerticalGroup(
            jPanelFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFeedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFeedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFriends)
                    .addComponent(jButtonClubs)
                    .addComponent(jButtonFeed)
                    .addComponent(jButtonProfile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBelowToolBar.setOpaque(false);

        javax.swing.GroupLayout jPanelAllLayout = new javax.swing.GroupLayout(jPanelAll);
        jPanelAll.setLayout(jPanelAllLayout);
        jPanelAllLayout.setHorizontalGroup(
            jPanelAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAllLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanelBelowToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelAllLayout.createSequentialGroup()
                .addGroup(jPanelAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAllLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRightHeadliner, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelFeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAllLayout.setVerticalGroup(
            jPanelAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAllLayout.createSequentialGroup()
                .addComponent(jLabelRightHeadliner)
                .addGap(3, 3, 3)
                .addComponent(jPanelFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBelowToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 710));

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
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JLabel jLabelHeadline;
    private javax.swing.JLabel jLabelLeftHeadliner;
    private javax.swing.JLabel jLabelRightHeadliner;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelAll;
    private javax.swing.JPanel jPanelBelowToolBar;
    private javax.swing.JPanel jPanelFeed;
    // End of variables declaration//GEN-END:variables
}
