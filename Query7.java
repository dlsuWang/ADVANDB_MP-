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
public class Query7 {
    private String normalQuery, heuristicsQuery, indexQuery, storedProcedureQuery;
    private ArrayList<String> execQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    private String append;
    
    public Query7(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount){
        NormalQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        ViewsQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        StoredProcedureQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
    }
    
    public void NormalQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount){
        normalQuery = "SELECT d.mdeady_o, h.totin\n" +
                        "FROM hpq_hh h, hpq_death d, hpq_aquaequip ae, hpq_aquani an\n" +
                        "WHERE h.id =d.hpq_hh_id and h.id = ae.hpq_hh_id and h.id = an.hpq_hh_id\n" +
                        "GROUP BY ae.aquaequiptype\n" +
                        "HAVING ae.aquaequiptype IS NOT NULL";
        normalQuery += " AND sum(an.aquani_vol) >" + amount;
        
        if(ae1 == 1) normalQuery +=" AND ae.aquaequiptype = 1";if(ae5 == 1) normalQuery +=" AND ae.aquaequiptype = 5";
        if(ae2 == 1) normalQuery +=" AND ae.aquaequiptype = 2";if(ae6 == 1) normalQuery +=" AND ae.aquaequiptype = 6";
        if(ae3 == 1) normalQuery +=" AND ae.aquaequiptype = 3";if(ae7 == 1) normalQuery +=" AND ae.aquaequiptype = 7";
        if(ae4 == 1) normalQuery +=" AND ae.aquaequiptype = 4";if(ae8 == 1) normalQuery +=" AND ae.aquaequiptype = 8";

        normalQuery +=";\n";
    }

    public void HeuristicsQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount) {
    }

    public void IndexQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount) {
    }

    public void ViewsQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount) {
        String create, create2, create3,query, drop1, drop2, drop3;
        
        create = "CREATE VIEW hview AS\n" +
                 "SELECT h.id, h.totin\n" +
                 "FROM hpq_hh h, hpq_death d, hpq_aquaequip ae, hpq_aquani an\n" +
                 "WHERE h.id = d.hpq_hh_id and h.id = ae.hpq_hh_id and h.id = an.hpq_hh_id;";
        create2 = "\nCREATE VIEW dview AS\n" +
                  "SELECT h.id,  d.mdeady_o\n" +
                  "FROM hview h, hpq_death d\n" +
                  "WHERE h.id = d.hpq_hh_id;";
        create3 = "\nCREATE VIEW aview AS\n" +
                  "SELECT h.id, d.mdeady_o,  ae.aquaequiptype, an.aquani_vol\n" +
                  "FROM hview h, hpq_aquaequip ae, hpq_aquani an, dview d\n" +
                  "WHERE  h.id = d.id AND h.id = an.hpq_hh_id AND h.id = ae.hpq_hh_id\n" +
                  "GROUP BY ae.aquaequiptype;";
        query =  "\nSELECT d.mdeady_o, h.totin\n" +
                 "FROM  dview d , aview a, hpq_hh h\n" +
                 "WHERE h.id = d.id AND h.id = a.id AND a.id = d.id\n" +
                 "GROUP BY a.aquaequiptype\n" +
                 "HAVING a.aquaequiptype IS NOT NULL";
        
        query += " AND sum(a.aquani_vol) > " + amount;
        if(ae1 == 1) query +=" AND a.aquaequiptype = 1";if(ae5 == 1) query +=" AND a.aquaequiptype = 5";
        if(ae2 == 1) query +=" AND a.aquaequiptype = 2";if(ae6 == 1) query +=" AND a.aquaequiptype = 6";
        if(ae3 == 1) query +=" AND a.aquaequiptype = 3";if(ae7 == 1) query +=" AND a.aquaequiptype = 7";
        if(ae4 == 1) query +=" AND a.aquaequiptype = 4";if(ae8 == 1) query +=" AND a.aquaequiptype = 8";
        
        query +=";\n"; 
        
        drop1 = "DROP VIEW aview;\n";
        drop2 = "DROP VIEW dview;";
        drop3 = "DROP VIEW hview;";
        
        execQuery.add(create);
        execQuery.add(create2);
        execQuery.add(create3);
        execQuery.add(query);
        execQuery.add(drop1);
        execQuery.add(drop2);
        execQuery.add(drop3); 
    }

    public void StoredProcedureQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount) {
        NormalQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery7;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery7()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery7();");
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