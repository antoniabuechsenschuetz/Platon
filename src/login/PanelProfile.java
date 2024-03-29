/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package login;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.ListModel;
import login.DB;
import login.Homepage;
import login.Usercontroller;
import login.InterestEnum;

/**
 * PanelProfile class represents a JPanel used for displaying and updating user
 * profile information. It includes fields for name, username, location,
 * description, hobbies, and a profile picture. Users can edit and save their
 * profile information using this panel. Hobbies are displayed in a list, and
 * users can add new hobbies by clicking on the list.
 *
 * @author Antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh
 * Knutzen,Dominik Marlin Erhardt
 */
public class PanelProfile extends javax.swing.JPanel {

    private DefaultListModel<String> listModel;

    /**
     * Creates new form PanelProfile
     *
     * @param aThis The Homepage instance associated with this panel.
     */
    public PanelProfile(Homepage aThis) {
        initComponents();
        listModel = new DefaultListModel<>();
        hobbysList.setModel(listModel);
        display_data();
        displayer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveProfile = new javax.swing.JButton();
        ProfilePicture = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        Location = new javax.swing.JTextField();
        Description = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        HobbiesText = new javax.swing.JLabel();
        UsernameText = new javax.swing.JLabel();
        StandortText = new javax.swing.JLabel();
        NameText = new javax.swing.JLabel();
        BeschreibungText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hobbysList = new javax.swing.JList<>();

        setBackground(new java.awt.Color(6, 81, 81));
        setPreferredSize(new java.awt.Dimension(750, 500));

        SaveProfile.setBackground(new java.awt.Color(0, 51, 51));
        SaveProfile.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SaveProfile.setForeground(new java.awt.Color(255, 255, 255));
        SaveProfile.setText("Speichern");
        SaveProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveProfileMouseClicked(evt);
            }
        });

        ProfilePicture.setBackground(new java.awt.Color(169, 199, 199));
        ProfilePicture.setForeground(new java.awt.Color(169, 199, 199));
        ProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/Bilder/ProfilePicture.jpg"))); // NOI18N
        ProfilePicture.setAlignmentY(0.0F);
        ProfilePicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ProfilePicture.setMaximumSize(new java.awt.Dimension(218, 218));
        ProfilePicture.setMinimumSize(new java.awt.Dimension(218, 218));
        ProfilePicture.setPreferredSize(new java.awt.Dimension(218, 218));

        Name.setBackground(new java.awt.Color(169, 199, 199));
        Name.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Name.setText("Name");
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Username.setBackground(new java.awt.Color(169, 199, 199));
        Username.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Username.setText("Username");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        Location.setBackground(new java.awt.Color(169, 199, 199));
        Location.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Location.setText("Standort");
        Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationActionPerformed(evt);
            }
        });
        Location.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LocationKeyReleased(evt);
            }
        });

        Description.setBackground(new java.awt.Color(169, 199, 199));
        Description.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        Description.setText("Beschreibung");
        Description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionActionPerformed(evt);
            }
        });
        Description.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescriptionKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Bearbeiten");

        HobbiesText.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        HobbiesText.setForeground(new java.awt.Color(255, 255, 255));
        HobbiesText.setText("Hobbies");

        UsernameText.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        UsernameText.setForeground(new java.awt.Color(255, 255, 255));
        UsernameText.setText("Benutzername");

        StandortText.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        StandortText.setForeground(new java.awt.Color(255, 255, 255));
        StandortText.setText("Standort");

        NameText.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        NameText.setForeground(new java.awt.Color(255, 255, 255));
        NameText.setText("Name");

        BeschreibungText.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        BeschreibungText.setForeground(new java.awt.Color(255, 255, 255));
        BeschreibungText.setText("Beschreibung");

        hobbysList.setBackground(new java.awt.Color(169, 199, 199));
        hobbysList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Hobbys Hinzufügen..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        hobbysList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hobbysListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hobbysList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HobbiesText)
                    .addComponent(BeschreibungText)
                    .addComponent(StandortText)
                    .addComponent(UsernameText)
                    .addComponent(NameText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SaveProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Location, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Description, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveProfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(9, 9, 9))
                    .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameText)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StandortText))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(HobbiesText))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BeschreibungText)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Location.getAccessibleContext().setAccessibleName("Location");
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Displays the user's profile data in the corresponding fields.
     */
    private void display_data() {
        Name.setText(Usercontroller.getInstance().getLoggedInUser().getName());
        Username.setText(Usercontroller.getInstance().getLoggedInUser().getUsername());
        Location.setText(Usercontroller.getInstance().getLoggedInUser().getLocation());
        Description.setText(Usercontroller.getInstance().getLoggedInUser().getDescription());
    }

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed

    }//GEN-LAST:event_NameActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed

    }//GEN-LAST:event_UsernameActionPerformed

    private void LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationActionPerformed

    }//GEN-LAST:event_LocationActionPerformed

    private void DescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionActionPerformed

    }//GEN-LAST:event_DescriptionActionPerformed

    private void LocationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LocationKeyReleased

    }//GEN-LAST:event_LocationKeyReleased

    private void DescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescriptionKeyReleased

    }//GEN-LAST:event_DescriptionKeyReleased
    /**
     * Handles the action when the user clicks the "Speichern" button. Updates
     * the user's location and description in the database.
     */
    private void SaveProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveProfileMouseClicked
        int id = Usercontroller.getInstance().getLoggedInUser().getId();
        String lo = Location.getText();
        String d = Description.getText();
        try {
            DB.getInstance().databaseUpdate("USER", "LOCATION", lo, id);
            DB.getInstance().databaseUpdate("USER", "DESCRIPTION", d, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_SaveProfileMouseClicked
    /**
     * Handles the action when the user clicks on a hobby in the hobbies list.
     * Opens a HobbyFrame if the selected field is "Hobbys Hinzufügen...".
     */
    private void hobbysListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hobbysListMouseClicked
        if (hobbysList.isSelectedIndex(0) && hobbysList.getSelectedValue().equals("Hobbys Hinzufügen...")) {
            HobbyFrame bf = new HobbyFrame();
            bf.setVisible(true);
        }
    }//GEN-LAST:event_hobbysListMouseClicked
    /**
     * Updates the hobbies list with the user's hobbies.
     */
    private void displayer() {
        try {
            listModel.clear();
            listModel.addElement("Hobbys Hinzufügen...");
            List<String> i = DB.getInstance().readInterest(Usercontroller.getInstance().getLoggedInUserId());
            for (String e : i) {
                listModel.addElement(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeschreibungText;
    private javax.swing.JTextField Description;
    private javax.swing.JLabel HobbiesText;
    private javax.swing.JTextField Location;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NameText;
    private javax.swing.JLabel ProfilePicture;
    private javax.swing.JButton SaveProfile;
    private javax.swing.JLabel StandortText;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel UsernameText;
    private javax.swing.JList<String> hobbysList;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
