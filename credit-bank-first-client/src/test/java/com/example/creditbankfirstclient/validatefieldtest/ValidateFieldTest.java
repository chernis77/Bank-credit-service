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
@RunWith(MockitoJUnitRunner.class )
@SuppressWarnings("unchecked")
public class ValidateFieldTest {

    @Autowired
    private FormServiceImpl formService;

    @Mock
    private FillFormDTO fillFormDTO;

    @Test
    public void firstNameValidateTest(){
        Mockito.when(fillFormDTO.getFirstName()).thenReturn("gfds5");
        ResponseDTO responseDTO = formService.validateField(fillFormDTO);
        Assert.assertTrue(responseDTO.getMessage() != null);

    }
}
