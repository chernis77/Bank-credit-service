package com.example.creditbankapprovedclient.repository;

import com.example.creditbankapprovedclient.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    ContractEntity getContractEntityByContractNumber(String contractNumber);

}
