package com.example.creditbankapprovedclient.service;

import lombok.ToString;

@ToString
public class PaymentsSchedule {

    private int month;

    private double monthPayment;

    private double percentNow;

    private double loanBalance;

    private double totalOverpayment;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    public double getPercentNow() {
        return percentNow;
    }

    public void setPercentNow(double percentNow) {
        this.percentNow = percentNow;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public double getTotalOverpayment() {
        return totalOverpayment;
    }

    public void setTotalOverpayment(double totalOverpayment) {
        this.totalOverpayment = totalOverpayment;
    }
}
