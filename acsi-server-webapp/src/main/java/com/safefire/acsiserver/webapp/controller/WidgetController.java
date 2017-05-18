package com.safefire.acsiserver.webapp.controller;

import com.safefire.acsiserver.service.UserService;
import com.safefire.acsiserver.webapp.vo.Questions;
import com.safefire.acsiserver.webapp.vo.QuestionsChoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangguoxin on 16/5/31.
 */
@RequestMapping("/SpringBoot")
@RestController
public class WidgetController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Questions helloSpringBoot(){
        Questions qs = new Questions();
        for (int i=0;i<25;i++){
            QuestionsChoice choice = new QuestionsChoice();
            choice.setId(i);
            choice.setQ("问题-" + i);
            qs.getChoice().add(choice);
        }
        int count = userService.getCount();
        logger.info("getCount:" + count);

//        userService.getUser("Test User");

        return qs;
    }

}