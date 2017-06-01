package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Leo on 2017/5/19.
 */
@Mapper
public interface QuestionnaireMapper {

    QuestionnaireEntity findOneByProjectCodeAndCustomerMobile(@Param("projectCode") String projectCode, @Param("customerMobile") String customerMobile);

    int insertOne(QuestionnaireEntity one);


}
