package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.QuestionnaireItemCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Leo on 2017/5/22.
 */
@Mapper
public interface QuestionnaireItemCategoryMapper {

    List<QuestionnaireItemCategoryEntity> getAll();

}
