package com.example.creditbankfirstclient.dto;

public class ValidResponseDTO extends ErrorsDTO {

    boolean validated;

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
