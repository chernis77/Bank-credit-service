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

    private String bidNumber;

    private boolean  isEmployed;     // Трудоустроен или нет

    private int timeOfEmployment;    // Сколько работает на данной работе в месяцах

    private double salary;

    private  double loanPayments;       // Ежемесячные платежи по другим кредитам

    private double creditAmount;          //Сумма кредита в рублях

    private double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    private double percentYear;

    private Boolean bankConfirm;    // Согласие банка

    private Boolean clientConfirm;  // Согласие клиента


}
