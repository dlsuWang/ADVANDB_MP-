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
    private String normalQuery, heuristicsQuery, indexSql, storedProcedureQuery;
    private ArrayList<String> indexQuery = new ArrayList<String>();
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    private String append;
    
    public Query7(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int amount){
        NormalQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        ViewsQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
        IndexQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount);
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
        
        ArrayList list = new ArrayList<Integer>();
        list.add(ae1);
        list.add(ae2);
        list.add(ae3);
        list.add(ae4);
        list.add(ae5);
        list.add(ae6);
        list.add(ae7);
        list.add(ae8);
        
         boolean useIndex = false;
        
        for(int a=0; a < list.size(); a++)
        {
            if((int)list.get(a) == 1)
            {
                useIndex = true;
                break;
            }
        }

        if(useIndex)
        {
            indexSql = "Create Index indexOne on hpq_aquaequip(hpq_hh_id, aquaequiptype);";
        }
        else
        {
            indexSql = "Create Index indexOne on hpq_aquaequip(hpq_hh_id);";
        }
        
        indexQuery.add(indexSql);
        indexQuery.add("Create Index indexTwo on hpq_aquani(hpq_hh_id);");
        indexQuery.add("Create Index indexThree on hpq_death(hpq_hh_id);");
        indexQuery.add("Create Index indexFour on hpq_hh(id);");
        indexQuery.add(normalQuery);
        indexQuery.add("Alter Table hpq_aquaequip Drop Index indexOne;");
        indexQuery.add("Alter Table hpq_aquani Drop Index indexTwo");
        indexQuery.add("Alter Table hpq_death Drop Index indexThree");
        indexQuery.add("Alter Table hpq_hh Drop Index indexFour");
        
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
        
        viewQuery.add(create);
        viewQuery.add(create2);
        viewQuery.add(create3);
        viewQuery.add(query);
        viewQuery.add(drop1);
        viewQuery.add(drop2);
        viewQuery.add(drop3); 
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
