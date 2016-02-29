/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.sql.*;

/**
 *
 * @author Nikko
 */
public class Controller {
    
    ResultSetMetaData rsmd;
    ResultSet rs;
    DBConnector dbc;
    MainFrame mf;
    
    public Controller(MainFrame mf){
        this.mf = mf;
        dbc = new DBConnector();
    }
    
    /* Last Parameter of every LoadQueryRS is 
        1 - Normal Query
        2 - Heuristics Query
        3 - Index Query
        4 - Views Query
        5 - Stored Procedure Query
    */
    public void loadQuery1RS(int sch_type, int sex, int sss_ind, int variation){
        Query1 query = new Query1(sch_type, sex, sss_ind);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery2RS(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11, int variation){
        Query2 query = new Query2(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery3RS(int sex, int educ, int reg, int last, int job, int work, int death, int variation){
        Query3 query = new Query3(sex,educ,reg,last,job,work,death);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery4RS(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others, int variation){
        Query4 query = new Query4(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery5RS(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int variation){
        Query5 query = new Query5(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery6RS(int sugarcane, int palay, int corn, int others, int variation){
        Query6 query = new Query6(sugarcane,palay,corn,others);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
    public void loadQuery7RS(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount, int variation){
        Query7 query = new Query7(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        if(variation == 1) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        else if(variation == 2) mf.sendRSToTable(dbc.getResultSet(query.getHeuristicsQuery()));
        else if(variation == 3) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("index")));
        else if(variation == 4) mf.sendRSToTable(dbc.getResultSetCreateDropFunction(query.getQueryWithCreateDropFunction("view")));
        else if(variation == 5) mf.sendRSToTable(dbc.getResultSet(query.getNormalQuery()));
        
        mf.postExecutionTimeAndTupleVal(dbc.getExecutionTime(), dbc.getNumberOfTuples());
    }
}