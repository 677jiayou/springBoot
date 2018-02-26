package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue
    private Integer departmentId;
    private String departmentNumber;
    @Column(unique = true)
    private String name;
    private String notes;
    private String manager;
    private String telephone;
    private String address;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;
    private boolean idDel;
    @OneToMany(mappedBy = "employeeDepartment")
    private List<EmployeeInfo> employeeInfos;
}
