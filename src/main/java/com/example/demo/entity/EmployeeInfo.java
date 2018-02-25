package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class EmployeeInfo {
    @Id
    @GeneratedValue
    private  Integer employeeId;
    private  String employeeNumber;
    private  String  employeeName;
    private String employeeGender;
    private Date employeeBirthday;
    private String idCard;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private String employeeCity;
    @ManyToOne
    private Department employeeDepartment;
    @ManyToOne
    private Position employeePosition;
    private String employeeWorktype;
    @OneToOne
    private UserInfo employeeCount;
    private String employeeNote;
    private boolean employeeIsdel=false;

}

