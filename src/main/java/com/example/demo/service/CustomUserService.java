package com.example.demo.service;

import com.example.demo.Repository.UserInfoRepository;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.SysRole;
import com.example.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<UserInfo>  userInfoList= userInfoRepository.findByUserName(s);
        if (userInfoList.size()==0){
            throw new EntityNotFoundException("该用户不存在");
        }
        //将用户信息存入session
        EmployeeInfo employeeInfo=new EmployeeInfo();
        employeeInfo.setEmployeeNumber(s);
        EmployeeInfo employee=employeeService.findEmployeeByEmployeeNumber(employeeInfo);
        httpSession.setAttribute("employee",employee);
        List<GrantedAuthority> authorities=new ArrayList<>();
        for (SysRole role:userInfoList.get(0).getSysroleList()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        System.out.println(userInfoList.get(0).getUserName());
        System.out.println(userInfoList.get(0).getPassWord());
        System.out.println(authorities.get(0).getAuthority());
        return new User(s,userInfoList.get(0).getPassWord(),authorities);
    }

}
