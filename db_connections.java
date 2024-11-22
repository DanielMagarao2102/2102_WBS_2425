/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaito
 */
public class db_connections {
    private static String url = "jdbc:mysql://localhost:3306/wbs";
    private static String username = "root";
    private static String password = "";
    
    private static Connection conn;
    private static db_connections db;
    
public db_connections() {
    conn = null;
    try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(db_connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn = DriverManager.getConnection(url, username, password);
        JOptionPane.showMessageDialog(null, "Successful!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Failed: " + e.getMessage());
    }
}



public static db_connections getDBConnection(){
    if(db == null){
        db = new db_connections();
    }
    return db;
}

public Connection getConnection(){
    return conn;
}
public static void main(String[] args){
    
}  
}
