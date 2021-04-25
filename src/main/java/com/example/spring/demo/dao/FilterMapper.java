package com.example.spring.demo.dao;

import com.example.spring.demo.entity.Filter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FilterMapper {
    public List<Filter> list();

}
