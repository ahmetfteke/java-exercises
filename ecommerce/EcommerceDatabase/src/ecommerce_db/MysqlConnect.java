/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce_db;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author tq
 */
public class MysqlConnect {
    Connection conn = null;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/commerce";
    
    public static Connection ConnectDB() throws ClassNotFoundException{
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
