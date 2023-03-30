package com.example.creditbankcheckclient.checkformtest;

import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.entity.CheckClientEntity;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import com.example.creditbankcheckclient.repository.CheckClientRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

@SpringBootTest
@Testcontainers
@Transactional
@AutoConfigureMockMvc
public class CheckFormTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CheckBidRepository checkBidRepository;

    @Autowired
    private CheckClientRepository checkClientRepository;

    CheckClientEntity checkClientEntity = new CheckClientEntity();

    CheckBidEntity checkBidEntity = new CheckBidEntity();

    @AfterEach
    public void resetDB() {

        checkBidRepository.deleteAllInBatch();
        checkClientRepository.deleteAllInBatch();

    }

    @BeforeEach
    public void createDB(){

        resetDB();

        createClientEntity(checkClientEntity);
//        createBidEntity(checkBidEntity, checkClientEntity);
        checkClientRepository.save(checkClientEntity);
//        checkBidRepository.save(checkBidEntity);

    }

    public void createClientEntity(CheckClientEntity checkClientEntity ){

        checkClientEntity.setId(1L);
        checkClientEntity.setFirstName("Василий");
        checkClientEntity.setSurName("Петрович");
        checkClientEntity.setLastName("Сидоров");
        checkClientEntity.setPassportNum("2405 917564");

    }

    public void createBidEntity(CheckBidEntity checkBidEntity, CheckClientEntity checkClientEntity ){

        checkBidEntity.setId(1L);
        checkBidEntity.setBidNumber("Д23-0000001");
        checkBidEntity.setEmployed(true);
        checkBidEntity.setTimeOfEmployment(12);
        checkBidEntity.setSalary(80000);
        checkBidEntity.setLoanPayments(25000);
        checkBidEntity.setCreditAmount(250000);
        checkBidEntity.setCreditTerm(48);
        checkBidEntity.setPercentYear(13);
        checkBidEntity.setBankConfirm(true);
        checkBidEntity.setClientConfirm(false);
        checkBidEntity.setCheckClientEntity(checkClientEntity);

    }

    @Test
    public void firstTest(){

//        String bidNumber = checkBidEntity.getBidNumber();

        String passportNum = checkClientEntity.getPassportNum();
       checkClientRepository.save(checkClientEntity);
        Optional<CheckClientEntity> byId = checkClientRepository.findById(1L);
//        Optional<CheckBidEntity> byId = checkBidRepository.findById(1L);
//        Assertions.assertNotNull(byId.get());
//        Assertions.assertEquals(byId.get().getBidNumber(), "Д23-0000001");
//        Assert.assertTrue(byId.get().getBidNumber().equals("Д23-0000001"));

    }

}
