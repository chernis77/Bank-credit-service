package com.example.creditbankfirstclient.validatefieldtest;

import com.example.creditbankfirstclient.dto.FillFormDTO;
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

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class )
@SuppressWarnings("unchecked")
public class ValidateFieldTest {

    @Autowired
    private FormServiceImpl formService;

    @Mock
    private FillFormDTO fillFormDTO;

    private final String TEST_FIELD = "gfds5";
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
}
