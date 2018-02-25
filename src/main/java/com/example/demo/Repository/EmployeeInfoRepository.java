package com.example.demo.Repository;

import com.example.demo.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Integer> {
}
