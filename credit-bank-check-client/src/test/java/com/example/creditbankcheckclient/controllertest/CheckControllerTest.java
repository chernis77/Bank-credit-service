package com.example.creditbankcheckclient.controllertest;

import com.example.creditbankcheckclient.dto.RequestFormDTO;
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

import static com.example.creditbankcheckclient.test_object.PrepareTestObject.preparedValidTestObj;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CheckControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void checkControllerMethodTest() throws Exception {

        /** готовим валидный объект для теста */
        RequestFormDTO requestFormDTO = preparedValidTestObj();

        mockMvc.perform(MockMvcRequestBuilders.post("/check/clientresponse")
                        .content(asJSONstring(requestFormDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        /** ошибка со статусом 500 от RestTemplate говорит о положительной работе теста,
                         *  так как принимаемый объект прошёл валидацию
                         *  и подготовлен к отправке на проверку в следующий МКС */
                        .value("Нет доступа к BlackListService"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

//    @Test
//    public void sendFormToCheckClient() throws Exception {
//
//        /** готовим не валидный объект для теста */
//        RequestFormDTO requestFormDTO = prepareaNotValidTestObj();
//
//        mockMvc.perform(post(SEND_FORM_PATH)
//                        .content(asJSONstring(fillFormDTO))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.message")
//                        .value(APPROVE_NOT_VALID_MESSAGE))
//                .andExpect(MockMvcResultMatchers.status().is(200));
//    }

    public static String asJSONstring(final Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
