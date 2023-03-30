package com.example.creditbankfirstclient.controller;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.feignservice.FormFeignService;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.FormService;
import com.example.creditbankfirstclient.servise.RestTemplateServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fill" )
public class FormController {


    @Autowired
    private FormService formService;

    @Autowired
    private RestTemplateServise restTemplateServise;


    /**
     *  Принимает от клиента заполненную форму запроса FillFormDTO на выдачу кредита.
     */
    @PostMapping("/sendform")
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
