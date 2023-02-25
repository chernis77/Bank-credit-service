package com.example.apiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiClientApplication.class, args);
    }

}
