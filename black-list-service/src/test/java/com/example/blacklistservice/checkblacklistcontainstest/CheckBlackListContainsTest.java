package com.example.blacklistservice.checkblacklistcontainstest;

import com.example.blacklistservice.entity.BlackListEntity;
import com.example.blacklistservice.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@Transactional
public class CheckBlackListContainsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BlackListRepository blackListRepository;

    private BlackListEntity blackListEntity = new BlackListEntity();

    private ObjectMapper objectMapper = new ObjectMapper();

}
