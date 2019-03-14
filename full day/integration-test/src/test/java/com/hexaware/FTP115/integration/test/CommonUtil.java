package com.hexaware.FTP115.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP115");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}
/**
 * LeaveType enum to store LeaveType data.
 * @author hexaware
 */

enum LeaveType {
  /**
  * leaveType to store EL.
  */
  EL,

  /**
  * leaveType to store PL.
  */
  PL,

  /**
  * leaveType to store ML.
  */
  ML;

}

/**
 * LeaveStatus enum to store LeaveStatus data.
 * @author hexaware
 */

 enum LeaveStatus {
  /**
  * leaveStatus to store APPROVED.
  */
  APPROVED,
    /**
    * leaveStatus to store REJECTED.
    */
  REJECTED,
    /**
    * leaveStatus to store PENDING.
    */
  PENDING;
}

 class LeaveDetails {
/**
   * LeaId to store leave id.
   * LeaNoOfDays to store Leave no of days.
   * LeaStDate to store leave start date.
   * LeaEndDate to store leave End date.
   * LeaType to store leave type.
   * LeaReas to get the reason.
   * LeaAppOn to get applied leave date.
   * LeaStatus to check status of leave.
   * LeaMngcmts to store comments of manager.
   * LeaEmpId to give employee ID.
   */
  private int leaId;
  private int leaNoOfDays;
  private Date leaStDate;
  private Date leaEndDate;
  private LeaveType leaType;
  private String leaReas;
  private Date leaAppOn;
  private LeaveStatus leaStatus;
  private String leaMngCmts;
  private int leaEmpId;
  @Override
public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails emp = (LeaveDetails) obj;
    if (Objects.equals(leaId, emp.leaId)
        && Objects.equals(leaNoOfDays, emp.leaNoOfDays)
        && Objects.equals(leaStDate, emp.leaStDate)
        && Objects.equals(leaEndDate, emp.leaEndDate)
        && Objects.equals(leaType, emp.leaType)
        && Objects.equals(leaReas, emp.leaReas)
        && Objects.equals(leaAppOn, emp.leaAppOn)
        && Objects.equals(leaStatus, emp.leaStatus)
        && Objects.equals(leaMngCmts, emp.leaMngCmts)
        && Objects.equals(leaEmpId, emp.leaEmpId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(leaId, leaNoOfDays, leaStDate, leaEndDate, leaType,
    leaReas, leaAppOn, leaStatus, leaMngCmts, leaEmpId);
  }
 
   /**
  default Constructor.
  */
  public LeaveDetails() {
  }
/**
   * @param argLeaId to initialize leave id.
   * @param argLeaNoOfDays to initialize LeaNOOfDays.
   * @param argLeaStDate to initialize Leave start date.
   * @param argLeaEndDate to initialize Leave End date.
   * @param argLeaType to initialize leave type.
   * @param argLeaReas to initialize leave reason.
   * @param argLeaAppOn to initialize leave Applied on.
   * @param argLeaStatus to initialize leave status.
   * @param argLeaMngCmts to initialize leave manager comments.
   * @param argLeaEmpId to initialize leave Employee ID.
   */
  public LeaveDetails(final int argLeaId, final int argLeaNoOfDays, final Date argLeaStDate, final Date argLeaEndDate,
      final LeaveType argLeaType, final String argLeaReas, final Date argLeaAppOn, final LeaveStatus argLeaStatus,
      final String argLeaMngCmts, final int argLeaEmpId) {
    this.leaId = argLeaId;
    this.leaNoOfDays = argLeaNoOfDays;
    this.leaStDate = argLeaStDate;
    this.leaEndDate = argLeaEndDate;
    this.leaType = argLeaType;
    this.leaReas = argLeaReas;
    this.leaAppOn = argLeaAppOn;
    this.leaStatus = argLeaStatus;
    this.leaMngCmts = argLeaMngCmts;
    this.leaEmpId = argLeaEmpId;
  }
  /**
   * Gets the Leave Id.
   * @return this Leave ID.
   */
  public final int getLeaId() {
    return leaId;
  }

  /**
   *
   * @param argLeaId to set leave id.
   */
  public final void setLeaId(final int argLeaId) {
    this.leaId = argLeaId;
  }
  /**
   * Gets the Leave number of days.
   * @return this LeaveNoOfDays.
   */
  public final int getLeaNoOfDays() {
    return leaNoOfDays;
  }
  /**
   *
   * @param argLeaNoOfDays to set LeaNoOfDays.
   */
  public final void setLeaNoOfDays(final int argLeaNoOfDays) {
    this.leaNoOfDays = argLeaNoOfDays;
  }
  /**
  *Gets the LeaveStartDate.
  *@return this LeaveStartDate.
  */
  public final Date getLeaStDate() {
    return leaStDate;
  }
  /**
  *
  *@param argLeaStDate to set Leave StartDate.
  */
  public final void setLeaStDate(final Date argLeaStDate) {
    this.leaStDate = argLeaStDate;
  }
  /**
  *Gets the LeaveEndDate.
  *@return this LeaveEndDate.
  */
  public final Date getLeaEndDate() {
    return leaEndDate;
  }
  /**
  *
  *@param argLeaEndDate to set Leave EndDate.
  */
  public final void setLeaEndDate(final Date argLeaEndDate) {
    this.leaEndDate = argLeaEndDate;
  }
  /**
   * Gets the LeaveTYpe.
   * @return this Employee's ID.
   */
  public final LeaveType getLeaType() {
    return leaType;
  }
  /**
   * @param argLeaType to set Leave Type.
   */
  public final void setLeaType(final LeaveType argLeaType) {
    this.leaType = argLeaType;
  }
  /**
  *Gets the Leave Reason.
  *@return this Leave Reason.
  */
  public final String getLeaReas() {
    return leaReas;
  }

  /**
  *
  *@param argLeaReas to set Employee Leave Reason.
  */
  public final void setLeaReas(final String argLeaReas) {
    this.leaReas = argLeaReas;
  }
  /**
  *Gets the Leave Applied on.
  *@return this LeaAppOn.
  */
  public final Date getLeaAppOn() {
    return leaAppOn;
  }
  /**
  *
  *@param argLeaAppOn to set Leave ApplyDate.
  */
  public final void setLeaAppOn(final Date argLeaAppOn) {
    this.leaAppOn = argLeaAppOn;
  }
  /**
   * Gets the Leave Status.
   * @return this Leave Status.
   */
  public final LeaveStatus getLeaStatus() {
    return leaStatus;
  }
  /**
   * @param argLeaStat to set Leave Status.
   */
  public final void setLeaStatus(final LeaveStatus argLeaStat) {
    this.leaStatus = argLeaStat;
  }
  /**
  *Gets the Leave Manager Comments.
  *@return this Leave Manager Comments.
  */
  public final String getLeaMngCmts() {
    return leaMngCmts;
  }

  /**
  *
  *@param argLeaMngCmts to set Employee Manager Comments.
  */
  public final void setLeaMngCmts(final String argLeaMngCmts) {
    this.leaMngCmts = argLeaMngCmts;
  }


  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getLeaEmpId() {
    return leaEmpId;
  }

  /**
   *
   * @param argLeaEmpId to set employee id.
   */
  public final void setLeaEmpId(final int argLeaEmpId) {
    this.leaEmpId = argLeaEmpId;
  }
}


class Employee {
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
     final SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		  final String d1=sdf.format(empDOJ);
          final String d2=sdf.format(emp.empDOJ);
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMobile, emp.empMobile)
        && Objects.equals(d1, d2)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLeaveBal, emp.empLeaveBal)
        && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, empEmail, empMobile, empDept, empDOJ, empMgrId, empLeaveBal);
  }

 
  /**
  default Constructor.
  */
  public Employee() {
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
  public final void setEmpDepart(final String argEmpDept) {
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
  public final void setMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
