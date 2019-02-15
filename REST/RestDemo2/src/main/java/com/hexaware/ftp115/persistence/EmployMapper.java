package com.hexaware.ftp115.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org .skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp115.model.Employ;
/**
 * Mapper class to map from result set to employee object.
 */
public class EmployMapper implements ResultSetMapper<Employ> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Employ map(final int idx, final ResultSet rs, final      StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new Employ(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"), rs.getString("hiredate"),
    rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno"));

  }

}
