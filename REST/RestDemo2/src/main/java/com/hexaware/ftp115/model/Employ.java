package com.hexaware.ftp115.model;

import com.hexaware.ftp115.persistence.DbConnection;
import com.hexaware.ftp115.persistence.EmployDAO;
import java.util.List;
public class Employ {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;

    public Employ() { 
        
          }
        
          public Employ( int argEmpno,
                           String argeName,
                           String argjob,
                           int argmgr,
                           String arghiredate,
                           int argsal,
                            int argcomm,
                           int argdeptno)
                       
          {
            this.empno = argEmpno;
            this.ename = argeName;
           this.job = argjob;
            this.mgr = argmgr;
            this.sal = argsal;
            this.comm = argcomm;
            this.deptno = argdeptno;
          }

      /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpno() {
    return empno;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpno(final int argEmpno) {
    this.empno = argEmpno;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's name.
   */
  public final String getName() {
    return ename;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setName(final String argeName) {
    this.ename = argeName;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getJob() {
    return job;
  }

  /**
   *
   * @param argjob to set employee Email.
   */
  public final void setJob(final String argjob) {
    this.job = argjob;
  }

  public final int getMgr() {
    return mgr;
  }

  /**
   *
   * @param argmgr to set employee Email.
   */
  public final void setMgr(final int argmgr ) {
    this.mgr = argmgr ;
  }

  public final String getHireDate() {
    return hiredate;
  }

  /**
   *
   * @param arghiredate to set employee Email.
   */
  public final void setMgr(final String arghiredate ) {
    this.hiredate = arghiredate ;
  }

  public final int getSal() {
    return sal;
  }

  /**
   *
   * @param argsal to set employee Email.
   */
  public final void setSal(final int argsal ) {
    this.sal = argsal ;
  }

  public final int getComm() {
    return comm;
  }

  /**
   *
   * @param argcomm to set employee Email.
   */
  public final void setComm(final int argcomm ) {
    this.comm = argcomm ;
  }

  public final int getdeptno() {
    return deptno;
  }

  /**
   *
   * @param argcomm to set employee Email.
   */
  public final void setdeptno(final int argdeptno ) {
    this.deptno = argdeptno ;
  }

  private static EmployDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployDAO.class);
  }

  public static Employ[] listAll() {
    List<Employ> es = dao().list();
    return es.toArray(new Employ[es.size()]);
  }

  
  public static Employ listById(final int empID) {
    return dao().find(empID);
  } 

  public static String insertEmp(Employ e) {
    dao().insert(e.getEmpno(), e.getName(), e.getJob(), e.getMgr(), e.getHireDate(), e.getSal(),
    e.getComm(), e.getdeptno());
    return "Record Inserted...";
  }


}
