package com.example.creditbankapprovedclient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

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

    @Column(name = "date_contract")
    private String dateContract;

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

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract() {

        this.dateContract = LocalDate.now().toString();

    }

    public ApprovedClientEntity getApprovedClientEntity() {
        return approvedClientEntity;
    }

    public void setApprovedClientEntity(ApprovedClientEntity approvedClientEntity) {
        this.approvedClientEntity = approvedClientEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractEntity that = (ContractEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(contractNumber, that.contractNumber) && Objects.equals(creditAmount, that.creditAmount) && Objects.equals(creditTerm, that.creditTerm) && Objects.equals(percentYear, that.percentYear) && Objects.equals(dateContract, that.dateContract) && Objects.equals(approvedClientEntity, that.approvedClientEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contractNumber, creditAmount, creditTerm, percentYear, dateContract, approvedClientEntity);
    }
}
