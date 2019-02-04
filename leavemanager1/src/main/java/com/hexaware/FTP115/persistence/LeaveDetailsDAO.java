package com.hexaware.FTP115.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.hexaware.FTP115.model.LeaveDetails;
import com.hexaware.FTP115.model.LeaveStatus;
import com.hexaware.FTP115.model.LeaveType;

import java.util.List;
import java.util.Date;

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
  List<LeaveDetails> list(@Bind("leaEmpId") int leaEmpId);

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
            "       LEA_LEAVE_TYPE "
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
            @Bind("leaStDate") Date leaStDate,
            @Bind("leaEndDate") Date leaEndDate,
            @Bind("leaType") LeaveType leaType,
            @Bind("leaReas") String leaReas,
            @Bind("leaAppOn") Date leaAppOn,
            @Bind("leaStatus") LeaveStatus leaStatus,
            @Bind("leaEmpId") int leaEmpId);
/**
   * @param  empId of the employee.
   * @param newBalance the id of the Leave balance.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET"
      +
      "    EMP_AVAIL_LEAVE_BALANCE = :newBalance "
      +
      "    WHERE EMP_ID = :empId")
void levBalance(@Bind("newBalance") int newBalance, @Bind("empId") int empId);

/**
   * @param  leaEmpId of the employee.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET"
      +
      "    LEAVE_STATUS = 'APPROVED' "
      +
      "    WHERE LEA_EMP_ID = :leaEmpId")
  void autoapproved(@Bind("leaEmpId") int leaEmpId);
/**
    * @return returns the list.
    * @param empId the id of the employee.
    */
  @SqlQuery("select distinct * from employee where EMP_MGR_ID  in ( :empId); ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails listMgr(@Bind("empId") int empId);

/**
* @param empId the id of the manager.
* @return returns the list.
*/
  @SqlQuery("select * from employee where EMP_ID = (select  EMP_MGR_ID  from employee where EMP_ID  in (:empId)); ")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails listMgr1(@Bind("empId") int empId);

/**
* close with no args is used to close the connection.
*/
  void close();
}
