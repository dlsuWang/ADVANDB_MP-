

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
public class Query2 {
  private String normalQuery, heuristicsQuery, indexSql, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private ArrayList<String> indexQuery = new ArrayList<String>();
    private ArrayList<String> spQuery = new ArrayList<String>();
    
    private String append;
    
    public Query2(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11){
        NormalQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        ViewsQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);            
        IndexQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);  
        StoredProcedureQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);  
    }
    
    public void HeuristicsQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
        heuristicsQuery = "select zone, sum(prog_slp), sum(prog_fudforsch), sum(prog_fudforwrk), sum(prog_cshforwrk), sum(prog_spisc)"
                            +", sum(prog_cct), sum(prog_arcdp), sum(prog_cbep), sum(prog_phiheal_ofw), sum(prog_phiheal_empl), sum(prog_phiheal_indiv)\n"
                            +", sum(prog_phiheal_spon), sum(prog_phiheal_life)\n"
                            +"from (select zone, prog_slp, prog_fudforsch, prog_fudforwrk, prog_cshforwrk, prog_spisc, prog_cct, prog_arcdp, prog_cbep,\n"
                            +"            prog_phiheal_ofw, prog_phiheal_empl, prog_phiheal_indiv, prog_phiheal_spon, prog_phiheal_life, calam1_hwmny, calam2_hwmny,\n"
                            +"            calam3_hwmny, calam4_hwmny, calam5_hwmny, calam6_hwmny, calam7_hwmny, calam8_hwmny, calam9_hwmny, calam10_hwmny, calam11_hwmny\n"
                            +"    from hpq_hh) temp\n"
                            +"group by zone\n having sum(calam1_hwmny) > " + 0;
        if(c1 == 1) heuristicsQuery +=" AND sum(calam1_hwmny) > "+ v1;if(c9 == 1) heuristicsQuery +=" AND sum(calam9_hwmny) > "+ v9;
        if(c2 == 1) heuristicsQuery +=" AND sum(calam2_hwmny) > "+ v2;if(c10 == 1) heuristicsQuery +=" AND sum(calam10_hwmny) > "+ v10;
        if(c3 == 1) heuristicsQuery +=" AND sum(calam3_hwmny) > "+ v3;if(c11 == 1) heuristicsQuery +=" AND sum(calam11_hwmny) > "+ v11;
        if(c4 == 1) heuristicsQuery +=" AND sum(calam4_hwmny) > "+ v4;
        if(c5 == 1) heuristicsQuery +=" AND sum(calam5_hwmny) > "+ v5;
        if(c6 == 1) heuristicsQuery +=" AND sum(calam6_hwmny) > "+ v6;
        if(c7 == 1) heuristicsQuery +=" AND sum(calam7_hwmny) > "+ v7;
        if(c8 == 1) heuristicsQuery +=" AND sum(calam8_hwmny) > "+ v8;
    }                                                   

    public void HeuristicsQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
    }

    public void IndexQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
        
        ArrayList list = new ArrayList<Integer>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);
        list.add(c9);
        list.add(c10);
        list.add(c11);
        
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
            indexSql = "Create Index indexName on hpq_hh(";
            
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
            indexSql = "Create Index indexName on hpq_hh(zone);";
        }

        indexQuery.add(indexSql);
        
        indexQuery.add(normalQuery);
        
        String drop = "Alter Table hpq_hh Drop Index indexName;";
        
        indexQuery.add(drop);
        
    }

     public String indexFunction(String indexSql, int column){
        
        switch(column){
            case 1:
                indexSql = indexSql + "calam1_hwmny";
            break;
            
            case 2:
                indexSql = indexSql + "calam2_hwmny";
            break;
            
            case 3:
                indexSql = indexSql + "calam3_hwmny";
            break;
            
            case 4:
                indexSql = indexSql + "calam4_hwmny";
            break;
            
            case 5:
                indexSql = indexSql + "calam5_hwmny";
            break;

            case 6:
                indexSql = indexSql + "calam6_hwmny";
            break;
            
            case 7:
                indexSql = indexSql + "calam7_hwmny";
            break;
            
            case 8:
                indexSql = indexSql + "calam8_hwmny";
            break;
            
            case 9:
                indexSql = indexSql + "calam9_hwmny";
            break;
            
            case 10:
                indexSql = indexSql + "calam10_hwmny";
            break;
            
            case 11:
                indexSql = indexSql + "calam11_hwmny";
        }
                 
        return indexSql;
    }
    
    public void ViewsQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
        String create, create2, query, drop1, drop2;
        
        create = "CREATE VIEW progview AS\n" +
                "SELECT id, zone, prog_slp, prog_fudforsch, prog_fudforwrk, prog_cshforwrk, prog_spisc, prog_cct, prog_arcdp, prog_cbep,\n" +
                "		prog_phiheal_ofw, prog_phiheal_empl, prog_phiheal_indiv, prog_phiheal_spon, prog_phiheal_life \n" +
                "FROM hpq_hh;";
        create2 = "CREATE VIEW calamview AS\n" +
                "SELECT h.zone, h.calam1_hwmny, h.calam2_hwmny, h.calam3_hwmny, h.calam4_hwmny, h.calam5_hwmny, h.calam6_hwmny,\n" +
                "		h.calam7_hwmny, h.calam8_hwmny, h.calam9_hwmny, h.calam10_hwmny, h.calam11_hwmny, p.prog_slp, p.prog_fudforsch, \n" +
                "        p.prog_fudforwrk, p.prog_cshforwrk, p.prog_spisc, p.prog_cct, p.prog_arcdp, p.prog_cbep,\n" +
                "		p.prog_phiheal_ofw, p.prog_phiheal_empl, p.prog_phiheal_indiv, p.prog_phiheal_spon, p.prog_phiheal_life\n" +
                "FROM hpq_hh h, progview p\n" +
                "WHERE  h.id = p.id;";
        query="SELECT c.zone, sum(c.prog_slp), sum(c.prog_fudforsch), sum(c.prog_fudforwrk), sum(c.prog_cshforwrk), sum(c.prog_spisc)\n" +
                ", sum(c.prog_cct), sum(c.prog_arcdp), sum(c.prog_cbep), sum(c.prog_phiheal_ofw), sum(c.prog_phiheal_empl), sum(c.prog_phiheal_indiv)\n" +
                ", sum(c.prog_phiheal_spon), sum(c.prog_phiheal_life)\n" +
                "FROM calamview c\n" +
                "GROUP BY c.zone\n" +
                "HAVING c.zone IS NOT NULL";
        if(c1 == 1) query +=" AND sum(calam1_hwmny) > "+ v1;if(c9 == 1) query +=" AND sum(calam9_hwmny) > "+ v9;
        if(c2 == 1) query +=" AND sum(calam2_hwmny) > "+ v2;if(c10 == 1) query +=" AND sum(calam10_hwmny) > "+ v10;
        if(c3 == 1) query +=" AND sum(calam3_hwmny) > "+ v3;if(c11 == 1) query +=" AND sum(calam11_hwmny) > "+ v11;
        if(c4 == 1) query +=" AND sum(calam4_hwmny) > "+ v4;
        if(c5 == 1) query +=" AND sum(calam5_hwmny) > "+ v5;
        if(c6 == 1) query +=" AND sum(calam6_hwmny) > "+ v6;
        if(c7 == 1) query +=" AND sum(calam7_hwmny) > "+ v7;
        if(c8 == 1) query +=" AND sum(calam8_hwmny) > "+ v8;
        
        drop1 = "DROP VIEW calamview;\n";
        drop2 = "DROP VIEW progview;\n";
        
        viewQuery.add(create);
        viewQuery.add(create2);
        viewQuery.add(query);
        viewQuery.add(drop1);
        viewQuery.add(drop2);
    }

    public void StoredProcedureQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
        NormalQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        spQuery.add("DROP PROCEDURE IF EXISTS getSPQuery2;");
        spQuery.add("DELIMITER $$ "
                + "CREATE PROCEDURE getSPQuery2()"
                + "BEGIN "
                + getNormalQuery()
                + "END "
                + "DELIMITER ;");
        spQuery.add("CALL getSPQuery2()");
        
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