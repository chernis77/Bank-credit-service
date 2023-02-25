package com.example.creditbankapprovedclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testapproved" )
public class TestController {
    @GetMapping("/testappmessage" )
    String testMessage (@RequestParam String name){
        return " Это сообщение из модуля credit-bank-approved-client, класс TestController, метод TestMessage() " + name ;
    }

}
