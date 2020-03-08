package com.only.you;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan({"com.only.you.dao"})
@EnableFeignClients
public class TaskServer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskServer.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }
}
