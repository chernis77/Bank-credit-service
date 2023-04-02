package com.example.creditbankfirstclient.controllertest;

import com.example.creditbankfirstclient.dto.FillFormDTO;
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

import static com.example.creditbankfirstclient.controller.ConstantProject.APPROVE_MESSAGE;
import static com.example.creditbankfirstclient.controller.ConstantProject.APPROVE_NOT_VALID_MESSAGE;
import static com.example.creditbankfirstclient.controller.ConstantProject.SEND_FORM_PATH;
import static com.example.creditbankfirstclient.test_object.PrepareTestObject.prepareaNotValidTestObj;
import static com.example.creditbankfirstclient.test_object.PrepareTestObject.prepareaValidTestObj;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkControllerMethodTest() throws Exception {

        /** готовим валидный объект для теста */
        FillFormDTO formDTOtest = prepareaValidTestObj();

        mockMvc.perform(MockMvcRequestBuilders.post(SEND_FORM_PATH)
                        .content(asJSONstring(formDTOtest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        /** ошибка со статусом 500 от RestTemplate говорит о положительной работе теста,
                         *  так как принимаемый объект прошёл валидацию
                         *  и подготовлен к отправке на проверку в следующий МКС */
                        .value(APPROVE_MESSAGE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void sendFormToCheckClient() throws Exception {

        /** готовим не валидный объект для теста */
        FillFormDTO fillFormDTO = prepareaNotValidTestObj();

        mockMvc.perform(post(SEND_FORM_PATH)
                        .content(asJSONstring(fillFormDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value(APPROVE_NOT_VALID_MESSAGE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    public static String asJSONstring(final Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
