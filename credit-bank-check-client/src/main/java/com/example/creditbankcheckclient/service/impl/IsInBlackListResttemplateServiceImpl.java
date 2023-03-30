package com.example.creditbankcheckclient.service.impl;

import com.example.creditbankcheckclient.resttemplate.IsInBlackListResttemplate;
import com.example.creditbankcheckclient.service.IsInBlackListResttemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsInBlackListResttemplateServiceImpl implements IsInBlackListResttemplateService {

    @Autowired
    private IsInBlackListResttemplate isInBlackListResttemplate;
    public Boolean getBlackListResponse(String passportNum) throws NullPointerException {

        Boolean  blackListResponce = isInBlackListResttemplate.isInBlackListRequest(passportNum);
            if (blackListResponce != null) return blackListResponce;
            throw new NullPointerException();

    }
}

