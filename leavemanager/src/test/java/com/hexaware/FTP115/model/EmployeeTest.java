<<<<<<< HEAD
package com.hexaware.FTP115.model;

import com.hexaware.FTP115.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
  * Tests the default constructors methods of the employee class.
  */
  @Test
  public final void testDefaultContructor() {
    Employee e100 = new Employee();
    assertNotNull(e100);
    Employee e101 = null;
    assertNull(e101);
  }
   /**
  * Tests the Parameterized Constructors and Get/Set methods of the employee class.
  * @throws ParseException in case there is an error in converting data.
  */
  @Test
  public final void testParamConstructor() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "1998-12-12";
    Date doj = sdf.parse(s1);
    Employee e100 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444",
        doj, "FTP", 0, 12);
    assertEquals(1, e100.getEmpId());
    assertEquals("Bhuvaneswari", e100.getEmpFullName());
    assertEquals("Bhuvi@gmail.com", e100.getEmpEmail());
    assertEquals("8872134444", e100.getEmpMobile());
    assertEquals(doj, e100.getEmpDOJ());
    assertEquals("FTP", e100.getEmpDepart());
    assertEquals(0, e100.getMgrId());
    assertEquals(12, e100.getEmpLeaveBal());
    Employee e101 = new Employee();
    e101.setEmpId(3);
    assertEquals(3, e101.getEmpId());
    e101.setEmpFullName("meghana");
    assertEquals("meghana", e101.getEmpFullName());
    e101.setEmpEmail("Bhuvi@gmail.com");
    assertEquals("Bhuvi@gmail.com", e101.getEmpEmail());
    e101.setEmpMobile("8872134444");
    assertEquals("8872134444", e101.getEmpMobile());
    e101.setEmpDOJ(doj);
    assertEquals(doj, e101.getEmpDOJ());
    e101.setEmpDepart("FTP");
    assertEquals("FTP", e101.getEmpDepart());
    e101.setMgrId(1);
    assertEquals(1, e101.getMgrId());
    e101.setEmpLeaveBal(20);
    assertEquals(20, e101.getEmpLeaveBal());
    Employee e102 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
    Employee e103 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
    assertEquals(e102.hashCode(), e103.hashCode());
    Employee e104 = null;
    assertNotEquals(e102, e104);
    LeaveDetails ld = new LeaveDetails();
    assertNotEquals(e102, ld);
    assertEquals(e102, e103);
    assertNotEquals(e101, e102);
    String res = " Empid:1 EmpName:Bhuvaneswari EmpEmail:"
        + "Bhuvi@gmail.com EmpPhone:8872134444 EmpJoinDate:1998-12-12 EmpDept:"
        + "FTP EmpMgrId:0 EmpLeaveId:12";
    assertEquals(res, e102.toString());
    EmployeeDAO edao = Employee.dao();
    assertNotNull(edao);
  }

  // /**
  //  * Tests the equals/hashcode methods of the employee class.
  //  */
  // @Test
  // public final void testEmployee() {
  //   Employee e100 = new Employee(100);
  //   Employee e101 = new Employee(101);
  //   assertNotEquals(e100, null);
  //   assertNotEquals(e100, new Integer(100));
  //   assertEquals(e100, new Employee(100));
  //   assertNotEquals(e101, new Employee(100));
  //   assertEquals(e100.hashCode(), new Employee(100).hashCode());
  //   assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
  //   e101.setEmpId(100);
  //   assertEquals(e101, new Employee(100));
  // }


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
  * Tests that a list with some employees is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for parsing dates.
  */
  @Test
public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12));
        es.add(new Employee(2, "Meghana", "Megha@gmail.com", "8878134444", doj, "FTP", 0, 12));
        es.add(new Employee(3, "Omkar", "Omkar@gmail.com", "9972134444", doj, "FTP", 0, 12));
        dao.list(); result = es;
        }
      };
    new MockUp<Employee>() {
      @Mock
       EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12), es[0]);
    assertEquals(new Employee(2, "Meghana", "Megha@gmail.com", "8878134444", doj, "FTP", 0, 12), es[1]);
    assertEquals(new Employee(3, "Omkar", "Omkar@gmail.com", "9972134444", doj, "FTP", 0, 12), es[2]);
  }

  /**
  * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class.
   * @throws ParseException handles parse exception.
  */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    final Employee e100 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
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

=======
package com.hexaware.FTP115.model;

import com.hexaware.FTP115.persistence.EmployeeDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
  * Tests the default constructors methods of the employee class.
  */
  @Test
  public final void testDefaultContructor() {
    Employee e100 = new Employee();
    assertNotNull(e100);
    Employee e101 = null;
    assertNull(e101);
  }
   /**
  * Tests the Parameterized Constructors and Get/Set methods of the employee class.
  * @throws ParseException in case there is an error in converting data.
  */
  @Test
  public final void testParamConstructor() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String s1 = "1998-12-12";
    Date doj = sdf.parse(s1);
    Employee e100 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444",
        doj, "FTP", 0, 12);
    assertEquals(1, e100.getEmpId());
    assertEquals("Bhuvaneswari", e100.getEmpFullName());
    assertEquals("Bhuvi@gmail.com", e100.getEmpEmail());
    assertEquals("8872134444", e100.getEmpMobile());
    assertEquals(doj, e100.getEmpDOJ());
    assertEquals("FTP", e100.getEmpDepart());
    assertEquals(0, e100.getMgrId());
    assertEquals(12, e100.getEmpLeaveBal());
    Employee e101 = new Employee();
    e101.setEmpId(3);
    assertEquals(3, e101.getEmpId());
    e101.setEmpFullName("meghana");
    assertEquals("meghana", e101.getEmpFullName());
    e101.setEmpEmail("Bhuvi@gmail.com");
    assertEquals("Bhuvi@gmail.com", e101.getEmpEmail());
    e101.setEmpMobile("8872134444");
    assertEquals("8872134444", e101.getEmpMobile());
    e101.setEmpDOJ(doj);
    assertEquals(doj, e101.getEmpDOJ());
    e101.setEmpDepart("FTP");
    assertEquals("FTP", e101.getEmpDepart());
    e101.setMgrId(1);
    assertEquals(1, e101.getMgrId());
    e101.setEmpLeaveBal(20);
    assertEquals(20, e101.getEmpLeaveBal());
    Employee e102 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
    Employee e103 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
    assertEquals(e102.hashCode(), e103.hashCode());
    Employee e104 = null;
    assertNotEquals(e102, e104);
    LeaveDetails ld = new LeaveDetails();
    assertNotEquals(e102, ld);
    assertEquals(e102, e103);
    assertNotEquals(e101, e102);
    String res = " Empid:1 EmpName:Bhuvaneswari EmpEmail:"
        + "Bhuvi@gmail.com EmpPhone:8872134444 EmpJoinDate:1998-12-12 EmpDept:"
        + "FTP EmpMgrId:0 EmpLeaveId:12";
    assertEquals(res, e102.toString());
    EmployeeDAO edao = Employee.dao();
    assertNotNull(edao);
  }

  // /**
  //  * Tests the equals/hashcode methods of the employee class.
  //  */
  // @Test
  // public final void testEmployee() {
  //   Employee e100 = new Employee(100);
  //   Employee e101 = new Employee(101);
  //   assertNotEquals(e100, null);
  //   assertNotEquals(e100, new Integer(100));
  //   assertEquals(e100, new Employee(100));
  //   assertNotEquals(e101, new Employee(100));
  //   assertEquals(e100.hashCode(), new Employee(100).hashCode());
  //   assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
  //   e101.setEmpId(100);
  //   assertEquals(e101, new Employee(100));
  // }


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
  * Tests that a list with some employees is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for parsing dates.
  */
  @Test
public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12));
        es.add(new Employee(2, "Meghana", "Megha@gmail.com", "8878134444", doj, "FTP", 0, 12));
        es.add(new Employee(3, "Omkar", "Omkar@gmail.com", "9972134444", doj, "FTP", 0, 12));
        dao.list(); result = es;
        }
      };
    new MockUp<Employee>() {
      @Mock
       EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12), es[0]);
    assertEquals(new Employee(2, "Meghana", "Megha@gmail.com", "8878134444", doj, "FTP", 0, 12), es[1]);
    assertEquals(new Employee(3, "Omkar", "Omkar@gmail.com", "9972134444", doj, "FTP", 0, 12), es[2]);
  }

  /**
  * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class.
   * @throws ParseException handles parse exception.
  */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String s1 = "1998-12-12";
    final Date doj = sdf.parse(s1);
    final Employee e100 = new Employee(1, "Bhuvaneswari", "Bhuvi@gmail.com", "8872134444", doj, "FTP", 0, 12);
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

>>>>>>> 2e118db2de146e4596351f78afd36a7390788349
