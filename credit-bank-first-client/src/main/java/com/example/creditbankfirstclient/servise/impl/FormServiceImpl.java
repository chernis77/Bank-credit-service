package com.example.creditbankfirstclient.servise.impl;

import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {


//    @Autowired
//    private FormFeignService formFeignService;

    @Autowired
    private FormRestTemplate formRestTemplate;


//    public ResponseDTO fillInForm(String firstName, String lastName) {
//        RequestFormDTO requestFormDTO = new RequestFormDTO();
//        requestFormDTO.setFirstName(firstName);
//        requestFormDTO.setLastName(lastName);
//
//
//        ResponseDTO responseDTO = validateField(requestFormDTO);
//
//        if (responseDTO.getMessage() != null) {
//            return responseDTO;
//        }
////        /** вызываем FeinClient, передаём RequestFormDTO */
//
////        String s = formFeignService.requestTest(requestFormDTO);
//
//        String s = formRestTemplate.getCheckForm(requestFormDTO);
//        responseDTO.setMessage(s);
//        return responseDTO;
//    }

    public ResponseDTO validateField(FillFormDTO form) {

        ResponseDTO responseDTO = new ResponseDTO();

//        if (form == null) {
//            responseDTO.setMessage("Ошибка заполнения формы");
//        }

        if (form.getFirstName().matches(".*[^А-Яа-яЁё].*") == true) {
            responseDTO.setMessage("В поле firstName содержатся некорректные символы");

            //  responseDTO.setStatusCode(HttpStatus.SC_FORBIDDEN);
        }

        if (form.getSurName().matches(".*[^А-Яа-яЁё].*") == true) {
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле surName содержатся некорректные символы");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("В поле surName содержатся некорректные символы");
            }
        }

        if (form.getLastName().matches(".*[^А-Яа-яЁё].*") == true) {
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле LastName содержатся некорректные символы");
            } else {
                responseDTO.setMessage("В поле LastName содержатся некорректные символы");
            }
        }

        if (form.getPassportNum().matches("(\\d{4}\\s\\d{6})") == false) {
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " Поле passportNum заполнено некорректно, " +
                        "в нем должно быть 10 цифр, после 4й цифры -пробел");
            } else {
                responseDTO.setMessage("Поле passportNum заполнено некорректно, в нем должно быть 10 цифр, после 4й цифры -пробел");
            }
        }

        if (!form.getIsEmployed().equalsIgnoreCase("true") && !form.getIsEmployed().equalsIgnoreCase("false")
                && !form.getIsEmployed().equalsIgnoreCase("да") && !form.getIsEmployed().equalsIgnoreCase("нет")) {
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле isEmployed содержатся некорректные символы, введите true, false, да или нет");
            } else {
                responseDTO.setMessage("В поле isEmployed содержатся некорректные символы, введите true, false, да или нет");
            }
        }

        if (form.getTimeOfEmployment().matches("\\d+") == false) {

            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " в поле timeOfEmployment содержатся некорректные символы " +
                        ", допустимы только цифры");
            } else {
                responseDTO.setMessage("В поле timeOfEmployment содержатся некорректные символы, допустимы только цифры");
            }
        }

        if (form.getSalary().matches("\\d+") == false) {

            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " в поле salary содержатся некорректные символы " +
                        ", допустимы только цифры");
            } else {
                responseDTO.setMessage("В поле salary содержатся некорректные символы, допустимы только цифры");
            }
        }

        if (form.getLoanPayments().matches("\\d+") == false) {

            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " в поле loanPayments содержатся некорректные символы " +
                        ", допустимы только цифры");
            } else {
                responseDTO.setMessage("В поле loanPayments содержатся некорректные символы, допустимы только цифры");
            }
        }

        if (form.getCreditAmount().matches("\\d+") == false) {

            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " в поле creditAmount содержатся некорректные символы " +
                        ", допустимы только цифры");
            } else {
                responseDTO.setMessage("В поле creditAmount содержатся некорректные символы, допустимы только цифры");
            }
        }

        if (form.getCreditTerm().matches("\\d+") == false) {

            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " в поле creditTerm содержатся некорректные символы " +
                        ", допустимы только цифры");
            } else {
                responseDTO.setMessage("В поле creditTerm содержатся некорректные символы, допустимы только цифры");
            }
        }

        return responseDTO;
    }

    public RequestFormDTO fillInRequestFormDTO(FillFormDTO form) {

        RequestFormDTO requestFormDTO = new RequestFormDTO();

        requestFormDTO.setFirstName(form.getFirstName());
        requestFormDTO.setSurName(form.getSurName());
        requestFormDTO.setLastName(form.getLastName());
        requestFormDTO.setPassportNum(form.getPassportNum());
        if (form.getIsEmployed().equalsIgnoreCase("true") || form.getIsEmployed().equalsIgnoreCase("да")) {
            requestFormDTO.setEmployed(true);
        } else if (form.getIsEmployed().equalsIgnoreCase("false") || form.getIsEmployed().equalsIgnoreCase("нет")) {
            requestFormDTO.setEmployed(false);
        }
        requestFormDTO.setTimeOfEmployment(Double.valueOf(form.getTimeOfEmployment()));
        requestFormDTO.setSalary(Double.valueOf(form.getSalary()));
        requestFormDTO.setLoanPayments(Double.valueOf(form.getLoanPayments()));
        requestFormDTO.setCreditAmount(Double.valueOf(form.getCreditAmount()));
        requestFormDTO.setCreditTerm(Double.valueOf(form.getCreditTerm()));

        return requestFormDTO;

    }

}
