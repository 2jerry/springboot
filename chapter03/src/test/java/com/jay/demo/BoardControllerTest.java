package com.jay.demo;


import com.jay.demo.domain.BoardVO;
import com.jay.demo.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest // controller나 restcontroller가 설정된 클래스들을 찾아 메모리에 생성한다.
@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BoardService boardService;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello").param("name", "둘리"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello : 둘리"))
                .andDo(print());
    }

    @Test
    public void testHello2() throws Exception{
        String result = restTemplate.getForObject("/hello?name=둘리",String.class);
        assertEquals("Hello : 둘리",result);
    }
    @Test
    public void testHello3() throws Exception {
        when(boardService.hello("둘리")).thenReturn("Hello : 둘리");

        mockMvc.perform(get("/hello").param("name", "둘리"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello : 둘리"))
                .andDo(print());
    }

        @Test
    public void testGetBoard() throws Exception {
        BoardVO boardVO = restTemplate.getForObject("/getBoard",BoardVO.class);
        assertEquals("테스터", boardVO.getWriter());
    }
}
