package com.hexaware.FTP115.model;

import com.hexaware.FTP115.persistence.DbConnection;
import com.hexaware.FTP115.persistence.EmployeeDAO;

import java.util.Objects;

import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empFullName to store employee name.
   * empEmail to store employee Email.
   */
  private int empId;
  private String empFullName;
  private String empEmail;
  private String empMobile;
  private Date empDOJ;
  private String empDept;
  private int empLeaveBal;
  private int empMgrId;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId);
  }

  @Override
  public final String toString() {
    return " Employee ID:" + empId + " Employee Name:" + empFullName + " Email:"
          +  empEmail + " Mobile:" + empMobile + " Department:" + empDept + " Join Date:"
          + empDOJ + " Manager ID:"   + empMgrId + " applied Leave ID:" + empLeaveBal;
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argempFullName to initialize employee Name.
   * @param argempMobile to initialize Mobile.
   * @param argempEmail to initialize employee email.
   * @param argEmpDOJ to initialize employee joining Date.
   * @param argEmpDept to initialize employee department name.
   * @param argEmpMgrId to initialize employee Manager id.
   * @param argEmpLeaveBal to initialize employee leave balance.
   */
  public Employee(final int argEmpId, final String argempFullName, final String argempEmail,
                  final String argempMobile, final Date argEmpDOJ, final String argEmpDept,
                  final int argEmpMgrId, final int argEmpLeaveBal) {
    this.empId = argEmpId;
    this.empFullName = argempFullName;
    this.empEmail = argempEmail;
    this.empMobile = argempMobile;
    this.empDOJ = argEmpDOJ;
    this.empDept = argEmpDept;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBal = argEmpLeaveBal;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }
  /**
   *
   * @param argempFullName to set employee's full Name.
   */
  public final void setEmpFullName(final String argempFullName) {
    this.empFullName = argempFullName;
  }
  /**
   * Gets the Employee Email.
   * @return this Employee's Email
   */
  public final String getEmpEmail() {
    return empEmail;
  }
  /**
   * @param argempEmail to set Employee's Email.
   */
  public final void setEmpEmail(final String argempEmail) {
    this.empEmail = argempEmail;
  }
  /**
   * Gets the Employee mobile.
   * @return this Employee's mobile.
   */
  public final String getEmpMobile() {
    return empMobile;
  }
  /**
   * @param argempMobile to set Employee's Email.
   */
  public final void setEmpMobile(final String argempMobile) {
    this.empMobile = argempMobile;
  }
  /**
   * Gets the Employee Date of Joining.
   * @return this Employee's Date of Joining
   */
  public final Date getEmpDOJ() {
    return empDOJ;
  }
  /**
   * @param argEmpDOJ to set Employee's Date of Joining.
   */
  public final void setEmpDOJ(final Date argEmpDOJ) {
    this.empDOJ = argEmpDOJ;
  }
  /**
   * Gets the Employee Department.
   * @return this Employee's Department
   */
  public final String getEmpDepart() {
    return empDept;
  }
  /**
   * @param argEmpDept to set Employee's Department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
   /**
   * Gets the Employee Leave Balance.
   * @return this Employee's Leave Balance
   */
  public final int getEmpLeaveBal() {
    return empLeaveBal;
  }
  /**
   * @param argEmpLeaveBal to set Employee's Email.
   */
  public final void setEmpLeaveBal(final int argEmpLeaveBal) {
    this.empLeaveBal = argEmpLeaveBal;
  }
   /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee id.
   */
  public final void setEmpMrgId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
  /**
   *The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
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

}

