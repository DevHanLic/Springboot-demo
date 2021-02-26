package com.example.spring.demo.service;

import com.example.spring.demo.entity.Filter;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.entity.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Userservice {

    public PageInfo<Login> list(int currPage, int pageSize);

    public String lists();

    public List<Filter> listW();

    public String text();

    public Map<String, Object> listM();

    void insert(Login login);
}
