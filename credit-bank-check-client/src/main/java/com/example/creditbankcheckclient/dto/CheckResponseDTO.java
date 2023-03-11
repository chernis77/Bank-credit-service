package com.example.creditbankcheckclient.dto;

import lombok.ToString;

@ToString
public class CheckResponseDTO {

private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
