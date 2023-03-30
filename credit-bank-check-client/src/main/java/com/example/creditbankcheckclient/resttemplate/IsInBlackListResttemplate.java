package com.example.creditbankcheckclient.resttemplate;

import com.example.creditbankcheckclient.dto.TransferPassportNumDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class IsInBlackListResttemplate {

    private RestTemplate restTemplate = new RestTemplate();

    private final String URL = "http://localhost:8090/blacklist/check?passportNum=%s";
    // "http://localhost:8090/blacklist/check?passportNum=('%s')"

    private final String URL2 = "http://localhost:8090/blacklist/check2";

    public boolean isInBlackListRequest(String passportNum) {

        String format = String.format(URL, passportNum);

        return restTemplate.exchange(format,
                HttpMethod.GET,
                new HttpEntity<>(null),
                Boolean.class).getBody();

    }

    public boolean isInBlackListRequest(TransferPassportNumDTO transferPassportNumDTO) {



        return restTemplate.exchange(URL2,
                HttpMethod.POST,
                new HttpEntity<>(transferPassportNumDTO),
                Boolean.class).getBody();

    }

}
