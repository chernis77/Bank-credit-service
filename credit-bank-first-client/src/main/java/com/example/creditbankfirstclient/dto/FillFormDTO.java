package com.example.creditbankfirstclient.dto;

public class FillFormDTO {

    private String firstName;

    private String surName;

    private String lastName;

    //    private Date birthDate;
//
    private String passportNum;

    private String  isEmployed;     // Трудоустроен или нет

    private String timeOfEmployment;    // Сколько работает на данной работе в месяцах

    private String salary;

    private  String loanPayments;       // Ежемесячные платежи по другим кредитам

    private String creditAmount;          //Сумма кредита в рублях

    private String creditTerm;           //Срок кредита в месяцах - от 12 до 60

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

    public String getIsEmployed() {
        return isEmployed;
    }

    public void setIsEmployed(String isEmployed) {
        this.isEmployed = isEmployed;
    }

    public String getTimeOfEmployment() {
        return timeOfEmployment;
    }

    public void setTimeOfEmployment(String timeOfEmployment) {
        this.timeOfEmployment = timeOfEmployment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLoanPayments() {
        return loanPayments;
    }

    public void setLoanPayments(String loanPayments) {
        this.loanPayments = loanPayments;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(String creditTerm) {
        this.creditTerm = creditTerm;
    }
}
