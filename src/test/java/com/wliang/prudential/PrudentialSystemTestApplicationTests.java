package com.wliang.prudential;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrudentialSystemTestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void bookTest() throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("carMode","BMW 650");
        param.put("phone","15122223333");
        param.put("bookingNum",2);
        param.put("bookStartTime","2022-06-17 00:00:00");
        param.put("bookEndTime","2022-06-17 23:59:59");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(param);
        String result = mockMvc.perform(post("/car/book")
        .contentType(MediaType.APPLICATION_JSON)
        .content(s)).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(result);
    }
}
