package com.example.creditbankcheckclient.service.impl;

import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.mapper.TransferBidToApproveDTOMapper;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import com.example.creditbankcheckclient.resttemplate.ToApprovedClientResttemplate;
import com.example.creditbankcheckclient.service.TakeBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeBidServiceImpl implements TakeBidService {

    @Autowired
    CheckBidRepository checkBidRepository;

    @Autowired
    TransferBidToApproveDTOMapper transferBidToApproveDTOMapper;




    public String takeBidForContract(String bidNumber){

        String message = null;

        CheckBidEntity checkBidEntityByBidNumber = checkBidRepository.getCheckBidEntityByBidNumber(bidNumber);

        if(checkBidEntityByBidNumber != null  && checkBidEntityByBidNumber.getBankConfirm() == true && checkBidEntityByBidNumber.getClientConfirm() == null){
            checkBidEntityByBidNumber.setClientConfirm(true);
            TransferBidToApproveDTO transferBidToApproveDTO = transferBidToApproveDTOMapper.fillTransferBidToApproveDTO(checkBidEntityByBidNumber);

            ToApprovedClientResttemplate toApprovedClientResttemplate = new ToApprovedClientResttemplate();
            String s = toApprovedClientResttemplate.sendBidToApprovedClient(transferBidToApproveDTO);

            message = s;

        } else if (checkBidEntityByBidNumber == null ){
            message = "Заявки с таким номером не существует ";
        } else if (checkBidEntityByBidNumber.getBankConfirm() == true && checkBidEntityByBidNumber.getClientConfirm() == true) {
            message =  "Договор по заявке № " + bidNumber + " уже создан." ;
        }
        return message;
    }

}
