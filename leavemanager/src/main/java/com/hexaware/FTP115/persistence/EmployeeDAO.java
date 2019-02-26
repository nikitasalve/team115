<<<<<<< HEAD
package com.hexaware.FTP115.persistence;

import com.hexaware.FTP115.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
    * Update LeaveBalance after ApplyLeave.
    *@param empId the id of the Manager.
    * @param updBal the latest leave Balance.
    */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BALANCE = :updBal WHERE EMP_ID = :empId")
  void decrement(@Bind("empId") int empId, @Bind("updBal") int updBal);
  /**
    * Update LeaveBalance after ApplyLeave.
    *@param empId the id of the Manager.
    * @param updBal the latest leave Balance.
    */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BALANCE = :updBal WHERE EMP_ID = :empId")
    void increment(@Bind("empId") int empId, @Bind("updBal") int updBal);
    /**
  /**
   *
  * close with no args is used to close the connection.
  */
  void close();
}
=======
package com.hexaware.FTP115.persistence;

import com.hexaware.FTP115.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
    * Update LeaveBalance after ApplyLeave.
    *@param empId the id of the Manager.
    * @param updBal the latest leave Balance.
    */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BALANCE = :updBal WHERE EMP_ID = :empId")
  void decrement(@Bind("empId") int empId, @Bind("updBal") int updBal);
  /**
    * Update LeaveBalance after ApplyLeave.
    *@param empId the id of the Manager.
    * @param updBal the latest leave Balance.
    */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAIL_LEAVE_BALANCE = :updBal WHERE EMP_ID = :empId")
    void increment(@Bind("empId") int empId, @Bind("updBal") int updBal);
    /**
  /**
   *
  * close with no args is used to close the connection.
  */
  void close();
}
>>>>>>> 2e118db2de146e4596351f78afd36a7390788349
