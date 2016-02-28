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
  private String normalQuery, heuristicsQuery, indexQuery, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private String append;
    
    public Query2(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11){
        NormalQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        ViewsQuery(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
    }
    
    public void NormalQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11){
        normalQuery = "SELECT zone, sum(prog_slp) as 'Sustainable Life Program', sum(prog_fudforsch) as 'Food for School', sum(prog_fudforwrk) as 'Food for Work', sum(prog_cshforwrk) as 'Cash for Work', sum(prog_spisc) as 'Social Pension' \n" +
                        ", sum(prog_cct) as '4Ps', sum(prog_arcdp) as 'ARCSP', sum(prog_cbep) as 'CBEP', sum(prog_phiheal_ofw) as 'PhilHealth OFW', sum(prog_phiheal_empl) as 'Philhealth Employed', sum(prog_phiheal_indiv) as 'Philhealth Individual' \n" +
                        ", sum(prog_phiheal_spon) as 'Philhealth Sponsored', sum(prog_phiheal_life) as 'Philhealth Life' \n" +
                        "FROM hpq_hh\n" +"GROUP BY zone\n" +"HAVING zone IS NOT NULL";
                      
        if(c1 == 1) normalQuery +=" AND sum(calam1_hwmny) > "+ v1;
        if(c2 == 1) normalQuery +=" AND sum(calam2_hwmny) > "+ v2;
        if(c3 == 1) normalQuery +=" AND sum(calam3_hwmny) > "+ v3;
        if(c4 == 1) normalQuery +=" AND sum(calam4_hwmny) > "+ v4;
        if(c5 == 1) normalQuery +=" AND sum(calam5_hwmny) > "+ v5;
        if(c6 == 1) normalQuery +=" AND sum(calam6_hwmny) > "+ v6;
        if(c7 == 1) normalQuery +=" AND sum(calam7_hwmny) > "+ v7;
        if(c8 == 1) normalQuery +=" AND sum(calam8_hwmny) > "+ v8;
        if(c9 == 1) normalQuery +=" AND sum(calam9_hwmny) > "+ v9;
        if(c10 == 1) normalQuery +=" AND sum(calam10_hwmny) > "+ v10;
        if(c11 == 1) normalQuery +=" AND sum(calam11_hwmny) > "+ v11;
        
    }                                                          

    public void HeuristicsQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
    }

    public void IndexQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
    }

    public void ViewsQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
        /*String create, create2 , create3, query, drop1, drop2, drop3;
        
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
        viewQuery.add(query);indexViewQuery = 3;
        viewQuery.add(drop1);
        viewQuery.add(drop2);
        viewQuery.add(drop3);*/
    }

    public void StoredProcedureQuery(int c1,int c2, int c3,int c4, int c5 , int c6, int c7, int c8,  int c9, int c10, int c11, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8,int v9, int v10, int v11) {
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

    public String getStoredProcedureQuery() {
        return storedProcedureQuery;
    }

    public ArrayList<String> getViewQuery() {
        return viewQuery;
    }

}
