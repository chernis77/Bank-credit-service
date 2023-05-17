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
    ContractShowMapper contractShowMapper;

    @PostMapping("/contractinfo/{contractNumber}")
    public @ResponseBody ContractShowDTO getContractInfo(@PathVariable String contractNumber ){

        ContractEntity contractEntityByContractNumber = contractRepository.getContractEntityByContractNumber(contractNumber);

        ContractShowDTO contractShowDTO = contractShowMapper.getContractShowDTO(contractEntityByContractNumber);

        return  contractShowDTO;

    }





}

//  /testapproved/requestmessage

//  /testapproved/contractinfo