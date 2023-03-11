package com.example.creditbankapprovedclient.repository;

import com.example.creditbankapprovedclient.entity.ApprovedClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovedClientRepository extends JpaRepository<ApprovedClientEntity, Long> {

    ApprovedClientEntity getApprovedClientEntitiesByPassportNum(String passportNum);

}
