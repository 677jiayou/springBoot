package com.example.demo.Repository;

import com.example.demo.entity.Department;
import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
