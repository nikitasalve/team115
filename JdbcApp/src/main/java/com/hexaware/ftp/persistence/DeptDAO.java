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
}