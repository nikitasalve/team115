package com.hexaware.ftp.util;
import com.hexaware.ftp.model.Dept;

public class CliMain {
  public static void main(final String[] ar) {
    Dept[] depts = Dept.listAll();
    for (Dept e : depts) {
      System.out.println(e.getDeptno() + " " +
             e.getDeptName() + " " + e.getLoc());
    }
  }
}
