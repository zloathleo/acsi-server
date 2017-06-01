package com.safefire.acsiserver.service;

import com.safefire.acsiserver.dao.mapinterface.QuestionnaireItemCategoryMapper;
import com.safefire.acsiserver.entity.QuestionnaireItemCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Leo on 2017/5/22.
 * 问答类别
 */
@Service
public class QuestionnaireItemCategoryService {

    @Autowired
    private QuestionnaireItemCategoryMapper questionnaireItemCategoryMapper;

    /**
     * Id-->Entity
     * @return
     */
    public Map<Integer, QuestionnaireItemCategoryEntity> getAll() {
        List<QuestionnaireItemCategoryEntity> all = getAllList();
        if (CollectionUtils.isEmpty(all)) {
            return null;
        } else {
            return all.stream().collect(Collectors.toMap(QuestionnaireItemCategoryEntity::getId, Function.identity()));
        }
    }

    public List<QuestionnaireItemCategoryEntity> getAllList() {
        return questionnaireItemCategoryMapper.getAll();
    }

}
