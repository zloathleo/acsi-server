package com.safefire.acsiserver.service;

import com.safefire.acsiserver.dao.mapinterface.QuestionnaireQRcodeMapper;
import com.safefire.acsiserver.entity.QuestionnaireQRcodeEntity;
import com.safefire.acsiserver.utils.QRUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Leo on 2017/5/18.
 */
@Service
public class QuestionnaireQRcodeService {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionnaireQRcodeMapper questionnaireQRcodeMapper;

    public QuestionnaireQRcodeEntity findOneByProjectCode(String projectCode){
        return questionnaireQRcodeMapper.findOneByProjectCode(projectCode);
    }

    public int insertOne(QuestionnaireQRcodeEntity one){
        String qrCode = QRUtils.generateProjectQRCode(one.getProjectCode());
        one.setQrCode(qrCode);
        return questionnaireQRcodeMapper.insertOne(one);
    }


}
