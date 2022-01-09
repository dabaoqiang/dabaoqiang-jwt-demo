package com.dabaoqiang.jwt.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.dabaoqiang")
@RestController
@ServletComponentScan(value = "com.dabaoqiang.jwt.config")
@MapperScan(basePackages = {"com.dabaoqiang.jwt.mapper"})
public class JwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

    @RequestMapping("/monitor")
    public String monitor() {
        return "SUCCESS";
    }
}
