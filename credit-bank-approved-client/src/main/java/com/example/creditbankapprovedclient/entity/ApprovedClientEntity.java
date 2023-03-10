package com.example.creditbankapprovedclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "approvedclient_table")
public class ApprovedClientEntity {

    @Id
    @SequenceGenerator(name = "approvedclient_tableSequence", sequenceName = "approvedclient_table_sequence", allocationSize = 1, initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "approvedclient_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "passportnum")
    private String passportNum;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "approvedClientEntity")
    private List<ContractEntity> contractEntityList;

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

    public List<ContractEntity> getContractEntityList() {
        return contractEntityList;
    }

    public void setContractEntityList(List<ContractEntity> contractEntityList) {
        this.contractEntityList = contractEntityList;
    }
}
