/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author OPR
 */
public class ConnectionProvider {
    public static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ComputerLab\\Desktop\\Inventory Management System\\DB\\Inv.db");
            System.out.println("Connection established successfully");
            return con;
        }
        catch(Exception e){
            System.out.println("CONNECTION UNSUCCESSFUL");
            return null;
        }
        
    }   
}
