package com.example.creditbankapprovedclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="contract_table")
public class ContractEntity {
    @Id
    @SequenceGenerator(name = "contract_tableSequence", sequenceName = "contract_table_sequence", allocationSize = 1, initialValue = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_tableSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "credit_amount")
    private Double creditAmount;          //Сумма кредита в рублях

    @Column(name = "credit_term")
    private Double creditTerm;           //Срок кредита в месяцах - от 12 до 60

    @Column(name = "percent_year")
    private Double percentYear;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_client")
    private ApprovedClientEntity approvedClientEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Double getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(Double creditTerm) {
        this.creditTerm = creditTerm;
    }

    public Double getPercentYear() {
        return percentYear;
    }

    public void setPercentYear(Double percentYear) {
        this.percentYear = percentYear;
    }

    public ApprovedClientEntity getApprovedClientEntity() {
        return approvedClientEntity;
    }

    public void setApprovedClientEntity(ApprovedClientEntity approvedClientEntity) {
        this.approvedClientEntity = approvedClientEntity;
    }
}