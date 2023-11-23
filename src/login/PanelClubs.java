package login;

import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lisas //Gruppe löschen & Freunde hinzufügen
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
        jListSearchFriends = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJoinedClubs = new javax.swing.JList<>();
        jButtonDeleteClub = new javax.swing.JButton();

        setBackground(new java.awt.Color(5, 81, 81));

        jButtonCreateClub.setText("Gruppe erstellen");
        jButtonCreateClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateClubActionPerformed(evt);
            }
        });

        jButtonJoinNewClub.setText("Gruppe beitreten");
        jButtonJoinNewClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJoinNewClubActionPerformed(evt);
            }
        });

        jButtonLeaveClub.setText("aus Gruppe austreten");
        jButtonLeaveClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveClubActionPerformed(evt);
            }
        });

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

        jListSearchFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSearchFriendsMouseClicked(evt);
            }
        });
        jListSearchFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListSearchFriendsActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListJoinedClubs);

        jButtonDeleteClub.setText("Gruppe löschen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(jListSearchFriends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCreateClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jButtonLeaveClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jButtonDeleteClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonJoinNewClub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreateClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonJoinNewClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLeaveClub)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteClub))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jListSearchFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonJoinNewClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJoinNewClubActionPerformed
        Usercontroller.getInstance().addClub(tmpClubname);
        displayClubs();
        System.out.println("Club hinzugefügt.");
    }//GEN-LAST:event_jButtonJoinNewClubActionPerformed

    private void jButtonCreateClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateClubActionPerformed
        CreateClubDialog createClubDialog = new CreateClubDialog();
        createClubDialog.setVisible(true);
    }//GEN-LAST:event_jButtonCreateClubActionPerformed

    private void jButtonLeaveClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveClubActionPerformed
    

    }//GEN-LAST:event_jButtonLeaveClubActionPerformed

    private void jTextFieldSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarMouseClicked
        jTextFieldSearchBar.setText("");
    }//GEN-LAST:event_jTextFieldSearchBarMouseClicked

    private void jTextFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarActionPerformed

        String searchText = jTextFieldSearchBar.getText();
        List<Club> searchResult = Usercontroller.getInstance().searchClub(searchText);
        result = searchResult;
        jListSearchFriends.removeAll();
        for (Club e : searchResult) {
            jListSearchFriends.add(e.getName());
        }
    }//GEN-LAST:event_jTextFieldSearchBarActionPerformed

    private void jListSearchFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSearchFriendsMouseClicked
        List<Club> tmp = this.result;
        int x = jListSearchFriends.getSelectedIndex();
        if (x >= 0) {
            //jButtonAddFriend.setEnabled(true);
            System.out.println(x);
            tmpClubname = tmp.get(x).getName();
        }
    }//GEN-LAST:event_jListSearchFriendsMouseClicked

    private void jListSearchFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListSearchFriendsActionPerformed
        //TODO
    }//GEN-LAST:event_jListSearchFriendsActionPerformed

    private void displayClubs() {
        listModel.clear();
        List<Club> clubs = Usercontroller.getInstance().getClubs();
        for (Club e : clubs) {
            listModel.addElement(e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateClub;
    private javax.swing.JButton jButtonDeleteClub;
    private javax.swing.JButton jButtonJoinNewClub;
    private javax.swing.JButton jButtonLeaveClub;
    private javax.swing.JList<Club> jListJoinedClubs;
    private java.awt.List jListSearchFriends;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
