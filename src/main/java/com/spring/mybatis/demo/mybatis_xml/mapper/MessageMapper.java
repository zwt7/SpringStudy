package com.spring.mybatis.demo.mybatis_xml.mapper;

import com.spring.mybatis.demo.mybatis_xml.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<Message> selectAll();
    Message selectById(Integer id);
    int insert(Message message);
    int delete(Integer id);
    int update(Message message);
    int updateText(Message message);
    int batchInsert(List<Message> messages);
//
}
