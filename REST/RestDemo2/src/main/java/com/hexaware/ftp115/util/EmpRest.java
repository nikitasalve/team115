package com.hexaware.ftp115.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp115.model.Employ;

@Path("/employ")
public class EmpRest {

     @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Employ[] employList() {
    System.out.println("Employees List");
    final Employ[] employ = Employ.listAll();
    return employ;
  }

  @POST
  @Path("/employInsert/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String insertEmploy(final Employ e) {
    String s = Employ.insertEmp(e);
    System.out.println(s);
    return s;
  }
/**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Employ employeeListById(@PathParam("id") final int id) {
    final Employ empl = Employ.listById(id);
    if (empl == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return empl;
  }

}