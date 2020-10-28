package com.example.spring.demo.serviceImpl;

import com.example.spring.demo.entity.Filter;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.entity.Message;
import com.example.spring.demo.mapper.FilterMapper;
import com.example.spring.demo.mapper.LoginMapper;
import com.example.spring.demo.mapper.MessageMapper;
import com.example.spring.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Userservicelmpl implements Userservice {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    FilterMapper filterMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Login> list() {
        return loginMapper.list();
    }
    @Override
    public String text() {
        String a = "[16:42:17] C端报文：<?xml 张三version=\"1.0\" encoding=\"UTF-8\"?><SSA> <Request><KeyStatus>0</KeyStatus><TermNum>80010001</TermNum><APTLID>00003476</APTLID><BranchNum>8001</BranchNum><StrSsbNum /><StrTellerNum>9901990</StrTellerNum><TermDateTime>20200217164459</TermDateTime></Request><ProcessorName>UpdateKeyLoadStatus</ProcessorName><ProcessorNameCN>更新密钥结果通知</ProcessorNameCN><Response><ServerDateTime>2020/02/17 16:42:17</ServerDateTime><TermRetCode>0000</TermRetCode><TermRetDesc>成功</TermRetDesc><TermRetDescEn>Succeed</TermRetDescEn></Response></SSA> ";
        return  a;
    }
    @Override
    public List<Filter> listW() {
        return filterMapper.list();
    }
    @Override
    public Map<String, Object> listM() {
        List<Message> list= messageMapper.list();
        List<String> stringList =new ArrayList<>();
        Map<String, Object> Map=new HashMap<>();
        for (int i=0;i<list.size();i++){
            Message message=list.get(i);
            stringList.add(message.getText());
        }
        Map.put("message",stringList);
        return Map;
    }
    @Override
    public String lists() {
       List<Filter> filters= filterMapper.list();
       String a = "[16:42:17] C端报文：<?xml 张三version=\"1.0\" encoding=\"UTF-8\"?><SSA> <Request><KeyStatus>0</KeyStatus><TermNum>80010001</TermNum><APTLID>00003476</APTLID><BranchNum>8001</BranchNum><StrSsbNum /><StrTellerNum>9901990</StrTellerNum><TermDateTime>20200217164459</TermDateTime></Request><ProcessorName>UpdateKeyLoadStatus</ProcessorName><ProcessorNameCN>更新密钥结果通知</ProcessorNameCN><Response><ServerDateTime>2020/02/17 16:42:17</ServerDateTime><TermRetCode>0000</TermRetCode><TermRetDesc>成功</TermRetDesc><TermRetDescEn>Succeed</TermRetDescEn></Response></SSA>";
        for (int i=0;i<filters.size();i++){
            Filter filter=filters.get(i);
          if (a.contains(filter.getSensitiveWord())) {
              //用一个*替换一个字符
              String replac="";
              for(int j=0;j<filter.getSensitiveWord().length();j++){
                  replac+="*";
              }
              //替换所有匹配
              a = a.replaceAll(filter.getSensitiveWord(), replac);
          }

        }
        return a;
    }


}
