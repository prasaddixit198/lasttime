package com.hexaware.ftp87.util;
import java.util.Scanner;
import com.hexaware.ftp87.model.LeaveDetails;
import java.text.ParseException;
import com.hexaware.ftp87.model.Employee;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Leave History");
    System.out.println("5. Pending Leaves");
    System.out.println("6. Approved Deny Leaves");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        pendingLeaves();
        break;
      case 6:
        approveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6 or 7");
    }
    mainMenu();
  }

  /**
  * For Approval and Denial.
  */
  public static void approveDeny() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a leave ID:");
    int leaveId = sc.nextInt();
    System.out.println("Enter Employ Id  ");
    int mgrId = sc.nextInt();
    System.out.println("Approve (yes/no):");
    String ch = sc.next();
    ch = ch.toUpperCase().trim();
    System.out.println("Manager Comments  ");
    String mgrCom = sc.next();
    String res = LeaveDetails.approveDeny(leaveId, mgrId, ch, mgrCom);
    System.out.println(res);
  }
  private void pendingLeaves() {
    int mgrId;
    System.out.println("Enter ManagerId ");
    mgrId = Integer.parseInt(option.next());
    LeaveDetails[] pending = LeaveDetails.listPending(mgrId);
    for (LeaveDetails e : pending) {
      System.out.println(e.getempid() + "  "
          + e.getleaveid() + "  "
          + e.getleavendays() + "  "
          + e.getleavesdate() + "  "
          + e.getleaveedate() + "  "
          + e.getleavereason() + "  "
          + e.getleaveappliedon());
    }
  }
  private void applyLeave() {
    System.out.println("Enter an Employee Id  ");
    int empId = Integer.parseInt(option.next());
    System.out.println("Enter StartDate (yyyy-MM-dd) ");
    String startDate = option.next();
    System.out.println("Enter EndDate (yyyy-MM-dd) ");
    String endDate = option.next();
    System.out.println("Enter No of Leave days ");
    int noOfdays = Integer.parseInt(option.next());
    System.out.println("Enter leave type : EL, SL, CL ");
    String leaveType = option.next();
    option.nextLine();
    System.out.println("Enter leave reason");
    String leaveReason = option.nextLine();
    String res = null;
    try {
      res = LeaveDetails.applyLeave(empId, startDate,
                    endDate, noOfdays, leaveType, leaveReason);
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(res);
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  "
          + e.getEmpDept() + "  " + e.getEmpEmail() + "  " + e.getEmpMob() + "  " + e.getEmpDoj() + "  "
          + e.getEmpLeavbal() + "  " + e.getEmpMgrid());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  "
          + e.getEmpDept() + "  " + e.getEmpEmail() + "  " + e.getEmpMob() + "  " + e.getEmpDoj() + "  "
          + e.getEmpLeavbal() + "  " + e.getEmpMgrid());
    }
  }

  private void leaveHistory() {
    System.out.println("enter employee id: ");
    final int empid = option.nextInt();
    LeaveDetails[] ld = LeaveDetails.leaveHis(empid);
    for (LeaveDetails e : ld) {
      System.out.println(e.getleaveid() + "  " + e.getempid() + "  "
          + e.getleavesdate() + "  " + e.getleaveedate() + "  " + e.getleavendays() + "  " + e.getleavetype() + "  "
          + e.getleavestatus() + "  " + e.getleavereason());
    }
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
