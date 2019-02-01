package com.hexaware.FTP115.model;
import java.util.Date;
import java.util.Objects;
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
    if (Objects.equals(leaId, emp.leaId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(leaId);
  }
  @Override
  public final String toString() {
    return " LeaId:" + leaId + " LeaNoOfDays: " + leaNoOfDays + " LeaveStartDate: "
           + leaStDate + "  leaStDate: " + leaEndDate + " LeaType: "
           + leaType + " LeaReason: " + leaReas + " LeaAppOn: "
           + leaAppOn + " LeaStatus: " + leaStatus + " LeaMngCmt: " + leaMngCmts + " EmpLeaveID: " + leaEmpId;
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
  public final void setLevId(final int argLeaNoOfDays) {
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
  public final int getleaEmpId() {
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


