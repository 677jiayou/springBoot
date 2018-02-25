package com.example.demo;

import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.EmployeeInfoRepository;
import com.example.demo.Repository.PositionRepository;
import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.Position;
import com.example.demo.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Test
//    @Transactional
    public void contextLoads() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("madi");
        userInfo.setPassWord("1234");

        Department department=new Department();
        department.setDepartmentNumber("1000");
        department.setName("急诊科");

        Position position=new Position();
        position.setPositionNumber("2000");
        position.setLevel("部门主任");
        position.setName("主任医师");


        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo.setEmployeeAddress("陕西省西安市");
        employeeInfo.setEmployeeBirthday(new Date());
        employeeInfo.setEmployeeCity("西安市蓝田县");
        employeeInfo.setEmployeeCount(userInfo);
        employeeInfo.setEmployeeEmail("444718843@qq.com");
        employeeInfo.setEmployeeGender("男");
        employeeInfo.setEmployeeName("马迪");
        employeeInfo.setEmployeeNote("nothing");
        employeeInfo.setEmployeePhone("13310971217");
        employeeInfo.setEmployeeNumber("1001");
        employeeInfo.setEmployeeWorktype("主席");
        employeeInfo.setEmployeeDepartment(department);
        employeeInfo.setEmployeePosition(position);





        userInfoRepository.save(userInfo);
        departmentRepository.save(department);
        positionRepository.save(position);
        employeeInfoRepository.save(employeeInfo);
    }
    @Test
    public void onrn(){
        EmployeeInfo employeeInfo=employeeInfoRepository.findOne(1);
        System.out.println(employeeInfo.getEmployeePosition().getName());
    }
}
