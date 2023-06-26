/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiket.view;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEXIS
 */
public class Gerbong extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    public Gerbong() {
        initComponents();
        tbldata.removeColumn(tbldata.getColumnModel().getColumn(0));
        getKereta();
    }

    ArrayList<String> idKereta = new ArrayList<String>();

    public void reset() {
        gerbongName.setText(null);
        keretaCombo.setSelectedIndex(0);
    }
    
    public void getKereta() {
        try {
            idKereta.clear();
            Connection connection = MysqlConnection.Connect();
            String query = "SELECT * FROM kereta";
            PreparedStatement stmnt = connection.prepareStatement(query);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                keretaCombo.addItem(rs.getString("nama_kereta"));
                idKereta.add(String.valueOf(rs.getInt("id")));
            }
        } catch (Exception e) {
        }
    }

    public void refresh() {
        int index = 1;
        DefaultTableModel tblModel = (DefaultTableModel)tbldata.getModel();
        tblModel.setRowCount(0);
        try {
            Connection connection = MysqlConnection.Connect();
            String query = "SELECT gerbong.*, kereta.id as kereta, kereta.nama_kereta FROM gerbong LEFT JOIN kereta ON gerbong.kereta = kereta.id";
            PreparedStatement stmnt = connection.prepareStatement(query);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nama = rs.getString("nama_kereta");
                String gerbong = rs.getString("nama_gerbong");
                String tbData[] = { id, String.valueOf(index), nama, gerbong };
                tblModel.addRow(tbData);
                index++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void insertKursi(String index) {
        Connection connection = MysqlConnection.Connect();
        int kursi = 1;
        int i = 1;
        try {
            while (i <= 30) {
             String query = "INSERT INTO kursi (nama_kursi, id_gerbong, status) VALUES (?, ?, ?)";
            PreparedStatement stmnt = connection.prepareStatement(query);
            stmnt.setString(1, String.valueOf(kursi));
            stmnt.setString(2, index);
            stmnt.setInt(3, 0);
            stmnt.executeUpdate();
            kursi++;
            i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean validate(String nama, int kereta) {
        Connection connection = MysqlConnection.Connect();
        try {
                String query = "SELECT * FROM gerbong WHERE nama_gerbong = ? AND kereta = ?";
                PreparedStatement stmnt = connection.prepareStatement(query);
                stmnt.setString(1, nama);
                stmnt.setInt(2, kereta);
                ResultSet rs = stmnt.executeQuery();
                if (rs.next()) {
                    return false;
                } else {
                    return true;
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpload5 = new javax.swing.JButton();
        btnUpload1 = new javax.swing.JButton();
        btnUpload2 = new javax.swing.JButton();
        btnUpload3 = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        userButton = new javax.swing.JButton();
        keretaButton = new javax.swing.JButton();
        gerbongButton = new javax.swing.JButton();
        tujuanButton = new javax.swing.JButton();
        jadwalButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        clearButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        gerbongName = new javax.swing.JTextField();
        keretaCombo = new javax.swing.JComboBox<>();

        btnUpload5.setText("Delete");
        btnUpload5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload5ActionPerformed(evt);
            }
        });

        btnUpload1.setText("Detail");
        btnUpload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload1ActionPerformed(evt);
            }
        });

        btnUpload2.setText("Edit");
        btnUpload2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload2ActionPerformed(evt);
            }
        });

        btnUpload3.setText("Refresh");
        btnUpload3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpload3ActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        userButton.setText("User");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        keretaButton.setText("Kereta");
        keretaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keretaButtonActionPerformed(evt);
            }
        });

        gerbongButton.setText("Gerbong");
        gerbongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerbongButtonActionPerformed(evt);
            }
        });

        tujuanButton.setText("Tujuan");
        tujuanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tujuanButtonActionPerformed(evt);
            }
        });

        jadwalButton.setText("Jadwal");
        jadwalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jadwalButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gerbongButton, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(tujuanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jadwalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keretaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(userButton)
                .addGap(12, 12, 12)
                .addComponent(keretaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gerbongButton)
                .addGap(18, 18, 18)
                .addComponent(tujuanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jadwalButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gerbong");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Nama_Gerbong");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Kereta");

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No", "Kereta", "Gerbong"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        gerbongName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerbongNameActionPerformed(evt);
            }
        });

        keretaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kereta" }));
        keretaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keretaComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gerbongName, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(keretaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(keretaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(gerbongName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clearButton)
                            .addComponent(refreshButton)
                            .addComponent(uploadButton)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        User us = new User();
        us.setVisible(true);
    }//GEN-LAST:event_userButtonActionPerformed

    private void keretaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keretaButtonActionPerformed
        Kereta ker = new Kereta();
        ker.setVisible(true);
    }//GEN-LAST:event_keretaButtonActionPerformed

    private void gerbongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerbongButtonActionPerformed
        
    }//GEN-LAST:event_gerbongButtonActionPerformed

    private void tujuanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tujuanButtonActionPerformed
        Tujuan tuju = new Tujuan();
        tuju.setVisible(true);
    }//GEN-LAST:event_tujuanButtonActionPerformed

    private void jadwalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadwalButtonActionPerformed
        Jadwal jdw = new Jadwal();
        jdw.setVisible(true);
    }//GEN-LAST:event_jadwalButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void btnUpload5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpload5ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpload5ActionPerformed

    private void btnUpload1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpload1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpload1ActionPerformed

    private void btnUpload2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpload2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpload2ActionPerformed

    private void btnUpload3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpload3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpload3ActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUploadActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
        
    }// GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearButtonActionPerformed
        reset();
    }// GEN-LAST:event_clearButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_editButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
    }// GEN-LAST:event_refreshButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_uploadButtonActionPerformed
        int getIndex = keretaCombo.getSelectedIndex();
        if (gerbongName.getText().isEmpty() || keretaCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Data yang anda masukkan belum lengkap\nSilahkan ulangi lagi");
        } else {
            Connection connection = MysqlConnection.Connect();
            try {
                if (validate(gerbongName.getText(), Integer.parseInt(idKereta.get(getIndex-1)))) {
                    String sql = "insert into gerbong (nama_gerbong, kereta) values (?, ?)";
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, gerbongName.getText());
                    pstmt.setString(2, idKereta.get(getIndex-1));
                    
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil di masukan");
                    refresh();
                    DefaultTableModel model = (DefaultTableModel) tbldata.getModel();
                    insertKursi(model.getValueAt(model.getRowCount()-1, 0).toString());
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Gerbong telah terdaftar !!!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }// GEN-LAST:event_uploadButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    }// GEN-LAST:event_formComponentShown

    private void gerbongNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_gerbongNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_gerbongNameActionPerformed

    private void keretaComboActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_keretaComboActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_keretaComboActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tbldata.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbldata.getModel();
        gerbongName.setText(model.getValueAt(row, 2).toString());
        keretaCombo.setSelectedItem(model.getValueAt(row, 3));
    }// GEN-LAST:event_tbldataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gerbong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerbong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerbong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerbong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerbong().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnUpload1;
    private javax.swing.JButton btnUpload2;
    private javax.swing.JButton btnUpload3;
    private javax.swing.JButton btnUpload5;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton gerbongButton;
    private javax.swing.JTextField gerbongName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jadwalButton;
    private javax.swing.JButton keretaButton;
    private javax.swing.JComboBox<String> keretaCombo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable tbldata;
    private javax.swing.JButton tujuanButton;
    private javax.swing.JButton uploadButton;
    private javax.swing.JButton userButton;
    // End of variables declaration//GEN-END:variables

    private void tampilData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
