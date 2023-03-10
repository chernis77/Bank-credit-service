package com.example.creditbankcheckclient.mapper.impl;

import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.mapper.TransferBidToApproveDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class TransferBidToApproveDTOMapperImpl implements TransferBidToApproveDTOMapper {

    public TransferBidToApproveDTO fillTransferBidToApproveDTO(CheckBidEntity checkBidEntity) {

        TransferBidToApproveDTO transferBidToApproveDTO = new TransferBidToApproveDTO();

        transferBidToApproveDTO.setBidNumber(checkBidEntity.getBidNumber());
        transferBidToApproveDTO.setFirstName(checkBidEntity.getCheckClientEntity().getFirstName());
        transferBidToApproveDTO.setSurName(checkBidEntity.getCheckClientEntity().getSurName());
        transferBidToApproveDTO.setLastName(checkBidEntity.getCheckClientEntity().getLastName());
        transferBidToApproveDTO.setPassportNum(checkBidEntity.getCheckClientEntity().getPassportNum());
        transferBidToApproveDTO.setCreditAmount(checkBidEntity.getCreditAmount());
        transferBidToApproveDTO.setCreditTerm(checkBidEntity.getCreditTerm());
        transferBidToApproveDTO.setPercentYear(checkBidEntity.getPercentYear());

            return transferBidToApproveDTO;
    }

}
