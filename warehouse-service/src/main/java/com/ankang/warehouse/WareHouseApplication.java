package com.ankang.warehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ankang.warehouse.mapper")
@SpringBootApplication
public class WareHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareHouseApplication.class,args);
    }
}
