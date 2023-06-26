/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tiket.view;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALEXIS
 */
public class Jadwal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */

    public Jadwal() {
        initComponents();
        tblData.removeColumn(tblData.getColumnModel().getColumn(0));
        getKereta();
        getTujuan();
    }

    ArrayList<String> idKereta = new ArrayList<String>();
    ArrayList<String> idTujuan = new ArrayList<String>();
    
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
    
    public void getTujuan() {
        try {
            idTujuan.clear();
            Connection connection = MysqlConnection.Connect();
            String query = "SELECT * FROM stasiun";
            PreparedStatement stmnt = connection.prepareStatement(query);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                tujuanCombo.addItem(rs.getString("nama"));
                idTujuan.add(String.valueOf(rs.getInt("id")));
            }
        } catch (Exception e) {
        }
    }
    
    
    public void refresh() {
        int index = 1;
        DefaultTableModel tblModel = (DefaultTableModel) tblData.getModel();
        tblModel.setRowCount(0);
        try {
            Connection connection = MysqlConnection.Connect();
            String query = "SELECT j.*, k.id as kereta_id, k.nama_kereta, k.kelas, t.nama FROM jadwal j "
                    + "INNER JOIN kereta k ON j.kereta_id = k.id "
                    + "INNER JOIN stasiun t ON j.tujuan = t.id";
            PreparedStatement stmnt = connection.prepareStatement(query);
            ResultSet rs = stmnt.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String nama_kereta = rs.getString("nama_kereta");
                String kelas = rs.getString("kelas");
                String tujuan = rs.getString("nama");
                String tglBerangkat = rs.getString("berangkat");
                String tglSampai = rs.getString("sampai");
                String jamBerangkat = rs.getString("jam_berangkat");
                String jamSampai = rs.getString("jam_sampai");
                String harga = rs.getString("harga");
                String tbData[] = { id, String.valueOf(index), nama_kereta,
                    kelas, tujuan, tglBerangkat,
                    tglSampai, jamBerangkat, jamSampai, harga
                };
                tblModel.addRow(tbData);
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reset() {
        kelasField.setText(null);
        keretaCombo.setSelectedIndex(0);
        tujuanCombo.setSelectedIndex(0);
        berangkatDate.setDate(null);
        berangkatTime.setText(null);
        sampaiDate.setDate(null);
        sampaiTime.setText(null);
        hargaField.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        timePickerMenu1 = new com.raven.swing.TimePickerMenu();
        jPanel3 = new javax.swing.JPanel();
        userButton = new javax.swing.JButton();
        keretaButton = new javax.swing.JButton();
        gerbongButton = new javax.swing.JButton();
        tujuanButton = new javax.swing.JButton();
        jadwalButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        detailButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kelasField = new javax.swing.JTextField();
        tujuanCombo = new javax.swing.JComboBox<>();
        berangkatDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        sampaiDate = new com.toedter.calendar.JDateChooser();
        hargaField = new javax.swing.JTextField();
        keretaCombo = new javax.swing.JComboBox<>();
        berangkatTime = new javax.swing.JTextField();
        sampaiTime = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jButton6.setText("User");

        jButton7.setText("Kereta");

        jButton8.setText("Tiket");

        jButton9.setText("Gerbong");

        jButton10.setText("Tujuan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton6)
                    .addComponent(jButton9))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton6)
                .addGap(39, 39, 39)
                .addComponent(jButton7)
                .addGap(29, 29, 29)
                .addComponent(jButton8)
                .addGap(35, 35, 35)
                .addComponent(jButton9)
                .addGap(33, 33, 33)
                .addComponent(jButton10)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keretaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gerbongButton, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(tujuanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jadwalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(userButton)
                .addGap(18, 18, 18)
                .addComponent(keretaButton)
                .addGap(18, 18, 18)
                .addComponent(gerbongButton)
                .addGap(18, 18, 18)
                .addComponent(tujuanButton)
                .addGap(18, 18, 18)
                .addComponent(jadwalButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Nama_Kereta");

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "No", "Nama Kereta", "Kelas Kereta", "Tujuan", "Berangkat", "Sampai", "Jam Berangkat", "Jam Sampai", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Jadwal");

        detailButton.setText("Clear");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Kelas kereta");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tujuan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Berangkat");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Jam Berangkat");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Jam Sampai");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Harga");

        tujuanCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Stasiun" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Sampai");

        keretaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kereta" }));
        keretaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keretaComboActionPerformed(evt);
            }
        });

        berangkatTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                berangkatTimeActionPerformed(evt);
            }
        });

        sampaiTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sampaiTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(berangkatTime))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(berangkatDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(kelasField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tujuanCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 177, Short.MAX_VALUE)
                                            .addComponent(keretaCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sampaiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(sampaiTime))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                                .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(keretaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sampaiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(kelasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(sampaiTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tujuanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(berangkatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(berangkatTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(detailButton)
                            .addComponent(refreshButton)
                            .addComponent(uploadButton)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void berangkatTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berangkatTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_berangkatTimeActionPerformed

    private void sampaiTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sampaiTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sampaiTimeActionPerformed

    private void keretaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keretaComboActionPerformed
        try {
            kelasField.setText(null);
            int getIndex = keretaCombo.getSelectedIndex();
            Connection connection = MysqlConnection.Connect();
            String query = "SELECT kelas FROM kereta WHERE id = ?";
            PreparedStatement stmnt = connection.prepareStatement(query);
            stmnt.setInt(1, Integer.parseInt(idKereta.get(getIndex-1)));
            ResultSet rs = stmnt.executeQuery();
            if (rs.next()) {
                kelasField.setText(rs.getString("kelas"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_keretaComboActionPerformed

    private void keretaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keretaButtonActionPerformed
        Kereta ker = new Kereta();
        ker.setVisible(true);
    }//GEN-LAST:event_keretaButtonActionPerformed

    private void gerbongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerbongButtonActionPerformed
        Gerbong ger = new Gerbong();
        ger.setVisible(true);
    }//GEN-LAST:event_gerbongButtonActionPerformed

    private void tujuanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tujuanButtonActionPerformed
        Tujuan tuju = new Tujuan();
        tuju.setVisible(true);
    }//GEN-LAST:event_tujuanButtonActionPerformed

    private void jadwalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadwalButtonActionPerformed
        
    }//GEN-LAST:event_jadwalButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        User us = new User();
        us.setVisible(true);
    }//GEN-LAST:event_userButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
    }// GEN-LAST:event_jTable1MouseClicked

    private void cbRoll1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbRoll1ActionPerformed

    }// GEN-LAST:event_cbRoll1ActionPerformed

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbRoll1ActionPerformed
        reset();
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbRoll1ActionPerformed
        
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbRoll1ActionPerformed
     
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbRoll1ActionPerformed
        refresh();
    }

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
            Connection connection = MysqlConnection.Connect();
            if (keretaCombo.getSelectedIndex() == 0 || kelasField.getText().isEmpty() || tujuanCombo.getSelectedIndex() == 0 || berangkatDate.getDate() == null || berangkatTime.getText().isEmpty() || sampaiDate.getDate() == null || sampaiTime.getText().isEmpty() || hargaField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lengkapi Data terlebih dahulu !!!");
            } else {
                int getIndexKereta = keretaCombo.getSelectedIndex();
                int getIndexTujuan = tujuanCombo.getSelectedIndex();
                SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
                String berangkat = s.format(berangkatDate.getDate());
                String sampai = s.format(sampaiDate.getDate());
                try {
                    String sql = "insert into jadwal (kereta_id, tujuan, berangkat, sampai, jam_berangkat, jam_sampai, harga) values (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, idKereta.get(getIndexKereta-1));
                    pstmt.setString(2, idTujuan.get(getIndexTujuan-1));
                    pstmt.setString(3, berangkat);
                    pstmt.setString(4, sampai);
                    pstmt.setString(5, berangkatTime.getText());
                    pstmt.setString(6, sampaiTime.getText());
                    pstmt.setString(7, hargaField.getText());
                    

                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil di masukan");
                    refresh();
                    reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            }
            
    }

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
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser berangkatDate;
    private javax.swing.JTextField berangkatTime;
    private javax.swing.JButton detailButton;
    private javax.swing.JButton gerbongButton;
    private javax.swing.JTextField hargaField;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jadwalButton;
    private javax.swing.JTextField kelasField;
    private javax.swing.JButton keretaButton;
    private javax.swing.JComboBox<String> keretaCombo;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton refreshButton;
    private com.toedter.calendar.JDateChooser sampaiDate;
    private javax.swing.JTextField sampaiTime;
    private javax.swing.JTable tblData;
    private com.raven.swing.TimePickerMenu timePickerMenu1;
    private javax.swing.JButton tujuanButton;
    private javax.swing.JComboBox<String> tujuanCombo;
    private javax.swing.JButton uploadButton;
    private javax.swing.JButton userButton;
    // End of variables declaration//GEN-END:variables
}
