package com.safefire.acsiserver.service;

import com.safefire.acsiserver.dao.mapinterface.QuestionnaireMapper;
import com.safefire.acsiserver.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Leo on 2017/5/19.
 */
@Service
public class QuestionnaireService {

    @Autowired
    QuestionnaireMapper questionnaireMapper;


    public QuestionnaireEntity findOneByProjectCodeAndCustomerMobile(String projectCode, String customerMobile) {
        return questionnaireMapper.findOneByProjectCodeAndCustomerMobile(projectCode, customerMobile);
    }

    public int insertOne(QuestionnaireEntity one) {
        return questionnaireMapper.insertOne(one);
    }


}
