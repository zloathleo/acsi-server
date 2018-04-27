package com.safefire.acsiserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class WebAppStart {

    private static Logger logger = LoggerFactory.getLogger(WebAppStart.class.getClass());

    public static void main(String[] args) {
        try{
            SpringApplication.run(WebAppStart.class, args);
            logger.info("boot acsi server success ...");
        }catch(Exception ex){
            logger.error("acsi server exception",ex);
        }

    }

}
