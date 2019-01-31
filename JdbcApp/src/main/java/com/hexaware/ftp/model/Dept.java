package com.hexaware.ftp.model;
public class Dept{
   private int deptno;
   private String dname;
   private String loc;

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

} 