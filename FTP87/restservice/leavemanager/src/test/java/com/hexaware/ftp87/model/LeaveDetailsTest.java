package com.hexaware.ftp87.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import com.hexaware.ftp87.persistence.EmployeeDAO;
import com.hexaware.ftp87.persistence.LeavedetailsDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import org.junit.runner.RunWith;
  /**
   * leavemanagercomm to store  manager comments.
   */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
  /**
   * leavemanagercomm to store  manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails ld = new LeaveDetails(3, 1000, date1,
                    date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    assertEquals(3, ld.getleaveid());
    assertEquals(1000, ld.getempid());
    assertEquals(sdf.parse("2018-11-11"), ld.getleavesdate());
    assertEquals(sdf.parse("2018-11-11"), ld.getleaveedate());
    assertEquals(2, ld.getleavendays());
    assertEquals(LeaveType.EL, ld.getleavetype());
    assertEquals(LeaveStatus.PENDING, ld.getleavestatus());
    assertEquals("Sick", ld.getleavereason());
    assertEquals(sdf.parse("2018-11-11"), ld.getleaveappliedon());
    assertEquals("jee", ld.getleavemanagercomm());
  }
  /**
   * leavemanagercomm to store  manager comments.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testSetter() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails obj1 = new LeaveDetails();
    obj1.setleaveid(3);
    obj1.setEmpid(1000);
    obj1.setleavesdate(date1);
    obj1.setleaveedate(date2);
    obj1.setleavendays(2);
    obj1.setleavetype(LeaveType.EL);
    obj1.setleavestatus(LeaveStatus.PENDING);
    obj1.setleavereason("Sick");
    obj1.setleaveappliedon(date3);
    obj1.setleavemanagercomm("jee");
    Employee e1 = new Employee();
    assertFalse(obj1.equals(e1));
    LeaveDetails ld = null;
    assertFalse(obj1.equals(ld));
  }
   /**
   * test hashcode.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testHashcode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails e1 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e2 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e3 = new LeaveDetails(4, 2000, sdf.parse("2018-12-01"),
        sdf.parse("2018-12-10"), 10,  LeaveType.EL, LeaveStatus.PENDING,
        "GOING HOME", sdf.parse("2018-11-16"), "sorry");
    assertEquals(e1.hashCode(), e2.hashCode());
    assertNotEquals(e1.hashCode(), e3.hashCode());
    assertNotEquals(e2.hashCode(), e3.hashCode());
  }
    /**
   * test equals.
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails e1 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e2 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e3 = new LeaveDetails(4, 2000, sdf.parse("2018-12-01"),
        sdf.parse("2018-12-10"), 10,  LeaveType.EL, LeaveStatus.PENDING,
        "GOING HOME", sdf.parse("2018-11-16"), "sorry");
    assertEquals(e1, e2);
    assertNotEquals(e1, e3);
    assertNotEquals(e2, e3);
  }
/**
 * to test toString method.
 * @throws ParseException throws.
 */
  @Test
  public final void testtoString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = sdf.parse("2018-11-11");
    Date date2 = sdf.parse("2018-11-11");
    Date date3 = sdf.parse("2018-11-11");
    LeaveDetails e1 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e2 = new LeaveDetails(3, 1000, date1,
        date2, 2, LeaveType.EL, LeaveStatus.PENDING, "Sick", date3, "jee");
    LeaveDetails e3 = new LeaveDetails(4, 2000, sdf.parse("2018-12-01"),
        sdf.parse("2018-12-10"), 10,  LeaveType.EL, LeaveStatus.PENDING,
        "GOING HOME", sdf.parse("2018-11-16"), "sorry");
    String res = "leave ID :" + e1.getleaveid() + "emp ID :" + e1.getempid()
        + "Leave start date :" + e1.getleavesdate()
        + "end Date :" + e1.getleaveedate() + "No of days:"
        + e1.getleavendays() + "Leave type :" + e1.getleavetype()
        + "Leave status :" + e1.getleavestatus()
        + "leave reason :" + e1.getleavereason()
        + "Leave apply date :" + e1.getleaveappliedon()
        + "Manager comment :" + e1.getleavemanagercomm();
    assertEquals(res, e1.toString());
  }

 /**
   * Tests that a list with some employees is handled correctly.
   * @param edao mocking the EmployeeDAO class.
   * @param ldao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   */
  @Test
  public final void testApplyLeave(@Mocked final EmployeeDAO edao, @Mocked final LeavedetailsDAO ldao)
                    throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date today = new Date();
    new Expectations() {
      {
        ldao.count(2, "2018-12-26", "2018-12-27"); result = 0;
      }
    };
    new Expectations() {
      {
        ldao.count(2, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new Expectations() {
      {
        edao.find(1);  result = new Employee(1, "Dhanya", "Java",
            "dhanya@gmail.com", "9949391111", sf.parse("2018-08-01"), 44, 0);
        edao.find(2);  result = new Employee(2, "Vennella", "Ftp",
            "vennella@gmail.com", "8583456645", sf.parse("2018-08-01"), 23, 1);
        edao.find(3); result = null;
      }
    };
    new Expectations() {
      {
        ldao.apply(2, "2018-12-26", "2018-12-26", 1, "EL", "PENDING", "sick", sf.format(today));
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeavedetailsDAO dao() {
        return ldao;
      }
    };
    String str1 = LeaveDetails.applyLeave(2, "2018-12-26", "2018-12-26", 1, "EL", "sick");
    assertEquals("Leave Applied Successfully...1 Days ", str1);
    String str2 = LeaveDetails.applyLeave(2, "2018-12-26", "2018-12-25", 2, "EL", "sick");
    assertEquals("StartDate Must be Greater than EndDate...", str2);
    String str4 = LeaveDetails.applyLeave(2, "2018-12-30", "2018-12-30", 1, "EL", "sick");
    assertEquals("already applied on given date", str4);
    String str5 = LeaveDetails.applyLeave(2, "2018-12-26", "2019-12-26", 1, "EL", "sick");
    assertEquals("insufficient leav balance", str5);
    String str6 = LeaveDetails.applyLeave(2, "2018-12-26", "2018-12-27", 2, "EL", "sick");
    assertEquals("Leave Applied Successfully...2 Days ", str6);
    String str7 = LeaveDetails.applyLeave(3, "2018-12-26", "2018-12-27", 2, "EL", "sick");
    assertEquals("Employ id not found", str7);
    String str8 = LeaveDetails.applyLeave(1, "2018-12-26", "2018-12-26", 1, "EL", "sick");
    assertEquals("Leave AutoApproved Successfully...1 Days ", str8);
    String str9 = LeaveDetails.applyLeave(2, "2018-12-26", "2018-12-29", 2, "EL", "sick");
    assertEquals("NO Of Days Should be right", str9);
   /* Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]); */
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for date parsing.
   */
  @Test
  public final void testPending(@Mocked final LeavedetailsDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails();
    final ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        es.add(new LeaveDetails(2, 2, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"),
                2, LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"), "go"));
        es.add(new LeaveDetails(4, 2, sdf.parse("2019-01-02"), sdf.parse("2019-01-02"),
            1, LeaveType.EL, LeaveStatus.PENDING, "marriage", sdf.parse("2018-11-22"), "done"));
        es.add(new LeaveDetails(6, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            3, LeaveType.EL, LeaveStatus.PENDING, "urgent", sdf.parse("2018-11-22"), "go"));
        es.add(new LeaveDetails(7, 3, sdf.parse("2018-11-28"), sdf.parse("2018-11-30"),
            3, LeaveType.EL, LeaveStatus.PENDING, "urgent", sdf.parse("2018-11-22"), "go"));
        dao.pending(1); result = es;
        dao.pending(2); result = es2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeavedetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] lds1 = LeaveDetails.listPending(1);
    assertEquals(4, lds1.length);
    LeaveDetails[] lds2 = LeaveDetails.listPending(2);
    assertEquals(0, lds2.length);
  }
/**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for handling Dateparse Errors.
   */
  @Test
  public final void testLeaveHistory(@Mocked final LeavedetailsDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
        es.add(new LeaveDetails(2, 2, sf.parse("2018-12-01"), sf.parse("2018-12-02"),
            2, LeaveType.EL, LeaveStatus.PENDING, "sick", sf.parse("2018-11-29"), "go"));
        dao.empHistory(100); result = es;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeavedetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ls = LeaveDetails.leaveHis(100);
    assertEquals(1, ls.length);
  }

/**
   * Test to check the functionality of Approve/Deny.
   * @param dao mocking the LeaveDetailsDAO class.
   * @throws ParseException for Date conversions.
   */
  @Test
  public final void testApproveDeny(@Mocked final LeavedetailsDAO dao)
  throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date today = new Date();
    //final String appliedOn = sf.format(today);
    final LeaveDetails ld1 = new LeaveDetails(200, 2, sf.parse("2018-12-12"),
          sf.parse("2018-12-13"), 2, LeaveType.EL, LeaveStatus.PENDING, "Sick",
          today, "enjoy");
    new Expectations() {
      {
        dao.find(200); result = ld1;
        dao.find(300); result = null;
      }
    };
    new Expectations() {
      {
        dao.showManager(200); result = 1;
        dao.showManager(400); result = 2;
      }
    };
    new Expectations() {
      {
        dao.comment("Enjoy", "APPROVED", 200);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
    LeavedetailsDAO dao() {
        return dao;
      }
    };

    String s1 = LeaveDetails.approveDeny(200, 1, "YES", "Enjoy");
    assertEquals(s1, "Leave Approved Successfully");
    String s2 = LeaveDetails.approveDeny(300, 1, "NO", "Sorry");
    assertEquals(s2, "Invalid leaveid");
    String s3 = LeaveDetails.approveDeny(400, 1, "YES", "Enjoy");
    assertEquals(s3, "You are not authorised to access this employee.");
    String s4 = LeaveDetails.approveDeny(200, 1, "NO", "Sorry");
    assertEquals(s4, "Leave Rejected");
    String s5 = LeaveDetails.approveDeny(200, 1, "BYE", "Sorry");
    assertEquals(s5, "Invalid entry");

  }
/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeavedetailsDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeavedetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listAll();
    assertEquals(0, es.length);
  }
   /**
   * Tests that a fetch of a specific employee works correctly.
   * @param edao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO edao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(1, "Dhanya", "Java",
          "dhanya@gmail.com", "9949391111", sf.parse("2018-08-01"), 44, 1);
    new Expectations() {
      {
        edao.find(100); result = e100;
        edao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
}
