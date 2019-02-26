<<<<<<< HEAD
package com.hexaware.FTP115.util;
import java.util.Scanner;
import com.hexaware.FTP115.model.LeaveType;
import com.hexaware.FTP115.model.LeaveDetails;
import com.hexaware.FTP115.model.Employee;
import java.text.ParseException;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("\n Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Leave History");
    System.out.println("5. Pending Leaves  ");
    System.out.println("6. Approve/Deny ");
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
        listPending();
        break;
      case 6:
        apporveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose from 1 to 6");
    }
    mainMenu();
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number " + "\t"
        + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("----------------------------------------");
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  private void listEmployeeDetail() {
    int empId = 0;
    System.out.println("Enter an Employee Id");
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      listEmployeeDetail();
    }
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.print("-----------------------------------------------------------------------------------------");
      System.out.println("--------------------------------------");
      System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number "
          + "\t" + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
      System.out.print("-----------------------------------------------------------------------------------------");
      System.out.println("---------------------------------------");
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  //apply leave try block
  private void applyLeave() {
    System.out.println("Enter employee ID:");
    int empId = 0;
    String res = "";
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Employee ID is in wrong format please re enter");
      applyLeave();
    }
    if (empId != 0) {
      System.out.println("Enter Start date:(YYYY-MM-DD)");
      String leaStDate = option.next();
      System.out.println("Enter End date:(YYYY-MM-DD)");
      String leaEndDate = option.next();
      System.out.println("Enter number of leave days:");
      int leaNoOfDays = option.nextInt();
      System.out.println("Enter leave type");
      try {
        String leaType = option.next();
        leaType = leaType.toUpperCase();
        LeaveType lt = LeaveType.valueOf(leaType);
        if (lt == LeaveType.EL || lt == LeaveType.PL || lt == LeaveType.ML) {
          System.out.println("Enter leave Reason");
          String leaReas = option.next();
          try {
            res = LeaveDetails.applyLeave(empId, leaStDate, leaEndDate,
              leaNoOfDays, lt, leaReas);
          } catch (ParseException e) {
            res = "Invalid Format...";
          }
        }
      } catch (IllegalArgumentException e) {
        System.out.println("please enter in EL/PL/ML");
      }
    }
    System.out.println(res);
  }
  private void leaveHistory() {
    int empId = 0;
    System.out.println("Enter an Employee Id");
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      leaveHistory();
    }
    LeaveDetails[] leaveHistory = LeaveDetails.listAll(empId);
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("--------------------------------------");
    System.out.println("LeaveId" + "\t" + "NoofDays" + "\t" + "start Date" + "\t"
        + "End Date" + "\t" + "Leave Type " + " Leave reason " + "\t" + "Applied On"
        + "\t" + "Leave Status " + " Manager comment" + "\t" + "Employee ID");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    for (LeaveDetails e : leaveHistory) {
      System.out.println(e.getLeaId() + "\t" + e.getLeaNoOfDays() + "\t\t" + e.getLeaStDate()
          + "\t" + e.getLeaEndDate() + "\t" + e.getLeaType() + "\t\t" + e.getLeaReas() + "\t\t" + e.getLeaAppOn()
          + "\t" + e.getLeaStatus() + "\t\t\t" + e.getLeaMngCmts() + "\t\t" + e.getLeaEmpId());
    }
  }
  private void listPending() {
    System.out.println("Enter employee (Manager) ID:");
    int empId = 0;
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      listPending();
    }
    LeaveDetails[] pendingHistory = LeaveDetails.listPending(empId);
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("--------------------------------------");
    System.out.println("LeaveId" + "\t" + "NoofDays" + "\t" + "start Date" + "\t"
        + "End Date" + "\t" + "Leave Type " + " Leave reason " + "\t" + "Applied On"
        + "\t" + "Leave Status " + " Manager comment" + "\t" + "Employee ID");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    for (LeaveDetails e : pendingHistory) {
      System.out.println(e.getLeaId() + "\t" + e.getLeaNoOfDays() + "\t\t" + e.getLeaStDate()
          + "\t" + e.getLeaEndDate() + "\t" + e.getLeaType() + "\t\t" + e.getLeaReas() + "\t\t" + e.getLeaAppOn()
          + "\t" + e.getLeaStatus() + "\t" + e.getLeaMngCmts() + "\t\t" + e.getLeaEmpId());
    }
  }
  private void apporveDeny() {
    int leavId = 0;
    int mgrId = 0;
    System.out.println("Enter Leave ID:");
    try {
      leavId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      apporveDeny();
    }
    System.out.println("Enter Manager ID:");
    try {
      mgrId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      apporveDeny();
    }
    System.out.println("Approved (YES/NO) ");
    String status = option.next();
    status = status.toUpperCase();
    option.nextLine();
    System.out.println("Manager Comments");
    String mgrComm = option.nextLine();
    String res = LeaveDetails.approveDeny(leavId, mgrId, status, mgrComm);
    System.out.println(res);
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
=======
package com.hexaware.FTP115.util;
import java.util.Scanner;
import com.hexaware.FTP115.model.LeaveType;
import com.hexaware.FTP115.model.LeaveDetails;
import com.hexaware.FTP115.model.Employee;
import java.text.ParseException;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("\n Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Leave History");
    System.out.println("5. Pending Leaves  ");
    System.out.println("6. Approve/Deny ");
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
        listPending();
        break;
      case 6:
        apporveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose from 1 to 6");
    }
    mainMenu();
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number " + "\t"
        + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("----------------------------------------");
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  private void listEmployeeDetail() {
    int empId = 0;
    System.out.println("Enter an Employee Id");
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      listEmployeeDetail();
    }
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.print("-----------------------------------------------------------------------------------------");
      System.out.println("--------------------------------------");
      System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number "
          + "\t" + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
      System.out.print("-----------------------------------------------------------------------------------------");
      System.out.println("---------------------------------------");
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  //apply leave try block
  private void applyLeave() {
    System.out.println("Enter employee ID:");
    int empId = 0;
    String res = "";
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Employee ID is in wrong format please re enter");
      applyLeave();
    }
    if (empId != 0) {
      System.out.println("Enter Start date:(YYYY-MM-DD)");
      String leaStDate = option.next();
      System.out.println("Enter End date:(YYYY-MM-DD)");
      String leaEndDate = option.next();
      System.out.println("Enter number of leave days:");
      int leaNoOfDays = option.nextInt();
      System.out.println("Enter leave type");
      try {
        String leaType = option.next();
        leaType = leaType.toUpperCase();
        LeaveType lt = LeaveType.valueOf(leaType);
        if (lt == LeaveType.EL || lt == LeaveType.PL || lt == LeaveType.ML) {
          System.out.println("Enter leave Reason");
          String leaReas = option.next();
          try {
            res = LeaveDetails.applyLeave(empId, leaStDate, leaEndDate,
              leaNoOfDays, lt, leaReas);
          } catch (ParseException e) {
            res = "Invalid Format...";
          }
        }
      } catch (IllegalArgumentException e) {
        System.out.println("please enter in EL/PL/ML");
      }
    }
    System.out.println(res);
  }
  private void leaveHistory() {
    int empId = 0;
    System.out.println("Enter an Employee Id");
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      leaveHistory();
    }
    LeaveDetails[] leaveHistory = LeaveDetails.listAll(empId);
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("--------------------------------------");
    System.out.println("LeaveId" + "\t" + "NoofDays" + "\t" + "start Date" + "\t"
        + "End Date" + "\t" + "Leave Type " + " Leave reason " + "\t" + "Applied On"
        + "\t" + "Leave Status " + " Manager comment" + "\t" + "Employee ID");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    for (LeaveDetails e : leaveHistory) {
      System.out.println(e.getLeaId() + "\t" + e.getLeaNoOfDays() + "\t\t" + e.getLeaStDate()
          + "\t" + e.getLeaEndDate() + "\t" + e.getLeaType() + "\t\t" + e.getLeaReas() + "\t\t" + e.getLeaAppOn()
          + "\t" + e.getLeaStatus() + "\t\t\t" + e.getLeaMngCmts() + "\t\t" + e.getLeaEmpId());
    }
  }
  private void listPending() {
    System.out.println("Enter employee (Manager) ID:");
    int empId = 0;
    try {
      empId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      listPending();
    }
    LeaveDetails[] pendingHistory = LeaveDetails.listPending(empId);
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("--------------------------------------");
    System.out.println("LeaveId" + "\t" + "NoofDays" + "\t" + "start Date" + "\t"
        + "End Date" + "\t" + "Leave Type " + " Leave reason " + "\t" + "Applied On"
        + "\t" + "Leave Status " + " Manager comment" + "\t" + "Employee ID");
    System.out.print("-----------------------------------------------------------------------------------------");
    System.out.println("---------------------------------------");
    for (LeaveDetails e : pendingHistory) {
      System.out.println(e.getLeaId() + "\t" + e.getLeaNoOfDays() + "\t\t" + e.getLeaStDate()
          + "\t" + e.getLeaEndDate() + "\t" + e.getLeaType() + "\t\t" + e.getLeaReas() + "\t\t" + e.getLeaAppOn()
          + "\t" + e.getLeaStatus() + "\t" + e.getLeaMngCmts() + "\t\t" + e.getLeaEmpId());
    }
  }
  private void apporveDeny() {
    int leavId = 0;
    int mgrId = 0;
    System.out.println("Enter Leave ID:");
    try {
      leavId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      apporveDeny();
    }
    System.out.println("Enter Manager ID:");
    try {
      mgrId = Integer.parseInt(option.next());
    } catch (NumberFormatException e) {
      System.out.println("Invalid format please Re-enter");
      apporveDeny();
    }
    System.out.println("Approved (YES/NO) ");
    String status = option.next();
    status = status.toUpperCase();
    option.nextLine();
    System.out.println("Manager Comments");
    String mgrComm = option.nextLine();
    String res = LeaveDetails.approveDeny(leavId, mgrId, status, mgrComm);
    System.out.println(res);
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
>>>>>>> 2e118db2de146e4596351f78afd36a7390788349
