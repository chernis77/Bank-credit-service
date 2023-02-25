package com.example.blacklistservice.repository;

import com.example.blacklistservice.entity.BlackListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends JpaRepository<BlackListEntity, Long> {

    BlackListEntity getBlackListEntityByPassportNum(String passportNum);

}
