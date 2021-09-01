package com.example.spring.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author han_lic
 * @date 2021/9/1 10:19
 */
@Data
public class FilterExport {

    @Excel(name = "授信Id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    @Excel(name = "授信文档")
    private String sensitiveWord;
}
