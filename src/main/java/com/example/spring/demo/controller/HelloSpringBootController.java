package com.example.spring.demo.controller;

import com.example.spring.demo.entity.Login;
import com.example.spring.demo.service.Userservice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author han_lic
 * @date 2020/11/4 16:08
 */
@RestController
@RequestMapping("/test")
public class HelloSpringBootController {
    @Autowired
    Userservice userservice;

    @CrossOrigin
    @RequestMapping("/hello")
    public PageInfo<Login> hello(@RequestParam(name = "currPage", defaultValue = "1") Integer currPage,
                                 @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                 @RequestParam(name = "input") String input) {
        PageInfo<Login> list = userservice.list(currPage, pageSize, input);
        return list;
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public Map<String, String> json() {
        Map<String, String> map = new HashMap<>();
        map.put("statues", "str");
        return map;
    }

    @CrossOrigin
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public void selectUser(@RequestBody Map<String, String> map) {
        System.out.println(map.get("id"));
        userservice.deleteById(map.get("id"));
    }

    @RequestMapping("/list")
    public Map<String, Object> list() {
        return userservice.listM();
    }

    @CrossOrigin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody Login login) {
        userservice.insert(login);
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody Login login) {
        userservice.update(login);
    }


}
