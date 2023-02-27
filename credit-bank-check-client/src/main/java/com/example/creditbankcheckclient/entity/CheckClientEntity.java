package com.example.creditbankcheckclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "checkclient_table")
public class CheckClientEntity {

    @Id
    @SequenceGenerator(name = "checkclient_tableSequence", sequenceName = "checkclient_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkclient_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "sure_name")
    private String surName;

    @Column(name = "last_name")
    private String lastName;

    //    private Date birthDate;

    @Column(name = "passport_num")
    private String passportNum;

    @OneToOne(mappedBy = "checkClientEntity")
    private CheckBidEntity checkBidEntity;


}
