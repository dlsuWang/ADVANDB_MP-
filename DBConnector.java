/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DBConnector {

    private Connection c;
    private Statement st;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private long startTime=-999, stopTime=-999;
    private int numoftuples = 0;
    
    public DBConnector(){
        c = new Connector().getConnector();
    }
    
    public Connection getConnection(){
        return c;
    }
    
    public ResultSet getResultSet(String query){
        System.out.println(query);
        System.out.println("-------");
       try{
            startTime = System.nanoTime();
                st = c.createStatement();
                rs = st.executeQuery(query);
            stopTime = System.nanoTime();  
           
            numoftuples = 0;
            while (rs.next()) {
                numoftuples++;
            }
            rs.beforeFirst(); //cause we iterated until the end, we need to put the cursor back to the first record.
            
            return rs;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Cannot create statement","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
        }; 
        return null;
    }
    
    public ResultSet getResultSetWithCreateView(ArrayList<String> query){
        
        for(int i = 0; i<query.size(); i++)
            System.out.println(query.get(i));
        System.out.println("-------");
        
        int mid = query.size()/2; //first half is create, second half is drop, mid is the projection
       try{
            for(int i = 0; i<mid; i++){
                try{
                    st = c.createStatement();
                    st.execute(query.get(i)); //first is create
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Cannot create statement in for loop","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
                };
            }
            startTime = System.nanoTime();
                st = c.createStatement();
                rs = st.executeQuery(query.get(mid));
            stopTime = System.nanoTime();  
            for(int i = mid+1; i<query.size(); i++){
                try{
                    st = c.createStatement();
                    st.execute(query.get(i)); //first is create
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Cannot create statement in for loop","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
                };
            }
           
            numoftuples = 0;
            while (rs.next()) {
                numoftuples++;
            }
            rs.beforeFirst(); //cause we iterated until the end, we need to put the cursor back to the first record.
            
            return rs;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Cannot create statement","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
        }; 
        return null;
    }
    
    public double getExecutionTime(){
        return (double)(stopTime - startTime) / 1000000000.0;
    }
    
    public int getNumberOfTuples(){
        return numoftuples;
    }
}
