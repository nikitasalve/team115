package com.hexaware.FTP115.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;

import java.text.ParseException;


import com.hexaware.FTP115.model.LeaveDetails;


/**
 * This class provides a REST interface for the leave details entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {
    /**
   * Returns a list of all the employees details.
   * @return a list of all the employees details.
   */
  @GET
    @Produces(MediaType.APPLICATION_JSON)
    public final LeaveDetails[] leavdetailsList() {
    System.out.println("Leave Details List");
    final LeaveDetails[] leaved = LeaveDetails.listAll1();
    return leaved;
  }

  /**
     * Returns a specific employee's details.
     * @param id the id of the employee
     * @return the employee details
     */
  @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final LeaveDetails leaveListById(@PathParam("id") final int id) {
    final LeaveDetails l1 = LeaveDetails.listByLeaveId(id);
    if (l1 == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return l1;
  }

    /**
     * Returns a specific employee's details.
     * @param id the id of the employee
     * @return the employee details
     */
  @GET
    @Path("/leavehistory/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final LeaveDetails[] leaveHistory(@PathParam("id") final int id) {
    final LeaveDetails[] h1 = LeaveDetails.listAll(id);
    if (h1.length == 0) {
      throw new NotFoundException("No leave history: " + id);
    }
    return h1;
  }
   /**
     * Returns a specific employee's details.
     * @param id the id of the employee
     * @return the employee details
     */
  @GET
    @Path("/leavepending/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public final LeaveDetails[] leavePending(@PathParam("id") final int id) {
    final LeaveDetails[] p1 = LeaveDetails.listPending(id);
    if (p1.length == 0) {
      throw new NotFoundException("No leave pending: " + id);
    }
    return p1;
  }
  /**
   * @param empid for input employee Id.
   * @param e input leave details.
   * @return applied leave status.
   * @throws ParseException for handling Date issue.
   */
  @POST
  @Path("/applyleave/{empid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String applyleave(@PathParam("empid") final int empid, final LeaveDetails e) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String stDate = sdf.format(e.getLeaStDate());
    String eDate = sdf.format(e.getLeaEndDate());
    String s = LeaveDetails.applyLeave(empid, stDate, eDate,
                         e.getLeaNoOfDays(), e.getLeaType(), e.getLeaReas());
    return s;
  }
  /**
   * @param empMgrId for input employee  mgrId.
   * @param e input leave details.
   * @return applied leave status.
   * @param status for status.
   * @throws ParseException for handling Date issue.
   */
  @POST
  @Path("/approveDeny/{empMgrId}/{status}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String approvedeny(@PathParam("empMgrId") final int empMgrId,
        @PathParam("status") final String status, final LeaveDetails e) throws ParseException {
    String s = LeaveDetails.approveDeny(e.getLeaId(), empMgrId, status,
        e.getLeaMngCmts());
    return s;
  }
}





