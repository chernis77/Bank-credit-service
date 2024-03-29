package com.example.creditbankcheckclient.dto;

import jakarta.persistence.Column;
import lombok.ToString;

@ToString
public class TransferBidToApproveDTO {

    private String bidNumber;

    private String firstName;

    private String surName;

    private String lastName;

    private String passportNum;

    private Double creditAmount;          //Сумма кредита в рублях

    private Double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    private Double percentYear;

    public String getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Double getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Double creditTerm) {
        this.creditTerm = creditTerm;
    }

    public Double getPercentYear() {
        return percentYear;
    }

    public void setPercentYear(Double percentYear) {
        this.percentYear = percentYear;
    }
}
