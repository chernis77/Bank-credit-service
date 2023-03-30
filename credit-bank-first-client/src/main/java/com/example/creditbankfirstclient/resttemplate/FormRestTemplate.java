package com.example.creditbankfirstclient.resttemplate;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FormRestTemplate  {

    private RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://localhost:8097/check/clientresponse";

    private final String URL2 = "http://localhost:8097/check/checkrequest";

    public String getCheckForm(RequestFormDTO requestFormDTO){

     return    restTemplate.exchange(              // restTemplate.exchange() - метод сборки параметров для запроса
                URL2,                               //путь к методу, куда мы обращаемся
                HttpMethod.GET,                    //тип запроса
               new HttpEntity<>(requestFormDTO),  //передача тела запроса и headers
                String.class                       //тип возвращаемого значения
        ).getBody();                               // .getBody() - метод для выгрузки запроса

    }

    /**
     *  Высылает на credit-bank-check-client экземпляр RequestFormDTO ,
     *  затем получает с credit-bank-check-client ответ в экземпляре CheckResponseDTO, возвращает CheckResponseDTO
     */

    public CheckResponseDTO getCheckResponse(RequestFormDTO requestFormDTO){

        return    restTemplate.exchange(              // restTemplate.exchange() - метод сборки параметров для запроса
                URL,                               //путь к методу, куда мы обращаемся
                HttpMethod.POST,                    //тип запроса
                new HttpEntity<>(requestFormDTO),  //передача тела запроса и headers
                CheckResponseDTO.class                       //тип возвращаемого значения
        ).getBody();                               // .getBody() - метод для выгрузки запроса

//        return new CheckResponseDTO();
    }

}
