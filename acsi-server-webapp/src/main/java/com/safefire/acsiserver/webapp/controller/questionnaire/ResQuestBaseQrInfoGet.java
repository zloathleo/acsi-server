package com.safefire.acsiserver.webapp.controller.questionnaire;

import com.safefire.acsiserver.entity.QuestionnaireQRcodeEntity;
import com.safefire.acsiserver.webapp.vo.base.BasicRes;

/**
 * Created by Leo on 2017/5/19.
 */
public class ResQuestBaseQrInfoGet extends BasicRes {

    private QuestionnaireQRcodeEntity info;

    public QuestionnaireQRcodeEntity getInfo() {
        return info;
    }

    public void setInfo(QuestionnaireQRcodeEntity info) {
        this.info = info;
    }
}
