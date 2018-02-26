package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SysRole {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;


}
