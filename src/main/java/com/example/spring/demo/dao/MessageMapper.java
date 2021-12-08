package com.example.spring.demo.dao;


import com.example.spring.demo.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HLC
 */
@Mapper
@Repository
public interface MessageMapper {

    public List<Message> list();

    Integer insert(Message message);

    Integer updateMessage(Message message);
}
