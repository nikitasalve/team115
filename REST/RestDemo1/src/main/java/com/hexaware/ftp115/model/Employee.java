package com.hexaware.ftp115.model;

import com.hexaware.ftp115.persistence.DbConnection;
import com.hexaware.ftp115.persistence.EmployeeDAO;
import java.util.List;

public class Employee {

  
  private int empno;
  private String name;
  private String dept;
  private String desig;
  private int basic;

  public Employee() { 

  }

  public Employee( int argEmpno, 
                   String argName,
                   String argDept,
                   String argDesig,
                   int argBasic
                  )
  {
    this.empno = argEmpno;
    this.name = argName;
    this.dept = argDept; 
    this.desig = argDesig;
    this.basic = argBasic;
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
    return name;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setName(final String argName) {
    this.name = argName;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getDept() {
    return dept;
  }

  /**
   *
   * @param argEmpEmail to set employee Email.
   */
  public final void setDept(final String argDept) {
    this.dept = argDept;
  }

  /**
   * Gets the EmployeeMobNo.
   * @return this Employee's Mobile number.
   */
  public final String getDesig() {
    return desig;
  }

  /**
   *
   * @param argEmpMobNo to set employee mobile Number.
   */
  public final void setDesig(final String argDesig) {
    this.desig = argDesig;
  }

  /**
   * Gets the EmployeeDptName.
   * @return this Employee's department Name.
   */
  public final int getBasic() {
    return basic;
  }

  /**
   *
   * @param argEmpDptName to set employee Department Name.
   */
  public final void setBasic(final int argBasic) {
    this.basic = argBasic;
  }

  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  public static Employee[] listAll() {
    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  } 

  public static String insertEmp(Employee e) {
    dao().insert(e.getEmpno(), e.getName(), e.getDept(), e.getDesig(), e.getBasic());
    return "Record Inserted...";
  }
}
