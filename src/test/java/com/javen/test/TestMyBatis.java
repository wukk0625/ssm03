package com.javen.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.javen.model.User;
import com.javen.service.UserService;

/**
 * ����spring��junit���ϣ�junit����ʱ����springIOC���� spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ����junit spring�����ļ�
@ContextConfiguration({ "classpath:applicationContext.xml"})
public class TestMyBatis  {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
    @Autowired
    public UserService userService;
    
    @Test
    public void getUserByIdTest(){
        User user = userService.getUserById(1);
        logger.info(JSON.toJSONString(user));
//        System.out.println(user);
    }
    
}