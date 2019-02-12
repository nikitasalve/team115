package com.hexaware.FTP115.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.FTP115.model.LeaveDetails;
import com.hexaware.FTP115.model.LeaveStatus;
import com.hexaware.FTP115.model.LeaveType;
/**
 * Mapper class to map from result set to employee object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped employee object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx)throws SQLException {

    String s1 = rs.getString("LEAVE_TYPE");
    LeaveType l1 = LeaveType.valueOf(s1);

    String s2 = rs.getString("LEAVE_STATUS");
    LeaveStatus l2 = LeaveStatus.valueOf(s2);
        /**
         * @return LeaveHistory
         */
    return new LeaveDetails(rs.getInt("LEA_LEAVE_ID"), rs.getInt("LEA_NO_OF_DAYS"), rs.getDate("LEA_START_DATE"),
                rs.getDate("LEA_END_DATE"), l1, rs.getString("LEA_LEAVE_REASON"),
                rs.getDate("LEA_APPLIED_ON"), l2, rs.getString("LEA_MGR_COMMENTS"),
                rs.getInt("LEA_EMP_ID"));
  }
}