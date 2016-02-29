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
    
    public ResultSet getResultSetCreateDropFunction(ArrayList<String> query){
        
        for(int i = 0; i<query.size(); i++)
            System.out.println(query.get(i));
        System.out.println("-------");
        
        int mid = query.size()/2; //first half is create, second half is drop, mid is the projection
       try{
            for(int i = 0; i<mid; i++){
                try{
                    st = c.createStatement();
                    st.execute(query.get(i)); //first half are the create functions
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
                    st.execute(query.get(i)); //second half are the drop functions
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
    
    public ResultSet getResultSetStoredProcedure(ArrayList<String> query) throws SQLException
    {
        for(int i = 0; i < query.size() ; i++)
            System.out.println(query.get(i));
        System.out.println("-------");
        
        //execute queries
        // for dropping of procedure
        try{
                    st = c.createStatement();
                    st.execute(query.get(0)); //first half are the create functions
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"DROP PROCEDURE failed! Procedure may not exist!","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
                };
                
        // for create procedure
        try{
                    st = c.createStatement();
                    st.execute(query.get(1)); //first half are the create functions
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"CREATE PROCEDURE failed! Procedure may already exist!","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
                };
                
        // for call procedure
        try{     
            startTime = System.nanoTime();
                st = c.createStatement();
                rs = st.executeQuery(query.get(2));
            stopTime = System.nanoTime();  
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"CALL PROCEDURE failed! Procedure may not exist!","ERROR", JOptionPane.ERROR_MESSAGE); 
               System.out.println("**Entered getResultSet error**");
                };
                
                numoftuples = 0;
            while (rs.next()) {
                numoftuples++;
            }
            rs.beforeFirst(); //cause we iterated until the end, we need to put the cursor back to the first record.
            
            return rs;
        
    }
    
    public double getExecutionTime(){
        return (double)(stopTime - startTime) / 1000000000.0;
    }
    
    public int getNumberOfTuples(){
        return numoftuples;
    }
}
