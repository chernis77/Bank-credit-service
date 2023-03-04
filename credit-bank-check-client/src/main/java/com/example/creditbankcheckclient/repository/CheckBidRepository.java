package com.example.creditbankcheckclient.repository;

import com.example.creditbankcheckclient.entity.CheckBidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckBidRepository extends JpaRepository<CheckBidEntity, Long >{


    CheckBidEntity save(CheckBidEntity checkBidEntity);

    CheckBidEntity getTopByOrderByIdDesc();

    CheckBidEntity getCheckBidEntityByBidNumber(String bidNumber);



}
