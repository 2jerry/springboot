package com.jay.chapter07.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String index() {
        System.out.println("index 요청");
        return "index";
    }

    @GetMapping("/member")
    public void forMember() {
        System.out.println("Member 요청");
    }

    @GetMapping("/manager")
    public void forManager() {
        System.out.println("Manager 요청");
    }

    @GetMapping("/admin")
    public void forAdmin() {
        System.out.println("Admin 요청");
    }

    @GetMapping("/accessDenied")
    public void accessDenied() {

    }


    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/loginSuccess")
    public void loginSuccess() {

    }

}

