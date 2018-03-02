package com.example.demo.Repository;

import com.example.demo.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo,Integer> ,JpaSpecificationExecutor<EmployeeRepository> {


    EmployeeInfo findEmployeeByEmployeeNumber(@Param("employeeNumber") String employeeNumber);

    //这里不要用表名
    @Query("select max(bean.employeeNumber) from EmployeeInfo bean")
    Integer findMaxEmployeeNumber();

    Integer deleteEmployeeByEmployeeNumber(Integer employeeNumber);


    @Query("select e from EmployeeInfo e where e.employeeName like ?1")
    List<EmployeeInfo> findEmployeeByInput(String input);

}
