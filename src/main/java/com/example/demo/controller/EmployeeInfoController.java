package com.example.demo.controller;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeInfoController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private  EmployeeServiceImpl employeeService;
    // 个人信息页面映射处理
    @GetMapping("/employeeDetail")
    public String toDetail(@RequestParam("employeeNumber") String employeeNumber) {
        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo.setEmployeeNumber(employeeNumber);
        EmployeeInfo employee1 = employeeService.findEmployeeByEmployeeNumber(employeeInfo);
        httpSession.setAttribute("employee", employee1);
        return "employee_detail";
    }
}
