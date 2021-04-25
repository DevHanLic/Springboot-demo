package com.example.spring.demo.Filter;


import com.alibaba.fastjson.JSON;
import com.example.spring.demo.config.ResponseWrapper;
import com.example.spring.demo.dao.FilterMapper;
import com.example.spring.demo.dao.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class MyFilter1 implements Filter {
    @Autowired
    FilterMapper filterMapper;
    @Autowired
    MessageMapper messageMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter1-->init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter1-->dofilter");
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);//转换成代理类
        filterChain.doFilter(servletRequest, responseWrapper);
        byte[] content = responseWrapper.getResponseData();
        String str="";
        if (content.length > 0 ) {
            str = new String(content);
            HashMap hashMap = JSON.parseObject(str, HashMap.class);
            List<String> lists= (List<String>) hashMap.get("message");
            String message="";
            HttpServletResponse response=(HttpServletResponse)servletResponse;
            List<String> list =new ArrayList<>();
            Map<String,List<String>> map =new HashMap<>();
            List<com.example.spring.demo.entity.Filter> filters= filterMapper.list();
//            String a = "[16:42:17] C端报文：<?xml 张三version=\"1.0\" encoding=\"UTF-8\"?><SSA> <Request><KeyStatus>0</KeyStatus><TermNum>80010001</TermNum><APTLID>00003476</APTLID><BranchNum>8001</BranchNum><StrSsbNum /><StrTellerNum>9901990</StrTellerNum><TermDateTime>20200217164459</TermDateTime></Request><ProcessorName>UpdateKeyLoadStatus</ProcessorName><ProcessorNameCN>更新密钥结果通知</ProcessorNameCN><Response><ServerDateTime>2020/02/17 16:42:17</ServerDateTime><TermRetCode>0000</TermRetCode><TermRetDesc>成功</TermRetDesc><TermRetDescEn>Succeed</TermRetDescEn></Response></SSA>";
            for (int k = 0; k < lists.size(); k++) {
                message = lists.get(k);
               for (int i=0;i<filters.size();i++){
                com.example.spring.demo.entity.Filter filter=filters.get(i);
                    if (message.contains(filter.getSensitiveWord())) {
                        //用一个*替换一个字符
                        String replac = "";
                        for (int j = 0; j < filter.getSensitiveWord().length(); j++) {
                            replac += "*";
                        }
                        //替换所有匹配
                        message = message.replaceAll(filter.getSensitiveWord(), replac);
                        System.out.println(message);
                        list.add(message);
                    }
                }
            }
            map.put("message",list);
            writeResponse(response,200,map);
        }
    }
        public static void writeResponse (HttpServletResponse response,int status,  Map<String,List<String>> json){
            try {
                response.reset();//很重要
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Methods", "*");
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(status);
                response.getWriter().write(JSON.toJSONString(json));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void destroy() {
        System.out.println("MyFilter1-->destroy");
    }
}
