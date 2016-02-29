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
public class Query4{
    
    private String normalQuery, heuristicsQuery, indexSql, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private ArrayList<String> indexQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    
    private String append;
    
    public Query4(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others){
        NormalQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
        ViewsQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
        StoredProcedureQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
        HeuristicsQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
    }
    
    public void NormalQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others){
        normalQuery = "SELECT  c.croptype, AVG(c.crop_vol)\n" +
                      "FROM hpq_crop c, hpq_hh h\n" +
                      "WHERE c.hpq_hh_id = h.id";
        if(ae1 == 1) normalQuery +=" AND agriequip1_nown = 1";if(ae9 == 1) normalQuery +=" AND agriequip9_nown = 1";if(ae17 == 1) normalQuery +=" AND agriequip17_nown = 1";
        if(ae2 == 1) normalQuery +=" AND agriequip2_nown = 1";if(ae10 == 1) normalQuery +=" AND agriequip10_nown = 1";if(ae18 == 1) normalQuery +=" AND agriequip18_nown = 1";
        if(ae3 == 1) normalQuery +=" AND agriequip3_nown = 1";if(ae11 == 1) normalQuery +=" AND agriequip11_nown = 1";if(sugarcane == 1) normalQuery +=" AND c.croptype = 1";
        if(ae4 == 1) normalQuery +=" AND agriequip4_nown = 1";if(ae12 == 1) normalQuery +=" AND agriequip12_nown = 1";if(palay == 1) normalQuery +=" AND c.croptype = 2";
        if(ae5 == 1) normalQuery +=" AND agriequip5_nown = 1";if(ae13 == 1) normalQuery +=" AND agriequip13_nown = 1";if(corn == 1) normalQuery +=" AND c.croptype = 3";
        if(ae6 == 1) normalQuery +=" AND agriequip6_nown = 1";if(ae14 == 1) normalQuery +=" AND agriequip14_nown = 1";if(others == 1) normalQuery +=" AND c.croptype = 4";
        if(ae7 == 1) normalQuery +=" AND agriequip7_nown = 1";if(ae15 == 1) normalQuery +=" AND agriequip15_nown = 1";
        if(ae8 == 1) normalQuery +=" AND agriequip8_nown = 1";if(ae16 == 1) normalQuery +=" AND agriequip16_nown = 1";
        
    }

    public void HeuristicsQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others) {
        heuristicsQuery = "select croptype, croptype_o, SUM(crop_vol)\n"
                       +"from hpq_crop\n"
                       +"where hpq_hh_id in\n"
                       +"(select id"
                       +"from hpq_hh"
                       +"where agriequip1_nown = 0 ";
        if(ae1 == 1) heuristicsQuery +="and agriequip1_nown = 1) ";if(ae9 == 1) heuristicsQuery +="and agriequip9_nown = 1) ";if(ae17 == 1) heuristicsQuery +="and agriequip17_nown = 1) ";
        if(ae2 == 1) heuristicsQuery +="and agriequip2_nown = 1) ";if(ae10 == 1) heuristicsQuery +="and agriequip10_nown = 1) ";if(ae18 == 1) heuristicsQuery +="and agriequip18_nown = 1) ";
        if(ae3 == 1) heuristicsQuery +="and agriequip3_nown = 1) ";if(ae11 == 1) heuristicsQuery +="and agriequip11_nown = 1) ";if(sugarcane == 1) heuristicsQuery +="and c.croptype = 1 ";
        if(ae4 == 1) heuristicsQuery +="and agriequip4_nown = 1) ";if(ae12 == 1) heuristicsQuery +="and agriequip12_nown = 1) ";if(palay == 1) heuristicsQuery +="and c.croptype = 2";
        if(ae5 == 1) heuristicsQuery +="and agriequip5_nown = 1) ";if(ae13 == 1) heuristicsQuery +="and agriequip13_nown = 1) ";if(corn == 1) heuristicsQuery +="and c.croptype = 3";
        if(ae6 == 1) heuristicsQuery +="and agriequip6_nown = 1) ";if(ae14 == 1) heuristicsQuery +="and agriequip14_nown = 1) ";if(others == 1) heuristicsQuery +="and c.croptype = 4";
        if(ae7 == 1) heuristicsQuery +="and agriequip7_nown = 1) ";if(ae15 == 1) heuristicsQuery +="and agriequip15_nown = 1) ";
        if(ae8 == 1) heuristicsQuery +="and agriequip8_nown = 1) ";if(ae16 == 1) heuristicsQuery +="and agriequip16_nown = 1) ";
    }

    public void IndexQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others) {
    
        ArrayList list = new ArrayList<Integer>();
        list.add(ae1);
        list.add(ae2);
        list.add(ae3);
        list.add(ae4);
        list.add(ae5);
        list.add(ae6);
        list.add(ae7);
        list.add(ae8);
        list.add(ae9);
        list.add(ae10);
        list.add(ae11);
        list.add(ae12);
        list.add(ae13);
        list.add(ae14);
        list.add(ae15);
        list.add(ae16);
        list.add(ae17);
        list.add(ae18);
    
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
        indexQuery.add("Create Index indexTwo on hpq_crop(croptype);");
        indexQuery.add(normalQuery + ";");
        indexQuery.add("Alter Table hpq_hh Drop Index indexOne;");
        indexQuery.add("Alter Table hpq_crop Drop Index indexTwo;");

    }
    
     public String indexFunction(String indexSql, int column){
     
        switch(column){
            case 1:
                indexSql = indexSql + "agriequip1_nown";
            break;
            
            case 2:
                indexSql = indexSql + "agriequip2_nown";
            break;
            
            case 3:
                indexSql = indexSql + "agriequip3_nown";
            break;
            
            case 4:
                indexSql = indexSql + "agriequip4_nown";
            break;
            
            case 5:
                indexSql = indexSql + "agriequip5_nown";
            break;

            case 6:
                indexSql = indexSql + "agriequip6_nown";
            break;
            
            case 7:
                indexSql = indexSql + "agriequip7_nown";
            break;
            
            case 8:
                indexSql = indexSql + "agriequip8_nown";
            break;
            
            case 9:
                indexSql = indexSql + "agriequip9_nown";
            break;
            
            case 10:
                indexSql = indexSql + "agriequip10_nown";
            break;
            
            case 11:
                indexSql = indexSql + "agriequip11_nown";
             break;
             
            case 12:
                indexSql = indexSql + "agriequip12_nown";
             break;
            
            case 13:
                indexSql = indexSql + "agriequip13_nown";
             break;
            
            case 14:
                indexSql = indexSql + "agriequip14_nown";
             break;
            
            case 15:
                indexSql = indexSql + "agriequip15_nown";
             break;
            
            case 16:
                indexSql = indexSql + "agriequip16_nown";
             break;
            
            case 17:
                indexSql = indexSql + "agriequip17_nown";
             break;
            
            case 18:
                indexSql = indexSql + "agriequip18_nown";
                
        }
                 
        return indexSql;
    }

    public void ViewsQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others) {
        String create, create2 ,query, drop1, drop2;
        
        create = "CREATE VIEW id_view\n" +"AS SELECT id \n" +"FROM hpq_hh \n" +"WHERE id = id ";
            if(ae1 == 1) create +=" AND agriequip1_nown = 1";if(ae9 == 1) create +=" AND agriequip9_nown = 1";if(ae17 == 1) create +=" AND agriequip17_nown = 1";
            if(ae2 == 1) create +=" AND agriequip2_nown = 1";if(ae10 == 1) create +=" AND agriequip10_nown = 1";if(ae18 == 1) create +=" AND agriequip18_nown = 1";
            if(ae3 == 1) create +=" AND agriequip3_nown = 1";if(ae11 == 1) create +=" AND agriequip11_nown = 1";
            if(ae4 == 1) create +=" AND agriequip4_nown = 1";if(ae12 == 1) create +=" AND agriequip12_nown = 1";
            if(ae5 == 1) create +=" AND agriequip5_nown = 1";if(ae13 == 1) create +=" AND agriequip13_nown = 1";
            if(ae6 == 1) create +=" AND agriequip6_nown = 1";if(ae14 == 1) create +=" AND agriequip14_nown = 1";
            if(ae7 == 1) create +=" AND agriequip7_nown = 1";if(ae15 == 1) create +=" AND agriequip15_nown = 1";
            if(ae8 == 1) create +=" AND agriequip8_nown = 1";if(ae16 == 1) create +=" AND agriequip16_nown = 1";
        create += ";\n";
        create2 = "CREATE VIEW crop_view\n" +"AS SELECT  c.croptype,  c.crop_vol\n" +"FROM hpq_crop c, id_view h\n" +"WHERE c.hpq_hh_id = h.id;";
        
        query =  "\nSELECT  croptype,  AVG(crop_vol)\n" +"FROM crop_view \n" +"WHERE croptype = croptype";
        
        if(sugarcane == 1) query +=" AND croptype = 1 ";
        if(palay == 1) query +=" AND croptype = 2 ";
        if(corn == 1) query +=" AND croptype = 3 ";
        if(others == 1) query +=" AND croptype = 4 ";
        
        query +=";\n"; 
        drop1 = "DROP VIEW crop_view;\n";
        drop2 = "DROP VIEW id_view;";
        
        viewQuery.add(create);
        viewQuery.add(create2);
        viewQuery.add(query);
        viewQuery.add(drop1);
        viewQuery.add(drop2);
        
    }

    public void StoredProcedureQuery(int ae1, int ae2, int ae3, int ae4, int ae5, int ae6, int ae7, int ae8, int ae9, int ae10, int ae11, int ae12, int ae13, int ae14, int ae15, int ae16, int ae17, int ae18, int sugarcane, int palay, int corn, int others) {
        NormalQuery(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,ae9,ae10,ae11,ae12,ae13,ae14,ae15,ae16,ae17,ae18,sugarcane,palay,corn,others);
        spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery4;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery4()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery4();");
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
