package com.example.spring.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.spring.demo.config.TestQO;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.dao.FilterMapper;
import com.example.spring.demo.dao.LoginMapper;
import com.example.spring.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource(name = "myRedisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    Userservice userservice;

    @Autowired
    FilterMapper filterMapper;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @CrossOrigin
    @RequestMapping("/getName")
    public String getName(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("北京", "晴天");
        map.put("天津", "下雨天");
        map.put("河北", "晴转多云");
        map.put("西安", "阴天");
        String s = map.get(name);
        return s;
    }

    @RequestMapping("/putRedis")
    public void putRedis() {
        List<TestQO> list = new ArrayList<>();
        TestQO testQO = TestQO.builder()
                .title("1")
                .sku("111")
                .build();
        TestQO testQO1 = TestQO.builder()
                .title("7")
                .sku("112")
                .build();
        list.add(testQO);
        list.add(testQO1);
        list.stream().forEach(p -> {
                    try {
                        handclearMessage(p);
                    } catch (Exception e) {
                        p.setErrorMessage(e.getMessage());
                    } finally {
                        String key = "login_" + UUID.randomUUID();
                        redisTemplate.opsForValue().set(key, JSON.toJSONString(p));
                    }
                }
        );
    }

    private void handclearMessage(TestQO testQO) {
        Login login = loginMapper.selectByPrimaryKey(testQO.getTitle());
        Login login1 = new Login();
        login1.setId(testQO.getTitle());
        login1.setMoney(BigDecimal.valueOf((int) 300));

        System.out.println(login);
        if (login == null) {
            throw new RuntimeException(testQO.getTitle() + "不存在");
        } else {
            loginMapper.updateByPrimaryKey(login1);
        }

    }

    @GetMapping("/getRedis/{key}")
    public void getRedis(@PathVariable String key) {
        String keys = key + "_*";
        System.out.println(keys);
        Set<String> keys1 = redisTemplate.keys(keys);
        keys1.stream().forEach(k ->
                System.out.println(JSON.parseObject(String.valueOf(redisTemplate.opsForValue().get(k)), TestQO.class))
        );
    }

    @GetMapping("/demo")
    public void demo() {
        List<TestQO> list = new ArrayList<>();
        TestQO testQO = TestQO.builder()
                .title("1")
                .sku("111")
                .build();
        TestQO testQO1 = TestQO.builder()
                .title("7")
                .sku("112")
                .build();
        list.add(testQO);
        list.add(testQO1);
        Login login =new Login();
        list.stream().forEach(p -> {
            executorService.execute(
                    new Runnable() {
                        public void run() {
                            login.setEmail(p.getSku());
                            System.out.println(login.getEmail());
                        }

                    }
            );
        });

    }
//    @GetMapping("/pageInfo")
//    public  PageInfo<Login> processingData(int PageNum, int PageSize){
//        PageHelper.startPage(PageNum,PageSize);
//        List<Login> loginList = userservice.list();
//        PageInfo<Login> pageInfo = new PageInfo<>(loginList);
//        System.out.println(pageInfo.getPageSize());
//        return pageInfo;
//    }
}
