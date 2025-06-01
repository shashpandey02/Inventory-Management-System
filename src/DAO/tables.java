/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author OPR
 */
public class tables {
    
    public static void main(String[]args){
        Connection con=null;
        Statement st=null;
        try{
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            
            st.executeUpdate("create table if not exists appuser(appuser_pk INTEGER PRIMARY KEY AUTOINCREMENT, userRole varchar(50), name varchar(200), mobileNo varchar(50), username varchar(200), password varchar(50), address varchar(200), status varchar(50))");
            st.executeUpdate("insert into appuser(userRole, name, mobileNo, username, password, address, status) values ('superadmin','Shashwat Pandey','9335484502', 'shash02', '12345', 'Lucknow', 'Active')");
            st.executeUpdate("create table if not exists equipment(assetID INTEGER PRIMARY KEY AUTOINCREMENT, slno varchar(100), eqID TEXT, eqName varchar(200), loc varchar(50),srvNo TEXT, fails int)");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS historyCard (SN INTEGER PRIMARY KEY AUTOINCREMENT, eqID TEXT, reportDate TEXT, failedDate TEXT, rectifiedDate TEXT, correctiveActionRefNo TEXT, report)");
//            st.executeUpdate("insert into historyCard(ID, reportDate, failedDate, rectifiedDate, correctiveActionRefNo) values ('NOP/LGS/STC/01','02/11/2015','02/11/2015', '02/11/2015', 'System Reset')");
//            st.executeUpdate("insert into historyCard(ID, reportDate, failedDate, rectifiedDate, correctiveActionRefNo) values ('NOP/LGS/STC/01','20/03/2019','20/03/2019', '21/03/2019', 'Report attached')");
//            st.executeUpdate("insert into historyCard(ID, reportDate, failedDate, rectifiedDate, correctiveActionRefNo) values ('NOP/LGS/STC/01','11/10/2021','10/10/2021', '11/10/2021', 'Report attached (preventive maintenance)')");
//            st.executeUpdate("insert into equipment(ID, slno, eqID, eqName, loc, srvNo, fails) values ('A00020130592','C1954Y1','NOP/LGS/STC/01', 'Station Computer-01 DELL-T5600', 'TELEMETRY', '-', '3')");
           
                
                
               
            JOptionPane.showMessageDialog(null, "Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                con.close();
                st.close();
            }
            catch(Exception e){}
        }
    }
}
