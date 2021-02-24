package com.example.spring.demo.service;

import com.example.spring.demo.entity.Filter;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.entity.Message;

import java.util.List;
import java.util.Map;

public interface Userservice {

    public List<Login> list();

    public String lists();

    public List<Filter> listW();

    public String text();

    public Map<String, Object> listM();

    void insert(Login login);
}
