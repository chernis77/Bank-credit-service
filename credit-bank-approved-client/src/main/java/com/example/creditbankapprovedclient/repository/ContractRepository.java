package com.example.creditbankapprovedclient.repository;

import com.example.creditbankapprovedclient.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    ContractEntity getContractEntityByContractNumber(String contractNumber);

    @Transactional
    void deleteContractEntitiesByContractNumber(String contractNumber);
}
