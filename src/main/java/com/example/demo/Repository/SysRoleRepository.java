package com.example.demo.Repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole,Integer> {

List<SysRole> findByName(String name);
}
