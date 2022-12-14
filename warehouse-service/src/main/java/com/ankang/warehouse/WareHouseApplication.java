package com.ankang.warehouse;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.PharmacyClient;
import com.ankang.clients.StaffClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.ankang.warehouse.mapper")
@SpringBootApplication
@EnableFeignClients(clients = {DrugsClient.class, StaffClient.class, PharmacyClient.class})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WareHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareHouseApplication.class,args);
    }
}
