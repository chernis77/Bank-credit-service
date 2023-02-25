package com.example.creditbankcheckclient.controller;

import com.example.creditbankcheckclient.dto.CheckResponseDTO;
import com.example.creditbankcheckclient.dto.RequestFormDTO;
import com.example.creditbankcheckclient.dto.TransferPassportNumDTO;
import com.example.creditbankcheckclient.resttemplate.IsInBlackListResttemplate;
import com.example.creditbankcheckclient.service.CheckClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
@RequestMapping("/check" )
public class CheckController {
    @Autowired
    CheckClientService checkClientService;

//    public String requestTest(@RequestBody RequestFormDTO requestFormDTO){
        @GetMapping("/checkrequest" )
       public String requestTest(){

//        if(requestFormDTO.getFirstName()!= null && requestFormDTO.getLastName() !=null) {
//
//            return "Метод requestTest из модуля credit-bank-check-client, поля заполнены ";
//
//        }
        return "Метод requestTest из модуля credit-bank-check-client, поля отсутствуют ";
    }

    @GetMapping( "/blacklist")
    public boolean blackListRequest(String passportNum){
        IsInBlackListResttemplate isInBlackListResttemplate = new IsInBlackListResttemplate();
        boolean inBlackListRequest = isInBlackListResttemplate.isInBlackListRequest(passportNum);
        return inBlackListRequest;

    }

//    @GetMapping( "/blacklist2")
//    public boolean blackListRequest(String passportNum){
//
//        TransferPassportNumDTO transferPassportNumDTO = new TransferPassportNumDTO();
//        transferPassportNumDTO.setPassportNum(passportNum);
//
//        IsInBlackListResttemplate isInBlackListResttemplate = new IsInBlackListResttemplate();
//        boolean inBlackListRequest = isInBlackListResttemplate.isInBlackListRequest(transferPassportNumDTO);
//        try {
//            boolean inBlackListRequest = isInBlackListResttemplate.isInBlackListRequest(transferPassportNumDTO);
//        } catch (HttpStatusCodeException ex){
//            ex.getStatusCode();
//            return
//        }
//        return inBlackListRequest;

//    }

    @PostMapping("/clientresponse")
    public CheckResponseDTO checkClientResponse (@RequestBody RequestFormDTO requestFormDTO){

        CheckResponseDTO checkResponseDTO = checkClientService.checkFormClient(requestFormDTO);
        return checkResponseDTO;

    }

}

//   /check/checkrequest                /check/blacklist          /check/monthpay

//  /check/clientresponse