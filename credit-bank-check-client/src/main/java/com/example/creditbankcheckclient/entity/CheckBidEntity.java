package com.example.creditbankcheckclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "checkbid_table")
public class CheckBidEntity {
    @Id
    @SequenceGenerator(name = "checkbid_tableSequence", sequenceName = "checkbid_table_sequence", allocationSize = 1, initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkbid_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bid_number")
    private String bidNumber;

    @Column(name = "is_employed")
    private Boolean isEmployed;     // Трудоустроен или нет

    @Column(name = "time_of_employment")
    private Integer timeOfEmployment;    // Сколько работает на данной работе в месяцах

    @Column(name = "salary")
    private Double salary;

    @Column(name = "loan_payments")
    private Double loanPayments;       // Ежемесячные платежи по другим кредитам

    @Column(name = "credit_Amount")
    private Double creditAmount;          //Сумма кредита в рублях

    @Column(name = "credit_term")
    private Double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    @Column(name = "percent_year")
    private Double percentYear;

    @Column(name = "bank_confirm")
    private Boolean bankConfirm;    // Согласие банка

    @Column(name = "client_сonfirm")
    private Boolean clientConfirm;  // Согласие клиента

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_client")
    private CheckClientEntity checkClientEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CheckClientEntity getCheckClientEntity() {
        return checkClientEntity;
    }

    public void setCheckClientEntity(CheckClientEntity checkClientEntity) {
        this.checkClientEntity = checkClientEntity;
    }
}
