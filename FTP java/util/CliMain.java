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
    System.out.println("Leave Management System");
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
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println("-----------------------------------------------------------------------------------------");
      System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number "
          + "\t" + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
      System.out.println("-----------------------------------------------------------------------------------------");
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  private void listPending() {
    System.out.println("Enter employee (Manager) ID:");
    int empId = option.nextInt();
    LeaveDetails[] leaveHistory = LeaveDetails.listPending(empId);

    for (LeaveDetails e : leaveHistory) {
      System.out.println(e);
    }
  }
  private void leaveHistory() {
    System.out.println("Enter employee ID:");
    int empId = option.nextInt();
    LeaveDetails[] leaveHistory = LeaveDetails.listAll(empId);
    for (LeaveDetails e : leaveHistory) {
      System.out.println(e  );
    }
  }
  private void apporveDeny() {
    System.out.println("Enter Leave ID:");
    int leavId = option.nextInt();
    System.out.println("Enter Manager ID:");
    int mgrId = option.nextInt();
    System.out.println("Approved (YES/NO) ");
    String status = option.next();
    System.out.println("Manager Comments  ");
    String mgrComm = option.next();
    String res = LeaveDetails.approveDeny(leavId, mgrId, status, mgrComm);
    System.out.println(res);
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("EmpId " + "\t" + " EmpFullName " + "\t" + "Employee Email ID " + "\t" + " Mobile Number " + "\t"
        + " Date of Joining " + "\t" + " Department " + "\t" + " Leave Balance " + "\t" + " Manager ID ");
    System.out.println("-----------------------------------------------------------------------------------------");
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "\t" + e.getEmpFullName() + "\t" + e.getEmpEmail()
          + "\t" + e.getEmpMobile() + "\t" + e.getEmpDOJ() + "\t\t" + e.getEmpDepart()
          + "\t\t\t" + e.getEmpLeaveBal() + "\t\t" + e.getMgrId());
    }
  }
  private void applyLeave() {
    System.out.println("Enter employee ID:");
    int empId = option.nextInt();
    System.out.println("Enter Start date:(YYYY-MM-DD)");
    String leaStDate = option.next();
    System.out.println("Enter End date:(YYYY-MM-DD)");
    String leaEndDate = option.next();
    System.out.println("Enter number of leave days:");
    int leaNoOfDays = option.nextInt();
    System.out.println("Enter leave type");
    String leaType = option.next();
    LeaveType lt = LeaveType.valueOf(leaType);
    System.out.println("Enter leave Reason");
    String leaReas = option.next();
    String res = "";
    try {
      res = LeaveDetails.applyLeave(empId, leaStDate, leaEndDate,
        leaNoOfDays, lt, leaReas);
    } catch (ParseException e) {
      res = "Invalid Format...";
    }
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
