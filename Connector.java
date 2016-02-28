/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikko
 */
public class Connector {
    
    private final String url = "jdbc:mysql://localhost/db_hpq";
    private final String user = "root"; 
    private final String pass = "";
    private Connection c;

    
    public Connection getConnector(){
        try{
            c= DriverManager.getConnection (url, user, pass);
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Cannot establish connection to the database","ERROR", JOptionPane.ERROR_MESSAGE); 
            System.out.println("**Entered DBConnector error**");
        };
        
        return c;
    }
}
