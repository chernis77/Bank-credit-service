package com.example.creditbankapprovedclient.controller;

import com.example.creditbankapprovedclient.dto.ContractShowDTO;
import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.mapper.ContractShowMapper;
import com.example.creditbankapprovedclient.repository.ContractRepository;
import com.example.creditbankapprovedclient.service.PaymentsCalc;
import com.example.creditbankapprovedclient.service.PaymentsSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testapproved" )
public class TestController {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    PaymentsCalc paymentsCalc;

    @Autowired
    ContractShowMapper contractShowMapper;


    @GetMapping("/testappmessage" )
    public String testMessage (@RequestParam String name){
        return " Это сообщение из модуля credit-bank-approved-client, класс TestController, метод TestMessage() " + name ;
    }

    @PostMapping("/requestmessage")
    public String testRequestMessage(@RequestBody TransferBidToApproveDTO transferBidToApproveDTO){

        String bidNumber = transferBidToApproveDTO.getBidNumber();
        String firstName = transferBidToApproveDTO.getFirstName();
        String surName = transferBidToApproveDTO.getSurName();
        String lastName = transferBidToApproveDTO.getLastName();
        String passportNum = transferBidToApproveDTO.getPassportNum();
        Double creditAmount = transferBidToApproveDTO.getCreditAmount();
        Double creditTerm = transferBidToApproveDTO.getCreditTerm();
        Double percentYear = transferBidToApproveDTO.getPercentYear();

        return "Заявка " + bidNumber + " " + firstName + " " + surName + " " + lastName +" паспотрт№ " + passportNum + " "
                + creditAmount + " руб, срок " + creditTerm + " под " + percentYear + "%" ;

    }

    @PostMapping("/contractinfo/{contractNumber}")
    public @ResponseBody ContractShowDTO getContractInfo(@PathVariable String contractNumber ){

        ContractEntity contractEntityByContractNumber = contractRepository.getContractEntityByContractNumber(contractNumber);

        ContractShowDTO contractShowDTO = contractShowMapper.getContractShowDTO(contractEntityByContractNumber);

//        List<PaymentsSchedule> paymentsSchedule = paymentsCalc.getPaymentsSchedule(contractEntityByContractNumber);

        return  contractShowDTO;

    }





}

//  /testapproved/requestmessage

//  /testapproved/contractinfo