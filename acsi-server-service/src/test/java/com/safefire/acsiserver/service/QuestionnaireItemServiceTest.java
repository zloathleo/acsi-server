package com.safefire.acsiserver.service;

import com.safefire.acsiserver.entity.QuestionnaireItemContentEntity;
import com.safefire.acsiserver.entity.QuestionnaireItemEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * QuestionnaireItemService Tester.
 *
 * @author Leo Zhong
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireItemServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private com.safefire.acsiserver.service.QuestionnaireItemService testInstance;

    @Autowired
    private QuestionnaireItemContentService contentService;


    @Test
    public void testQueryQuestionnaireItemsByQuestionnaireId() throws Exception {
        Map<Integer, QuestionnaireItemEntity> itemScore = testInstance.queryQuestionnaireItemsByQuestionnaireId(9);
        logger.info("items:" + itemScore);
    }

    @Test
    public void testInsertBatch() throws Exception {
        int questionnaireId = 8;
        Map<Integer, QuestionnaireItemEntity> itemScore = testInstance.queryQuestionnaireItemsByQuestionnaireId(questionnaireId);
        if (itemScore == null) {
            List<QuestionnaireItemContentEntity> contents = contentService.getAllList();

            List<QuestionnaireItemEntity> items = new ArrayList<QuestionnaireItemEntity>();

            for (QuestionnaireItemContentEntity c : contents) {
                QuestionnaireItemEntity item = new QuestionnaireItemEntity();
                item.setQuestionnaireId(questionnaireId);
                item.setContentId(c.getId());
                item.setScore(0);
                item.setSuggest("");
                items.add(item);
            }

            int count = testInstance.insertBatch(items);
            logger.info("count:" + count);
        } else {

        }
    }

    @Test
    public void testUpdateBatch() throws Exception {
        int questionnaireId = 11;
        List<QuestionnaireItemEntity> itemScore = testInstance.queryQuestionnaireItemsListByQuestionnaireId(questionnaireId);
        if (itemScore != null) {
            for (QuestionnaireItemEntity item : itemScore) {
                item.setScore(2);
            }
            testInstance.updateBatch(itemScore);
        }
    }


}
