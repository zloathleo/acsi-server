package com.safefire.acsiserver.webapp.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Leo on 2017/5/16.
 */
public class Questions {

    private Integer questionnaireId;
    private Date createTime;
    private Date lastUpdateTime;

    private List<QuestionsCategory> choice = new ArrayList<>();
    private List<QuestionsAnswer> answerQuestions = new ArrayList<>();

    public Questions() {
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<QuestionsCategory> getChoice() {
        return choice;
    }

    public void setChoice(List<QuestionsCategory> choice) {
        this.choice = choice;
    }

    public List<QuestionsAnswer> getAnswerQuestions() {
        return answerQuestions;
    }

    public void setAnswerQuestions(List<QuestionsAnswer> answerQuestions) {
        this.answerQuestions = answerQuestions;
    }
}
