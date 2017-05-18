package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.QuestionnaireQRcodeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Leo on 2017/5/17.
 */
@Mapper
public interface QuestionnaireQRcodeMapper {

    QuestionnaireQRcodeEntity findOneByProjectCode(String projectCode);

    int insertOne(QuestionnaireQRcodeEntity one);

}
