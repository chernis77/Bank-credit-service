package com.example.creditbankfirstclient.controller;


import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.dto.TestDTO;
import com.example.creditbankfirstclient.feignservice.TestFeignService;
import com.example.creditbankfirstclient.feignservice.TestFeignService2;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.creditbankfirstclient.constant.ErrorsConstant.FIELD_MISSED;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private TestFeignService testFeignService;

    @Autowired
    private TestFeignService2 testFeignService2;


    @GetMapping("/test")
    public String testString(@RequestParam String name) {

        String firstMessage = testFeignService.testMessage(name);
       String secondMessage = testFeignService2.testMessage(name);


        TestDTO testDTO = new TestDTO();
        testDTO.setFirstMessage(firstMessage);
 //       testDTO.setCheckMessage(secondMessage);

        return firstMessage + secondMessage ;
 //       return testDTO.toString();
    }



    @GetMapping("/validate")
    public @ResponseBody ResponseDTO validateField(@Validated @RequestBody RequestFormDTO form) {

        ResponseDTO responseDTO = null;

//        if (form.getFirstName()==null ){
//            ResponseDTO responseDTO = new ResponseDTO();
//            responseDTO.setMessage(FIELD_MISSED);
//            responseDTO.setStatusCode(HttpStatus.);
//        }

        if (form.getFirstName().matches("[^А-Яа-яЁё]") == true) {
            responseDTO = new ResponseDTO();

            responseDTO.setMessage("В поле FirstName содержатся некорректные символы");
            //  responseDTO.setStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        if (form.getLastName().matches("[^А-Яа-яЁё]") == true) {
            if (responseDTO == null) {
                responseDTO = new ResponseDTO();
            }
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле LastName содержатся некорректные символы");
            } else {
                responseDTO.setMessage("В поле LastName содержатся некорректные символы");
            }

        }


        return responseDTO;
    }
}