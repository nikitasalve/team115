package com.hexaware.ftp.persistence;
import org.skife.jdbi.v2.DBI;
public class Main {
     public static void main(String[] args) {
         DbConnection obj = new DbConnection();
         DBI d = obj.getConnect();
     }
}