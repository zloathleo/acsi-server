package com.safefire.acsiserver.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest { 

    private Logger logger =  LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private com.safefire.acsiserver.service.UserService testInstance;

    @Test
    public void testGetCount() throws Exception {
        logger.info("count:" + testInstance.getCount());
    } 

    @Test
    public void testFindUserById() throws Exception { 
        //TODO: Test goes here... 
    } 

    @Test
    public void testFindUserByUserName() throws Exception { 
        //TODO: Test goes here... 
    } 


} 
