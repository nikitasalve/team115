package com.hexaware.ftp.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp.model.Dept;;

public class DeptMapper implements ResultSetMapper<Dept> {
  public final Dept map(final int idx, final ResultSet rs,
   final StatementContext ctx) throws SQLException {
    return new Dept(rs.getInt("deptno"), rs.getString("dname"), 
      rs.getString("loc"));
        
  }
}
