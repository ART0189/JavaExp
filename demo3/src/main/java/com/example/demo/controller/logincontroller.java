package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("")
@Controller
public class logincontroller {
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        String u = request.getParameter("username");
        String P =  request.getParameter("password");
        return "6666";

    }
    @RequestMapping("/index")
    public String index(){
        return "login";
    }
    @RequestMapping("/")
    public String index2(){
        return "login";
    }
}
