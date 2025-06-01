
import DAO.ConnectionProvider;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.File;
import java.awt.Desktop;

import javax.swing.table.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author OPR
 */
public class SearchRes extends javax.swing.JFrame {

    private DefaultTableModel model;
    String URole;
    int f;
    String result;
    String path = "";
    public static int SN;

    /**
     * Creates new form SearchRes
     */
    public SearchRes() {
        initComponents();
        Color col = new Color(215, 243, 243);
        getContentPane().setBackground(col);
        tableFails.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        tableFails.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor());
        if (Home.URole.equals("Admin")) {
            btnFinish.setVisible(false);
            btnUpdate.setVisible(false);
            btnFile.setVisible(false);
        }
        SN = 0;
    }

    public SearchRes(String res) {
    result = res;
    initComponents();
    Color col = new Color(215, 243, 243);
    getContentPane().setBackground(col);
    SN = 0;

    // ✅ Define column names including SN
    String[] columnNames = {
        "S.No", "Report Date", "Failed Date", "Rectified Date", "Corrective Action Ref", "Report", "SN"
    };

    // ✅ Set a new model with 7 columns
    model = new DefaultTableModel(columnNames, 0);
    tableFails.setModel(model);

    // ✅ Set renderer/editor AFTER setting model
    tableFails.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
    tableFails.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor());

    // Hide the SN column
    tableFails.getColumnModel().getColumn(6).setMinWidth(0);
    tableFails.getColumnModel().getColumn(6).setMaxWidth(0);
    tableFails.getColumnModel().getColumn(6).setWidth(0);

    // Hide UI elements
    labD.setVisible(false);
    btnFinish.setVisible(false);
    labF.setVisible(false);
    labR.setVisible(false);
    labC.setVisible(false);
    txtD.setVisible(false);
    txtF.setVisible(false);
    txtR.setVisible(false);
    txtC.setVisible(false);
    btnFile.setVisible(false);
    btnAddhis.setVisible(false);
    btnUpdhis.setVisible(false);

    if (Home.URole.equals("Admin")) {
        labD.setVisible(false);
        labF.setVisible(false);
        labR.setVisible(false);
        labC.setVisible(false);
        btnFile.setVisible(false);
        txtD.setVisible(false);
        txtF.setVisible(false);
        txtR.setVisible(false);
        txtC.setVisible(false);
        btnAddhis.setVisible(false);
        btnUpdhis.setVisible(false);
        btnUpdate.setVisible(false);
    }

    try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from equipment");

        while (rs.next()) {
            String slno = rs.getString("slno");
            String asset = rs.getString("assetID");
            String eq = rs.getString("eqID");
            if (slno.equalsIgnoreCase(res) || asset.equalsIgnoreCase(res) || eq.equalsIgnoreCase(res)) {
                txtID.setText(rs.getString("eqID"));
                txtID.setEditable(false);
                txtName.setText(rs.getString("eqName"));
                txtName.setEditable(false);
                txtSlno.setText(rs.getString("slno"));
                txtSlno.setEditable(false);
                txtAsset.setText(rs.getString("assetID"));
                txtAsset.setEditable(false);
                txtLoc.setText(rs.getString("loc"));
                txtLoc.setEditable(false);
                txtFails.setText(rs.getString("fails"));
                txtFails.setEditable(false);
                String srv = rs.getString("srvNo");
                txtSRV.setText(srv.isEmpty() ? "-" : srv);
                txtSRV.setEditable(false);
            }
        }

        rs = st.executeQuery("select * from historyCard");
        int i = 1;
        while (rs.next()) {
            if (rs.getString("eqID").equals(txtID.getText())) {
                model.addRow(new Object[]{
                    i++,
                    rs.getString("reportDate"),
                    rs.getString("failedDate"),
                    rs.getString("rectifiedDate"),
                    rs.getString("correctiveActionRefNo"),
                    rs.getString("report"),
                    rs.getInt("SN")  // SN stored in hidden column
                });
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


    public void select() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLoc = new javax.swing.JTextField();
        txtSlno = new javax.swing.JTextField();
        txtAsset = new javax.swing.JTextField();
        txtSRV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFails = new javax.swing.JTable();
        txtFails = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labD = new javax.swing.JLabel();
        txtD = new javax.swing.JTextField();
        labF = new javax.swing.JLabel();
        txtF = new javax.swing.JTextField();
        labR = new javax.swing.JLabel();
        txtR = new javax.swing.JTextField();
        labC = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        btnAddhis = new javax.swing.JButton();
        btnUpdhis = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setText("EQUIPMENT DETAILS");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Equipment ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Serial No:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Equipment Name:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Asset ID:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Location:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("Store Ref / SRV No:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("History card of the equipment (fails):");

        txtID.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtLoc.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtLoc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtSlno.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtSlno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtSlno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlnoActionPerformed(evt);
            }
        });

        txtAsset.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtAsset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtSRV.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtSRV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tableFails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tableFails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN", "Date", "Failed On", "Rectified On", "Corrective Action Reference No.", "Report"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableFails.setRowHeight(40);
        tableFails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableFailsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableFails);

        txtFails.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtFails.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnUpdate.setBackground(new java.awt.Color(253, 202, 150));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 2, true));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labD.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labD.setText("Date");

        txtD.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        labF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labF.setText("Failed On");

        txtF.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActionPerformed(evt);
            }
        });

        labR.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labR.setText("Rectified On");

        txtR.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        labC.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        labC.setText("Corrective Action Reference No.");

        txtC.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        txtC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAddhis.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddhis.setText("ADD history card");
        btnAddhis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnAddhis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddhisActionPerformed(evt);
            }
        });

        btnUpdhis.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnUpdhis.setText("UPDATE history card");
        btnUpdhis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnUpdhis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdhisActionPerformed(evt);
            }
        });

        btnFinish.setBackground(new java.awt.Color(153, 255, 153));
        btnFinish.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        btnFinish.setText("FINISH");
        btnFinish.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 2, true));
        btnFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFinishMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFinishMouseExited(evt);
            }
        });
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        btnFile.setBackground(new java.awt.Color(153, 153, 255));
        btnFile.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnFile.setText("Upload Rpt");
        btnFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 255), 2, true));
        btnFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFileMouseExited(evt);
            }
        });
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtLoc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSRV))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAsset))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSlno, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFails, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(labD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAddhis, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(labF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(btnUpdhis, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 832, Short.MAX_VALUE)
                                        .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1639, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(162, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(774, 774, 774)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSlno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSRV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labD)
                    .addComponent(txtD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labF)
                    .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labR)
                    .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labC)
                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddhis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdhis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtSlnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlnoActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        JOptionPane.showMessageDialog(null, "The fields are editable now!");
        tableFails.setEnabled(true);
        labD.setVisible(true);
        labF.setVisible(true);
        labR.setVisible(true);
        labC.setVisible(true);
        btnFile.setVisible(true);
        txtD.setVisible(true);
        txtF.setVisible(true);
        txtR.setVisible(true);
        txtC.setVisible(true);
        btnAddhis.setVisible(true);
        btnAddhis.setEnabled(true);
        btnUpdhis.setVisible(true);
        btnUpdhis.setEnabled(false);
        txtSRV.setEditable(true);
        txtName.setEditable(true);
        txtSlno.setEditable(true);
        txtAsset.setEditable(true);
        txtLoc.setEditable(true);
        txtFails.setEditable(true);
        btnFinish.setVisible(true);
        btnUpdate.setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        new Equipment().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed
    /*
    private void btnUpdhisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdhisActionPerformed
        String date=txtD.getText();
        String failed=txtF.getText();
        String rect=txtR.getText();
        String act=txtC.getText();
        if(date.equals("")||failed.equals("")||rect.equals("")||act.equals("")){
            JOptionPane.showMessageDialog(null,"All fields are required!!!");
        }
        else{
            try{
                Connection con=ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("update historyCard set reportDate=?,failedDate=?,rectifiedDate=?,correctiveActionRefNo=? where SN=?");
                if(f==0)
                {
                    ps.setString(1,date);
                    ps.setString(2,failed);
                    ps.setString(3,rect);
                    ps.setString(4,act);
                    String sn=SN+"";
                    ps.setString(5,sn);
                    ps.executeUpdate();
                }
                else{
                    ps=con.prepareStatement("update historyCard set reportDate=?,failedDate=?,rectifiedDate=?,correctiveActionRefNo=?, report=? where SN=?");
                    ps.setString(1,date);
                    ps.setString(2,failed);
                    ps.setString(3,rect);
                    ps.setString(4,act);
                    String sn=SN+"";
                    ps.setString(5,path);
                    ps.setString(6,sn);
                    ps.executeUpdate();        
                }
                JOptionPane.showMessageDialog(null,"Update successful!");
                setVisible(false);
                new SearchRes(result).setVisible(true);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnUpdhisActionPerformed
    */
    private void btnUpdhisActionPerformed(java.awt.event.ActionEvent evt) {
        String date = txtD.getText();
        String failed = txtF.getText();
        String rect = txtR.getText();
        String act = txtC.getText();

        if (date.isEmpty() || failed.isEmpty() || rect.isEmpty() || act.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }

        // Get selected row from table
        int selectedRow = tableFails.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to update.");
            return;
        }

        // Get SN from hidden column
        DefaultTableModel model = (DefaultTableModel) tableFails.getModel();
        String sn = model.getValueAt(selectedRow, 6).toString(); // Column 6 = SN

        try {
            Connection con = ConnectionProvider.getCon();  // Ensure valid connection
            PreparedStatement ps;
            int rows;

            System.out.println("Updating historyCard with SN: " + sn);
            System.out.println("f = " + f);

            if (f == 0) {
                String sql = "UPDATE historyCard SET reportDate=?, failedDate=?, rectifiedDate=?, correctiveActionRefNo=? WHERE SN=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, date);
                ps.setString(2, failed);
                ps.setString(3, rect);
                ps.setString(4, act);
                ps.setString(5, sn);
            } else {
                String sql = "UPDATE historyCard SET reportDate=?, failedDate=?, rectifiedDate=?, correctiveActionRefNo=?, report=? WHERE SN=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, date);
                ps.setString(2, failed);
                ps.setString(3, rect);
                ps.setString(4, act);
                ps.setString(5, path); // Ensure path is valid
                ps.setString(6, sn);
            }

            rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Update successful!");
                setVisible(false);
                new SearchRes(result).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found. SN: " + sn);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }


    private void tableFailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFailsMouseClicked
        int index = tableFails.getSelectedRow();
        TableModel model = tableFails.getModel();
        String id = model.getValueAt(index, 0).toString();

        SN = SN + Integer.parseInt(id) + 1;
        String date = model.getValueAt(index, 1).toString();
        String failed = model.getValueAt(index, 2).toString();
        String rect = model.getValueAt(index, 3).toString();
        String act = model.getValueAt(index, 4).toString();
        txtD.setText(date);
        txtF.setText(failed);
        txtR.setText(rect);
        txtC.setText(act);

        btnAddhis.setEnabled(false);
        btnUpdhis.setEnabled(true);

    }//GEN-LAST:event_tableFailsMouseClicked

    private void btnAddhisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddhisActionPerformed
        String date = txtD.getText();
        String failed = txtF.getText();
        String rect = txtR.getText();
        String act = txtC.getText();
        if (date.equals("") || failed.equals("") || rect.equals("") || act.equals("") || path.equals("")) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into historyCard (ID, reportDate, failedDate, rectifiedDate, correctiveActionRefNo,report) values (?,?,?,?,?,?)");
                ps.setString(1, txtID.getText());
                ps.setString(2, date);
                ps.setString(3, failed);
                ps.setString(4, rect);
                ps.setString(5, act);
                ps.setString(6, path);
                ps.executeUpdate();
                int i = Integer.parseInt(txtFails.getText());
                i++;
                String f1 = i + "";
                PreparedStatement p = con.prepareStatement("update equipment set fails=? where eqID=?");
                System.out.println(f1);
                p.setString(1, f1);
                p.setString(2, result);
                p.executeUpdate();
                JOptionPane.showMessageDialog(null, "History added successfully!");
                setVisible(false);
                new SearchRes(result).setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnAddhisActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed

    }//GEN-LAST:event_btnFinishActionPerformed

    private void tableFailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFailsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tableFailsMouseEntered

    private void txtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFActionPerformed

    private void btnFinishMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseEntered
        btnFinish.setBackground(new Color(51, 153, 0));
        btnFinish.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnFinishMouseEntered

    private void btnFinishMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinishMouseExited
        btnFinish.setBackground(new Color(153, 255, 153));
        btnFinish.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnFinishMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setBackground(new Color(255, 153, 51));
        btnUpdate.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(new Color(253, 202, 150));
        btnUpdate.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(new Color(255, 51, 51));
        btnBack.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(new Color(255, 102, 102));
        btnBack.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFileMouseEntered

    private void btnFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFileMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFileMouseExited

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        JFileChooser filechooser = new JFileChooser();
//        FileNameExtensionFilter filter=new FileNameExtensionFilter("Image","jpg","png","gif","jpeg");
//        filechooser.setFileFilter(filter);
        int returnVal = filechooser.showOpenDialog(btnFile);
        if (returnVal == filechooser.APPROVE_OPTION) {
            String filepath = filechooser.getSelectedFile().getPath();
            System.out.println("Selected File : " + filepath);
            JOptionPane.showMessageDialog(null, "Report Uploaded successfully!");
            path = filepath;
        } else
            System.out.println("File upload canceled");
    }//GEN-LAST:event_btnFileActionPerformed

//    private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
//        DefaultTableModel model=(DefaultTableModel) tableFails.getModel();
//        try{
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select * from historyCard where ID='"+txtID);
//            int i=1;
//            while(rs.next()){
//                model.addRow(new Object[]{i++,rs.getString("date"),rs.getString("failedOn"),rs.getString("rectifiedOn"),rs.getString("correctiveActionRefNo")});
//            }
//        }
//         catch(Exception e){
//                JOptionPane.showMessageDialog(null,e);
//        }
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddhis;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdhis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labC;
    private javax.swing.JLabel labD;
    private javax.swing.JLabel labF;
    private javax.swing.JLabel labR;
    private javax.swing.JTable tableFails;
    private javax.swing.JTextField txtAsset;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtD;
    private javax.swing.JTextField txtF;
    private javax.swing.JTextField txtFails;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLoc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtR;
    private javax.swing.JTextField txtSRV;
    private javax.swing.JTextField txtSlno;
    // End of variables declaration//GEN-END:variables
}
