package com.example.spring.demo.entity;

/**
 * @author HLC
 */
public class Filter{

    private Integer id;

    private String sensitiveWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensitiveWord() {
        return sensitiveWord;
    }

    public void setSensitiveWord(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }
}
