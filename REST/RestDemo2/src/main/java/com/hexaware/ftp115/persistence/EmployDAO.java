package com.hexaware.ftp115.persistence;

import com.hexaware.ftp115.model.Employ;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;
import java.util.Date;

/**
 * The DAO class for employee.
 */
public interface EmployDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMP")
  @Mapper(EmployMapper.class)
  List<Employ> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMP WHERE EMPNO = :empno")
  @Mapper(EmployMapper.class)
  Employ find(@Bind("empno") int empno);

  @SqlUpdate("INSERT INTO EMP(EMPNO, ename, job, mgr, hiredate, sal, comm, deptno) "
  + "VALUES(:empno, :ename , :job , :mgr , :hiredate, :sal , :comm , :deptno )") 
  void insert(@Bind("empno") int empno,
            @Bind("ename") String ename,
            @Bind("job") String job, 
        @Bind("mgr") int mgr, 
        @Bind("hiredate") String hiredate,
        @Bind("sal") int sal, 
        @Bind("comm") int comm, 
        @Bind("deptno") int deptno);
  
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
