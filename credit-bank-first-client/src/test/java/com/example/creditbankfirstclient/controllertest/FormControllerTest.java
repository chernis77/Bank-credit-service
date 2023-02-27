package com.example.creditbankfirstclient.controllertest;

import com.example.creditbankfirstclient.controller.FormController;
import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FormController formController;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void sendFormToCheckClient() throws Exception {

        FillFormDTO fillFormDTO = new FillFormDTO();
        this.mockMvc.perform(post("/fill/sendform")
                .content(objectMapper.writeValueAsString(fillFormDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Ошибка заполнения формы"));


    }


}
