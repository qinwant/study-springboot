package com.kingwan.boot.controller;

import com.kingwan.boot.BootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by kingwan on 2020/11/24.
 * 说明：控制层接口方法调试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApplication.class})
@AutoConfigureMockMvc
public class UserControllerTest {
    private Logger logger =  LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    //用户列表查询
    @Test
    public void apiTest() throws Exception {
        //构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/queryAllInfo")
                .contentType("text/html")// 指定请求的contentType头信息
                .accept(MediaType.APPLICATION_JSON_UTF8);// 指定请求的Accept头信息
        //发送请求，获取请求结果
        ResultActions perform = mockMvc.perform(request);
        //请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());
        //表示执行完成后返回相应的结果
        MvcResult result = perform.andReturn();
        //获取响应
        MockHttpServletResponse response = result.getResponse();

        logger.info("响应状态:{}",response.getStatus());
        logger.info("响应消息:{}",response.getContentAsString());


    }
}
