package com.example.creditbankcheckclient.dto;

import jakarta.persistence.Column;
import lombok.ToString;

@ToString
public class CheckBidDTO {

    private String bidNumber;


    private boolean isEmployed;     // Трудоустроен или нет


    private int timeOfEmployment;    // Сколько работает на данной работе в месяцах


    private double salary;


    private double loanPayments;       // Ежемесячные платежи по другим кредитам


    private double creditAmount;          //Сумма кредита в рублях


    private double creditTerm;           //Срок кредита в месяцах - от 12 до 60


    private double percentYear;


    private Boolean bankConfirm;    // Согласие банка


    private Boolean clientConfirm;  // Согласие клиента

    private CheckClientDTO checkClientDTO;

    public String getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(String bidNumber) {
        this.bidNumber = bidNumber;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public int getTimeOfEmployment() {
        return timeOfEmployment;
    }

    public void setTimeOfEmployment(int timeOfEmployment) {
        this.timeOfEmployment = timeOfEmployment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLoanPayments() {
        return loanPayments;
    }

    public void setLoanPayments(double loanPayments) {
        this.loanPayments = loanPayments;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(double creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getPercentYear() {
        return percentYear;
    }

    public void setPercentYear(double percentYear) {
        this.percentYear = percentYear;
    }

    public Boolean getBankConfirm() {
        return bankConfirm;
    }

    public void setBankConfirm(Boolean bankConfirm) {
        this.bankConfirm = bankConfirm;
    }

    public Boolean getClientConfirm() {
        return clientConfirm;
    }

    public void setClientConfirm(Boolean clientConfirm) {
        this.clientConfirm = clientConfirm;
    }

    public CheckClientDTO getCheckClientDTO() {
        return checkClientDTO;
    }

    public void setCheckClientDTO(CheckClientDTO checkClientDTO) {
        this.checkClientDTO = checkClientDTO;
    }
}
