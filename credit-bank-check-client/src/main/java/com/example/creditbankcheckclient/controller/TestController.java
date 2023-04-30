package com.example.creditbankcheckclient.controller;

import com.example.creditbankcheckclient.dto.CheckBidDTO;
import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.mapper.CheckBidEntityMapper;
import com.example.creditbankcheckclient.mapper.TransferBidToApproveDTOMapper;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import com.example.creditbankcheckclient.resttemplate.ToApprovedClientResttemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testclient")
public class TestController {

    @Autowired
    private CheckBidRepository checkBidRepository;

    @Autowired
    private CheckBidEntityMapper checkBidEntityMapper;

    @Autowired
    private TransferBidToApproveDTOMapper transferBidToApproveDTOMapper;

    @GetMapping("/testmessage")
    public String testMessage(@RequestParam String name){

        return "Это сообщение из модуля credit-bank-check-client, class TestController, метод testMessage " + name;
    }

    @PostMapping("/lastrow")
    public @ResponseBody CheckBidEntity getLastBid(){

        CheckBidEntity topByOrderByIdDesc = checkBidRepository.getTopByOrderByIdDesc();
        return topByOrderByIdDesc;

    }
    @PostMapping("/bidNum")
    public @ResponseBody CheckBidDTO getCheckBidDTO(@RequestParam String bidNumber){

    CheckBidEntity checkBidEntityByBidNumber = checkBidRepository.getCheckBidEntityByBidNumber(bidNumber);

    CheckBidDTO checkBidDTO = checkBidEntityMapper.checkBidEntityToDTO(checkBidEntityByBidNumber);

    return checkBidDTO;

    }

    @PostMapping("/toApproveDTO")
    public @ResponseBody TransferBidToApproveDTO getTransferBidToApproveDTO(@RequestParam String bidNumber){

        CheckBidEntity checkBidEntityByBidNumber = checkBidRepository.getCheckBidEntityByBidNumber(bidNumber);

        TransferBidToApproveDTO transferBidToApproveDTO = transferBidToApproveDTOMapper.fillTransferBidToApproveDTO(checkBidEntityByBidNumber);

        return transferBidToApproveDTO;
    }

    @PostMapping("/toApprovedClient")
    public String testTransferCheckClientToApproveClient(@RequestParam String bidNumber){

        CheckBidEntity checkBidEntityByBidNumber = checkBidRepository.getCheckBidEntityByBidNumber(bidNumber);

        TransferBidToApproveDTO transferBidToApproveDTO = transferBidToApproveDTOMapper.fillTransferBidToApproveDTO(checkBidEntityByBidNumber);

        ToApprovedClientResttemplate toApprovedClientResttemplate = new ToApprovedClientResttemplate();
        String responseMessage = toApprovedClientResttemplate.testResponceToApprovedClient(transferBidToApproveDTO);

        return responseMessage;

    }



}

//  /testclient/bidNum    /testclient/toApproveDTO    /testclient/toApprovedClient