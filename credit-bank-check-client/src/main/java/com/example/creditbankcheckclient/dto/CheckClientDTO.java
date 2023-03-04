package com.example.creditbankcheckclient.dto;

import jakarta.persistence.Column;
import lombok.ToString;

@ToString
public class CheckClientDTO {

    private String firstName;

    private String surName;

    private String lastName;

    private String passportNum;

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
}
