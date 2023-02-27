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
    @SequenceGenerator(name = "checkbid_tableSequence", sequenceName = "checkbid_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkbid_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bid_number")
    private String bidNumber;

    @Column(name = "is_employed")
    private boolean isEmployed;     // Трудоустроен или нет

    @Column(name = "time_of_employment")
    private int timeOfEmployment;    // Сколько работает на данной работе в месяцах

    @Column(name = "salary")
    private double salary;

    @Column(name = "loan_payments")
    private double loanPayments;       // Ежемесячные платежи по другим кредитам

    @Column(name = "credit_Amount")
    private double creditAmount;          //Сумма кредита в рублях

    @Column(name = "credit_term")
    private double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    @Column(name = "percent_year")
    private double percentYear;

    @Column(name = "bank_confirm")
    private Boolean bankConfirm;    // Согласие банка

    @Column(name = "client_сonfirm")
    private Boolean clientConfirm;  // Согласие клиента

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private CheckClientEntity checkClientEntity;


}
