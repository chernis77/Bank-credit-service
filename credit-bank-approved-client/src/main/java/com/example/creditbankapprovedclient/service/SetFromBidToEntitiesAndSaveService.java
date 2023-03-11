package com.example.creditbankapprovedclient.service;

import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;

public interface SetFromBidToEntitiesAndSaveService {

    void setAndSaveFromBidToContract(TransferBidToApproveDTO transferBidToApproveDTO);

    String contractResponseMessage(String bidNumber);

}
