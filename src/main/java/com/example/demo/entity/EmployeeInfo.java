package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class EmployeeInfo {
    @Id
    @GeneratedValue
    private  Integer employeeId;
    //工号
    private  String employeeNumber;
    //姓名
    private  String  employeeName;
    //性别
    private String employeeGender;
    //出生日期
    private Date employeeBirthday;
    //身份证号
    private String idCard;
    //邮箱
    private String employeeEmail;
    //电话
    private String employeePhone;
    //家庭地址
    private String employeeAddress;
    //籍贯
    private String employeeCity;
    //所在部门
    @ManyToOne
    private Department employeeDepartment;
    //职位
    @ManyToOne
    private Position employeePosition;
    //岗位
    private String employeeWorktype;
    //账户
    @OneToOne
    private UserInfo employeeCount;
    //备注
    private String employeeNote;
    //是否删除
    private boolean employeeIsdel=false;
    //学历
    private String education;
    //入职时间
    @CreatedDate
    private Date ImportDate;

}

