package com.spring.anotation.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.anotation.mybatis.mapper")
public class AnotationMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnotationMybatisApplication.class, args);
    }

}
