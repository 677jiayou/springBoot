package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
}
