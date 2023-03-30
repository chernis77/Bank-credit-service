package com.example.creditbankfirstclient.getresttemplatecheckresponse;

import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.resttemplate.FormRestTemplate;
import com.example.creditbankfirstclient.servise.impl.RestTemplateServiseImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.ResourceAccessException;

@SpringBootTest
public class getResttemplateCheckResponseTest {

    @Mock
    private FormRestTemplate formRestTemplate;

    @Autowired
    private RestTemplateServiseImpl restTemplateServise;

    @Test
    public void checkAccessException(){

        RequestFormDTO requestFormDTO = new RequestFormDTO();


        Mockito.when(formRestTemplate.getCheckResponse(requestFormDTO)).thenReturn(null ) ;
        restTemplateServise.getResttemplateCheckResponce(requestFormDTO);


    }


}
