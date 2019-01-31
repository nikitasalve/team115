package com.hexaware.ftp.model;

import java.util.List;

import com.hexaware.ftp.persistence.DbConnection;
import com.hexaware.ftp.persistence.DeptDAO;

public class Dept{
   private int deptno;
   private String dname;
   private String loc;

   public Dept(int argDeptno, String argDeptName, String argDeptloc ){
       this.deptno = argDeptno;
       this.dname = argDeptName;
       this.loc = argDeptloc;
   }

   public int getDeptno(){
       return deptno;
   }

   public void setDeptno(int argDeptno){
       this.deptno =argDeptno;
   }

   public String getDeptName(){
       return dname;
   }

   public final void setDeptName(final String argDeptName){
       this.dname = argDeptName;
   }

   public String getLoc(){
    return loc;
    }

public final void setLoc(final String argDeptloc){
    this.loc = argDeptloc;
}

private static DeptDAO dao(){
    DbConnection db =new DbConnection();
    return db.getConnect().onDemand(DeptDAO.class);
}

public static Dept[] listAll() {
    List<Dept> es =dao().list();
    return es.toArray(new Dept[es.size()]);
}
} 