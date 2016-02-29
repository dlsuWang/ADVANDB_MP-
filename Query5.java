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
public class Query5{
    
    private String normalQuery, heuristicsQuery, indexSql, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    private ArrayList<String> indexQuery = new ArrayList<String>();
    
    public Query5(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8){
        NormalQuery(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
        ViewsQuery(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
        StoredProcedureQuery(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
        HeuristicsQuery(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
    }
    
    public void NormalQuery(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8){
        normalQuery = "SELECT m.id, m.memno,h.naquani, h.naquaequip, ae.aquaequiptype, ae.aquaequiptype_o\n" +
                      "FROM hpq_mem m, hpq_hh h, hpq_aquaequip ae\n" +
                      "WHERE m.id = h.id AND h.id = ae.hpq_hh_id AND (m.occup LIKE '%fish%' OR m.occup LIKE '%isda%') AND h.naquaequip >=1 "+
                      "AND h.naquani >=2 AND ae.aquaequiptype_own = 1";
        if(ae1 == 1) normalQuery +=" AND ae.aquaequiptype = 1";if(af1 == 1) normalQuery +=" AND h.fishpond = 1";
        if(ae2 == 1) normalQuery +=" AND ae.aquaequiptype = 2";if(af2 == 1) normalQuery +=" AND h.fishpen = 1";
        if(ae3 == 1) normalQuery +=" AND ae.aquaequiptype = 3";if(af3 == 1) normalQuery +=" AND h.fishcage = 1";
        if(ae4 == 1) normalQuery +=" AND ae.aquaequiptype = 4";if(af4 == 1) normalQuery +=" AND h.seaweedfarm = 1";
        if(ae5 == 1) normalQuery +=" AND ae.aquaequiptype = 5";if(af5 == 1) normalQuery +=" AND h.oysterfarm = 1";
        if(ae6 == 1) normalQuery +=" AND ae.aquaequiptype = 6";if(af6 == 1) normalQuery +=" AND h.musselfarm = 1";
        if(ae7 == 1) normalQuery +=" AND ae.aquaequiptype = 7";if(af7 == 1) normalQuery +=" AND h.fishtank = 1";
        if(ae8 == 1) normalQuery +=" AND ae.aquaequiptype = 8";if(af8 == 1) normalQuery +=" AND h.hatchery = 1";
                                                               if(af9 == 1) normalQuery +=" AND h.aquafarm_o = 1";
        
        normalQuery += "\nGROUP BY m.id, ae.aquaequiptype, ae.aquaequiptype_o";                                                        
    }                                                          

    public void HeuristicsQuery(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8) {
        heuristicsQuery = "select id\n"
                            +"from hpq_mem\n"
                            +"where (occup LIKE '%fish%' OR occup LIKE '%isda%') and\n"
                            +"    id in \n"
                            +"    (select id\n"
                            +"     from   hpq_hh\n"
                            +"where naquaequip >=2 ";
        if(af1 == 1) heuristicsQuery +=" AND h.fishpond = 1";
        if(af2 == 1) heuristicsQuery +=" AND h.fishpen = 1";
        if(af3 == 1) heuristicsQuery +=" AND h.fishcage = 1";
        if(af4 == 1) heuristicsQuery +=" AND h.seaweedfarm = 1";
        if(af5 == 1)  heuristicsQuery+=" AND h.oysterfarm = 1";
        if(af6 == 1) heuristicsQuery +=" AND h.musselfarm = 1";
        if(af7 == 1) heuristicsQuery +=" AND h.fishtank = 1";
        if(af8 == 1) heuristicsQuery +=" AND h.hatchery = 1";
        if(af9 == 1) heuristicsQuery +=" AND h.aquafarm_o = 1";
        heuristicsQuery += "and naquani >= 2\nid in"
                        + "id in \n"
                        + "(select hpq_hh_id\n"
                        + " from hpq_aquaequip\n";
        if(ae1 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 1";
        if(ae2 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 2";
        if(ae3 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 3";
        if(ae4 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 4";
        if(ae5 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 5";
        if(ae6 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 6";
        if(ae7 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 7";
        if(ae8 == 1) heuristicsQuery +=" AND ae.aquaequiptype = 8";
        heuristicsQuery += ")\n);";
    }

    public void IndexQuery(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8) {
    
    ArrayList list = new ArrayList<Integer>();
        list.add(af1);
        list.add(af2);
        list.add(af3);
        list.add(af4);
        list.add(af5);
        list.add(af6);
        list.add(af7);
        list.add(af8);
        list.add(af9);
        
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
            indexSql = "Create Index indexOne on hpq_hh(id, ";
            
            boolean isFirst = true;
            
            for(int a=0; a < list.size(); a++)
            {
                if((int)list.get(a) == 1 && isFirst)
                {
                    isFirst = false;
                    
                    indexSql = indexFunction(indexSql, a+1);
                }
                else if((int)list.get(a) == 1 && !isFirst)
                {
                    indexSql = indexSql + ", ";
                    indexSql = indexFunction(indexSql, a+1);
                }
            }
            
             indexSql = indexSql + ");"; 
        }
        else
        {
            indexSql = "Create Index indexOne on hpq_hh(id);";
        }
        
        indexQuery.add(indexSql);
        
        list = new ArrayList<Integer>();
        list.add(ae1);
        list.add(ae2);
        list.add(ae3);
        list.add(ae4);
        list.add(ae5);
        list.add(ae6);
        list.add(ae7);
        list.add(ae8);

        useIndex = false;
        
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
            indexSql = "Create Index indexTwo on hpq_aquaequip(hpq_hh_id, aquaequiptype);";
         
        }
        else
        {
            indexSql = "Create Index indexTwo on hpq_aquaequip(hpq_hh_id);";
        }
        
        indexQuery.add(indexSql);
        indexQuery.add(normalQuery);
        indexQuery.add("Alter Table hpq_hh Drop Index indexOne;");
        indexQuery.add("Alter Table hpq_aquaequip Drop Index indexTwo;");
                  
    }
    
      public String indexFunction(String indexSql, int column){
 
        switch(column){
            case 1:
                indexSql = indexSql + "fishpond";
            break;
            
            case 2:
                indexSql = indexSql + "fishpen";
            break;
            
            case 3:
                indexSql = indexSql + "fishcage";
            break;
            
            case 4:
                indexSql = indexSql + "oysterfarm";
            break;
            
            case 5:
                indexSql = indexSql + "musselfarm";
            break;

            case 6:
                indexSql = indexSql + "fishtank";
            break;
            
            case 7:
                indexSql = indexSql + "hatchery";
            break;
            
            case 8:
                indexSql = indexSql + "aquafarm_o";
           }
                 
        return indexSql;
    }
      

    public void ViewsQuery(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8) {
        String create, create2 , create3, query, drop1, drop2, drop3;
        
        create = "CREATE VIEW mview AS\n" +"SELECT id, memno,occup\n" +"FROM hpq_mem\n" +"WHERE (occup LIKE '%fish%' OR occup LIKE '%isda%');";
        create2 = "CREATE VIEW hview AS \n" +"SELECT m.id, m.memno, h.naquani, h.naquaequip\n" +"FROM mview m, hpq_hh h\n" +"WHERE m.id = h.id AND h.naquaequip >=1 AND h.naquani >=2 ";
            if(af1 == 1) create2 +=" AND h.fishpond = 1";
            if(af2 == 1) create2 +=" AND h.fishpen = 1";
            if(af3 == 1) create2 +=" AND h.fishcage = 1";
            if(af4 == 1) create2 +=" AND h.seaweedfarm = 1";
            if(af5 == 1) create2 +=" AND h.oysterfarm = 1";
            if(af6 == 1) create2 +=" AND h.musselfarm = 1";
            if(af7 == 1) create2 +=" AND h.fishtank = 1";
            if(af8 == 1) create2 +=" AND h.hatchery = 1";
            if(af9 == 1) create2 +=" AND h.aquafarm_o = 1";
        create2 += ";\n";
        create3 = "CREATE VIEW aview AS\n" +"SELECT hpq_hh_id, aquaequiptype, aquaequiptype_o\n" +"FROM hpq_aquaequip\n" +"WHERE aquaequiptype_own = 1";
            if(ae1 == 1) create3 +=" AND aquaequiptype = 1";
            if(ae2 == 1) create3 +=" AND aquaequiptype = 2";
            if(ae3 == 1) create3 +=" AND aquaequiptype = 3";
            if(ae4 == 1) create3 +=" AND aquaequiptype = 4";
            if(ae5 == 1) create3 +=" AND aquaequiptype = 5";
            if(ae6 == 1) create3 +=" AND aquaequiptype = 6";
            if(ae7 == 1) create3 +=" AND aquaequiptype = 7";
            if(ae8 == 1) create3 +=" AND aquaequiptype = 8";
        query =  "\nSELECT h.id, h.memno, h.naquani, h.naquaequip, a.aquaequiptype, a.aquaequiptype_o\n" +
                 "FROM hview h, aview a\n" +
                 "WHERE a.hpq_hh_id = h.id\n" +
                 "GROUP BY h.id, a.aquaequiptype, a.aquaequiptype_o;";
        
        drop1 = "DROP VIEW hview;\n";
        drop2 = "DROP VIEW mview;\n";
        drop3 = "DROP VIEW aview;\n";
        
        viewQuery.add(create);
        viewQuery.add(create2);
        viewQuery.add(create3);
        viewQuery.add(query);
        viewQuery.add(drop1);
        viewQuery.add(drop2);
        viewQuery.add(drop3);
    }

    public void StoredProcedureQuery(int af1, int af2, int af3, int af4, int af5, int af6, int af7, int af8, int af9, int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8) {
        NormalQuery(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8);
        spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery5;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery5()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery5();");
    }

    public String getNormalQuery() {
        return normalQuery;
    }

    public String getIndexQuery() {
        return indexSql;
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