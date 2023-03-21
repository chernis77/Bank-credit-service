package com.example.creditbankfirstclient.controller;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.feignservice.FormFeignService;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fill" )
public class FormController {


    @Autowired
    private FormService formService;

    @Autowired
    private FormRestTemplate formRestTemplate;

//    @GetMapping("/fillform" )
//    public @ResponseBody ResponseDTO fillForm(@RequestParam String firstName, @RequestParam String lastName){
//
//        ResponseDTO responseDTO = formService.fillInForm(firstName, lastName);
//        return responseDTO;
//    }

//    @GetMapping("/fillform" )
//    public @ResponseBody ResponseDTO fillForm(@RequestParam String firstName, @RequestParam String lastName){
//        RequestFormDTO requestFormDTO = new RequestFormDTO();
//        requestFormDTO.setFirstName(firstName);
//        requestFormDTO.setLastName(lastName);
//
//
//        ResponseDTO responseDTO = validateField(requestFormDTO);
//        /** вызываем FeinClient, передаём RequestFormDTO */
////        if(responseDTO.getMessage().isEmpty()){
////            ;
////        }
//
//       return responseDTO;
//    }
//
//    public ResponseDTO validateField(@Validated RequestFormDTO form) {
//
//          ResponseDTO responseDTO = null;
//
//
//        if (form.getFirstName().matches(".*[^А-Яа-яЁё].*") == true) {
//            responseDTO = new ResponseDTO();
//
//            responseDTO.setMessage("В поле FirstName содержатся некорректные символы");
//            //  responseDTO.setStatusCode(HttpStatus.SC_FORBIDDEN);
//        }
//        if (form.getLastName().matches(".*[^А-Яа-яЁё].*") == true) {
//            if (responseDTO == null) {
//                responseDTO = new ResponseDTO();
//            }
//            if (responseDTO.getMessage() != null) {
//                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле LastName содержатся некорректные символы");
//            } else {
//                responseDTO.setMessage("В поле LastName содержатся некорректные символы");
//            }
//        }
//        return responseDTO;
//    }

    /**
     *  Принимает от клиента заполненную форму запроса FillFormDTO на выдачу кредита.
     *
     *
     */
    @PostMapping("/sendform")
    public @ResponseBody ResponseDTO sendFormToCheckClient(@RequestBody FillFormDTO fillFormDTO) {

        ResponseDTO responseDTO = formService.validateField(fillFormDTO);

        if (responseDTO.getMessage() == null) {
        RequestFormDTO requestFormDTO = formService.fillInRequestFormDTO(fillFormDTO);
        CheckResponseDTO checkResponse = formRestTemplate.getCheckResponse(requestFormDTO);
        responseDTO.setMessage(checkResponse.getMessage());
    }

        return responseDTO;

    }
    //    /fill/sendform

}
