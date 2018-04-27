package com.safefire.acsiserver.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Created by Leo on 2017/5/23.
 */
@Configuration
public class CORSConfiguration {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        WebMvcConfigurerAdapter _conf = new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.warn("-------------------------------------------------------");
                logger.warn("跨域配置");
                logger.warn("-------------------------------------------------------");
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOrigins("*");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                logger.warn("-------------------------------------------------------");
                logger.warn("浏览器缓存配置完成");
                logger.warn("-------------------------------------------------------");
                registry.addResourceHandler("/js/**")
                        .addResourceLocations("classpath:/static/js/")
                        .setCacheControl(CacheControl.maxAge(180, TimeUnit.DAYS).cachePublic());
            }

        };
        return _conf;
    }


}