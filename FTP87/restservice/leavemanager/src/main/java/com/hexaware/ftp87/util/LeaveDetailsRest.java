package com.hexaware.ftp87.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.hexaware.ftp87.model.LeaveDetails;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavedetailsList() {
    System.out.println("LeaveDetais List");
    final LeaveDetails[] leavedetails = LeaveDetails.listAll();
    return leavedetails;
  }

  /**
   * Returns a specific employee's details.
   * @param id the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leavedetailsListById(@PathParam("id") final int id) {
    final LeaveDetails leavedetails = LeaveDetails.listById(id);
    if (leavedetails == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return leavedetails;
  }
  /**
   * Returns a specific leave's details.
   * @param id the id of the leave
   * @return the leave details
   */
  @GET
  @Path("/pending/{i}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavedetailsListPending(@PathParam("i") final int id) {
    final LeaveDetails[] leavedetails = LeaveDetails.listPending(id);
    if (leavedetails == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return leavedetails;
  }
  /**
   * Returns a specific leave's details.
   * @param id the id of the leave
   * @return the leave details
   */
  @GET
  @Path("/history/{i}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leavedetailsLeaveHis(@PathParam("i") final int id) {
    final LeaveDetails[] leavedetails = LeaveDetails.leaveHis(id);
    if (leavedetails == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return leavedetails;
  }
    /**
   * Method for Approve or Deny the Leave.
   * @param leaveId to enter LeaveId to approve/deny.
   * @throws ParseException .
   * @param ld foe leavedetails.
   * @return String.
   */
  @POST
  @Path("/Ad/{mgrId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String approveDeny(@PathParam ("mgrId") final int leaveId,
      final LeaveDetails ld)  throws ParseException {
    String lstatus = ld.getleavestatus().toString();
    String status = null;
    if (lstatus.equals("APPROVED")) {
      status = "YES";
    } else {
      status = "NO";
    }
    String result = LeaveDetails.approveDeny(leaveId,
             ld.getempid(), status, ld.getleavemanagercomm());
    return result;
  }
  /**
   * Returns a specific leave's details.
   * @param empId the id of the leave.
   * @throws ParseException .
   * @param ld foe leavedetails.
   * @return the leave details
   */
  @POST
  @Path("/applyleave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String leaveapplyLeave(@PathParam("empId") final int empId,
                   final LeaveDetails ld) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String leType = ld.getleavetype().toString();
    String result = LeaveDetails.applyLeave(empId, sdf.format(ld.getleavesdate()),
              sdf.format(ld.getleaveedate()), ld.getleavendays(), leType, ld.getleavereason());
    return result;
  }
}
