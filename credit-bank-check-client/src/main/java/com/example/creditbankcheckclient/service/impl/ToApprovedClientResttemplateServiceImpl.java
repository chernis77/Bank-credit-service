package com.example.creditbankcheckclient.service.impl;

import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import com.example.creditbankcheckclient.resttemplate.ToApprovedClientResttemplate;
import com.example.creditbankcheckclient.service.ToApprovedClientResttemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class ToApprovedClientResttemplateServiceImpl implements ToApprovedClientResttemplateService {

    @Autowired
    private ToApprovedClientResttemplate toApprovedClientResttemplate;


    public String castBidToApproveClient(TransferBidToApproveDTO transferBidToApproveDTO){
        String contractMessage = " ";

        try{
            contractMessage = toApprovedClientResttemplate.sendBidToApprovedClient(transferBidToApproveDTO);
            if(contractMessage != null ) return contractMessage;
            throw new NullPointerException();
        } catch (ResourceAccessException ex){
            contractMessage = ex.getMessage();
            return contractMessage;
        } catch (NullPointerException ex){
            contractMessage = "Проблемы с сервисом контрактов " + ex.getMessage();
            return contractMessage;
        }
    }
}

