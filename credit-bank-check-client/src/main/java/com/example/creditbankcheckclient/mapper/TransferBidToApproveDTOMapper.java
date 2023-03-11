package com.example.creditbankcheckclient.mapper;

import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;

public interface TransferBidToApproveDTOMapper {

    TransferBidToApproveDTO fillTransferBidToApproveDTO(CheckBidEntity checkBidEntity);

}
