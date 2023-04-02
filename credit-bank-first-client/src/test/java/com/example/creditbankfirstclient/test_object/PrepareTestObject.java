package com.example.creditbankfirstclient.test_object;

import com.example.creditbankfirstclient.dto.FillFormDTO;

public class PrepareTestObject {

    public static FillFormDTO prepareaValidTestObj() {

        FillFormDTO formDTOtest = new FillFormDTO();

        formDTOtest.setFirstName("Иван");
        formDTOtest.setLastName("Иванов");
        formDTOtest.setSurName("Иванович");

        formDTOtest.setPassportNum("1234 567887");
        formDTOtest.setIsEmployed("да");
        formDTOtest.setTimeOfEmployment("12");
        formDTOtest.setSalary("50000");
        formDTOtest.setLoanPayments("15000");
        formDTOtest.setCreditAmount("300000");
        formDTOtest.setCreditTerm("12");

        return formDTOtest;
    }

    public static FillFormDTO prepareaNotValidTestObj() {

        FillFormDTO formDTOtest = new FillFormDTO();

        formDTOtest.setFirstName("1111");
        formDTOtest.setLastName("1111");
        formDTOtest.setSurName("1111");

        formDTOtest.setPassportNum("номер паспорта");
        formDTOtest.setIsEmployed("нет");
        formDTOtest.setTimeOfEmployment("двенадцать месяцев");
        formDTOtest.setSalary("число");
        formDTOtest.setLoanPayments("число");
        formDTOtest.setCreditAmount("число");
        formDTOtest.setCreditTerm("число");

        return formDTOtest;
    }
}
