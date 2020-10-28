package com.example.spring.demo.mapper;


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


}
