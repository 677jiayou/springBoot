package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index1(){

        return "index";
    }

//    @GetMapping("/hello")
//    @ResponseBody
//    @PreAuthorize("hasAnyRole('admin')")
//    public String hello(){
//        return "你好";
//    }
}
