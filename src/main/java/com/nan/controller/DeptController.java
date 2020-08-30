package com.nan.controller;

import com.nan.domain.Department;
import com.nan.mapper.DepartmentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
   private DepartmentMapper departmentMapper;


    @GetMapping("/department/{id}")
    public Department getDepartmentByid(@PathVariable("id") int id){

        return departmentMapper.getDepartmentByID(id);
    }

    @GetMapping("/department")
    public  Department setDeaprment(Department department){
        departmentMapper.insertDeptment(department);
        return  department;
    }

}
