package com.example.demo.service;

import com.example.demo.entity.EmployeeInfo;

import java.util.List;

public interface IEmployeeService {

    //员工信息全查
    List<EmployeeInfo> findAllEmployee();
    //根据id查询员工信息
    EmployeeInfo findEmployeeById(Integer id);

    //修改员工信息
    boolean updateEmployee(EmployeeInfo employee);
    //根据工号查询员工信息
    EmployeeInfo findEmployeeByEmployeeNumber(EmployeeInfo employeeInfo);
    //查询员工号的最大值
    Integer maxEmployeeNumber();
    //保存员工信息
    boolean saveNewEmployee(EmployeeInfo employee);
    //删除员工信息
    Integer deleteEmployee(Integer employeeNumber);
    //模糊查询
    List<EmployeeInfo> getEmployeesByInput(String input);
}
