/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.util.ArrayList;

/**
 *
 * @author Nikko
 */
public class Query6 {
    
    private String normalQuery, heuristicsQuery, indexQuery, storedProcedureQuery;
    private ArrayList<String> execQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    private String append;
    
    public Query6(int sugarcane, int palay, int corn, int others){
        NormalQuery(sugarcane,palay,corn,others);
        ViewsQuery(sugarcane,palay,corn,others);
        StoredProcedureQuery(sugarcane,palay,corn,others);
    }
    
    public void NormalQuery(int sugarcane, int palay, int corn, int others){
        normalQuery = "SELECT m.id, m.memno, c.croptype, m.educal, h.water\n" +
                      "FROM hpq_crop c, hpq_mem m, hpq_hh h\n" +
                      "WHERE c.hpq_hh_id = m.id AND c.hpq_hh_id = h.id AND  \n" +
                      " m.educal > 22 AND m.reln = 1 AND h.water_dist = 3 AND (h.water = 1 OR h.water = 2 OR h.water = 3 OR h.water = 4 OR h.water = 5 OR h.water = 6)";
        if(sugarcane == 1) normalQuery +=" AND c.croptype = 1";
        if(palay == 1) normalQuery +=" AND c.croptype = 2";
        if(corn == 1) normalQuery +=" AND c.croptype = 3";
        if(others == 1) normalQuery +=" AND c.croptype = 4";

        normalQuery+= ";\n";
    }

    public void HeuristicsQuery(int sugarcane, int palay, int corn, int others) {
    }

    public void IndexQuery(int sugarcane, int palay, int corn, int others) {
    }

    public void ViewsQuery(int sugarcane, int palay, int corn, int others) {
        String create, create2 ,query, drop1, drop2;
        
        create = "CREATE VIEW hview AS\n" +
                 "SELECT id, water\n" +"FROM hpq_hh\n" +
                 "WHERE water_dist = 3 AND (water = 1 OR water = 2 OR water = 3 OR water = 4 OR water = 5 OR water = 6);";
        create2 = "CREATE VIEW mview AS\n" +
                  "SELECT m.id, m.memno, m.educal, h.water\n" +
                  "FROM hpq_mem m, hview h\n" +
                  "WHERE h.id = m.id AND m.educal > 22 AND m.reln = 1;";
        
        query =  "\nSELECT m.id, m.memno, c.croptype, m.educal, m.water\n" +
                 "FROM hpq_crop c, mview m\n" +"WHERE c.hpq_hh_id = m.id";
        
        if(sugarcane == 1) query +=" AND croptype = 1 ";
        if(palay == 1) query +=" AND croptype = 2 ";
        if(corn == 1) query +=" AND croptype = 3 ";
        if(others == 1) query +=" AND croptype = 4 ";
        
        query +=";\n"; 
        drop1 = "DROP VIEW mview;\n";
        drop2 = "DROP VIEW hview;";
        
        execQuery.add(create);
        execQuery.add(create2);
        execQuery.add(query);
        execQuery.add(drop1);
        execQuery.add(drop2);
        
    }

    public void StoredProcedureQuery(int sugarcane, int palay, int corn, int others) {
        NormalQuery(sugarcane,palay,corn,others);
        spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery6;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery6()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery6();");
    }

    public String getNormalQuery() {
        return normalQuery;
    }

    public String getIndexQuery() {
        return indexQuery;
    }

    public String getHeuristicsQuery() {
        return heuristicsQuery;
    }

    public ArrayList<String> getStoredProcedureQuery() {
        return spQuery;
    }

    public ArrayList<String> getQueryWithCreateDropFunction() {
        return execQuery;
    }
    
}
