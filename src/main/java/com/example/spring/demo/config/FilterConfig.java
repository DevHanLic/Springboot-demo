package com.example.spring.demo.config;

import com.example.spring.demo.Filter.MyFilter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter1());
        filterRegistrationBean.setName("myFilter1");
        filterRegistrationBean.addUrlPatterns("/test/list");
        //doFilter 在第1个
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
    @Bean
    public Filter filter1() {
        return new MyFilter1();
    }
}
