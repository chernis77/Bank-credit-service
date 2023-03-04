package com.example.creditbankcheckclient.controller;

import com.example.creditbankcheckclient.dto.CheckBidDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.mapper.CheckBidEntityMapper;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testclient")
public class TestController {

    @Autowired
    CheckBidRepository checkBidRepository;

    @Autowired
    CheckBidEntityMapper checkBidEntityMapper;

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

}

//  /testclient/bidNum