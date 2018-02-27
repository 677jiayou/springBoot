package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    SysRoleRepository sysRoleRepository;
    @Test
//    @Transactional
    public void contextLoads() {
        SysRole sysRole=new SysRole();
        sysRole.setName("游客");
        sysRoleRepository.save(sysRole);

        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("liukang");
        userInfo.setPassWord("1234");
        List<SysRole>  roles=new ArrayList<SysRole>();
        roles.add(sysRole);
        userInfo.setSysroleList(roles);
        userInfoRepository.save(userInfo);


        Department department=new Department();
        department.setDepartmentNumber("1000");
        department.setName("急诊科");
        departmentRepository.save(department);

        Position position=new Position();
        position.setPositionNumber("2000");
        position.setLevel("部门主任");
        position.setName("主任医师");
        positionRepository.save(position);



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
        employeeInfo.setEmployeeNumber("1004");
        employeeInfo.setEmployeeWorktype("主席");
        employeeInfo.setEmployeeDepartment(department);
        employeeInfo.setEmployeePosition(position);
        employeeInfoRepository.save(employeeInfo);
    }
//    @Test
//    @Transactional
//    public void onrn(){
//        EmployeeInfo employeeInfo=employeeInfoRepository.findOne(1);
//        System.out.println(employeeInfo.getEmployeeDepartment().getEmployeeInfos());
//        Department department=departmentRepository.findOne(1);
//        System.out.println(department.getEmployeeInfos().size());
//    }

    @Test
    public void saveNewEmployee(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("lijiaqi");
        userInfo.setPassWord("1234");

        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo.setEmployeeAddress("陕西省西安市");
        employeeInfo.setEmployeeBirthday(new Date());
        employeeInfo.setEmployeeCity("西安市蓝田县");
        employeeInfo.setEmployeeCount(userInfo);
        employeeInfo.setEmployeeEmail("444718843@qq.com");
        employeeInfo.setEmployeeGender("男");
        employeeInfo.setEmployeeName("李佳奇");
        employeeInfo.setEmployeeNote("nothing");
        employeeInfo.setEmployeePhone("13310971217");
        employeeInfo.setEmployeeNumber("1004");
        employeeInfo.setEmployeeWorktype("主席");
        employeeInfo.setEmployeeDepartment(departmentRepository.findByName("急诊科"));
        employeeInfo.setEmployeePosition(positionRepository.findByName("主任医师"));
        List<SysRole>  roles=new ArrayList<SysRole>();
       sysRoleRepository.findByName("管理员");
        roles.add(sysRoleRepository.findByName("管理员").get(0));
        userInfo.setSysroleList(roles);
        userInfoRepository.save(userInfo);
        employeeInfoRepository.save(employeeInfo);
    }
}
