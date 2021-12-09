package com.example.fundsystembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableOpenApi
public class FundSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundSystemBackendApplication.class, args);
    }

}
