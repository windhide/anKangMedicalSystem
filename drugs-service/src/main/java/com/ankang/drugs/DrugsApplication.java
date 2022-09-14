package com.ankang.drugs;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.ankang.drugs.mapper")
@SpringBootApplication
public class DrugsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugsApplication.class, args);
    }
}
