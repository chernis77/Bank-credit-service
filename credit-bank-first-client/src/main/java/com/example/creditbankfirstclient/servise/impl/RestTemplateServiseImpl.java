package com.example.creditbankfirstclient.servise.impl;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.RestTemplateServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class RestTemplateServiseImpl implements RestTemplateServise {

    @Autowired
    private FormRestTemplate formRestTemplate;

    @Override
    public CheckResponseDTO getResttemplateCheckResponce(RequestFormDTO requestFormDTO) {
        CheckResponseDTO checkResponseDTO = new CheckResponseDTO();

        try {
            checkResponseDTO = formRestTemplate.getCheckResponse(requestFormDTO);
            if (checkResponseDTO.getMessage() != null) return checkResponseDTO;
            throw new NullPointerException();
        } catch (ResourceAccessException ex) {
            checkResponseDTO.setMessage(ex.getLocalizedMessage());
            return checkResponseDTO;
        } catch (NullPointerException ex) {
            checkResponseDTO.setMessage("Проблемы с сервисом проверки " + ex.getMessage());
            return checkResponseDTO;
        }
    }
}
