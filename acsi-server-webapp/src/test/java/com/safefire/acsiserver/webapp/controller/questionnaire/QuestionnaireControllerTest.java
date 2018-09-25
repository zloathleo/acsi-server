package com.safefire.acsiserver.webapp.controller.questionnaire;

import com.safefire.acsiserver.entity.QuestionnaireItemEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * QuestionnaireController Tester.
 *
 * @author Leo Zhong
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionnaireControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private com.safefire.acsiserver.webapp.controller.questionnaire.QuestionnaireController testInstance;

    @Test
    public void testCreateQuestQtImage() throws Exception {

    }

    @Test
    public void testGetProjectInfo() throws Exception {

    }

    @Test
    public void testGetQuest() throws Exception {

        QuestionnaireItemEntity score = new QuestionnaireItemEntity();

        Integer ss = score.getScore();
        Integer scoreValue = (score == null ? Integer.valueOf(0) : ss);


        System.out.println(scoreValue);
    }


    @Test
    public void testGenerateQs() throws Exception {
//        testInstance.generateQs(9);

    }

} 
