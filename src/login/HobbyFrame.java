/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JCheckBox;
import login.PanelFeed;

/**
 *
 * @author patricia
 */
public class HobbyFrame extends javax.swing.JFrame {

    private List<String> hobbys = new LinkedList<>();

    /**
     * Creates new form BeitragFrame
     */
    public HobbyFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(169, 199, 199));
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

        SaveButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        box1 = new javax.swing.JCheckBox();
        box2 = new javax.swing.JCheckBox();
        box3 = new javax.swing.JCheckBox();
        box4 = new javax.swing.JCheckBox();
        box5 = new javax.swing.JCheckBox();
        box6 = new javax.swing.JCheckBox();
        box7 = new javax.swing.JCheckBox();
        box8 = new javax.swing.JCheckBox();
        box9 = new javax.swing.JCheckBox();
        box10 = new javax.swing.JCheckBox();
        box11 = new javax.swing.JCheckBox();
        box12 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setMinimumSize(new java.awt.Dimension(350, 350));
        setSize(new java.awt.Dimension(350, 350));

        SaveButton.setBackground(new java.awt.Color(0, 51, 51));
        SaveButton.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("Speichern");
        SaveButton.setEnabled(false);
        SaveButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SaveButtonStateChanged(evt);
            }
        });
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButtonMouseClicked(evt);
            }
        });
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseButtonMouseEntered(evt);
            }
        });
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        box1.setText("Init");
        box1.setVisible(false);
        box1.setEnabled(false);
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        box2.setText("Init");
        box2.setVisible(false);
        box2.setEnabled(false);
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        box3.setText("Init");
        box3.setVisible(false);
        box3.setEnabled(false);
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        box4.setText("Init");
        box4.setVisible(false);
        box4.setEnabled(false);
        box4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box4ActionPerformed(evt);
            }
        });

        box5.setText("Init");
        box5.setVisible(false);
        box5.setEnabled(false);
        box5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box5ActionPerformed(evt);
            }
        });

        box6.setText("Init");
        box6.setVisible(false);
        box6.setEnabled(false);
        box6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box6ActionPerformed(evt);
            }
        });

        box7.setText("Init");
        box7.setVisible(false);
        box7.setEnabled(false);
        box7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box7ActionPerformed(evt);
            }
        });

        box8.setText("Init");
        box8.setVisible(false);
        box8.setEnabled(false);
        box8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box8ActionPerformed(evt);
            }
        });

        box9.setText("Init");
        box9.setVisible(false);
        box9.setEnabled(false);
        box9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box9ActionPerformed(evt);
            }
        });

        box10.setText("Init");
        box10.setVisible(false);
        box10.setEnabled(false);
        box10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box10ActionPerformed(evt);
            }
        });

        box11.setText("Init");
        box11.setVisible(false);
        box11.setEnabled(false);
        box11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box11ActionPerformed(evt);
            }
        });

        box12.setText("Init");
        box12.setVisible(false);
        box12.setEnabled(false);
        box12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CloseButton)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CloseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(box7)
                        .addComponent(box1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box2)
                            .addComponent(box8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box4)
                            .addComponent(box10))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box5)
                    .addComponent(box11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box12)
                    .addComponent(box6))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed

    }//GEN-LAST:event_CloseButtonActionPerformed

    private void CloseButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseButtonMouseEntered

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
        dispose();
    }//GEN-LAST:event_CloseButtonMouseClicked

    private void SaveButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SaveButtonStateChanged
        if (hobbys.isEmpty()) {
            SaveButton.setEnabled(false);
        }
    }//GEN-LAST:event_SaveButtonStateChanged

    private void SaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseClicked
        try {
            DB.getInstance().addInterest(hobbys, Usercontroller.getInstance().getLoggedInUserId());
            dispose();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_SaveButtonMouseClicked

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        if (box1.isSelected()) {
            hobbys.add(box1.getText());
            SaveButton.setEnabled(true);
        } else if (!box1.isSelected()) {
            hobbys.remove(box1.getText());
        }
    }//GEN-LAST:event_box1ActionPerformed

    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        if (box2.isSelected()) {
            hobbys.add(box2.getText());
            SaveButton.setEnabled(true);
        } else if (!box2.isSelected()) {
            hobbys.remove(box2.getText());
        }
    }//GEN-LAST:event_box2ActionPerformed

    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        if (box3.isSelected()) {
            hobbys.add(box3.getText());
            SaveButton.setEnabled(true);
        } else if (!box3.isSelected()) {
            hobbys.remove(box3.getText());
        }
    }//GEN-LAST:event_box3ActionPerformed

    private void box4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box4ActionPerformed
        if (box4.isSelected()) {
            hobbys.add(box4.getText());
            SaveButton.setEnabled(true);
        } else if (!box4.isSelected()) {
            hobbys.remove(box4.getText());
        }
    }//GEN-LAST:event_box4ActionPerformed

    private void box5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box5ActionPerformed
        if (box5.isSelected()) {
            hobbys.add(box5.getText());
            SaveButton.setEnabled(true);
        } else if (!box5.isSelected()) {
            hobbys.remove(box5.getText());
        }
    }//GEN-LAST:event_box5ActionPerformed

    private void box6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box6ActionPerformed
        if (box6.isSelected()) {
            hobbys.add(box6.getText());
            SaveButton.setEnabled(true);
        } else if (!box6.isSelected()) {
            hobbys.remove(box6.getText());
        }
    }//GEN-LAST:event_box6ActionPerformed

    private void box7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box7ActionPerformed
        if (box7.isSelected()) {
            hobbys.add(box7.getText());
            SaveButton.setEnabled(true);
        } else if (!box7.isSelected()) {
            hobbys.remove(box7.getText());
        }
    }//GEN-LAST:event_box7ActionPerformed

    private void box8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box8ActionPerformed
        if (box8.isSelected()) {
            hobbys.add(box8.getText());
            SaveButton.setEnabled(true);
        } else if (!box8.isSelected()) {
            hobbys.remove(box8.getText());
        }
    }//GEN-LAST:event_box8ActionPerformed

    private void box9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box9ActionPerformed
        if (box9.isSelected()) {
            hobbys.add(box9.getText());
            SaveButton.setEnabled(true);
        } else if (!box9.isSelected()) {
            hobbys.remove(box9.getText());
        }
    }//GEN-LAST:event_box9ActionPerformed

    private void box10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box10ActionPerformed
        if (box10.isSelected()) {
            hobbys.add(box10.getText());
            SaveButton.setEnabled(true);
        } else if (!box10.isSelected()) {
            hobbys.remove(box10.getText());
        }
    }//GEN-LAST:event_box10ActionPerformed

    private void box11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box11ActionPerformed
        if (box11.isSelected()) {
            hobbys.add(box11.getText());
            SaveButton.setEnabled(true);
        } else if (!box11.isSelected()) {
            hobbys.remove(box11.getText());
        }
    }//GEN-LAST:event_box11ActionPerformed

    private void box12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box12ActionPerformed
        if (box12.isSelected()) {
            hobbys.add(box12.getText());
            SaveButton.setEnabled(true);
        } else if (!box12.isSelected()) {
            hobbys.remove(box12.getText());
        }
    }//GEN-LAST:event_box12ActionPerformed

    public void displayer() {
        try {
            List<String> inDataHobby = DB.getInstance().readInterest(Usercontroller.getInstance().getLoggedInUserId());

            List<JCheckBox> box = new LinkedList<>();

            box.add(box1);
            box.add(box2);
            box.add(box3);
            box.add(box4);
            box.add(box5);
            box.add(box6);
            box.add(box7);
            box.add(box8);
            box.add(box9);
            box.add(box10);
            box.add(box11);
            box.add(box12);

            List<String> inter = Stream.of(InterestEnum.values())
                    .map(Enum::name)
                    .collect(Collectors.toList());

            int ende = (inter.size() > box.size() ? box.size() : inter.size());
            for (int i = 0; i < ende; i++) {

                JCheckBox currentBox = box.get(i);
                String currentInterest = inter.get(i);

                currentBox.setVisible(true);
                currentBox.setEnabled(true);
                currentBox.setText(currentInterest);

                for (String e : inDataHobby) {
                    if (currentInterest.equals(e)) {
                        currentBox.setSelected(true);
                    }

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JCheckBox box1;
    private javax.swing.JCheckBox box10;
    private javax.swing.JCheckBox box11;
    private javax.swing.JCheckBox box12;
    private javax.swing.JCheckBox box2;
    private javax.swing.JCheckBox box3;
    private javax.swing.JCheckBox box4;
    private javax.swing.JCheckBox box5;
    private javax.swing.JCheckBox box6;
    private javax.swing.JCheckBox box7;
    private javax.swing.JCheckBox box8;
    private javax.swing.JCheckBox box9;
    // End of variables declaration//GEN-END:variables
}