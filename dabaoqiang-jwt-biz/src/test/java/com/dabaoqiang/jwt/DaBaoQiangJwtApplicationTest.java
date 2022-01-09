package com.dabaoqiang.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xq
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.dabaoqiang.jwt.mapper"})
public class DaBaoQiangJwtApplicationTest {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DaBaoQiangJwtApplicationTest.class);
        springApplication.run(args);

    }
}
