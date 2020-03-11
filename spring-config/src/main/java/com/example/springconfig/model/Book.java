package com.example.springconfig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix ="book")
//配置了data，那么在properties中一样就可以了，要是不可以，要加上
//value注解
public class Book {
    private String isdn;
    private String name;
    private String author;
    private Float price;
    //描述
    private String desc;
    //粉丝列表
    private List<String> fans;
    //每月排名
    private Map<String,Integer> rank;
}
