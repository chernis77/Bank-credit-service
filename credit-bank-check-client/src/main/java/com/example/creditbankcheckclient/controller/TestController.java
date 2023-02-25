package com.example.creditbankcheckclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testclient")
public class TestController {
    @GetMapping("/testmessage")
    public String testMessage(@RequestParam String name){

        return "Это сообщение из модуля credit-bank-check-client, class TestController, метод testMessage " + name;
    }

}
