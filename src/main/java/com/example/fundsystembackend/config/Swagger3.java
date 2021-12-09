package com.example.fundsystembackend.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author Jarrett Luo
 * @Date 2021/3/6 22:15
 * @Version 1.0
 */
@Configuration
public class Swagger3 {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder()
                        .contact(new Contact("Jarrett", "https://jiaruiblog.com", "luojiarui2@163.com"))
                        .title("基金管理系统项目Api")
                        .build()
        );
    }
}