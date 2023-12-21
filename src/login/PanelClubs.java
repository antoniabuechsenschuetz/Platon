package login;

import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class PanelClubs extends javax.swing.JPanel {

    private DefaultListModel<Club> listModel;
    public List<Club> result;
    public String tmpClubname;

    public PanelClubs(Homepage aThis) {
        initComponents();
        //jButtonLeaveClub.setEnabled(false);

        listModel = new DefaultListModel<>();
        jListJoinedClubs.setModel(listModel);
        displayClubs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCreateClub = new javax.swing.JButton();
        jButtonJoinNewClub = new javax.swing.JButton();
        jButtonLeaveClub = new javax.swing.JButton();
        jTextFieldSearchBar = new java.awt.TextField();
        jListSearchClubs = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJoinedClubs = new javax.swing.JList<>();
        jButtonDeleteClub = new javax.swing.JButton();
        jButtonShowClubDetails = new javax.swing.JButton();

        setBackground(new java.awt.Color(5, 81, 81));
        setPreferredSize(new java.awt.Dimension(750, 500));

        jButtonCreateClub.setBackground(new java.awt.Color(0, 51, 51));
        jButtonCreateClub.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonCreateClub.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCreateClub.setText("Gruppe erstellen");
        jButtonCreateClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateClubActionPerformed(evt);
            }
        });

        jButtonJoinNewClub.setBackground(new java.awt.Color(0, 51, 51));
        jButtonJoinNewClub.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonJoinNewClub.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJoinNewClub.setText("Gruppe beitreten");
        jButtonJoinNewClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJoinNewClubActionPerformed(evt);
            }
        });

        jButtonLeaveClub.setBackground(new java.awt.Color(0, 51, 51));
        jButtonLeaveClub.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonLeaveClub.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLeaveClub.setText("aus Gruppe austreten");
        jButtonLeaveClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveClubActionPerformed(evt);
            }
        });

        jTextFieldSearchBar.setBackground(new java.awt.Color(169, 199, 199));
        jTextFieldSearchBar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jTextFieldSearchBar.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldSearchBar.setText("Suche...");
        jTextFieldSearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchBarMouseClicked(evt);
            }
        });
        jTextFieldSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchBarActionPerformed(evt);
            }
        });

        jListSearchClubs.setBackground(new java.awt.Color(169, 199, 199));
        jListSearchClubs.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jListSearchClubs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSearchClubsMouseClicked(evt);
            }
        });
        jListSearchClubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListSearchClubsActionPerformed(evt);
            }
        });

        jListJoinedClubs.setBackground(new java.awt.Color(169, 199, 199));
        jListJoinedClubs.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListJoinedClubs);

        jButtonDeleteClub.setBackground(new java.awt.Color(0, 51, 51));
        jButtonDeleteClub.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonDeleteClub.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeleteClub.setText("Gruppe löschen");
        jButtonDeleteClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteClubActionPerformed(evt);
            }
        });

        jButtonShowClubDetails.setBackground(new java.awt.Color(0, 51, 51));
        jButtonShowClubDetails.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonShowClubDetails.setForeground(new java.awt.Color(255, 255, 255));
        jButtonShowClubDetails.setText("Gruppendetails anzeigen");
        jButtonShowClubDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonShowClubDetailsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jListSearchClubs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCreateClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLeaveClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDeleteClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonJoinNewClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonShowClubDetails))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreateClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonJoinNewClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLeaveClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteClub)
                        .addGap(16, 16, 16)
                        .addComponent(jButtonShowClubDetails)))
                .addGap(21, 21, 21)
                .addComponent(jListSearchClubs, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJoinNewClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJoinNewClubActionPerformed
        System.out.println(tmpClubname);
        Usercontroller.getInstance().addClub(tmpClubname);
        displayClubs();
        System.out.println("Club hinzugefügt.");
    }//GEN-LAST:event_jButtonJoinNewClubActionPerformed

    private void jButtonCreateClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateClubActionPerformed
        CreateClubDialog createClubDialog = new CreateClubDialog();
        createClubDialog.setVisible(true);
    }//GEN-LAST:event_jButtonCreateClubActionPerformed

    private void jButtonLeaveClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveClubActionPerformed
        Club selectedClub = jListJoinedClubs.getSelectedValue();
        int response = JOptionPane.showConfirmDialog(this, "Möchten Sie die ausgewählte Gruppe wirklich verlassen?",
                "Gruppe verlassen", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            boolean res = Usercontroller.getInstance().exitClub(selectedClub);

            if (res == true) {
                displayClubs();
                JOptionPane.showMessageDialog(this, "Gruppe erfolgreich verlassen.");
            } else {
                JOptionPane.showMessageDialog(this, "Fehler beim Verlassen der Gruppe.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayClubs();

    }//GEN-LAST:event_jButtonLeaveClubActionPerformed

    private void jTextFieldSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarMouseClicked
        jTextFieldSearchBar.setText("");
    }//GEN-LAST:event_jTextFieldSearchBarMouseClicked

    private void jTextFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarActionPerformed

        String searchText = jTextFieldSearchBar.getText();
        List<Club> searchResult = Usercontroller.getInstance().searchClub(searchText);
        result = searchResult;
        jListSearchClubs.removeAll();
        for (Club e : searchResult) {
            jListSearchClubs.add(e.getName());
        }
    }//GEN-LAST:event_jTextFieldSearchBarActionPerformed

    private void jListSearchClubsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSearchClubsMouseClicked
        List<Club> tmp = this.result;
        int x = jListSearchClubs.getSelectedIndex();
        if (x >= 0) {
            //jButtonAddFriend.setEnabled(true);
            tmpClubname = tmp.get(x).getName();
        }

    }//GEN-LAST:event_jListSearchClubsMouseClicked

    private void jListSearchClubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListSearchClubsActionPerformed

    }//GEN-LAST:event_jListSearchClubsActionPerformed

    private void jButtonDeleteClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteClubActionPerformed

        Club selectedClub = jListJoinedClubs.getSelectedValue();
        int response = JOptionPane.showConfirmDialog(this, "Möchten Sie die ausgewählte Gruppe wirklich löschen?",
                "Gruppe löschen", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            int res = Usercontroller.getInstance().deleteClub(selectedClub);

            if (res == 0) {
                displayClubs();
                JOptionPane.showMessageDialog(this, "Gruppe erfolgreich gelöscht.");
            } else if (res == 1) {
                JOptionPane.showMessageDialog(this, "User ist nicht Senator dieser Gruppe. Kann nicht gelöscht werden.");
            } else {
                JOptionPane.showMessageDialog(this, "Fehler beim Löschen der Gruppe.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayClubs();
    }//GEN-LAST:event_jButtonDeleteClubActionPerformed

    private void jButtonShowClubDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonShowClubDetailsMouseClicked
        ClubDetailsDialog clubDetailsDialog = new ClubDetailsDialog(jListJoinedClubs.getSelectedValue()); //Instanz 
        clubDetailsDialog.setVisible(true); 
    }//GEN-LAST:event_jButtonShowClubDetailsMouseClicked

    private void displayClubs() {
        listModel.clear();
        List<Club> clubs = Usercontroller.getInstance().getClubs();
        for (Club club : clubs) {
            listModel.addElement(club); //hier wird dann toString in Club aufgerufen
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateClub;
    private javax.swing.JButton jButtonDeleteClub;
    private javax.swing.JButton jButtonJoinNewClub;
    private javax.swing.JButton jButtonLeaveClub;
    private javax.swing.JButton jButtonShowClubDetails;
    private javax.swing.JList<Club> jListJoinedClubs;
    private java.awt.List jListSearchClubs;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
