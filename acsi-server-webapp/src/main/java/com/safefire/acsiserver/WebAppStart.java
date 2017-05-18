package com.safefire.acsiserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppStart {

    public static void main(String[] args) {
        SpringApplication.run(WebAppStart.class, args);
    }
}