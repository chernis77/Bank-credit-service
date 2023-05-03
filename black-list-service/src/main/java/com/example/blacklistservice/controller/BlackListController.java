package com.example.blacklistservice.controller;

import com.example.blacklistservice.entity.BlackListEntity;
import com.example.blacklistservice.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blacklist")
public class BlackListController {

    @Autowired
    private BlackListRepository blackListRepository;

    @GetMapping("/check")
   public boolean checkClientBlackList(@RequestParam String passportNum){

        boolean isInBlackList = false;

        BlackListEntity blackListEntityByPassportNum = blackListRepository.getBlackListEntityByPassportNum(passportNum);
            if(blackListEntityByPassportNum != null ){
                isInBlackList = true;
            }

            return isInBlackList;
    }

}

///    /blacklist/check