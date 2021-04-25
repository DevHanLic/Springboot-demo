package com.example.spring.demo.util;

import com.example.spring.demo.annotation.PreInsert;
import com.example.spring.demo.annotation.PreUpdate;

/**
 * @author han_lic
 * @date 2021/4/25 14:55
 */
public class BaseDO {

    private String tmSmp;

    @PreInsert
    public void preInsert() {
        setTmSmp(DateTimeUtils.getCurrentDateTimeStr());
    }

    @PreUpdate
    public void preUpdate() {
        setTmSmp(DateTimeUtils.getCurrentDateTimeStr());
    }

    public String getTmSmp() {
        return tmSmp;
    }

    public void setTmSmp(String tmSmp) {
        this.tmSmp = tmSmp;
    }

}
