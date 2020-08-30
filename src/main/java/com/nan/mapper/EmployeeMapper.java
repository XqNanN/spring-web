package com.nan.mapper;

import com.nan.domain.Employee;
import org.apache.ibatis.annotations.Mapper;


public interface EmployeeMapper {

    public Employee getEmployeeByID(int id);

    public Employee setEmployee(Employee employee);

    public void addEmployee(Employee employee);
}
