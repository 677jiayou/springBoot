package com.example.demo.service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.entity.EmployeeInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeInfo> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeInfo findEmployeeById(Integer id) {
        return employeeRepository.findOne(id);
    }



    @Override
    public boolean updateEmployee(EmployeeInfo employee) {
        try {
            employeeRepository.saveAndFlush(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Cacheable(value = "employeeInfo", key = "#employeeInfo.employeeNumber")//缓存
    public EmployeeInfo findEmployeeByEmployeeNumber(EmployeeInfo employeeInfo) {
        EmployeeInfo employeeInfo1=employeeRepository.findEmployeeByEmployeeNumber(employeeInfo.getEmployeeNumber());
        System.out.println("为员工号、key为:"+employeeInfo1.getEmployeeNumber()+"数据做了缓存");
        return employeeInfo1;
    }

    @Override
    public Integer maxEmployeeNumber() {
        return employeeRepository.findMaxEmployeeNumber();
    }

    @Override
    public boolean saveNewEmployee(EmployeeInfo employee) {
        try {
            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Integer deleteEmployee(Integer employeeNumber) {
        return employeeRepository.deleteEmployeeByEmployeeNumber(employeeNumber);
    }

    @Override
    public List<EmployeeInfo> getEmployeesByInput(String input) {
        return employeeRepository.findEmployeeByInput(input);
    }
}
