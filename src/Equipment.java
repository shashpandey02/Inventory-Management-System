/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OPR
 */
import DAO.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Equipment extends javax.swing.JFrame {
String URole;
    /**
     * Creates new form Equipment
     */
    public Equipment(String role) {
        initComponents();
        Color col=new Color(215,243,243);
        getContentPane().setBackground(col);
        URole=role;
        if(role.equals("Admin"))
                btnAdd.setVisible(false);
    }
    
    public Equipment() {
        initComponents();
        Color col=new Color(215,243,243);
        getContentPane().setBackground(col);
        if(Home.URole.equals("Admin"))
            btnAdd.setVisible(false);
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
        btnAsset = new javax.swing.JButton();
        btnLoc = new javax.swing.JButton();
        btnSlno = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnOther = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EQUIPMENT MANAGEMENT");

        btnAsset.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnAsset.setText("Search by Equipment ID");
        btnAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssetActionPerformed(evt);
            }
        });

        btnLoc.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnLoc.setText("Search by Location");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnSlno.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnSlno.setText("Search by Serial Number");
        btnSlno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlnoActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnAdd.setText("Add Equipment");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnOther.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnOther.setText("Enter Custom Query");
        btnOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 197, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOther, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSlno, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSlno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(btnOther, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnBack)
                .addGap(123, 123, 123))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssetActionPerformed
        String a=JOptionPane.showInputDialog("Enter the Equipment ID");
        while(a.equals("")){
            JOptionPane.showMessageDialog(null,"Empty Value!");
            a=JOptionPane.showInputDialog("Enter the Equipment ID");
        }
        if(!a.equals("")){
            try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from equipment");
                int f=0;
                while(rs.next()){
                    String asset=rs.getString("eqID");
                    if(asset.equals(a)){
                        f=1;
                        
                        setVisible(false);
                        new SearchRes(a).setVisible(true);//opening a new window
                    }
                }
                if(f==0)
                    JOptionPane.showMessageDialog(null,"Equipment doesn't exist!");
               
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnAssetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        setVisible(false);
        new AddEquip().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        setVisible(false);
        new Home(Home.URole).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        String a=JOptionPane.showInputDialog("Enter the Location");
        while(a.equals("")){
            JOptionPane.showMessageDialog(null,"Empty Value!");
            a=JOptionPane.showInputDialog("Enter the Location");
        }
        if(!a.equals("")){
            setVisible(false);
            new LocRes(a).setVisible(true);
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnSlnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlnoActionPerformed
        String a=JOptionPane.showInputDialog("Enter the Serial Number");
        while(a.equals("")){
            JOptionPane.showMessageDialog(null,"Empty Value!");
            a=JOptionPane.showInputDialog("Enter the Serial Number");
        }
        if(!a.equals("")){
            try{
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from equipment");
                int f=0;
                while(rs.next()){
                    String asset=rs.getString("slno");
                    if(asset.equals(a)){
                        f=1;
//                        con.close();
//                        st.close();
                        setVisible(false);
                        new SearchRes(a).setVisible(true);//opening a new window
                    }
                    
                }
               
                if(f==0)
                    JOptionPane.showMessageDialog(null,"Equipment doesn't exist!");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnSlnoActionPerformed

    private void btnOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherActionPerformed
        String a=JOptionPane.showInputDialog("Enter your Query");
        while(a.equals("")){
            JOptionPane.showMessageDialog(null,"Empty Value!");
            a=JOptionPane.showInputDialog("Enter your Query");
        }
    }//GEN-LAST:event_btnOtherActionPerformed

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
            java.util.logging.Logger.getLogger(Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Equipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Equipment().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAsset;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnOther;
    private javax.swing.JButton btnSlno;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
