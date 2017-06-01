package com.safefire.acsiserver.service;

import com.safefire.acsiserver.dao.mapinterface.QuestionnaireItemContentMapper;
import com.safefire.acsiserver.entity.QuestionnaireItemContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Leo on 2017/5/19.
 * 问答内容项
 */
@Service
public class QuestionnaireItemContentService {

    @Autowired
    private QuestionnaireItemContentMapper questionnaireItemContentMapper;

    /**
     * CategoryId -->Entity
     * @return
     */
    public Map<Integer, List<QuestionnaireItemContentEntity>> getAll() {
        List<QuestionnaireItemContentEntity> all = questionnaireItemContentMapper.getAll();
        if (CollectionUtils.isEmpty(all)) {
            return null;
        } else {
            return all.stream().collect(Collectors.groupingBy(QuestionnaireItemContentEntity::getCategoryId));
        }
    }

    public List<QuestionnaireItemContentEntity> getAllList() {
        return questionnaireItemContentMapper.getAll();
    }

}
