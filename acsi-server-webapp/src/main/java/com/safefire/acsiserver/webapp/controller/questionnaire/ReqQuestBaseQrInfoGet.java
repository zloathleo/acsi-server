package com.safefire.acsiserver.webapp.controller.questionnaire;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Leo on 2017/5/19.
 */
public class ReqQuestBaseQrInfoGet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 20, message = "参数长度超限")
    @NotNull(message = "参数不能为空")
    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
