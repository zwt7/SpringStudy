package com.spring.mybatis.demo.mybatis_xml.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
