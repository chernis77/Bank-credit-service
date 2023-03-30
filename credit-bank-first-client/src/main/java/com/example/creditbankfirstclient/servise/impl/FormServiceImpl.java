package com.example.creditbankfirstclient.servise.impl;

import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  FormServiceImpl implements FormService {




    @Autowired
    private FormRestTemplate formRestTemplate;



    /**
     * Выполняет валидацию полей экземпляра FillFormDTO, возвращает  ResponseDTO с сообщением
     * о выявленных ошибках.
     */

    public ResponseDTO validateField(FillFormDTO form) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (form == null) {
            responseDTO.setMessage("Ошибка заполнения формы - форма пустая");
            return responseDTO;
        }

        if(form.getFirstName() == null || form.getFirstName().equals("") ){
            responseDTO.setMessage("Поле firstName пустое");
        }

        if(form.getSurName() == null || form.getSurName().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле surName пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле surName пустое");
            }
        }

        if(form.getLastName() == null || form.getLastName().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле lastName пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле lastName пустое");
            }
        }

        if(form.getPassportNum() == null || form.getPassportNum().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле passportNum пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле passportNum пустое");
            }
        }

        if(form.getIsEmployed() == null || form.getIsEmployed().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле IsEmployed пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле IsEmployed пустое");
            }
        }

        if(form.getTimeOfEmployment() == null || form.getTimeOfEmployment().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле timeOfEmployment пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле timeOfEmployment пустое");
            }
        }
        if(form.getSalary() == null || form.getSalary().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле salary пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле salary пустое");
            }
        }

        if(form.getLoanPayments() == null || form.getLoanPayments().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле loanPayments пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле loanPayments пустое");
            }
        }

        if(form.getCreditAmount() == null || form.getCreditAmount().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле creditAmount пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле creditAmount пустое");
            }
        }

        if(form.getCreditTerm() == null || form.getCreditTerm().equals("")){
            if(responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + " \n" + " Поле creditTerm пустое");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("Поле creditTerm пустое");
            }
        }


        if (form.getFirstName().matches(".*[^А-Яа-яЁё].*") == true) {
            if (responseDTO.getMessage() != null) {
                responseDTO.setMessage(responseDTO.getMessage() + "\n" + " В поле firstName содержатся некорректные символы");
            } else if (responseDTO.getMessage() == null) {
                responseDTO.setMessage("В поле firstName содержатся некорректные символы");
            }
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

    /**
     * Заполняет поля экземпляра RequestFormDTO из FillFormDTO, возвращает экземпляр RequestFormDTO
     */

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
