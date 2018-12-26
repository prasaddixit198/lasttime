package com.hexaware.ftp87.model;

import com.hexaware.ftp87.persistence.DbConnection;
import com.hexaware.ftp87.persistence.EmployeeDAO;
import java.util.Date;
import java.util.Objects;
import java.util.List;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

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
  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * Update employee LeaveBalance.
   * @param empid id to get employee id.
   * @param leavenoofdays to get employee leavenoofdays.
   * @return String.
   */
  public static String increment(final int empid, final int leavenoofdays) {
    dao().increment(empid, leavenoofdays);
    return "Leave Balance Updated";
  }
/**
   * Update leaveBalance of employee.
   * @param empID id to enter employee details.
   * @param leaveTaken  to enter employee Leavetaken.
   * @return Status
   */

  public static String decrement(final int empID, final int leaveTaken) {
    dao().decrement(empID, leaveTaken);
    return "Leave Balance Updated";
  }
}
