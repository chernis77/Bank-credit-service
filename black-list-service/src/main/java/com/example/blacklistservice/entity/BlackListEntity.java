package com.example.blacklistservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="blacklist_table" )
public class BlackListEntity {

    @Id
    @SequenceGenerator(name = "blacklist_tableSequence", sequenceName = "blacklist_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blacklist_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sure_name")
    private String sureName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "passport_num")
    private String passportNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }
}
