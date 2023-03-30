package com.example.creditbankcheckclient.service;

import com.example.creditbankcheckclient.dto.TransferPassportNumDTO;

public interface IsInBlackListResttemplateService  {

    Boolean getBlackListResponse(String passportNum) throws NullPointerException;

}
