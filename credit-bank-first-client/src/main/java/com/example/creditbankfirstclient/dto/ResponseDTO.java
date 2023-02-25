package com.example.creditbankfirstclient.dto;

public class ResponseDTO extends ErrorsDTO{


     /**Номер заявки*/
    private Double bidNumber;

    public Double getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(Double bidNumber) {
        this.bidNumber = bidNumber;
    }
}
