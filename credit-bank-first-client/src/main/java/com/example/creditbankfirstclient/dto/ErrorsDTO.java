package com.example.creditbankfirstclient.dto;

import org.springframework.http.HttpStatusCode;

public class ErrorsDTO {

    //private HttpStatusCode statusCode;
    private String message;

//    public HttpStatusCode getStatusCode() {
//        return statusCode;
//    }

//    public void setStatusCode(HttpStatusCode statusCode) {
//        this.statusCode = statusCode;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
