package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo3Application {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "11111111";
    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
        String token = TokenUtil.sign(USERNAME, PASSWORD);

        System.out.println("加密后的token为：" + token);

        boolean flag = TokenUtil.verfiy(token);

        if(flag){
            System.out.println("校验成功");
        } else {
            System.out.println("校验失败");
        }

    }

}
