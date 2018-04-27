package com.safefire.acsiserver.webapp.controller.questionnaire;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Leo on 2017/5/19.
 */
public class ReqQuestQtImageCreate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 32, message = "参数长度超限")
    @NotNull(message = "参数不能为空")
    private String projectCode;

    private String projectName;

    private String userId;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
