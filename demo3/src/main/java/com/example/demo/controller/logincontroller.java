package com.example.demo.controller;

import com.example.demo.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("")
@Controller
public class logincontroller {


    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        String username = request.getParameter("username");
        String password =  request.getParameter("password");
        String token = TokenUtil.sign(username, password);
        Cookie ck=new Cookie("token",token);
        System.out.println("加密后的token为：" + token);

        boolean flag = TokenUtil.verfiy(token);

        if(flag){
            System.out.println("校验成功");
        } else {
            System.out.println("校验失败");
            return "loginfalse";
        }
        httpServletResponse.addCookie(ck);
        return "index";

    }
    @RequestMapping("/index")
    public String index(){
        return "login";
    }
    @RequestMapping("")
    public String login(){
        return "login";
    }
    @RequestMapping("/sysA")
    public String sysA(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return "login";
        }
        return "sysA";
    }
    @RequestMapping("/sysB")
    public String sysB(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return "login";
        }
        return "sysB";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse){
        Cookie ck=new Cookie("token",null);
        ck.setMaxAge(0);
        httpServletResponse.addCookie(ck);
        return "logout";
    }

}
