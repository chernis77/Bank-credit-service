package com.example.creditbankapprovedclient.approvedcontrollertest;


import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;
import com.example.creditbankapprovedclient.repository.ContractRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static com.example.creditbankapprovedclient.constantlist.ApprovedClientConstants.*;
import static com.example.creditbankapprovedclient.test_object.PrepareTestObjectApprovedClient.prepareValidTestObj;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ApprovedControllerTestFirst {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContractRepository contractRepository;

    @Test
    public void approvedControllerMethodTest() throws Exception {

        String dateContract = LocalDate.now().toString();

        /** готовим валидный объект для теста */
        TransferBidToApproveDTO requestFormDTO = prepareValidTestObj();
        contractRepository.deleteContractEntitiesByContractNumber("Т20-00000001");

        mockMvc.perform(MockMvcRequestBuilders.post("/approved/contract")
                        .content(asJSONstring(requestFormDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
               .andExpect(MockMvcResultMatchers.content().string(REQUEST_RESULT_FIRST + dateContract + REQUEST_RESULT_SECOND));

    }

    @Test
    public void getContractInfoMethodTest() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("/testapproved/contractinfo/{contractNumber}", "Д22-0000001"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().json(RESPONSE_RESULT_JSON));

    }

    public static String asJSONstring(final Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

//                .andExpect(jsonPath("$.message")