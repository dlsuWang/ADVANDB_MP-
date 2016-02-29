/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.util.*;

/**
 *
 * @author Nikko
 */
public class Query1{
    
    private String normalQuery, heuristicsQuery, indexSql, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private ArrayList<String> indexQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
 private String append;
    
    public Query1(int sch_type, int sex, int sss_ind){
        NormalQuery(sch_type,sex,sss_ind);
        ViewsQuery(sch_type,sex,sss_ind);
        IndexQuery(sch_type,sex,sss_ind);
        StoredProcedureQuery(sch_type,sex,sss_ind);
    }
    
    public void NormalQuery(int sch_type, int sex, int sss_ind){
        normalQuery = "SELECT id, memno, sex, occup, sch_type, indust, jstatus, educal, sss_ind\n"
                +"FROM hpq_mem	\n" 
                +"WHERE occup IS NOT NULL AND jstatus = 2 ";
        if(sch_type == 1) normalQuery +=" AND sch_type = 1 ";
        else if(sch_type == 2) normalQuery +=" AND sch_type = 2 ";
        else if(sch_type == 3) normalQuery +=" AND (sch_type = 1 OR sch_type = 2) ";
        
        if(sex == 1)normalQuery +=" AND sex = 1 ";
        else if(sex == 2) normalQuery +=" AND sex = 2 ";
        else if(sex == 3) normalQuery +=" AND (sex = 1 OR sex = 2) ";
        
        if(sss_ind == 1)normalQuery +=" AND sss_ind = 1 ";
        else if(sss_ind == 2) normalQuery +=" AND sss_ind = 2 ";
        else if(sss_ind == 3) normalQuery +=" AND sss_ind = 3 ";
        else if(sss_ind == 4) normalQuery +=" AND sss_ind = 4 ";
    }

    public void IndexQuery(int sch_type, int sex, int sss_ind){
        
        indexQuery.add("Create Index indexName on hpq_mem(sch_type, sex, sss_ind);");
        
        indexQuery.add(normalQuery);
        
        indexQuery.add("Alter Table hpq_mem Drop Index indexName;");
    }
    
    
    public void HeuristicsQuery(int sch_type, int sex, int sss_ind) {
    }

    public void ViewsQuery(int sch_type, int sex, int sss_ind) {
        String create, query, drop;
        
        create = "CREATE VIEW v_occup AS\n" 
                +"(SELECT id, memno, sex, occup, sch_type, indust, jstatus, educal, sss_ind\n" 
                +"FROM hpq_mem	\n" 
                +"WHERE occup IS NOT NULL AND jstatus = 2);\n" 
                +"\n";
        query =  "SELECT * FROM v_occup WHERE id IS NOT NULL ";
        
        if(sch_type == 1) query +=" AND sch_type = 1 ";
        else if(sch_type == 2) query +=" AND sch_type = 2 ";
        else if(sch_type == 3) query +=" AND (sch_type = 1 OR sch_type = 2) ";
        
        if(sex == 1)query +=" AND sex = 1 ";
        else if(sex == 2) query +=" AND sex = 2 ";
        else if(sex == 3) query +=" AND (sex = 1 OR sex = 2) ";
        
        if(sss_ind == 1)query +=" AND sss_ind = 1 ";
        else if(sss_ind == 2) query +=" AND sss_ind = 2 ";
        else if(sss_ind == 3) query +=" AND sss_ind = 3 ";
        else if(sss_ind == 4) query +=" AND sss_ind = 4 ";
        
        query +=";\n"; 
        drop = "DROP VIEW v_occup;";
        
        viewQuery.add(create);
        viewQuery.add(query);
        viewQuery.add(drop);
    }

    public void StoredProcedureQuery(int sch_type, int sex, int sss_ind) {
	
	NormalQuery(sch_type,sex,sss_ind);
	spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery1;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery1()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery1();");
	
	
    }

    public String getNormalQuery() {
        return normalQuery;
    }

    public String getHeuristicsQuery() {
        return heuristicsQuery;
    }

    public ArrayList<String> getStoredProcedureQuery() {
        return spQuery;
    }

    public ArrayList<String> getQueryWithCreateDropFunction(String keyword) {
        
        if(keyword.equals("view"))
        {
            return viewQuery;
        }
        else
        {
            return indexQuery;
        }   
    }
    
}
