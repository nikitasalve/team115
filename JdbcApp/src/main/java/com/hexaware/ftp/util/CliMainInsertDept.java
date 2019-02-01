package com.hexaware.ftp.util;

import com.hexaware.ftp.model.Dept;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class CliMainInsertDept{

    public static void main(final String[] ar){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department no. ");
        int deptno = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Department Name ");
        String dname  = sc.nextLine();
        System.out.println("Enter Department location ");
        String loc  = sc.nextLine();
        
        Dept.insertDept(deptno, dname, loc);
        System.out.println("Record Inserted...");
    }

}