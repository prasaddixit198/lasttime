package com.hexaware.ftp87.persistence;

import com.hexaware.ftp87.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for leavedetails.
 */
public interface LeavedetailsDAO  {
  /**
   * return all the details of all the Leavedetails.
   * @return the Leavedetails array
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS_DET")
  @Mapper(LeavedetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected Leavedetails.
   * @param leaveid the id of the Leavedetails
   * @return the Leavedetails object
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS_DET WHERE LEAVE_ID = :leaveid")
  @Mapper(LeavedetailsMapper.class)
  LeaveDetails find(@Bind("leaveid") int leaveid);
  /**
  * return Manager the details of the Leave Id.
  * @param leaveID the id of the employee
  * @return the ManagerID value
  */

  @SqlQuery("SELECT E1.EMP_ID FROM Employee_DET E1  "
      + " JOIN Employee_DET E2 ON E1.Emp_ID=E2.MANAGER_ID WHERE E2.EMP_ID =(SELECT EMP_ID FROM LEAVEDETAILS_DET "
      + "   WHERE LEAVE_ID=:leaveID)")
  int showManager(@Bind("leaveID") int leaveID);

  /**
   * @param mgrComments Updated Manager Response data.
   * @param leavStatus Updated Manager Status data.
   * @param leaveid the id of the LeaveDetails
   */
  @SqlUpdate("UPDATE LEAVEDETAILS_DET SET LEAVE_MGRCOMM = :mgrComments, LEAVE_STATUS = :leavStatus WHERE "
      + "LEAVE_ID = :leaveid")
  void comment(@Bind("mgrComments") String mgrComments, @Bind("leavStatus") String leavStatus,
      @Bind("leaveid") int leaveid);


  /**
 * insert all the details of the employee leave.
 * @param empId the employee id of the employee.
 * @param sDate the start date of the employee.
 * @param eDate the end date of the employee.
 * @param days the number of days of the employee.
 * @param ltype the leaveType details of employee.
 * @param lstatus the LeaveStatus details of employee.
 * @param reason the reason for applying.
 * @param appliedDate the applied date of the employee.
 */
  @SqlUpdate("insert into leaveDetails_DET  "
      +
      "             (EMP_ID, "
      +
      "              LEAVE_SDATE, "
      +
      "              LEAVE_EDATE, "
      +
      "              LEAVE_NDAYS, "
      +
      "              LEAVE_TYPE, "
      +
      "              LEAVE_STATUS, "
      +
      "              LEAVE_REASON, "
      +
      "              LEAVE_APPLIEDON) "
      +
      "values       ( "
      +
      "              :empId, "
      +
      "              :sDate, "
      +
      "              :eDate, "
      +
      "              :days, "
      +
      "              :ltype, "
      +
      "              :lstatus, "
      +
      "              :reason, "
      +
      "              :appliedDate)")

void apply(@Bind("empId") int empId,
       @Bind("sDate") String sDate,
       @Bind("eDate") String eDate,
       @Bind("days") int days,
       @Bind("ltype") String ltype,
       @Bind("lstatus") String lstatus,
       @Bind("reason") String reason,
       @Bind("appliedDate") String appliedDate);
 /**
   * return all the details of the Pending LeaveDetails.
   * @param empId the id of the LeaveDetails
   * @return the LeaveDetails Array object
   */

  @SqlQuery("SELECT * FROM LEAVEDETAILS_DET WHERE EMP_ID IN "
      + " (SELECT E2.EMP_ID FROM "
      + " EMPLOYEE_DET E1 INNER JOIN "
      + " EMPLOYEE_DET E2 ON E1.EMP_ID = E2.MANAGER_ID  WHERE E1.EMP_ID=:empId) AND "
      + " LEAVE_STATUS='PENDING'")
  @Mapper(LeavedetailsMapper.class)
List<LeaveDetails> pending(@Bind("empId") int empId);
/**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @param startDate leaveStartDate of employee
   * @param endDate leaveEndDate of employee.
   * @return the total record count
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVEDETAILS_DET "
      +    " WHERE EMP_ID = :empID AND (LEAVE_SDATE BETWEEN :startDate AND :endDate OR "
      +    " LEAVE_EDATE BETWEEN :startDate AND :endDate )")
  int count(@Bind("empID") int empID, @Bind("startDate") String startDate,
      @Bind("endDate") String endDate);
/**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the total record count
   */
  @SqlQuery("SELECT * FROM LEAVEDETAILS_DET WHERE EMP_ID = :empID")
  @Mapper(LeavedetailsMapper.class)
  List<LeaveDetails> empHistory(@Bind("empID") int empID);

  /**
  * close with no args is used to close the connection.
  */
  void close();
}
