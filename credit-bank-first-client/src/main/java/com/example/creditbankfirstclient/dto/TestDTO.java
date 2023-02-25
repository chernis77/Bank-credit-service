package com.example.creditbankfirstclient.dto;

import lombok.ToString;

@ToString
public class TestDTO {

    private String firstMessage;

    private String checkMessage;

    public String getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(String firstMessage) {

        this.firstMessage = firstMessage;
    }

    public String getCheckMessage() {

        return checkMessage;
    }

    public void setCheckMessage(String checkMessage) {

        this.checkMessage = checkMessage;
    }
}
