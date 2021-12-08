package com.example.spring.demo.test.service;

import com.example.spring.demo.entity.Login;

import java.util.List;

/**
 * @author han_lic
 * @date 2021/12/8 14:18
 * @Description 测试 事务
 */
public interface TestTransactionalService {

    /**
     *@Description 测试 事务
     *@param loginList
     *@return
     *@Date 2021/12/8 14:23
     */
    void testTransactional(List<Login> loginList);
}
