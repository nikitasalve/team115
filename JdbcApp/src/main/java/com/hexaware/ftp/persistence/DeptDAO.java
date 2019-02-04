package com.hexaware.ftp.persistence;
import com.hexaware.ftp.model.Dept;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

public interface DeptDAO  {

  @SqlQuery("SELECT * FROM dept")
  @Mapper(DeptMapper.class)
  List<Dept> list();

  // @SqlQuery("SELECT * FROM dept where deptno = :deptno")
  // @Mapper(DeptMapper.class)
  // Dept find(@Bind("deptno") int deptno);

  
  @SqlUpdate("INSERT INTO dept(deptno, dname, loc)" +
   "VALUES(:deptno, :dname, :loc) ")
  void insertDept(@Bind("deptno") int deptno,
        @Bind("dname") String dname,
        @Bind("loc") String loc);

  @SqlUpdate("DELETE FROM dept where deptno = :deptno")
  void deleteDept(@Bind("deptno") int deptno);

    

}