<<<<<<< HEAD
package com.hexaware.FTP115.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP115.model.Employee;
/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final      StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new Employee(rs.getInt("EMP_ID"), rs.getString("EMP_FULL_NAME"), rs.getString("EMP_EMAIL_ID"),
                        rs.getString("EMP_MOBILE_NO"), rs.getDate("EMP_DATE_OF_JOINING"),
                        rs.getString("EMP_DEPARTMENT"), rs.getInt("EMP_MGR_ID"),
                        rs.getInt("EMP_AVAIL_LEAVE_BALANCE"));
  }
}
=======
package com.hexaware.FTP115.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP115.model.Employee;
/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final      StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new Employee(rs.getInt("EMP_ID"), rs.getString("EMP_FULL_NAME"), rs.getString("EMP_EMAIL_ID"),
                        rs.getString("EMP_MOBILE_NO"), rs.getDate("EMP_DATE_OF_JOINING"),
                        rs.getString("EMP_DEPARTMENT"), rs.getInt("EMP_MGR_ID"),
                        rs.getInt("EMP_AVAIL_LEAVE_BALANCE"));
  }
}
>>>>>>> 2e118db2de146e4596351f78afd36a7390788349
