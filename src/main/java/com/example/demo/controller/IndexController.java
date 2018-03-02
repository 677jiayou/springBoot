package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class IndexController {

    @GetMapping("/index")
    public String index1(){
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    @PreAuthorize("hasAnyRole('admin')")
    public String hello(){
        return "您好,管理员！";
    }

    @GetMapping("/hello1")
    @ResponseBody
    @PreAuthorize("hasAnyRole('部门员工')")
    public String hello1(){
        return "您好,游客！";
    }
    @GetMapping("/403")
    @ResponseBody
    public String access(){
        return "对不起，您没有权限！";
    }

    @GetMapping("/welcome.do")
    @PreAuthorize("hasAnyRole('admin','部门员工','部门主任','人事部主任','人事部员工')")
    public String welcome(){
        return "welcome";
    }
}
