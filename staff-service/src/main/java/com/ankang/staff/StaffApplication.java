package com.ankang.staff;

import com.ankang.clients.DrugsClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("com.ankang.staff.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {DrugsClient.class})
public class StaffApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaffApplication.class,args);
    }
}
