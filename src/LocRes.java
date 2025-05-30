
import DAO.ConnectionProvider;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OPR
 */
public class LocRes extends javax.swing.JFrame {
String loc;
    /**
     * Creates new form LocRes
     */

 public LocRes() {
        initComponents();
        Color col=new Color(215,243,243);
        getContentPane().setBackground(col);
}
 
    public LocRes(String l,int k) {
        initComponents();
        Color col=new Color(215,243,243);
        getContentPane().setBackground(col);
        loc=l;
        labLoc.setText(loc);
        
        try{
                
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                DefaultTableModel model=(DefaultTableModel) tableLoc.getModel();
                ResultSet rs=st.executeQuery("select * from SwPkg");
                model.addColumn("Software ID");
                model.addColumn("Software Name");
                int i=1; int f=0;
                while(rs.next()){
                    
                    
                    
                    if(loc.equalsIgnoreCase(rs.getString("loc")))
                        {
                            model.addRow(new Object[]{i++,rs.getString("swID"),rs.getString("name")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    
                    else if(loc.contains("spare")&&loc.contains("tele"))
                    {
                        if(rs.getString("loc").contains("spare")&&rs.getString("loc").contains("tele"))
                        {
                            model.addRow(new Object[]{i++,rs.getString("swID"),rs.getString("name")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    }
                     if(rs.getString("loc").substring(0,3).equalsIgnoreCase(loc.substring(0,3)))
                    {
                        model.addRow(new Object[]{i++,rs.getString("swID"),rs.getString("name")});
                        f=1;
//                        SN=rs.getInt("SN");
                    }
                }
                if(f==0){
                    JOptionPane.showMessageDialog(null, "No registered packages in this device");
                    setVisible(false);
                    new Equipment().setVisible(true);
                }    
//                SN=SN-i;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        
    }
    
    public LocRes(String l) {
        initComponents();
        loc=l;
        labLoc.setText(loc);
        
        try{
                
                Connection con=ConnectionProvider.getCon();
                Statement st=con.createStatement();
                DefaultTableModel model=(DefaultTableModel) tableLoc.getModel();
                ResultSet rs=st.executeQuery("select * from equipment");
                model.addColumn("Equipment ID");
                model.addColumn("Equipment Name");
                int i=1; int f=0;
                while(rs.next()){
                    
                    
                    
                    if(loc.equalsIgnoreCase(rs.getString("loc")))
                        {
                            model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    
                    else if(loc.contains("spare")&&loc.contains("tele"))
                    {
                        if(rs.getString("loc").contains("spare")&&rs.getString("loc").contains("tele"))
                        {
                            model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                            f=1;
//                        SN=rs.getInt("SN");
                        }
                    }
                     if(rs.getString("loc").substring(0,3).equalsIgnoreCase(loc.substring(0,3)))
                    {
                        model.addRow(new Object[]{i++,rs.getString("eqID"),rs.getString("eqName")});
                        f=1;
//                        SN=rs.getInt("SN");
                    }
                }
                if(f==0){
                    JOptionPane.showMessageDialog(null, "No equipments in this location");
                    setVisible(false);
                    new Equipment().setVisible(true);
                }    
//                SN=SN-i;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
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
        labLoc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLoc = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel1.setText("RESULTS FOR LOCATION :");

        labLoc.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N

        tableLoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tableLoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SN"
            }
        ));
        tableLoc.setRowHeight(35);
        tableLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLoc);

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setText("(Single-click to view the detailed description of an equipment)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(labLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(601, 601, 601))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(727, 727, 727))))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(103, 103, 103))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocMouseClicked
        int index=tableLoc.getSelectedRow();
        TableModel model= tableLoc.getModel();
//        String sn=model.getValueAt(index,0).toString();
        
        
        String id=model.getValueAt(index, 1).toString();
//        String name=model.getValueAt(index, 2).toString();
       
        setVisible(false);
        new SearchRes(id).setVisible(true);
    }//GEN-LAST:event_tableLocMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setVisible(false);
        new Equipment().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocRes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocRes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labLoc;
    private javax.swing.JTable tableLoc;
    // End of variables declaration//GEN-END:variables
}
