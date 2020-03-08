package com.only.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CilentServer {

    public static void main(String[] args) {

        SpringApplication.run(CilentServer.class, args);
    }
}
