package com.example.creditbankapprovedclient.dto;

import com.example.creditbankapprovedclient.service.PaymentsSchedule;

import java.util.List;

public class ContractShowDTO {

    private String contractNumber;

    private String contractDate;

    private String firstName;

    private String surName;

    private String lastName;

    private String passportNum;

    private Double creditAmount;          //Сумма кредита в рублях

    private Double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    private Double percentYear;

    private List<PaymentsSchedule> paymentsScheduleList;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
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

    public List<PaymentsSchedule> getPaymentsScheduleList() {
        return paymentsScheduleList;
    }

    public void setPaymentsScheduleList(List<PaymentsSchedule> paymentsScheduleList) {
        this.paymentsScheduleList = paymentsScheduleList;
    }
}
