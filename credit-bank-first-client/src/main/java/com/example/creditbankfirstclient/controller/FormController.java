package com.example.creditbankfirstclient.controller;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.servise.FormService;
import com.example.creditbankfirstclient.servise.RestTemplateServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.creditbankfirstclient.controller.ConstantProject.SEND_FORM_PATH;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private RestTemplateServise restTemplateServise;

    /**
     *  Принимает от клиента заполненную форму запроса FillFormDTO на выдачу кредита.
     *
     */
    @PostMapping(SEND_FORM_PATH)
    public @ResponseBody ResponseDTO sendFormToCheckClient(@RequestBody FillFormDTO fillFormDTO) {

        ResponseDTO responseDTO = formService.validateField(fillFormDTO);

        if (responseDTO.getMessage() == null) {
        RequestFormDTO requestFormDTO = formService.fillInRequestFormDTO(fillFormDTO);
            CheckResponseDTO checkResponse = restTemplateServise.getResttemplateCheckResponce(requestFormDTO);

        responseDTO.setMessage(checkResponse.getMessage());
    }
        return responseDTO;
    }
    //    /fill/sendform

}
