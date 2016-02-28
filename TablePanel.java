/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Nikko
 */
public class TablePanel extends JPanel{
    
    private JTable tableData;
    private DefaultTableModel dtModel = null;
    private Vector<String> columnNames = new Vector<String>();
    private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    private JScrollPane scrollTable;
    private DBConnector dbc;
    private ResultSet rs;
    private ResultSetMetaData metaData = null;
    private String[] cols = {"Hello","Hi","O Elo", "Bonjour"}; 
    private Object[][] rows = {};
    private Controller c;
    
    public TablePanel(Controller c){
        this.c = c;
        createTable();
    }
    
    public void createTable(){
        this.setLayout(null);
        this.setBackground(Color.decode("#8c9bab"));
        if(metaData != null){
             // dtModel = new DefaultTableModel(data,columnNames);
            tableData = new JTable(dtModel); //tableData = new JTable(dtModel);
        }else{
            dtModel = new DefaultTableModel(rows,cols);
            tableData = new JTable(dtModel);
        }
        tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //cells will not resize
        tableData.setLayout(new BorderLayout());
        scrollTable = new JScrollPane(tableData,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //scrollTable.setViewportView(tableData); //we use setViewportView to get the column names cause if we use ScrollPane, the headers will disappear.
        scrollTable.setBounds(2,2,555,505);
        this.add(scrollTable);
    }
    
    /*from http://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset 
        This function puts all data of the query to the JTable
    */
    public DefaultTableModel buildTableModel(ResultSet rs){
        try {
            metaData = rs.getMetaData();
            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            
        return new DefaultTableModel(data, columnNames);
        } catch(SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }

    public void setResultSet(ResultSet rs) {
        this.rs = rs;
        //dtModel = null;
        //createTable();
        //dtModel.fireTableStructureChanged();
        
        this.removeAll();   //Table will hang after populating table, so u need to refresh by removing all then repainting and revalidating
        dtModel = buildTableModel(rs);
        createTable();
        dtModel.fireTableStructureChanged();
        repaint();
        revalidate();
    }
    
}
