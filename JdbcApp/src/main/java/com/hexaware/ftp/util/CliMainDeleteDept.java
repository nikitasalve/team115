package com.hexaware.ftp.util;

import com.hexaware.ftp.model.Dept;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class CliMainDeleteDept{

    public static void main(final String[] ar){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department no. ");
        int deptno = Integer.parseInt(sc.nextLine());
        Dept.deleteDept(deptno);
        System.out.println("Record Deleted...");
    }

}