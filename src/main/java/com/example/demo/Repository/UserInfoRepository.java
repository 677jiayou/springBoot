package com.example.demo.Repository;

import com.example.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
}
