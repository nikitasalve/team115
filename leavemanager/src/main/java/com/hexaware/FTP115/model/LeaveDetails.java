package com.hexaware.FTP115.model;
import com.hexaware.FTP115.persistence.DbConnection;
import com.hexaware.FTP115.persistence.EmployeeDAO;
import com.hexaware.FTP115.persistence.LeaveDetailsDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
//import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Leave_details class to store employee leave details.
 * @author hexaware.
 */
public class LeaveDetails {
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
  @Override
  public final String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String stD = sdf.format(leaStDate);
    String endD = sdf.format(leaEndDate);
    String lapD = sdf.format(leaAppOn);
    return " LeaId:" + leaId + " LeaNoOfDays: " + leaNoOfDays + " LeaveStartDate: "
           + stD + "  leaEndDate: " + endD + " LeaType: "
           + leaType + " LeaReason: " + leaReas + " LeaAppOn: "
           + lapD + " LeaStatus: " + leaStatus + " LeaMngCmt: " + leaMngCmts + " EmpLeaveID: " + leaEmpId;
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
/**
 * @return leave details connection.
 */
  public static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * @return employee connection.
   */

  public static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }
   /**
   * list LeaveDetails Record for Leaveid.
   * @param leavId id to get Leave details.
   * @return One record Leave' details
   */
  public static LeaveDetails listByLeaveId(final int leavId) {
    LeaveDetails es = dao().listById(leavId);
    return es;
  }
  /**
   * list all LeaveHistory details.
   * @param empId id to get Leave details.
   * @return all Leave' details
   */
  public static LeaveDetails[] listAll(final int empId) {

    List<LeaveDetails> es = dao().leaveHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

   /**
   * list all LeaveHistory details.
   * @param empId id to get Leave details.
   * @return all Leave' details
   */
  public static LeaveDetails[] listPending(final int empId) {
    List<LeaveDetails> es = dao().pending(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * @param argLeavId to set leave id.
   * @param argEmpMgrId to set ManagerID.
   * @param argStatus to set Approve or Deny.
   * @param argMgrComment to set Manager Response.
   * @return leave applied statement.
   */
  public static String approveDeny(final int argLeavId,
      final int argEmpMgrId,
      final String argStatus,
      final String argMgrComment) {
    String res = "";
    LeaveDetails ld = LeaveDetails.listByLeaveId(argLeavId);
    if (ld != null) {
      int noDays = ld.getLeaNoOfDays();
      int empId = ld.getLeaEmpId();
      Employee ed = Employee.listById(empId);
      int leavAvail = ed.getEmpLeaveBal();
      leavAvail = leavAvail + noDays;
      int mgrId = ed.getMgrId();
      String leavStatus = "";
      if (mgrId != argEmpMgrId) {
        res = "You are unauthorized to approve the Leave";
      } else {
        if (argStatus.equals("YES")) {
          res = "Leave Approved Successfully...";
          leavStatus = "APPROVED";
          dao().approveDeny(argLeavId, leavStatus, argMgrComment);
        } else {
          res = "Leave Rejected";
          leavStatus = "REJECTED";
          dao().approveDeny(argLeavId, leavStatus, argMgrComment);
          edao().increment(empId, leavAvail);
        }
      }
    } else {
      res = "Leave ID is not present!";
    }
    return res;
  }

 /**
 * @param argEmpId to set leave id.
 * * @param argLeaStDate to set Leave start date.
   * @param argLeaEndDate to set Leave End date.
   * @param argLeaNoOfDays to set LeaNOOfDays.
   * @param argLeaType to set leave type.
   * @param argLeaReas to set leave reason.
   * @return leave applied statement.
   * @throws ParseException in case there is an error in converting data.
   */
  public static String applyLeave(final int argEmpId,
                                final String argLeaStDate,
                                final String argLeaEndDate,
                                final int argLeaNoOfDays,
                                final LeaveType argLeaType,
                                final String argLeaReas) throws ParseException {
    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
    Date sdate = sdf.parse(argLeaStDate);
    Date edate = sdf.parse(argLeaEndDate);
    Date cur = new Date();
    long ms = edate.getTime() - sdate.getTime();
    long m = ms / (1000 * 24 * 60 * 60);
    int days = (int) m;
    days = days + 1;
    System.out.println("Difference is " + days);
    String res = "";
    final Date curDate = new Date();
    Employee e = Employee.listById(argEmpId); //get details of Employee by empId.
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(sdate);
    if (e != null) {
      final int empMgrid = e.getMgrId();
      int leaAvail = e.getEmpLeaveBal();
      System.out.println("Available  " + leaAvail);
      int diff = leaAvail - days;
      int count = dao().count(argEmpId, argLeaStDate, argLeaEndDate);
      System.out.println("applied count status " + count);
      if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
          || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        res = "StartDate cannot be Saturday or sunday...";
      } else if (count >= 1) {
        res = "Already Applied on Given Date...";
      } else if (days < 0) {
        res = "EndDate must be greater than StartDate..";
      } else if (diff < 0) {
        res = "Insufficient Leave balance";
      } else if (argLeaNoOfDays != days) {
        res = "enter correct number of days as..." + days;
      }  else if (sdate.compareTo(curDate) < 0) {
        res = "start date is less than current date";
      } else if (empMgrid == 0) {
        LeaveStatus leaStatus = LeaveStatus.APPROVED;
        String strleaAppOn = sdf.format(cur);
        dao().insert(argLeaNoOfDays, argLeaStDate, argLeaEndDate,
            argLeaType, argLeaReas, strleaAppOn, leaStatus, argEmpId);
        edao().decrement(argEmpId, diff);
        res = "Leave Autoapproved...";
      } else {
        LeaveStatus leaStatus = LeaveStatus.PENDING;
        String strleaAppOn = sdf.format(cur);
        dao().insert(argLeaNoOfDays, argLeaStDate, argLeaEndDate,
            argLeaType, argLeaReas, strleaAppOn, leaStatus, argEmpId);
        edao().decrement(argEmpId, diff);
        res = "Leave Applied successfully";
      }

    } else {
      res = "Employee ID not found";
    }

    return res;
  }
}


