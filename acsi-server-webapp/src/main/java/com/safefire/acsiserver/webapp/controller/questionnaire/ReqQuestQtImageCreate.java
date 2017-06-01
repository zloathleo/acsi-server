package com.safefire.acsiserver.webapp.controller.questionnaire;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Leo on 2017/5/19.
 */
public class ReqQuestQtImageCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 20, message = "{ReqLogin.loginName.Size}")
    @NotNull(message = "{ReqLogin.loginName.NotNull}")
    private String projectCode;

    private String userId;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
