package com.safefire.acsiserver.webapp.controller.questionnaire;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safefire.acsiserver.entity.*;
import com.safefire.acsiserver.service.*;
import com.safefire.acsiserver.utils.QRUtils;
import com.safefire.acsiserver.webapp.vo.Questions;
import com.safefire.acsiserver.webapp.vo.QuestionsAnswer;
import com.safefire.acsiserver.webapp.vo.QuestionsCategory;
import com.safefire.acsiserver.webapp.vo.QuestionsChoice;
import com.safefire.acsiserver.webapp.vo.base.BasicRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Leo on 2017/5/18.
 */
@RequestMapping("/quest")
@RestController
public class QuestionnaireController {

    private String serverSite = "http://116.62.150.38" ;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionnaireQRcodeService qrService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    QuestionnaireItemCategoryService questionnaireItemCategoryService;

    @Autowired
    QuestionnaireItemContentService questionnaireItemContentService;

    @Autowired
    QuestionnaireItemService questionnaireItemService;

    /**
     * 1.生成二维码
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/createQuestQtImage", method = RequestMethod.GET, produces = {MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    byte[] createQuestQtImage(@Valid ReqQuestQtImageCreate params) {
        String projectCode = params.getProjectCode();
        logger.warn("生成二维码", projectCode);
        QuestionnaireQRcodeEntity qr = qrService.findOneByProjectCode(projectCode);
        String qrCode = null;
        if (qr == null) {
            qrCode = QRUtils.generateProjectQRCode(projectCode);
            //插入数据库
            qr = new QuestionnaireQRcodeEntity();
            qr.setProjectCode(projectCode);
            //todo 关联查找projectName
            qr.setProjectName(projectCode);
            qr.setQrCode(qrCode);
            String projectName = StringUtils.isEmpty(params.getProjectName()) ? projectCode : params.getProjectName();
            qr.setProjectName(projectName);
            qr.setUserId(params.getUserId());
            qrService.insertOne(qr);
        } else {
            qrCode = qr.getQrCode();
        }


        //生成二维码
        String url = serverSite + "/?qrCode=" + qrCode;
        try {
            return QRUtils.createQRCodeImage(url);
        } catch (Exception e) {
            logger.error("生成二维码错误", e);
        }
        return null;
    }

    /**
     * 2.提供给用户扫码访问获得问卷项目基础信息
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/getQuestBaseQrInfo", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResQuestBaseQrInfoGet getProjectInfo(@Valid ReqQuestBaseQrInfoGet params) {
        String qrCode = params.getQrCode();
        String projectCode = QRUtils.unGenerateProjectQRCode(qrCode);
        QuestionnaireQRcodeEntity qr = qrService.findOneByProjectCode(projectCode);
        ResQuestBaseQrInfoGet value = new ResQuestBaseQrInfoGet();
        value.setInfo(qr);
        return value;
    }

    /**
     * 开始问卷生成问卷信息
     * 用户
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/startQuest", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResQuestionnaireGet getQuest(@Valid ReqQuestStart params) {
        String projectCode = params.getProjectCode();
        QuestionnaireQRcodeEntity qr = qrService.findOneByProjectCode(projectCode);
        if (qr == null) {
            throw new NullPointerException("ProjectCode not exist:" + projectCode);
        }
        String customerMobile = params.getCustomerMobile();
        QuestionnaireEntity one = questionnaireService.findOneByProjectCodeAndCustomerMobile(projectCode, customerMobile);

        if (one == null) {
            logger.info("该项目-{}-该用户-{}-还没有进行问卷", projectCode, customerMobile);
            //该项目该用户还没有进行问卷
            one = new QuestionnaireEntity();
            one.setName("WJ-" + projectCode + "-" + customerMobile);
            one.setQrCodeId(qr.getId());
            one.setProjectCode(projectCode);
            one.setProjectName(qr.getProjectName());
            one.setCustomerMobile(customerMobile);
            one.setCustomerName(params.getCustomerName());
            one.setState("START");
            questionnaireService.insertOne(one);
        } else {
            //该项目该用户已经进行了问卷
            logger.info("该项目-{}-该用户-{}-已经进行了问卷", projectCode, customerMobile);
        }

        Questions questions = generateQs(one.getId());
        questions.setQuestionnaireId(one.getId());
        questions.setCreateTime(one.getCreateTime());
        questions.setLastUpdateTime(one.getUpdateTime());
        ResQuestionnaireGet result = new ResQuestionnaireGet();
        result.setQuestions(questions);

        return result;
    }

    //初始化问题
    private Questions generateQs(Integer questionnaireId) {

        Map<Integer, QuestionnaireItemEntity> itemScores = questionnaireItemService.initQuestionnaireItems(questionnaireId);
        if (CollectionUtils.isEmpty(itemScores)) {
            return null;
        }
        List<QuestionnaireItemCategoryEntity> categories = questionnaireItemCategoryService.getAllList();
        Map<Integer, List<QuestionnaireItemContentEntity>> contents = questionnaireItemContentService.getAll();

        Questions questions = new Questions();

        //选择题
        for (QuestionnaireItemCategoryEntity categoryEnty : categories) {
            Integer id = categoryEnty.getId();

            QuestionsCategory category = new QuestionsCategory();
            category.setId(id);
            category.setDesc(categoryEnty.getContent());

            List<QuestionnaireItemContentEntity> itemContents = contents.get(id);
            List<QuestionsChoice> qs = itemContents.stream().map(i -> {
                QuestionnaireItemEntity score = itemScores.get(i.getId());
                if (score == null) {
                    logger.warn("i.getId():" + i.getId());
                    return null;
                } else {
                    Integer scoreValue = (score == null ? Integer.valueOf(0) : score.getScore());
                    return new QuestionsChoice(score.getId(), i.getContent(), scoreValue);
                }

            }).collect(Collectors.toList());
            category.setQs(qs);

            questions.getChoice().add(category);
        }

        //问答题
        List<QuestionnaireItemContentEntity> qices = contents.get(0);
        List<QuestionsAnswer> answerQuestions = qices.stream().map(i -> {
            QuestionnaireItemEntity score = itemScores.get(i.getId());
            if (score == null) {
                logger.warn("i.getId():" + i.getId());
                return null;
            } else {
                String suggest = (score == null ? "" : score.getSuggest());
                return new QuestionsAnswer(score.getId(), i.getContent(), suggest);
            }
        }).collect(Collectors.toList());
        questions.setAnswerQuestions(answerQuestions);
        return questions;
    }

    public static final ObjectMapper readMapper = new ObjectMapper();

    static {
        readMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        readMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        readMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 提交问卷答案
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/finishQuest", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    BasicRes finishQuest(@Valid ReqQuestFinish params) {
        String scoreJson = params.getQuestScoreJson();

        try {
            Questions questions = readMapper.readValue(scoreJson, Questions.class);

            List<QuestionnaireItemEntity> items = new ArrayList<>();

            List<QuestionsCategory> categories = questions.getChoice();
            for (QuestionsCategory category : categories) {
                List<QuestionsChoice> qcs = category.getQs();
                for (QuestionsChoice choice : qcs) {
                    QuestionnaireItemEntity score = new QuestionnaireItemEntity();
                    score.setId(choice.getId());
                    score.setScore(choice.getV());
                    items.add(score);
                }
            }

            List<QuestionsAnswer> qas = questions.getAnswerQuestions();
            for (QuestionsAnswer qa : qas) {
                QuestionnaireItemEntity score = new QuestionnaireItemEntity();
                score.setId(qa.getId());
                score.setSuggest(qa.getV());
                items.add(score);
            }

            logger.info("解析问卷结果:" + questions);
            questionnaireItemService.updateBatch(items);
        } catch (IOException e) {
            logger.error("解析scoreJson 失败," + scoreJson, e);
        }

        return new BasicRes();
    }

}
