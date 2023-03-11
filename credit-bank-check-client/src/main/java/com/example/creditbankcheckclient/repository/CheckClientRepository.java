package com.example.creditbankcheckclient.repository;

import com.example.creditbankcheckclient.entity.CheckClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckClientRepository extends JpaRepository<CheckClientEntity, Long> {

    CheckClientEntity getCheckClientEntityByPassportNum(String passportNum);

}
