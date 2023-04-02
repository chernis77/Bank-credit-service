package com.example.creditbankfirstclient.validatefieldtest;

import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;
import com.example.creditbankfirstclient.servise.impl.FormServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.creditbankfirstclient.controller.ConstantProject.TEST_FIELD;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class )
@SuppressWarnings("unchecked")
public class ValidateFieldTest {

    @Autowired
    private FormServiceImpl formService;

    @Mock
    private FillFormDTO fillFormDTO;

    @Test
    public void checkNonValidateTest(){
        Mockito.when(fillFormDTO.getFirstName()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getSurName()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getLastName()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getPassportNum()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getIsEmployed()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getTimeOfEmployment()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getSalary()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getLoanPayments()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getCreditAmount()).thenReturn(TEST_FIELD);
        Mockito.when(fillFormDTO.getCreditTerm()).thenReturn(TEST_FIELD);

        ResponseDTO responseDTO = formService.validateField(fillFormDTO);
        Assert.assertTrue(responseDTO.getMessage() != null);

    }

    @Test
    public void fillInRequestFormDTOTest(){
        Mockito.when(fillFormDTO.getFirstName()).thenReturn("Андрей");
        Mockito.when(fillFormDTO.getSurName()).thenReturn("Петрович");
        Mockito.when(fillFormDTO.getLastName()).thenReturn("Смиронов");
        Mockito.when(fillFormDTO.getPassportNum()).thenReturn("2110 876428");
        Mockito.when(fillFormDTO.getIsEmployed()).thenReturn("Да");
        Mockito.when(fillFormDTO.getTimeOfEmployment()).thenReturn("12");
        Mockito.when(fillFormDTO.getSalary()).thenReturn("50000");
        Mockito.when(fillFormDTO.getLoanPayments()).thenReturn("15000");
        Mockito.when(fillFormDTO.getCreditAmount()).thenReturn("300000");
        Mockito.when(fillFormDTO.getCreditTerm()).thenReturn("48");

        RequestFormDTO requestFormDTO = formService.fillInRequestFormDTO(fillFormDTO);

        Assert.assertTrue(requestFormDTO != null);
    }

}
