/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package login;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author lisas
 */
public class PanelFriends extends javax.swing.JPanel {
    private DefaultListModel<String> listModel;
    public List<User> result;
    public String tmpUsername;
    /**
     * Creates new form PanelFriends
     */
    public PanelFriends(Homepage aThis) {
        initComponents();
        listModel = new DefaultListModel<>();
        Friendslist.setModel(listModel);
        displayFriends();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAddFriend = new javax.swing.JButton();
        search = new java.awt.TextField();
        searchFriends = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        Friendslist = new javax.swing.JList<>();

        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(5, 81, 81));

        jButtonAddFriend.setText("add Friend");
        jButtonAddFriend.setEnabled(false);
        jButtonAddFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddFriendMouseClicked(evt);
            }
        });
        jButtonAddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFriendActionPerformed(evt);
            }
        });

        search.setText("Suche...");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        searchFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFriendsMouseClicked(evt);
            }
        });
        searchFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFriendsActionPerformed(evt);
            }
        });

        Friendslist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Friendslist);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddFriend)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonAddFriend))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(searchFriends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFriendActionPerformed
        Usercontroller.getInstance().addFriends(tmpUsername);
        displayFriends();
        System.out.println("Freund hinzugefügt.");
    }//GEN-LAST:event_jButtonAddFriendActionPerformed
    
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        String searchText = search.getText();
        List<User> searchResult = Usercontroller.getInstance().searchForUser(searchText);
        result = searchResult;
        searchFriends.removeAll();
        for(User e : searchResult) {
            searchFriends.add(e.getUsername());
        }
    }//GEN-LAST:event_searchActionPerformed

    private void searchFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFriendsActionPerformed
        //TODO
    }//GEN-LAST:event_searchFriendsActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        search.setText("");
    }//GEN-LAST:event_searchMouseClicked

    private void jButtonAddFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFriendMouseClicked

    }//GEN-LAST:event_jButtonAddFriendMouseClicked

    private void searchFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFriendsMouseClicked
        List<User> tmp = this.result;
        int x = searchFriends.getSelectedIndex();
        jButtonAddFriend.setEnabled(true);
        tmpUsername = tmp.get(x).getUsername();
    }//GEN-LAST:event_searchFriendsMouseClicked
    
    
    private void displayFriends() {
        listModel.clear();
        List<String> ids = Usercontroller.getInstance().getFriends();
        for(String e : ids) {
           listModel.addElement(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Friendslist;
    private javax.swing.JButton jButtonAddFriend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField search;
    private java.awt.List searchFriends;
    // End of variables declaration//GEN-END:variables
}
