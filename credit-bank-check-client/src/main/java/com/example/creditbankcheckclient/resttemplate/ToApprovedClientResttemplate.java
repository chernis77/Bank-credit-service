package com.example.creditbankcheckclient.resttemplate;

import com.example.creditbankcheckclient.dto.TransferBidToApproveDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ToApprovedClientResttemplate {

    private RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://localhost:8098/approved/contract";

    public String sendBidToApprovedClient(TransferBidToApproveDTO transferBidToApproveDTO ){

        return restTemplate.exchange(URL,
                HttpMethod.POST,
                new HttpEntity<>(transferBidToApproveDTO),
                String.class).getBody();
    }
}

//    /approved/contract