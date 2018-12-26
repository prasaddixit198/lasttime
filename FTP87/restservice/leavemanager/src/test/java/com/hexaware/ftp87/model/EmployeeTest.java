package com.hexaware.ftp87.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import com.hexaware.ftp87.persistence.EmployeeDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;


/**
 *  Unit test for Employee.
 */
public class EmployeeTest {

/**
 *  Testing the EMPLOYEE constructor.
 * @throws ParseException throws Parse Exception.
 */

  @Test
  public final void testEmployee() throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Employee obj1 = new Employee(4000, "PUJA", "FULLSTACK", "PUJA@GMAIL.COM", "9999999999",
        sdf1.parse("2018-10-04"), 5, 2000);
    assertEquals(4000, obj1.getEmpId());
    assertEquals("PUJA", obj1.getEmpName());
    assertEquals("FULLSTACK", obj1.getEmpDept());
    assertEquals("PUJA@GMAIL.COM", obj1.getEmpEmail());
    assertEquals("9999999999", obj1.getEmpMob());
    assertEquals(sdf1.parse("2018-10-04"), obj1.getEmpDoj());
    assertEquals(5, obj1.getEmpLeavbal());
    assertEquals(2000, obj1.getEmpMgrid());
  }
/**
 *  Test the Employee Setter Data.
 * @throws ParseException throws Parse Exception.
 */
  @Test
  public final void testEmployeeSetters() throws ParseException {
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    Employee e = new Employee();
    e.setEmpId(4000);
    e.setEmpName("PUJA");
    e.setEmpDept("FULLSTACK");
    e.setEmpEmail("PUJA@GMAIL.COM");
    e.setEmpMob("9999999999");
    e.setEmpDoj(sdf2.parse("2018-10-04"));
    e.setEmpLeavbal(5);
    e.setEmpMgrid(2000);

    assertEquals(4000, e.getEmpId());
    assertEquals("PUJA", e.getEmpName());
    assertEquals("FULLSTACK", e.getEmpDept());
    assertEquals("PUJA@GMAIL.COM", e.getEmpEmail());
    assertEquals("9999999999", e.getEmpMob());
    assertEquals(sdf2.parse("2018-10-04"), e.getEmpDoj());
    assertEquals(5, e.getEmpLeavbal());
    assertEquals(2000, e.getEmpMgrid());
    Employee e12 = null;
    assertFalse(e.equals(e12));
    LeaveDetails ld = new LeaveDetails();
    assertFalse(e.equals(ld));
  }
  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "Sonal", "sonal@gmail.com", "java", "987456321", sdf3.parse("2014-08-17"), 10, 1000);
    Employee e2 = new Employee(1, "Sonal", "sonal@gmail.com", "java", "987456321", sdf3.parse("2014-08-17"), 10, 1000);
    Employee e3 = new Employee(2, "rahul", "rahul@gmail.com", "sql", "984588456", sdf3.parse("2014-08-18"), 12, 3000);
    assertEquals(e1, e2);
    assertNotEquals(e1, e3);
    assertNotEquals(e2, e3);
  }

  /**
   * @throws ParseException throws Parse Exception
   */
  @Test
  public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Employee e1 = new Employee(1, "Sonal", "sonal@gmail.com", "java", "987456321", sdf.parse("2014-08-17"), 10, 1000);
    Employee e2 = new Employee(1, "Sonal", "sonal@gmail.com", "java", "987456321", sdf.parse("2014-08-17"), 10, 1000);
    Employee e3 = new Employee(2, "rahul", "rahul@gmail.com", "sql", "984588456", sdf.parse("2016-08-18"), 12, 3000);
    assertEquals(e1.hashCode(), e2.hashCode());
    assertNotEquals(e1.hashCode(), e3.hashCode());
    assertNotEquals(e2.hashCode(), e3.hashCode());
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testDecrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Dhanya", "84823444", "dhanya@gmail.com",
        "java", sf.parse("2018-08-01"), 1, 12);
    new Expectations() {
      {
        dao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        dao.decrement(100, 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.decrement(100, 2);
    assertEquals("Leave Balance Updated", result);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testIncrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "Dhanya", "84823444", "dhanya@gmail.com",
        "java", sf.parse("2018-08-01"), 1, 12);
    new Expectations() {
      {
        dao.find(100); result = e100;
      }
    };
    new Expectations() {
      {
        dao.increment(100, 12);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e1 = Employee.listById(100);
    assertEquals(e1, e100);
    String result = Employee.increment(100, 12);
    assertEquals("Leave Balance Updated", result);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }
  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class.
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e100 = new Employee(100, "priya", "java", "priyamadiraju7@gmail.com", "7894561232",
        sf.parse("2018-08-05"), 25, 2);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
}
