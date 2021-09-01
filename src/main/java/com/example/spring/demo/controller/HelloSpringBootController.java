package com.example.spring.demo.controller;

import com.example.spring.demo.entity.Filter;
import com.example.spring.demo.entity.FilterExport;
import com.example.spring.demo.entity.Login;
import com.example.spring.demo.service.Userservice;
import com.example.spring.demo.util.CopyUtils;
import com.example.spring.demo.util.ExcelUtils;
import com.example.spring.demo.util.ExportExcelUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author han_lic
 * @date 2020/11/4 16:08
 */
@RestController
@Slf4j
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

    @GetMapping("/collect/rewardExport")
    public void rewardExport(HttpServletResponse response) {
        List<Filter> filters = userservice.listW();
        List<FilterExport> filterExportList = CopyUtils.convertListProperties(filters, FilterExport.class);
        String filename = "营业员奖励金列表导出";
        try {
            ExportExcelUtils.exportExcel(filterExportList, FilterExport.class, filename, response);
        } catch (Exception e) {
            log.error("导出异常: {}", e);
            e.printStackTrace();
        }
    }
    /**
     * 模板文件目录
     */
    public static final String TEMPLATE_FILE_PATH = "D:\\template\\";
    /**
     *模板文件名
     */
    public static final String TEMPLATE_FILE_NAME = "mobile.xlsx";
    @GetMapping ("/export-template")
   public void exportTemplate(HttpServletResponse response) {
        try{
            ExcelUtils.downloadExcelFile(TEMPLATE_FILE_PATH, TEMPLATE_FILE_NAME, response);
        }catch (Exception e){
            log.error("根据条件查询所有列表：%s", e.getMessage(), e);
        }
    }
}
