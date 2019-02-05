package com.hexaware.FTP115.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.hexaware.FTP115.model.LeaveDetails;
import com.hexaware.FTP115.model.LeaveStatus;
import com.hexaware.FTP115.model.LeaveType;

import java.util.List;
/**
   *The DAO class for employee.
   */
public interface LeaveDetailsDAO {
    /**
    * return all the details of the selected employee.
    *@param leaEmpId the id of the employee.
    @return the employee object.
    */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_EMP_ID= :leaEmpId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> leaveHistory(@Bind("leaEmpId") int leaEmpId);

   /**
    * return all the details of the selected employee.
    *@param leaLeaveId the id of the leaveId.
    @return the employee object.
    */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_LEAVE_ID= :leaLeaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails listById(@Bind("leaLeaveId") int leaLeaveId);
  /**
    * return all the details of the selected employee.
    *@param empId the id of the Manager.
    @return the Pending Leaves of Manager.
    */
  @SqlQuery("SELECT * FROM leave_Details WHERE LEA_EMP_ID IN "
        +
      " (SELECT E2.Emp_ID FROM Employee E1 INNER JOIN EMPLOYEE E2 "
        +
      " ON E1.EMP_ID=E2.EMP_MGR_ID "
        +
      " WHERE E1.EMP_ID=:empId) "
        +
      " AND LEA_LEAVE_STATUS='PENDING'")
  @Mapper(LeaveDetailsMapper.class)
List<LeaveDetails> pending(@Bind("empId") int empId);

  /**
    * Update ApproveDeny Status .
    * @param leaveStatus the LeaveStaus final valuer.
    * @param mgrComm the Manager Response.
    * @param leavId leaveid for approve/Deny.
    */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEA_LEAVE_STATUS = :leaveStatus, "
        +
        " LEA_MGR_COMMENTS = :mgrComm WHERE LEA_LEAVE_ID = :leavId")
    void approveDeny(@Bind("leavId") int leavId,
          @Bind("leaveStatus") String leaveStatus,
          @Bind("mgrComm") String mgrComm);
    /**
     * return all the leave details of the employee.
     * @param leaNoOfDays leave total days of the employee.
     * @param leaStDate start date of the employee.
     * @param leaEndDate End date of the employee.
     * @param leaType leave type of the employee.
     * @param leaReas reason of the employee.
     * @param leaAppOn applied on of the employee.
     * @param leaStatus leave status of the employee.
     * @param leaEmpId employee id of the employee.
     */
  @SqlUpdate("insert into LEAVE_DETAILS "
            +
            "       (LEA_NO_OF_DAYS, "
            +
            "       LEA_START_DATE, "
            +
            "       LEA_END_DATE, "
            +
            "       LEA_LEAVE_TYPE, "
            +
            "       LEA_REASON, "
            +
            "       LEA_APPLIED_ON, "
            +
            "       LEA_LEAVE_STATUS, "
            +
            "       LEA_EMP_ID) "
            +
            "values    ( "
            +
            "              :leaNoOfDays, "
            +
            "              :leaStDate, "
            +
            "              :leaEndDate, "
            +
            "              :leaType, "
            +
            "              :leaReas, "
            +
            "              :leaAppOn, "
            +
            "               :leaStatus, "
            +
            "              :leaEmpId)")
    void insert(@Bind("leaNoOfDays") int leaNoOfDays,
            @Bind("leaStDate") String leaStDate,
            @Bind("leaEndDate") String leaEndDate,
            @Bind("leaType") LeaveType leaType,
            @Bind("leaReas") String leaReas,
            @Bind("leaAppOn") String leaAppOn,
            @Bind("leaStatus") LeaveStatus leaStatus,
            @Bind("leaEmpId") int leaEmpId);

}
