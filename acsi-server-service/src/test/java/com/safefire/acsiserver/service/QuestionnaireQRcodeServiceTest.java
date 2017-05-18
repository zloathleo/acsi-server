package com.safefire.acsiserver.service; 

import com.safefire.acsiserver.entity.QuestionnaireQRcodeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* QuestionnaireQRcodeService Tester. 
* 
* @author Leo Zhong
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireQRcodeServiceTest { 

    private Logger logger =  LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private com.safefire.acsiserver.service.QuestionnaireQRcodeService testInstance;

    @Test
    public void testFindOneByProjectCode() throws Exception {
        QuestionnaireQRcodeEntity entity = testInstance.findOneByProjectCode("pro_code_001");
        logger.info("logger:" + entity);
    } 

    @Test
    public void testInsertOne() throws Exception { 
        
    } 


} 
