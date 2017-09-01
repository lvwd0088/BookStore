package com.lyg.bookstore.controller.basic;

import com.lyg.bookstore.BookStoreApplication;
import com.lyg.bookstore.controller.baisc.BookLabelController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 图书标签Controller测试类
 * Created by weida on 2017/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BookStoreApplication.class)
@WebMvcTest
//@WebAppConfiguration
public class BookLabelControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.standaloneSetup(new BookLabelController()).build();
    }

    @Test
    public void queryTest(){
        try {
            MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/bookLabel").accept(MediaType.APPLICATION_JSON)).andReturn();
            MockHttpServletResponse response=mvcResult.getResponse();
            int status=response.getStatus();
            String content=response.getContentAsString();
            System.out.println(status);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
