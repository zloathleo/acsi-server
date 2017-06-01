package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.QuestionnaireItemContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Leo on 2017/5/19.
 */
@Mapper
public interface QuestionnaireItemContentMapper {

    List<QuestionnaireItemContentEntity> getAll();

}
