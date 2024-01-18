package login;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 * The PanelFriends class represents a JPanel for displaying a list of friends
 * in a user interface. It includes a DefaultListModel for managing the list of
 * friends, a List to store friend objects, and a String variable to temporarily
 * store usernames.
 *
 * This panel is typically used within the context of a Homepage, and it
 * initializes the components, sets up the DefaultListModel for the JList, and
 * displays the list of friends upon creation.
 *
 * @author Antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh
 * Knutzen,Dominik Marlin Erhardt
 */
public class PanelFriends extends javax.swing.JPanel {

    /**
     * The DefaultListModel to manage the list of friends in the JList
     * component. The list to store friend objects. A String variable to
     * temporarily store usernames.
     */
    private DefaultListModel<String> listModel;
    public List<User> result;
    public String tmpUsername;

    /**
     * Creates a new instance of the PanelFriends. It initializes the
     * components, sets up the DefaultListModel for the JList, and displays the
     * list of friends.
     *
     * @param aThis The Homepage instance to which this panel is associated.
     */
    public PanelFriends(Homepage aThis) {
        initComponents();
        listModel = new DefaultListModel<>();
        jListFriends.setModel(listModel);
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

        jPanelFriendsBackground = new javax.swing.JPanel();
        jButtonAddFriend = new javax.swing.JButton();
        jTextFieldSearchBar = new java.awt.TextField();
        jListSearchFriends = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListFriends = new javax.swing.JList<>();

        setOpaque(false);

        jPanelFriendsBackground.setBackground(new java.awt.Color(5, 81, 81));
        jPanelFriendsBackground.setPreferredSize(new java.awt.Dimension(750, 500));

        jButtonAddFriend.setBackground(new java.awt.Color(0, 51, 51));
        jButtonAddFriend.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButtonAddFriend.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddFriend.setText("Freund hinzufügen");
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

        jListSearchFriends.setBackground(new java.awt.Color(169, 199, 199));
        jListSearchFriends.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jListSearchFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSearchFriendsMouseClicked(evt);
            }
        });

        jListFriends.setBackground(new java.awt.Color(169, 199, 199));
        jListFriends.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jListFriends.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListFriends);

        javax.swing.GroupLayout jPanelFriendsBackgroundLayout = new javax.swing.GroupLayout(jPanelFriendsBackground);
        jPanelFriendsBackground.setLayout(jPanelFriendsBackgroundLayout);
        jPanelFriendsBackgroundLayout.setHorizontalGroup(
            jPanelFriendsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFriendsBackgroundLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelFriendsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jListSearchFriends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jButtonAddFriend)
                .addGap(35, 35, 35))
        );
        jPanelFriendsBackgroundLayout.setVerticalGroup(
            jPanelFriendsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFriendsBackgroundLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanelFriendsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFriendsBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelFriendsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddFriend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jListSearchFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFriendsBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFriendsBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * The jButtonAddFriendActionPerformed method is an event handler triggered
     * when the "Add Friend" button is clicked. It uses the Usercontroller to
     * add a friend with the specified username (tmpUsername), refreshes the
     * display of friends, and prints a message to the console.
     *
     * @param evt The ActionEvent that triggered the method.
     */
    private void jButtonAddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFriendActionPerformed
        Usercontroller.getInstance().addFriend(tmpUsername);
        displayFriends();
        System.out.println("Freund hinzugefügt.");
    }//GEN-LAST:event_jButtonAddFriendActionPerformed

    /**
     * The jTextFieldSearchBarActionPerformed method is an event handler
     * triggered when the user presses Enter in the search bar. It retrieves the
     * search text, performs a user search using Usercontroller, updates the
     * result list, clears the JListSearchFriends, and populates it with the
     * search results.
     *
     * @param evt The ActionEvent that triggered the method.
     */
    private void jTextFieldSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarActionPerformed
        String searchText = jTextFieldSearchBar.getText();
        List<User> searchResult = Usercontroller.getInstance().searchForUser(searchText);
        result = searchResult;
        jListSearchFriends.removeAll();
        for (User e : searchResult) {
            jListSearchFriends.add(e.getUsername());
        }
    }//GEN-LAST:event_jTextFieldSearchBarActionPerformed

    /**
     * The jTextFieldSearchBarMouseClicked method is an event handler triggered
     * when the search bar is clicked. It clears the text in the search bar to
     * allow for new input.
     *
     * @param evt The MouseEvent that triggered the method.
     */
    private void jTextFieldSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchBarMouseClicked
        jTextFieldSearchBar.setText("");
    }//GEN-LAST:event_jTextFieldSearchBarMouseClicked

    /**
     * The jButtonAddFriendMouseClicked method is an event handler triggered
     * when the "Add Friend" button is clicked (mouse click). This method is
     * auto-generated by the GUI builder and currently contains a placeholder
     * comment. Further implementation for handling the "Add Friend" button
     * click can be added in this method.
     *
     * @param evt The MouseEvent that triggered the method.
     */
    private void jButtonAddFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddFriendMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddFriendMouseClicked

    /**
     * The jListSearchFriendsMouseClicked method is an event handler triggered
     * when an item in the search results JList is clicked. It retrieves the
     * selected user's username and enables the "Add Friend" button for user
     * interaction.
     *
     * @param evt The MouseEvent that triggered the method.
     */
    private void jListSearchFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSearchFriendsMouseClicked
        List<User> tmp = this.result;
        int x = jListSearchFriends.getSelectedIndex();
        if (x >= 0) {
            jButtonAddFriend.setEnabled(true);
            System.out.println(x);
            tmpUsername = tmp.get(x).getUsername();
        }
    }//GEN-LAST:event_jListSearchFriendsMouseClicked

    /**
     * The displayFriends method updates the JList of friends by clearing the
     * DefaultListModel and adding the friend usernames.
     */
    private void displayFriends() {
        listModel.clear();
        List<String> ids = Usercontroller.getInstance().getFriends();
        for (String e : ids) {
            listModel.addElement(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFriend;
    private javax.swing.JList<String> jListFriends;
    private java.awt.List jListSearchFriends;
    private javax.swing.JPanel jPanelFriendsBackground;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField jTextFieldSearchBar;
    // End of variables declaration//GEN-END:variables
}
