package com.safefire.acsiserver.service; 

import com.safefire.acsiserver.entity.QuestionnaireEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* QuestionnaireService Tester. 
* 
* @author Leo Zhong
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireServiceTest { 

    private Logger logger =  LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private com.safefire.acsiserver.service.QuestionnaireService testInstance;

    @Test
    public void testFindOneByProjectCode() throws Exception {
        QuestionnaireEntity entity =  testInstance.findOneByProjectCodeAndCustomerMobile("abcd","13912345678");
        logger.info("entity:" + entity);
    } 

    @Test
    public void testInsertOne() throws Exception {
        QuestionnaireEntity one = new QuestionnaireEntity();
        one.setName("wj002");
        one.setQrCodeId(1);
        one.setProjectCode("pro_code_001");
        one.setProjectName("测试项目名称");
        one.setCustomerMobile("13912345678");
        one.setCustomerName("李四");
        one.setState("START");
        testInstance.insertOne(one);
    } 


} 
