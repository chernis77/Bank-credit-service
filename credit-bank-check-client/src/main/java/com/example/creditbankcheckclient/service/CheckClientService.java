package com.example.creditbankcheckclient.service;

import com.example.creditbankcheckclient.dto.CheckResponseDTO;
import com.example.creditbankcheckclient.dto.RequestFormDTO;

public interface CheckClientService {

    CheckResponseDTO checkFormClient(RequestFormDTO requestFormDTO);



}
