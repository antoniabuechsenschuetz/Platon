package login;

import java.sql.SQLException;
import java.util.List;

/**
 * The PostFrame class represents the GUI frame for posting messages in Platon.
 * It allows users to create and post messages to specific clubs they have
 * joined. Users can select a club, enter a title and description for their
 * post, and click the "Beitrag posten" button.
 *
 * @author Antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh
 * Knutzen,Dominik Marlin Erhardt
 */
public class PostFrame extends javax.swing.JFrame {

    /**
     * Creates new form PostFrame
     */
    public PostFrame() {
        initComponents();
        displayer();
        getContentPane().setBackground(new java.awt.Color(169, 199, 199));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClubChoicePost = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        PostText = new javax.swing.JTextArea();
        PostingButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        PostTitle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        ClubChoicePost.setBackground(new java.awt.Color(203, 226, 226));

        PostText.setBackground(new java.awt.Color(203, 226, 226));
        PostText.setColumns(20);
        PostText.setRows(5);
        PostText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PostTextKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(PostText);

        PostingButton.setBackground(new java.awt.Color(0, 51, 51));
        PostingButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        PostingButton.setForeground(new java.awt.Color(255, 255, 255));
        PostingButton.setText("Beitrag posten");
        PostingButton.setEnabled(false);
        PostingButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PostingButtonStateChanged(evt);
            }
        });
        PostingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PostingButtonMouseClicked(evt);
            }
        });

        CloseButton.setBackground(new java.awt.Color(0, 51, 51));
        CloseButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CloseButton.setForeground(new java.awt.Color(255, 255, 255));
        CloseButton.setText("Close");
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
        });

        PostTitle.setBackground(new java.awt.Color(203, 226, 226));
        PostTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PostTitleKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ClubChoicePost, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                            .addComponent(PostingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PostTitle)
                        .addComponent(jScrollPane1))
                    .addComponent(CloseButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(CloseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PostingButton)
                    .addComponent(ClubChoicePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(PostTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Handles the action when CloseButton is clicked. Closes the PostFrame by
     * disposing of it.
     *
     * @param evt The MouseEvent triggering the method.
     */
    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
        dispose();
    }//GEN-LAST:event_CloseButtonMouseClicked
    /**
     * Enables the PostingButton when text is typed into the PostText field.
     *
     * @param evt The KeyEvent triggering the method.
     */
    private void PostTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PostTextKeyTyped
        PostingButton.setEnabled(true);
    }//GEN-LAST:event_PostTextKeyTyped
    /**
     * Enables the PostingButton when text is typed into the PostTitle field.
     *
     * @param evt The KeyEvent triggering the method.
     */
    private void PostTitleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PostTitleKeyTyped
        PostingButton.setEnabled(true);
    }//GEN-LAST:event_PostTitleKeyTyped
    /**
     * Enables or disables the PostingButton based on the contents of PostText
     * and PostTitle fields.
     *
     * @param evt The ChangeEvent triggering the method.
     */
    private void PostingButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PostingButtonStateChanged
        if (PostText.getText().isEmpty() && PostTitle.getText().isEmpty()) {
            PostingButton.setEnabled(false);
        } else if (PostTitle.getText().isEmpty() && !PostText.getText().isEmpty()) {
            PostingButton.setEnabled(false);
        } else if (PostText.getText().isEmpty() && !PostTitle.getText().isEmpty()) {
            PostingButton.setEnabled(false);
        } else {
            PostingButton.setEnabled(true);
        }
    }//GEN-LAST:event_PostingButtonStateChanged

    /**
     * Handles the action when PostingButton is clicked. Retrieves post
     * information (title, content, user ID, club ID) and adds the post to the
     * database. Closes the PostFrame upon successful posting.
     *
     * @param evt The MouseEvent triggering the method.
     */
    private void PostingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PostingButtonMouseClicked

        try {
            String Title = PostTitle.getText();
            String Beitrag = PostText.getText();
            int MyID = Usercontroller.getInstance().getLoggedInUserId();
            String selectedGroup = ClubChoicePost.getSelectedItem().toString();
            Club foundGroup = DB.getInstance().searchClubByName(selectedGroup);
            int ClubID = foundGroup.getId();
            DB.getInstance().addPost(Title, Beitrag, MyID, ClubID);
            dispose();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_PostingButtonMouseClicked

    /**
     * Displays the clubs a user has joined in the ClubChoicePost dropdown menu.
     */
    public void displayer() {
        try {
            int id = Usercontroller.getInstance().getLoggedInUserId();
            List<String> group = DB.getInstance().getJoinedClubNames(id);
            ClubChoicePost.removeAll();
            for (String e : group) {
                ClubChoicePost.addItem(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JComboBox<String> ClubChoicePost;
    private javax.swing.JTextArea PostText;
    private javax.swing.JTextField PostTitle;
    private javax.swing.JButton PostingButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
