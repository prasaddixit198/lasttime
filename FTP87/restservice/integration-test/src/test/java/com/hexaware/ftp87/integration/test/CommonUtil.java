package com.hexaware.ftp87.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp87");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
  
   /**
   * empId to store employee id.
   */
  private int empId;
  /**
   * empName to store employee Name.
   */
  private String empName;
  /**
   * empDept to store employee Dept.
   */
  private String empDept;
  /**
   * empEmail to store employee Email.
   */
  private String empEmail;
  /**
   * empMob to store employee Mobile no.
   */
  private String empMob;
  /**
   * empDoj to store employee Date of joining.
   */
  private Date empDoj;
  /**
   * empLeavbal to store employee leave balance.
   */
  private int empLeavbal;
  /**
   * empMgrid to store employee manager id.
   */
  private int empMgrid;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMob, emp.empMob)
        && Objects.equals(empDoj, emp.empDoj)
        && Objects.equals(empLeavbal, emp.empLeavbal)
        && Objects.equals(empMgrid, emp.empMgrid)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empDept, empEmail, empMob, empDoj, empLeavbal, empMgrid);
  }
  /**
   * default constructor of employee.
   */
  public Employee() {
  }
  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpDept to initialize employee Dept.
   * @param argEmpEmail to initialize employee Email.
   * @param argEmpMob to initialize employee Mobile no.
   * @param argEmpDoj to initialize employee Doj.
   * @param argEmpLeavbal to initialize employee Leave balance.
   * @param argEmpMgrid to initialize employee Mgrid.
   */

  public Employee(final int argEmpId, final String argEmpName, final String argEmpDept, final String argEmpEmail,
      final String argEmpMob, final Date argEmpDoj, final int argEmpLeavbal,
      final int argEmpMgrid) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empDept = argEmpDept;
    this.empEmail = argEmpEmail;
    this.empMob = argEmpMob;
    this.empDoj = argEmpDoj;
    this.empLeavbal = argEmpLeavbal;
    this.empMgrid = argEmpMgrid;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
 /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }
  /**
   *
   * @param argEmpName to set employee Name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   * Gets the Employeedepartment.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argEmpDept to set employee Department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
   /**
   * Gets the EmployeeEmail.
   * @return this Employee's email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee id.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
   /**
   * Gets the EmployeeMob.
   * @return this Employee's Mob.
   */
  public final String getEmpMob() {
    return empMob;
  }

  /**
   *
   * @param argEmpMob to set employee Mob.
   */
  public final void setEmpMob(final String argEmpMob) {
    this.empMob = argEmpMob;
  }
   /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param argEmpDoj to set employee Doj.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
   /**
   * Gets the EmployeeLeavbal.
   * @return this Employee's Leavbal.
   */
  public final int getEmpLeavbal() {
    return empLeavbal;
  }

  /**
   *
   * @param argEmpLeavbal to set employee Leavbal.
   */
  public final void setEmpLeavbal(final int argEmpLeavbal) {
    this.empLeavbal = argEmpLeavbal;
  }
   /**
   * Gets the EmployeeMgrid.
   * @return this Employee's Mgrid.
   */
  public final int getEmpMgrid() {
    return empMgrid;
  }

  /**
   *
   * @param argEmpMgrid to set employee Mgrid.
   */
  public final void setEmpMgrid(final int argEmpMgrid) {
    this.empMgrid = argEmpMgrid;
  }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
class LeaveDetails {

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
 * LeaveStatus enum to store employee LeaveStatus details.
 * @author hexware
 */
}
 enum LeaveStatus {
  /**
   * PENDING for pending.
  */
  PENDING,
  /**
   * APPROVED for Approved.
  */
  APPROVED,
  /**
   * DENIED for Denied.
  */
  DENIED
}
/**
 * LeaveType enum to store employee LeaveType details.
 * @author hexware
 */

 enum LeaveType {
  /**
   * EARNED for EL.
  */
  EL,

  /**
   * EARNED for SL.
  */
  SL,
  /**
   * EARNED for CL.
  */
  CL
}

