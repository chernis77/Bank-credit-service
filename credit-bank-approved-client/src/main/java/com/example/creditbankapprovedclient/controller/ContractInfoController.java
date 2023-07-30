package com.example.creditbankapprovedclient.controller;

import com.example.creditbankapprovedclient.dto.ContractShowDTO;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.mapper.ContractShowMapper;
import com.example.creditbankapprovedclient.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testapproved" )
public class ContractInfoController {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    ContractShowMapper contractShowMapper;

    @PostMapping("/contractinfo/{contractNumber}")
    public @ResponseBody ContractShowDTO getContractInfo(@PathVariable String contractNumber ){

        ContractShowDTO contractShowDTO = null;

        if(contractRepository.getContractEntityByContractNumber(contractNumber) != null ) {

            ContractEntity contractEntityByContractNumber = contractRepository.getContractEntityByContractNumber(contractNumber);

            contractShowDTO = contractShowMapper.getContractShowDTO(contractEntityByContractNumber);

            contractShowDTO.setStartMessage("Информация о кредитном договоре: ");
        } else if (contractRepository.getContractEntityByContractNumber(contractNumber) == null ){
            contractShowDTO = new ContractShowDTO();
            contractShowDTO.setStartMessage("Договора с номером " + contractNumber + " не существует" );
        }

        return  contractShowDTO;

    }





}

//  /testapproved/requestmessage

//  /testapproved/contractinfo