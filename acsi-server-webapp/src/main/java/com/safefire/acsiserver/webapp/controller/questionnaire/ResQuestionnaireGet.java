package com.safefire.acsiserver.webapp.controller.questionnaire;

import com.safefire.acsiserver.webapp.vo.Questions;
import com.safefire.acsiserver.webapp.vo.base.BasicRes;

import java.util.List;

/**
 * Created by Leo on 2017/5/22.
 */
public class ResQuestionnaireGet extends BasicRes {

    private Questions questions;

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}
