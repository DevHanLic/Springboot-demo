package com.example.spring.demo.serviceImpl;

import com.example.spring.demo.entity.Filter;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.entity.Message;
import com.example.spring.demo.dao.FilterMapper;
import com.example.spring.demo.dao.LoginMapper;
import com.example.spring.demo.dao.MessageMapper;
import com.example.spring.demo.enums.MsgCodeEnum;
import com.example.spring.demo.exception.BusinessException;
import com.example.spring.demo.service.Userservice;
import com.example.spring.demo.util.DateTimeUtils;
import com.example.spring.demo.util.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class Userservicelmpl implements Userservice {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    FilterMapper filterMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public PageInfo<Login> list(int currPage, int pageSize, String input) {
        //封装 开始页
        PageHelper.startPage(currPage, pageSize);
        List<Login> list = loginMapper.list(input);
        PageInfo<Login> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public String text() {
        String a = "[16:42:17] C端报文：<?xml 张三version=\"1.0\" encoding=\"UTF-8\"?><SSA> <Request><KeyStatus>0</KeyStatus><TermNum>80010001</TermNum><APTLID>00003476</APTLID><BranchNum>8001</BranchNum><StrSsbNum /><StrTellerNum>9901990</StrTellerNum><TermDateTime>20200217164459</TermDateTime></Request><ProcessorName>UpdateKeyLoadStatus</ProcessorName><ProcessorNameCN>更新密钥结果通知</ProcessorNameCN><Response><ServerDateTime>2020/02/17 16:42:17</ServerDateTime><TermRetCode>0000</TermRetCode><TermRetDesc>成功</TermRetDesc><TermRetDescEn>Succeed</TermRetDescEn></Response></SSA> ";
        return a;
    }

    @Override
    public List<Filter> listW() {
        return filterMapper.list();
    }

    @Override
    public Map<String, Object> listM() {
        List<Message> list = messageMapper.list();
        List<String> stringList = new ArrayList<>();
        Map<String, Object> Map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Message message = list.get(i);
            stringList.add(message.getText());
        }
        Map.put("message", stringList);
        return Map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insert(Login login) {
        login.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4));
        login.setDate(DateTimeUtils.getCurrentDateTimeStr());
        ObjectUtils.strToObject(login);
        loginMapper.insert(login);
    }

    @Override
    public Integer insertMessage(Message message) {
        message.setId((int) (Math.random() * (100 - 1) + 1));
        return messageMapper.insert(message);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer updateMessage(Message message) {
        ObjectUtils.strToObject(message);
        return messageMapper.updateMessage(message);
    }

    @Override
    public void deleteById(String id) {
        loginMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Login login) {
        login.setDate(DateTimeUtils.getCurrentDateTimeStr());
        ObjectUtils.strToObject(login);
        loginMapper.updateByPrimaryKeySelective(login);
    }

    @Override
    public String lists() {
        List<Filter> filters = filterMapper.list();
        String a = "[16:42:17] C端报文：<?xml 张三version=\"1.0\" encoding=\"UTF-8\"?><SSA> <Request><KeyStatus>0</KeyStatus><TermNum>80010001</TermNum><APTLID>00003476</APTLID><BranchNum>8001</BranchNum><StrSsbNum /><StrTellerNum>9901990</StrTellerNum><TermDateTime>20200217164459</TermDateTime></Request><ProcessorName>UpdateKeyLoadStatus</ProcessorName><ProcessorNameCN>更新密钥结果通知</ProcessorNameCN><Response><ServerDateTime>2020/02/17 16:42:17</ServerDateTime><TermRetCode>0000</TermRetCode><TermRetDesc>成功</TermRetDesc><TermRetDescEn>Succeed</TermRetDescEn></Response></SSA>";
        for (int i = 0; i < filters.size(); i++) {
            Filter filter = filters.get(i);
            if (a.contains(filter.getSensitiveWord())) {
                //用一个*替换一个字符
                StringBuilder replac = new StringBuilder();
                for (int j = 0; j < filter.getSensitiveWord().length(); j++) {
                    replac.append("*");
                }
                //替换所有匹配
                a = a.replaceAll(filter.getSensitiveWord(), replac.toString());
            }
        }
        return a;
    }


}
