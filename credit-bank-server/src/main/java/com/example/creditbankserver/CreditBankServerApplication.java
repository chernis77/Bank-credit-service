package com.example.creditbankserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CreditBankServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditBankServerApplication.class, args);
    }

}
