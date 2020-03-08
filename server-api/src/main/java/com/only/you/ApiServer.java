package com.only.you;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.only.you.dao")
@EnableFeignClients
public class ApiServer {

    public static void main(String[] args) {
        SpringApplication.run(ApiServer.class, args);
    }
}
