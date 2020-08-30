package com.nan.mapper;

import com.nan.domain.Department;
import org.apache.ibatis.annotations.*;

/**
 * 注解版本mapper
 */


public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartmentByID(int id);

    @Delete("delete from department where id=#{id}")
    public int deleteDepartmentByID(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    public int insertDeptment(Department department);

    @Update("update department set department=#{departmentName}where id=#{id}")
    public int updateDepartment(Department department);

}
