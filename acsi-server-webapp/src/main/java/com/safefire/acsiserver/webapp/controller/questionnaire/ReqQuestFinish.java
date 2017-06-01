package com.safefire.acsiserver.webapp.controller.questionnaire;

import java.io.Serializable;

/**
 * Created by Leo on 2017/5/31.
 */
public class ReqQuestFinish implements Serializable {

    private static final long serialVersionUID = 1L;

    private String projectCode;

    private String customerMobile;

    private String customerName;

    private String questScoreJson;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQuestScoreJson() {
        return questScoreJson;
    }

    public void setQuestScoreJson(String questScoreJson) {
        this.questScoreJson = questScoreJson;
    }

    @Override
    public String toString() {
        return "ReqQuestFinish{" +
                "projectCode='" + projectCode + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerName='" + customerName + '\'' +
                ", questScoreJson='" + questScoreJson + '\'' +
                '}';
    }
}
