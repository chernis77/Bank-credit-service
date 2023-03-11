package com.example.creditbankcheckclient.repository;

import com.example.creditbankcheckclient.entity.CheckBidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckBidRepository extends JpaRepository<CheckBidEntity, Long >{


    CheckBidEntity save(CheckBidEntity checkBidEntity);

    CheckBidEntity getTopByOrderByIdDesc();

    CheckBidEntity getCheckBidEntityByBidNumber(String bidNumber);

//        @Query(nativeQuery = true, value = "INSERT INTO checkclient_table(id, first_name, sure_name, last_name, passport_num) VALUES(1, 'Иван', 'Иванович', 'Иванов', '9875 354292')" )
//        void saveToBase(Long idClient);

}
