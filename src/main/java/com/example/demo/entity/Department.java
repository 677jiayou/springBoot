package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
}
