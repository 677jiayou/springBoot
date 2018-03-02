package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.entity.*;
import com.example.demo.md5.MD5Util;
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
    private EmployeeRepository employeeInfoRepository;
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
    //向数据库角色表sys_role中增加信息
    @Test
    public void saveSysRole(){
        SysRole sysRole1=new SysRole();
        sysRole1.setName("admin");
        sysRoleRepository.save(sysRole1);

        SysRole sysRole2=new SysRole();
        sysRole2.setName("部门主任");
        sysRoleRepository.save(sysRole2);

        SysRole sysRole3=new SysRole();
        sysRole3.setName("部门员工");
        sysRoleRepository.save(sysRole3);

        SysRole sysRole4=new SysRole();
        sysRole4.setName("人事部主任");
        sysRoleRepository.save(sysRole4);

        SysRole sysRole5=new SysRole();
        sysRole5.setName("人事部员工");
        sysRoleRepository.save(sysRole5);
    }
    //向数据库部门表department中增加信息
    @Test
    public void saveDepartment(){
        Department department1=new Department();
        department1.setDepartmentNumber("2001");
        department1.setName("急诊科");
        department1.setAddress("住院楼101");
        department1.setTelephone("0923-3456180");
        department1.setManager("王生安");
        departmentRepository.save(department1);

        Department department2=new Department();
        department2.setDepartmentNumber("2002");
        department2.setName("骨科");
        department2.setAddress("门诊楼304");
        department2.setTelephone("0923-3456324");
        department2.setManager("贺易");
        departmentRepository.save(department2);


        Department department3=new Department();
        department3.setDepartmentNumber("2003");
        department3.setName("内分泌科");
        department3.setAddress("门诊楼205");
        department3.setTelephone("0923-3456909");
        department3.setManager("周卓浩");
        departmentRepository.save(department3);


        Department department4=new Department();
        department4.setDepartmentNumber("2004");
        department4.setName("神经内科");
        department4.setAddress("门诊楼109");
        department4.setTelephone("0923-3456231");
        department4.setManager("何刚名");
        departmentRepository.save(department4);


        Department department5=new Department();
        department5.setDepartmentNumber("2005");
        department5.setName("神经外科");
        department5.setAddress("门诊楼102");
        department5.setTelephone("0923-3456782");
        department5.setManager("王成文");
        departmentRepository.save(department5);


        Department department6=new Department();
        department6.setDepartmentNumber("2006");
        department6.setName("消化内科");
        department6.setAddress("门诊楼201");
        department6.setTelephone("0923-3456098");
        department6.setManager("严席华");
        departmentRepository.save(department6);


        Department department7=new Department();
        department7.setDepartmentNumber("2007");
        department7.setName("检验科");
        department7.setAddress("医技楼104");
        department7.setTelephone("0923-3456143");
        department7.setManager("云介融");
        departmentRepository.save(department7);


        Department department8=new Department();
        department8.setDepartmentNumber("2008");
        department8.setName("体检中心");
        department8.setAddress("医技楼203");
        department8.setTelephone("0923-3456677");
        department8.setManager("范湖");
        departmentRepository.save(department8);


        Department department9=new Department();
        department9.setDepartmentNumber("2009");
        department9.setName("放射科");
        department9.setAddress("医技楼305");
        department9.setTelephone("0923-3456489");
        department9.setManager("吴敬序");
        departmentRepository.save(department9);


        Department department10=new Department();
        department10.setDepartmentNumber("2010");
        department10.setName("护理部");
        department10.setAddress("住院楼109");
        department10.setTelephone("0923-3456210");
        department10.setManager("凌月青");
        departmentRepository.save(department10);


        Department department11=new Department();
        department11.setDepartmentNumber("2011");
        department11.setName("康复理疗科");
        department11.setAddress("医技楼208");
        department11.setTelephone("0923-3456724");
        department11.setManager("丁频佟");
        departmentRepository.save(department11);



        Department department12=new Department();
        department12.setDepartmentNumber("2012");
        department12.setName("药剂科");
        department12.setAddress("医技楼302");
        department12.setTelephone("0923-3456423");
        department12.setManager("王缘");
        departmentRepository.save(department12);


        Department department13=new Department();
        department13.setDepartmentNumber("2013");
        department13.setName("人事部");
        department13.setAddress("办公楼108");
        department13.setTelephone("0923-2456123");
        department13.setManager("李烨");
        departmentRepository.save(department13);
    }

    @Test
    public void savePosition(){
        Position position1=new Position();
        position1.setPositionNumber("3001");
        position1.setLevel("部门主任");
        position1.setName("主任医师");
        positionRepository.save(position1);


        Position position2=new Position();
        position2.setPositionNumber("3002");
        position2.setLevel("部门员工");
        position2.setName("副主任医师");
        positionRepository.save(position2);


        Position position3=new Position();
        position3.setPositionNumber("3003");
        position3.setLevel("部门员工");
        position3.setName("医师");
        positionRepository.save(position3);


        Position position4=new Position();
        position4.setPositionNumber("3004");
        position4.setLevel("部门主任");
        position4.setName("主任技师");
        positionRepository.save(position4);


        Position position5=new Position();
        position5.setPositionNumber("3005");
        position5.setLevel("部门员工");
        position5.setName("副主任技师");
        positionRepository.save(position5);


        Position position6=new Position();
        position6.setPositionNumber("3006");
        position6.setLevel("部门员工");
        position6.setName("技师");
        positionRepository.save(position6);



        Position position7=new Position();
        position7.setPositionNumber("3007");
        position7.setLevel("部门主任");
        position7.setName("护士长");
        positionRepository.save(position7);




        Position position8=new Position();
        position8.setPositionNumber("3008");
        position8.setLevel("部门员工");
        position8.setName("护士");
        positionRepository.save(position8);




        Position position9=new Position();
        position9.setPositionNumber("3009");
        position9.setLevel("人事部主任");
        position9.setName("人事部主任");
        positionRepository.save(position9);


        Position position10=new Position();
        position10.setPositionNumber("3010");
        position10.setLevel("人事部员工");
        position10.setName("人事部员工");
        positionRepository.save(position10);
    }

    @Test
//    @Transactional
    public void saveUserInfoAndEmployeeInfo(){
//        //获取角色
//        List<SysRole> sysRoleList1=new ArrayList<>();
//        sysRoleList1.add(sysRoleRepository.findByName("admin").get(0));
//
//        //设置账户信息
//        UserInfo userInfo1=new UserInfo();
//        userInfo1.setUserName("admin");
//        userInfo1.setPassWord("admin");
//        userInfo1.setSysroleList(sysRoleList1);
//        userInfoRepository.save(userInfo1);
//        //设置个人信息
//        EmployeeInfo employeeInfo1=new EmployeeInfo();
//        employeeInfo1.setEmployeeNumber("1000");
//        employeeInfo1.setEmployeePhone("13310971217");
//        employeeInfo1.setEmployeeName("马迪");
//        employeeInfo1.setEmployeeGender("男");
//        employeeInfo1.setEmployeeEmail("444718843@qq.com");
//        employeeInfo1.setEmployeeCount(userInfo1);
//        employeeInfo1.setEmployeeCity("西安");
//        employeeInfo1.setEmployeeBirthday(new Date());
//        employeeInfo1.setEmployeeAddress("西安市未央区辛家庙街道");
//        employeeInfoRepository.save(employeeInfo1);
        //------------------------------------------------------------------
        //获取角色
//        List<SysRole> sysRoleList2=new ArrayList<>();
//        sysRoleList2.add(sysRoleRepository.findByName("部门主任").get(0));
//        //获取部门
//        Department department2=new Department();
//        department2=departmentRepository.findByName("急诊科");
//        //获取职务
//        Position position2=new Position();
//        position2=positionRepository.findByName("主任医师");
//        //设置账户信息
//        UserInfo userInfo2=new UserInfo();
//        userInfo2.setUserName("1001");
//        userInfo2.setPassWord("1001");
//        userInfo2.setSysroleList(sysRoleList2);
//        userInfoRepository.save(userInfo2);
//        //设置个人信息
//        EmployeeInfo employeeInfo2=new EmployeeInfo();
//        employeeInfo2.setEmployeeNumber("1001");
//        employeeInfo2.setEmployeePhone("15678015439");
//        employeeInfo2.setEmployeeName("刘康");
//        employeeInfo2.setEmployeeGender("男");
//        employeeInfo2.setEmployeeEmail("49873672@qq.com");
//        employeeInfo2.setEmployeeCount(userInfo2);
//        employeeInfo2.setEmployeeCity("榆林");
//        employeeInfo2.setEmployeeBirthday(new Date());
//        employeeInfo2.setEmployeeAddress("西安市高新区");
//        employeeInfo2.setEmployeePosition(position2);
//        employeeInfo2.setEmployeeDepartment(department2);
//        employeeInfoRepository.save(employeeInfo2);


//
//        List<SysRole> sysRoleList3=new ArrayList<>();
//        sysRoleList3.add(sysRoleRepository.findByName("部门主任").get(0));
//        //获取部门
//        Department department3=new Department();
//        department3=departmentRepository.findByName("急诊科");
//        //获取职务
//        Position position3=new Position();
//        position3=positionRepository.findByName("主任医师");
//        //设置账户信息
//        UserInfo userInfo3=new UserInfo();
//        userInfo3.setUserName("1008");
//        userInfo3.setPassWord("1008");
//        userInfo3.setSysroleList(sysRoleList3);
//        userInfoRepository.save(userInfo3);
//        //设置个人信息
//        EmployeeInfo employeeInfo3=new EmployeeInfo();
//        employeeInfo3.setEmployeeNumber("1008");
//        employeeInfo3.setEmployeePhone("13572030134");
//        employeeInfo3.setEmployeeName("李光");
//        employeeInfo3.setEmployeeGender("男");
//        employeeInfo3.setEmployeeEmail("369876987@qq.com");
//        employeeInfo3.setEmployeeCount(userInfo3);
//        employeeInfo3.setEmployeeCity("河南洛阳");
//        employeeInfo3.setEmployeeBirthday(new Date());
//        employeeInfo3.setEmployeeAddress("西安市高新区");
//        employeeInfo3.setEmployeePosition(position3);
//        employeeInfo3.setEmployeeDepartment(department3);
//        employeeInfoRepository.save(employeeInfo3);
//
//
//        List<SysRole> sysRoleList4=new ArrayList<>();
//        sysRoleList4.add(sysRoleRepository.findByName("部门主任").get(0));
//        //获取部门
//        Department department4=new Department();
//        department4=departmentRepository.findByName("骨科");
//        //获取职务
//        Position position4=new Position();
//        position4=positionRepository.findByName("主任医师");
//        //设置账户信息
//        UserInfo userInfo4=new UserInfo();
//        userInfo4.setUserName("1009");
//        userInfo4.setPassWord("1009");
//        userInfo4.setSysroleList(sysRoleList4);
//        userInfoRepository.save(userInfo4);
//        //设置个人信息
//        EmployeeInfo employeeInfo4=new EmployeeInfo();
//        employeeInfo4.setEmployeeNumber("1009");
//        employeeInfo4.setEmployeePhone("13464358760");
//        employeeInfo4.setEmployeeName("刘邦");
//        employeeInfo4.setEmployeeGender("女");
//        employeeInfo4.setEmployeeEmail("534644422@qq.com");
//        employeeInfo4.setEmployeeCount(userInfo4);
//        employeeInfo4.setEmployeeCity("河南郑州");
//        employeeInfo4.setEmployeeBirthday(new Date());
//        employeeInfo4.setEmployeeAddress("西安市高新区");
//        employeeInfo4.setEmployeePosition(position4);
//        employeeInfo4.setEmployeeDepartment(department4);
//        employeeInfoRepository.save(employeeInfo4);
//
//
//        List<SysRole> sysRoleList5=new ArrayList<>();
//        sysRoleList5.add(sysRoleRepository.findByName("部门员工").get(0));
//        //获取部门
//        Department department5=new Department();
//        department5=departmentRepository.findByName("内分泌科");
//        //获取职务
//        Position position5=new Position();
//        position5=positionRepository.findByName("副主任技师");
//        //设置账户信息
//        UserInfo userInfo5=new UserInfo();
//        userInfo5.setUserName("1010");
//        userInfo5.setPassWord("1010");
//        userInfo5.setSysroleList(sysRoleList5);
//        userInfoRepository.save(userInfo5);
//        //设置个人信息
//        EmployeeInfo employeeInfo5=new EmployeeInfo();
//        employeeInfo5.setEmployeeNumber("1010");
//        employeeInfo5.setEmployeePhone("13772054088");
//        employeeInfo5.setEmployeeName("张敏");
//        employeeInfo5.setEmployeeGender("女");
//        employeeInfo5.setEmployeeEmail("492139921@qq.com");
//        employeeInfo5.setEmployeeCount(userInfo5);
//        employeeInfo5.setEmployeeCity("河南郑州");
//        employeeInfo5.setEmployeeBirthday(new Date());
//        employeeInfo5.setEmployeeAddress("西安市高新区");
//        employeeInfo5.setEmployeePosition(position5);
//        employeeInfo5.setEmployeeDepartment(department5);
//        employeeInfoRepository.save(employeeInfo5);
//
//        List<SysRole> sysRoleList6=new ArrayList<>();
//        sysRoleList6.add(sysRoleRepository.findByName("部门主任").get(0));
//        //获取部门
//        Department department6=new Department();
//        department6=departmentRepository.findByName("神经内科");
//        //获取职务
//        Position position6=new Position();
//        position6=positionRepository.findByName("主任技师");
//        //设置账户信息
//        UserInfo userInfo6=new UserInfo();
//        userInfo6.setUserName("1011");
//        userInfo6.setPassWord("1011");
//        userInfo6.setSysroleList(sysRoleList6);
//        userInfoRepository.save(userInfo6);
//        //设置个人信息
//        EmployeeInfo employeeInfo6=new EmployeeInfo();
//        employeeInfo6.setEmployeeNumber("1011");
//        employeeInfo6.setEmployeePhone("13345623456");
//        employeeInfo6.setEmployeeName("杨光");
//        employeeInfo6.setEmployeeGender("男");
//        employeeInfo6.setEmployeeEmail("989876587@qq.com");
//        employeeInfo6.setEmployeeCount(userInfo6);
//        employeeInfo6.setEmployeeCity("河南襄阳");
//        employeeInfo6.setEmployeeBirthday(new Date());
//        employeeInfo6.setEmployeeAddress("西安市高新区");
//        employeeInfo6.setEmployeePosition(position6);
//        employeeInfo6.setEmployeeDepartment(department6);
//        employeeInfoRepository.save(employeeInfo6);
//
//
//        List<SysRole> sysRoleList7=new ArrayList<>();
//        sysRoleList7.add(sysRoleRepository.findByName("部门员工").get(0));
//        //获取部门
//        Department department7=new Department();
//        department7=departmentRepository.findByName("神经外科");
//        //获取职务
//        Position position7=new Position();
//        position7=positionRepository.findByName("护士");
//        //设置账户信息
//        UserInfo userInfo7=new UserInfo();
//        userInfo7.setUserName("1012");
//        userInfo7.setPassWord("1012");
//        userInfo7.setSysroleList(sysRoleList7);
//        userInfoRepository.save(userInfo7);
//        //设置个人信息
//        EmployeeInfo employeeInfo7=new EmployeeInfo();
//        employeeInfo7.setEmployeeNumber("1012");
//        employeeInfo7.setEmployeePhone("18832013916");
//        employeeInfo7.setEmployeeName("唐浪涛");
//        employeeInfo7.setEmployeeGender("男");
//        employeeInfo7.setEmployeeEmail("87435436@qq.com");
//        employeeInfo7.setEmployeeCount(userInfo7);
//        employeeInfo7.setEmployeeCity("河北沧州");
//        employeeInfo7.setEmployeeBirthday(new Date());
//        employeeInfo7.setEmployeeAddress("西安市高新区");
//        employeeInfo7.setEmployeePosition(position7);
//        employeeInfo7.setEmployeeDepartment(department7);
//        employeeInfoRepository.save(employeeInfo7);


        List<SysRole> sysRoleList8=new ArrayList<>();
        sysRoleList8.add(sysRoleRepository.findByName("人事部员工").get(0));
        //获取部门
        Department department8=new Department();
        department8=departmentRepository.findByName("人事部");
        //获取职务
        Position position8=new Position();
        position8=positionRepository.findByName("人事部员工");
        //设置账户信息
        UserInfo userInfo8=new UserInfo();
        userInfo8.setUserName(MD5Util.encode("1014"));
        userInfo8.setPassWord(MD5Util.encode("1014"));
        userInfo8.setSysroleList(sysRoleList8);
        userInfoRepository.save(userInfo8);

        //设置个人信息
        EmployeeInfo employeeInfo8=new EmployeeInfo();
        employeeInfo8.setEmployeeNumber("1014");
        employeeInfo8.setEmployeePhone("13456745632");
        employeeInfo8.setEmployeeName("赵颖");
        employeeInfo8.setEmployeeGender("女");
        employeeInfo8.setEmployeeEmail("345342345@qq.com");
        employeeInfo8.setEmployeeCount(userInfo8);
        employeeInfo8.setEmployeeCity("河北衡水");
        employeeInfo8.setEmployeeBirthday(new Date());
        employeeInfo8.setEmployeeAddress("西安市雁塔区");
        employeeInfo8.setEmployeePosition(position8);
        employeeInfo8.setEmployeeDepartment(department8);
        employeeInfoRepository.save(employeeInfo8);
    }
}
