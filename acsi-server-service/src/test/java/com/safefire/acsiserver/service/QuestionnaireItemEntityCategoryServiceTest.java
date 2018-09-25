package com.safefire.acsiserver.service;

import com.safefire.acsiserver.entity.QuestionnaireItemCategoryEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * QuestionnaireItemCategoryService Tester.
 *
 * @author Leo Zhong
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireItemEntityCategoryServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private com.safefire.acsiserver.service.QuestionnaireItemCategoryService testInstance;

    @Test
    public void testGetAll() throws Exception {
        Map<Integer, QuestionnaireItemCategoryEntity> result = testInstance.getAll();
        logger.info("result:" + result);
    }


} 
