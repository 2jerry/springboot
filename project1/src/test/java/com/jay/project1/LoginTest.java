package com.jay.project1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.project1.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
     ObjectMapper objectMapper;

    @Test
    public void setUserTest(){
        User user1 = new User();
        user1.setUid("admin");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUid("member");
        user2.setPassword("456");
    }

    @Test
    public void failedLoginTest() throws Exception{
        // Status Code 400
        User user1 = new User();
        user1.setUid("");
        user1.setPassword("");
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isBadRequest())
                .andDo(print());

        // Status Code 401
        User user2 = new User();
        user2.setUid("test");
        user2.setPassword("123");
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user2)))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }

    @Test
    public void successLoginTest() throws Exception{
        // Status Code 200
        User user = new User();
        user.setUid("admin");
        user.setPassword("123");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}