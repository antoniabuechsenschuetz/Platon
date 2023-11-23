package login;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author lisas
 */
public class CreateClubDialog extends JDialog {

    /**
     * Creates new form CreateClubDialog
     */
    public CreateClubDialog() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldClubName = new javax.swing.JTextField();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldClubSize = new javax.swing.JTextField();
        jTextFieldImage = new javax.swing.JTextField();
        jButtonCreateClub = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(5, 81, 81));

        jTextFieldClubName.setText("Gruppenname...");

        jTextFieldDescription.setText("Beschreibung...");

        jTextFieldClubSize.setText("Gruppengröße...");

        jTextFieldImage.setText("Bild URL...");

        jButtonCreateClub.setText("Gruppe erstellen");
        jButtonCreateClub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateClubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCreateClub)
                    .addComponent(jTextFieldDescription)
                    .addComponent(jTextFieldClubName)
                    .addComponent(jTextFieldClubSize, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jTextFieldImage))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jTextFieldClubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldClubSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCreateClub)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateClubActionPerformed
        try {
            boolean success = DB.getInstance().createClub(
                jTextFieldClubName.getText(),
                jTextFieldDescription.getText(),
                Integer.parseInt(jTextFieldClubSize.getText()), //damit nur Nummern angenommen werden
                jTextFieldImage.getText()
        );

        if (success) {
            JOptionPane.showMessageDialog(CreateClubDialog.this, "Deine Gruppe wurde erfolgreich erstellt!");
            dispose(); // Schließt das Dialogfenster nach erfolgreichem Erstellen
        } else {
            JOptionPane.showMessageDialog(CreateClubDialog.this, "Fehler beim Erstellen deiner Gruppe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(CreateClubDialog.this, "Fehler: Überprüfe deine Eingaben.");
        }
    }//GEN-LAST:event_jButtonCreateClubActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateClub;
    private javax.swing.JTextField jTextFieldClubName;
    private javax.swing.JTextField jTextFieldClubSize;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldImage;
    // End of variables declaration//GEN-END:variables
}