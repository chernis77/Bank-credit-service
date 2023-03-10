package com.example.creditbankcheckclient.dto;


import lombok.ToString;

@ToString
public class RequestFormDTO {

    private String firstName;

    private String surName;

    private String lastName;

    //    private Date birthDate;

    private String passportNum;

    private boolean  isEmployed;     // Трудоустроен или нет

    private int timeOfEmployment;    // Сколько работает на данной работе в месяцах

    private double salary;

    private  double loanPayments;       // Ежемесячные платежи по другим кредитам

    private double creditAmount;          //Сумма кредита в рублях

    private double creditTerm;           //Срок кредита в месяцах - от 12 до 60

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

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
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

    @Override
    public String toString() {
        return "RequestFormDTO{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", isEmployed=" + isEmployed +
                ", timeOfEmployment=" + timeOfEmployment +
                ", Salary=" + salary +
                ", loanPayments=" + loanPayments +
                ", creditAmount=" + creditAmount +
                ", creditTerm=" + creditTerm +
                '}';
    }
}
