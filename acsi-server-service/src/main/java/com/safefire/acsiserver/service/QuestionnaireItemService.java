package com.safefire.acsiserver.service;

import com.safefire.acsiserver.dao.mapinterface.QuestionnaireItemMapper;
import com.safefire.acsiserver.entity.QuestionnaireItemContentEntity;
import com.safefire.acsiserver.entity.QuestionnaireItemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Leo on 2017/5/22.
 */
@Service
public class QuestionnaireItemService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionnaireItemMapper questionnaireItemMapper;


    @Autowired
    private QuestionnaireItemContentService contentService;

    public Map<Integer, QuestionnaireItemEntity> queryQuestionnaireItemsByQuestionnaireId(Integer questionnaireId) {
        List<QuestionnaireItemEntity> all = questionnaireItemMapper.queryQuestionnaireItemsByQuestionnaireId(questionnaireId);
        return toMap(all);
    }

    public List<QuestionnaireItemEntity> queryQuestionnaireItemsListByQuestionnaireId(Integer questionnaireId) {
        return questionnaireItemMapper.queryQuestionnaireItemsByQuestionnaireId(questionnaireId);

    }

    private static final Map<Integer, QuestionnaireItemEntity> toMap(List<QuestionnaireItemEntity> all) {
        if (CollectionUtils.isEmpty(all)) {
            return null;
        } else {
            return all.stream().collect(Collectors.toMap(QuestionnaireItemEntity::getContentId, Function.identity()));
        }

    }

    /**
     * 初始化问答题目
     *
     * @param questionnaireId
     * @return
     */
    public Map<Integer, QuestionnaireItemEntity> initQuestionnaireItems(Integer questionnaireId) {
        Map<Integer, QuestionnaireItemEntity> itemScore = this.queryQuestionnaireItemsByQuestionnaireId(questionnaireId);
        if (itemScore == null) {
            //没有初始化题目
            List<QuestionnaireItemContentEntity> contents = contentService.getAllList();

            List<QuestionnaireItemEntity> items = new ArrayList<QuestionnaireItemEntity>();

            for (QuestionnaireItemContentEntity c : contents) {
                QuestionnaireItemEntity item = new QuestionnaireItemEntity();
                item.setQuestionnaireId(questionnaireId);
                item.setContentId(c.getId());
                item.setScore(0);
                item.setSuggest("");
                items.add(item);
            }

            int count = this.insertBatch(items);
            logger.info("初始化问答题目ID:{},count:{}", questionnaireId, count);
            return toMap(items);
        } else {
            return itemScore;
        }

    }

    public int insertBatch(List<QuestionnaireItemEntity> items) {
        return questionnaireItemMapper.insertBatch(items);
    }

    public int updateBatch(List<QuestionnaireItemEntity> items) {
        return questionnaireItemMapper.updateBatch(items);
    }

}
