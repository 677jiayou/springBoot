package com.example.demo.Repository;

import com.example.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    List<UserInfo> findByUserName(String name);
}
