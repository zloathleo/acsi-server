package com.safefire.acsiserver.dao.mapinterface;

import com.safefire.acsiserver.entity.QuestionnaireItemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Leo on 2017/5/22.
 */
@Mapper
public interface QuestionnaireItemMapper {

    List<QuestionnaireItemEntity> queryQuestionnaireItemsByQuestionnaireId(Integer questionnaireId);

    int insertBatch(List<QuestionnaireItemEntity> items);

    int updateBatch(List<QuestionnaireItemEntity> items);

}
