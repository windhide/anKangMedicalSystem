package com.ankang.user;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.StaffClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@MapperScan("com.ankang.user.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {DrugsClient.class, StaffClient.class})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
