package com.example.fundsystembackend;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @EnableTransactionManagement
// @MapperScan("com.example.fundsystembackend.mapper")
// @ComponentScan(basePackages = {
//         "com.example.fundsystembackend.config",
//         "com.example.fundsystembackend.controller",
//         "com.example.fundsystembackend.service"})
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class FundSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundSystemBackendApplication.class, args);
    }

}
