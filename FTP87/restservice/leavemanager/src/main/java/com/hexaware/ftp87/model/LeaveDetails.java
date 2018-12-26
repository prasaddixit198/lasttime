package com.hexaware.ftp87.model;

import com.hexaware.ftp87.persistence.DbConnection;
import com.hexaware.ftp87.persistence.EmployeeDAO;
import com.hexaware.ftp87.persistence.LeavedetailsDAO;
import java.util.Date;
import java.util.Objects;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * leavedetails class to store employee personal details.
 * @author hexware
 */
public class LeaveDetails {

  /**
   * leaveid to store leave id.
   */
  private int leaveid;
  /**
   * empid to store employee id.
   */
  private int empid;
  /**
   * leavesdate to store leave Start date.
   */
  private Date leavesdate;
  /**
   * LEAVE_EDATE to store leave End date.
   */
  private Date leaveedate;
  /**
   * leavendays to store leave no of days.
   */
  private int leavendays;
  /**
   * leavetype to store  leave type.
   */
  private LeaveType leavetype;
  /**
   * leavestatus to store  leave status.
   */
  private LeaveStatus leavestatus;
  /**
   * leavereason to store leave reason.
   */
  private String leavereason;
  /**
   * leaveappliedon to store leave appliedon.
   */
  private Date leaveappliedon;
  /**
   * leavemanagercomm to store  manager comments.
   */
  private String leavemanagercomm;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails ld = (LeaveDetails) obj;
    if (Objects.equals(leaveid, ld.leaveid)
        && Objects.equals(empid, ld.empid)
        && Objects.equals(leavesdate, ld.leavesdate)
        && Objects.equals(leaveedate, ld.leaveedate)
        && Objects.equals(leavendays, ld.leavendays)
        && Objects.equals(leavetype, ld.leavetype)
        && Objects.equals(leavestatus, ld.leavestatus)
        && Objects.equals(leavereason, ld.leavereason)
        && Objects.equals(leaveappliedon, ld.leaveappliedon)
        && Objects.equals(leavemanagercomm, ld.leavemanagercomm)) {
      return true;
    }
    return false;
  }
  @Override
  public final String toString() {
    return "leave ID :" + leaveid + "emp ID :" + empid
      + "Leave start date :" + leavesdate
      + "end Date :" + leaveedate + "No of days:"
      + leavendays + "Leave type :" + leavetype
      + "Leave status :" + leavestatus
      + "leave reason :" +  leavereason
      + "Leave apply date :" + leaveappliedon
      + "Manager comment :" + leavemanagercomm;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaveid, empid, leavesdate, leaveedate, leavendays, leavetype, leavestatus,
    leavereason, leaveappliedon, leavemanagercomm);
  }

  /**
   * @param argleaveid to initialize Leavedetails id.
   * @param argempid to initialize employee id.
   * @param argleavesdate to initialize Leavedetails start date.
   * @param argleaveedate to initialize Leavedetails end date.
   * @param argleavendays to initialize Leavedetails no of days.
   * @param argleavetype to initialize Leavedetails type.
   * @param argleavestatus to initialize Leave status.
   * @param argleavereason to initialize Leave reason.
   * @param argleaveappliedon to initialize leave applied on.
   * @param argleavemanagercomm to initialize leave manager comments.
   */
  public LeaveDetails(final int argleaveid, final int argempid, final Date argleavesdate, final Date argleaveedate,
      final int argleavendays, final LeaveType argleavetype, final LeaveStatus argleavestatus,
      final String argleavereason, final Date argleaveappliedon, final String argleavemanagercomm) {
    this.leaveid = argleaveid;
    this.empid = argempid;
    this.leavesdate = argleavesdate;
    this.leaveedate = argleaveedate;
    this.leavendays = argleavendays;
    this.leavetype = argleavetype;
    this.leavestatus = argleavestatus;
    this.leavereason = argleavereason;
    this.leaveappliedon = argleaveappliedon;
    this.leavemanagercomm = argleavemanagercomm;
  }
  /**
   * creates the default constructor .
   */
  public LeaveDetails() {
  }
  /**
   * Gets the leave id.
   * @return this Employee's leave ID.
   */
  public final int getleaveid() {
    return leaveid;
  }

  /**
   *
   * @param argleaveid to set leave id.
   */
  public final void setleaveid(final int argleaveid) {
    this.leaveid = argleaveid;
  }
  /**
   * Gets the Employeeid.
   * @return this Employee's id.
   */
  public final int getempid() {
    return empid;
  }
  /**
   *
   * @param argEmpid to set employee id.
   */
  public final void setEmpid(final int argEmpid) {
    this.empid = argEmpid;
  }
  /**
   * Gets the Leave start date.
   * @return this Leave start date.
   */
  public final Date getleavesdate() {
    return leavesdate;
  }

  /**
   *
   * @param argleavesdate to set Leave start date.
   */
  public final void setleavesdate(final Date argleavesdate) {
    this.leavesdate = argleavesdate;
  }
   /**
   * Gets the Employee end date.
   * @return this Employee end date.
   */
  public final Date getleaveedate() {
    return leaveedate;
  }

  /**
   *
   * @param argleaveedate to set leave end date.
   */
  public final void setleaveedate(final Date argleaveedate) {
    this.leaveedate = argleaveedate;
  }
   /**
   * Gets the leave no of days.
   * @return this leave no of days.
   */
  public final int getleavendays() {
    return leavendays;
  }

  /**
   *
   * @param argleavendays to set leave no of days.
   */
  public final void setleavendays(final int argleavendays) {
    this.leavendays = argleavendays;
  }
   /**
   * Gets the leave type.
   * @return this Employee leave type.
   */
  public final LeaveType getleavetype() {
    return leavetype;
  }

  /**
   *
   * @param argleavetype to set employee leave type.
   */
  public final void setleavetype(final LeaveType argleavetype) {
    this.leavetype = argleavetype;
  }
   /**
   * Gets the leavestatus.
   * @return this Employee's leavestatus.
   */
  public final LeaveStatus getleavestatus() {
    return leavestatus;
  }

  /**
   *
   * @param argleavestatus to set employee leavestatus.
   */
  public final void setleavestatus(final LeaveStatus argleavestatus) {
    this.leavestatus = argleavestatus;
  }
   /**
   * Gets the leavereason.
   * @return this Employee's leavereason.
   */
  public final String getleavereason() {
    return leavereason;
  }

  /**
   *
   * @param argleavereason to set employee leavereason.
   */
  public final void setleavereason(final String argleavereason) {
    this.leavereason = argleavereason;
  }
    /**
   * Gets the leaveappliedon.
   * @return this Employee's leaveappliedon.
   */
  public final Date getleaveappliedon() {
    return leaveappliedon;
  }

  /**
   *
   * @param argleaveappliedon to set employee leaveappliedon.
   */
  public final void setleaveappliedon(final Date argleaveappliedon) {
    this.leaveappliedon = argleaveappliedon;
  }
    /**
   * Gets the leavemanagercomm.
   * @return this Employee's leavemanagercomm.
   */
  public final String getleavemanagercomm() {
    return leavemanagercomm;
  }

  /**
   *
   * @param argleavemanagercomm to set employee leavemanagercomm.
   */
  public final void setleavemanagercomm(final String argleavemanagercomm) {
    this.leavemanagercomm = argleavemanagercomm;
  }
  /**
   * The dao for Leavedetails.
   */
  private static LeavedetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeavedetailsDAO.class);
  }
/**
   * The dao for employee.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * The edao for EmployeeDetails.
   */
  private static EmployeeDAO sdao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }


  /**
   * list all employee details.
   * @return all employees' details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list all employee leave details.
   * @param mgrId id to get employee leave details.
   * @return all employees' leave details
   */
  public static LeaveDetails[] listPending(final int mgrId) {

    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list employee details by id.
   * @param leaveid id to get employee details.
   * @return Employee
   */
  public static LeaveDetails listById(final int leaveid) {
    return dao().find(leaveid);
  }
   /**
  * returns ManagerId for. LeaveId value
  * @param leaveId id to get employee manager details.
  * @return int.
  */
  public static int showManager(final int leaveId) {
    return dao().showManager(leaveId);
  }
/**
   * NO of overlapping Leaves.
   * @param empId id to get employee details.
   * @param startDate id to get employee details.
   * @param endDate id to get employee details.
   * @return count of no of employee.
   */
  public static int countNo(final int empId, final String startDate, final String endDate) {
    int count = dao().count(empId, startDate, endDate);
    return count;
  }
/**
   * NO of overlapping Leaves.
   * @param empID id to get employee details.
   * @return history of the leaves applied
   */

  public static LeaveDetails[] leaveHis(final int empID) {
    List<LeaveDetails> es = dao().empHistory(empID);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * Method for Approve or Deny the Leave.
   * @param leaveId to enter LeaveId to approve/deny.
   * @param lstatus to enter status to approve/deny.
   * @param empId to enter status to approve/deny.
   * @param mgrcomments to get manager comments.
   * @return String.
   */
  public static String approveDeny(final int leaveId, final int empId, final String lstatus, final String mgrcomments) {
    LeaveDetails ld = LeaveDetails.listById(leaveId);
    int empdId = LeaveDetails.showManager(leaveId);
    String res = null;
    String dbStatus = null;
    if (ld != null) {
      int noOfDays = ld.getleavendays();
      System.out.println(lstatus);
      if (empId != empdId) {
        res = "You are not authorised to access this employee.";
        return res;
      }
      if (lstatus.equals("YES")) {
        dbStatus = "APPROVED";
        res = "Leave Approved Successfully";
      } else if (lstatus.equals("NO")) {
        dbStatus = "DENIED";
        sdao().increment(empId, noOfDays);
        res = "Leave Rejected";
      } else {
        sdao().increment(empId, noOfDays);
        res = "Invalid entry";
      }
      dao().comment(mgrcomments, dbStatus, leaveId);
    } else {
      res = "Invalid leaveid";
    }
    dao().comment(mgrcomments, dbStatus, leaveId);
    return res;
  }

  /**
   * AppplyLeave for employee.
   * @param empId id to give employee id.
   * @param startDate to give leave Statdate.
   * @param endDate to give employee endDate.
   * @param noOfdays to give employee noOfdays.
   * @param leaveType to give employee leaveType.
   * @param leaveReason to give employee leaveReason.
   * @throws ParseException throws Parse Exception.
   * @return String
   */
  public static String applyLeave(final int empId,
                                  final String startDate,
                                  final String endDate,
                                  final int noOfdays,
                                  final String leaveType,
                                  final String leaveReason
  ) throws ParseException {
    Employee emplo = Employee.listById(empId);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date stDate = sdf.parse(startDate);
    Date enDate = sdf.parse(endDate);
    Calendar start = Calendar.getInstance();
    start.setTime(stDate);
    Calendar end = Calendar.getInstance();
    end.setTime(enDate);
    int count = 0;
    for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
      if (dayOfWeek == 1 || dayOfWeek == 7) {
        count++;
      }
    }
    System.out.println(count);
    long diff = enDate.getTime() - stDate.getTime();
    long days = diff / (1000 * 60 * 60 * 24);
    days = days + 1;
    String s = null;
    int leavendays;
    System.out.println(days);
    String status = null;
    long updLeave = 0;
    Date today = new Date();
    String appliedOn = sdf.format(today);
    //Employee employee = edao().find(empId);
    if (emplo != null) {
      int overlap = LeaveDetails.countNo(empId, startDate, endDate);
      long dif = emplo.getEmpLeavbal() - days;
      leavendays = emplo.getEmpLeavbal();
      System.out.println("Balance Available: " + leavendays);
      updLeave = emplo.getEmpLeavbal() - days;
      s = "object not created";
      if (days <= 0) {
        s = "StartDate Must be Greater than EndDate...";
      } else if (dif < 0) {
        s = "insufficient leav balance";
      } else if (noOfdays != days) {
        s = "NO Of Days Should be right";
      } else if (overlap > 0) {
        s = "already applied on given date";
      } else {
        if (emplo.getEmpMgrid() == 0) {
          status = "APPROVED";
          dao().apply(empId, startDate, endDate, noOfdays, leaveType, status, leaveReason, appliedOn);
          int bal = (int) updLeave;
          edao().decrement(empId, bal);
          s = "Leave AutoApproved Successfully..." + (days - count) + " Days ";
        } else {
          status = "PENDING";
          dao().apply(empId, startDate, endDate, noOfdays, leaveType, status, leaveReason, appliedOn);
          int bal = (int) updLeave;
          edao().decrement(empId, bal);
          s = "Leave Applied Successfully..." + (days - count) + " Days ";
        }
      }
    } else {
      s = "Employ id not found";
    }
    return s;
  }
}

