package com.safefire.acsiserver.webapp.controller.questionnaire;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Leo on 2017/5/19.
 */
public class ReqQuestStart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 32, message = "参数长度超限")
    private String projectCode;

    @Size(min = 4, max = 32, message = "参数长度超限")
    private String customerMobile;

    private String customerName;

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
}
