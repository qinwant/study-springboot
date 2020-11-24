package com.kingwan.boot.service;

import com.kingwan.boot.BootApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by kingwan on 2020/11/24.
 * 说明：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApplication.class})
public class UserServiceTest {
    private Logger logger =  LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Before
    public void before(){
        logger.info("单元测试开始====>>>");
    }

    @Test
    public void test(){
        logger.info("用户:{}",userService.queryUserById(1));
    }

    @After
    public void after(){
        logger.info("====>>单元测试结束");
    }
}
