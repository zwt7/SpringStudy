package com.custom.demo.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description：自定义MVC Configeurer，不推荐使用
 * 等同于:
 * spring.resources.static-locations=classpath:static/
 * spring.mvc.static-path-pattern=/**
 */
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

    }
}
