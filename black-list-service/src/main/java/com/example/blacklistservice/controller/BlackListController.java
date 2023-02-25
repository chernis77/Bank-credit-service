package com.example.blacklistservice.controller;

import com.example.blacklistservice.dto.TransferPassportNumDTO;
import com.example.blacklistservice.entity.BlackListEntity;
import com.example.blacklistservice.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/check2")
    public boolean checkClientBlackList(@RequestBody TransferPassportNumDTO transferPassportNumDTO){

        boolean isInBlackList = false;

        BlackListEntity blackListEntityByPassportNum = blackListRepository.getBlackListEntityByPassportNum(transferPassportNumDTO.getPassportNum() );
         if(blackListEntityByPassportNum != null ){
            isInBlackList = true;
        }

        return isInBlackList;
    }

}

///    /blacklist/check