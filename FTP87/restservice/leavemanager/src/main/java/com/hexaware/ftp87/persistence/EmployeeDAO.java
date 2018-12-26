package com.hexaware.ftp87.persistence;

import com.hexaware.ftp87.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DET")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DET WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param noOfDays for Leave Table of employee.

   */
  @SqlUpdate("UPDATE EMPLOYEE_DET SET LEAVE_BAL = LEAVE_BAL + :noOfDays WHERE EMP_ID = :empID")
  void increment(@Bind("empID") int empID, @Bind("noOfDays") int noOfDays);
  /**
   * Update LeaveBalance for selected employee.
   * @param empID the id of the employee.
   * @param leaveTaken no of days employee applied leave.
   */
  @SqlUpdate("UPDATE EMPLOYEE_DET SET LEAVE_BAL = :leaveTaken WHERE EMP_ID = :empID")
  void decrement(@Bind("empID") int empID, @Bind("leaveTaken") int leaveTaken);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
