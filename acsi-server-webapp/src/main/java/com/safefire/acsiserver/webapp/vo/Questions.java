package com.safefire.acsiserver.webapp.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2017/5/16.
 */
public class Questions {

    private List<QuestionsChoice> choice = new ArrayList<>();
    private List<QuestionsAnswer> answerQuestions = new ArrayList<>();

    public List<QuestionsChoice> getChoice() {
        return choice;
    }

    public void setChoice(List<QuestionsChoice> choice) {
        this.choice = choice;
    }

    public List<QuestionsAnswer> getAnswerQuestions() {
        return answerQuestions;
    }

    public void setAnswerQuestions(List<QuestionsAnswer> answerQuestions) {
        this.answerQuestions = answerQuestions;
    }
}
