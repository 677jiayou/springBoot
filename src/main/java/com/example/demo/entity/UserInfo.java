package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(unique =true)
    private String userName;
    private String passWord;
    private boolean isDel=false;
    private String note;
    @CreatedDate
    private Date registerDate;
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> sysroleList;
}
