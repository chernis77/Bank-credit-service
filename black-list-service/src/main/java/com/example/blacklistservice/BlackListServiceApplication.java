package com.example.blacklistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BlackListServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlackListServiceApplication.class, args);
    }

}
