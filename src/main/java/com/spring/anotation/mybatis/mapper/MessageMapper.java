package com.spring.anotation.mybatis.mapper;


import com.spring.anotation.mybatis.model.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    @Select("SELECT * FROM message")
    List<Message> selectAll();
    @Select("SELECT * FROM message WHERE msg_id=#{msgId}")
    Message selectById(Integer msgId);
    @Insert("INSERT INTO message(msg_text,msg_summary) VALUES(#{msgText},#{msgSummary})")
    int insert(Message message);
    @Delete("delete from message WHERE msg_id=#{msgId}")
    int delete(Integer msgId);
    @Update({"<script>",
            "update message set ",
            " <if test='msgText !=null'> msg_text=#{msgText},</if> ",
            " <if test='msgSummary !=null'> msg_summary=#{msgSummary} </if> ",
            "WHERE msg_id =#{msgId}",
            "</script>"})
    int update(Message message);
    @Update({"<script>",
            "update message ",
            "<set>",
            "<if test='msgText !=null'> msg_text=#{msgText}, </if> ",
            "<if test='msgSummary !=null'> msg_summary=#{msgSummary} </if> ",
            "</set>",
            "WHERE msg_id =#{msgId} ",
            "</script>"})
    int updateText(Message message);
    @Insert({"<script>",
            "INSERT INTO message (msg_text,msg_summary) VALUES ",
            "<foreach collection='list' item='msg' index='index' separator=',' >",
            "(#{msg.msgText},#{msg.msgSummary}) ",
            "</foreach> ",
            "</script>"})
    int batchInsert(List<Message> messages);
}
