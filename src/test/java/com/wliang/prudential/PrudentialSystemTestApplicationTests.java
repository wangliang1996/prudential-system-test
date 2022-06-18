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
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(param);
        String result = mockMvc.perform(post("/car/book")
        .contentType(MediaType.APPLICATION_JSON)
        .content(s)).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(result);
    }

    @Test
    void cancelBookTest() throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("carMode","BMW 650");
        param.put("phone","15122223333");
        param.put("bookingNum",2);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(param);
        String result = mockMvc.perform(post("/car/cancelBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s)).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(result);
    }
}
