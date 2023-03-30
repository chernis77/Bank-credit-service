package com.example.creditbankapprovedclient.controller;

import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;
import com.example.creditbankapprovedclient.service.SetFromBidToEntitiesAndSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/approved")
public class ApprovedController {

    @Autowired
    SetFromBidToEntitiesAndSaveService setFromBidToEntitiesAndSaveService;

    @PostMapping("/contract")
    public String saveBidToContract (@RequestBody TransferBidToApproveDTO transferBidToApproveDTO){

        setFromBidToEntitiesAndSaveService.setAndSaveFromBidToContract(transferBidToApproveDTO);

        String bidNumber = transferBidToApproveDTO.getBidNumber();

         return   setFromBidToEntitiesAndSaveService.contractResponseMessage(bidNumber);

    }

}


//   /approved/contract