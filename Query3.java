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
public class Query3 {
    private String normalQuery, heuristicsQuery, indexQuery, storedProcedureQuery;
    private ArrayList<String> viewQuery = new ArrayList<String>();
    private String append;
    
    public Query3(int sex, int educ, int reg, int last, int job, int work, int death){

        NormalQuery(sex,educ,reg,last,job,work,death);
        ViewsQuery(sex,educ,reg,last,job,work,death);
    }
    
    public void NormalQuery(int sex, int educ, int reg, int last, int job, int work, int death){
        normalQuery = "SELECT m.id, m.memno as 'Person ID', m.sex as 'Gender', m.educal as 'Education', m.regvotind as 'Registered Voter', m.voted_last_election as 'Voted Last Election', m.jobind as 'Employed', m.workcl as 'Employee Type', d.mdeady as 'Cause of Death'\n" +
                        "FROM hpq_mem m, hpq_death d\n" + "WHERE m.id = d.hpq_hh_id";
        if(sex == 1)normalQuery +=" AND m.sex = 1 ";
        else if(sex == 2) normalQuery +=" AND m.sex = 2 ";
        else if(sex == 3) normalQuery +=" AND (m.sex = 1 OR m.sex = 2) ";
        
        if(educ == 300) normalQuery +=" AND m.educal = 300 ";
        else if(educ == 400) normalQuery +=" AND m.educal = 400 ";
                
        if(reg == 1)normalQuery +=" AND m.regvotind = 1 ";
        else if(reg == 2) normalQuery +=" AND m.regvotind = 2 ";
        
        if(last == 1) normalQuery +=" AND m.voted_last_election = 1 ";
        else if(last == 2) normalQuery +=" AND m.voted_last_election = 2 ";
        else if(last == 3) normalQuery +=" AND m.voted_last_election = 3 ";
        
        if(job == 1)normalQuery +=" AND m.jobind = 1 ";
        else if(job == 2) normalQuery +=" AND m.jobind = 2 ";
        
        normalQuery+=" AND m.workcl = "+ work + " AND d.mdeady = "+death+ "\n";
        normalQuery+="ORDER BY m.educal, m.workcl, d.mdeady;";
    }

    public void HeuristicsQuery(int sex, int educ, int reg, int last, int job, int work, int death) {
    }

    public void IndexQuery(int sex, int educ, int reg, int last, int job, int work, int death) {
    }

    public void ViewsQuery(int sex, int educ, int reg, int last, int job, int work, int death) {
        String create, create2, query, drop, drop2;
        
        create = "CREATE VIEW dview AS\n" +
                 "SELECT hpq_hh_id, mdeady\n" +
                 "FROM hpq_death\n" +
                 "WHERE hpq_hh_id = hpq_hh_id";
        create+=" AND mdeady = "+death+ ";\n";
        
        create2 = "CREATE VIEW mview AS\n" +"SELECT m.id, m.memno, m.sex, m.educal, m.regvotind,m.voted_last_election,m.jobind, m.workcl, d.mdeady\n" +
                "FROM hpq_mem m, dview d\n" +"WHERE d.hpq_hh_id = m.id;";
        
        query =  "SELECT *\nFROM mview\nWHERE id = id ";
        if(sex == 1)query +=" AND sex = 1 ";
        else if(sex == 2) query +=" AND sex = 2 ";
        else if(sex == 3) query +=" AND (sex = 1 OR sex = 2) ";
        
        if(educ == 300) query +=" AND educal = 300 ";
        else if(educ == 400) query +=" AND educal = 400 ";
                
        if(reg == 1)query +=" AND regvotind = 1 ";
        else if(reg == 2) query +=" AND regvotind = 2 ";
        
        if(last == 1) query +=" AND voted_last_election = 1 ";
        else if(last == 2) query +=" AND voted_last_election = 2 ";
        else if(last == 3) query +=" AND voted_last_election = 3 ";
        
        if(job == 1)query +=" AND jobind = 1 ";
        else if(job == 2) query +=" AND jobind = 2 ";
        query+=" AND workcl = "+ work;
        query +="\nORDER BY educal, workcl, mdeady;\n"; 
        
        drop = "DROP VIEW mview;";
        drop2 = "DROP VIEW dview;";
        
        viewQuery.add(create);
        viewQuery.add(create2);
        viewQuery.add(query);
        viewQuery.add(drop);
        viewQuery.add(drop2);
    }

    public void StoredProcedureQuery(int sex, int educ, int reg, int last, int job, int work, int death) {
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
