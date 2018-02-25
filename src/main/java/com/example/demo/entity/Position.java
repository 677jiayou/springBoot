package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue
    private Integer positionId;
    private String positionNumber;
    @Column(unique = true)
    private String name;
    private String level;
    private String notes;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;
    private boolean idDel;
}
