package com.example.spring.demo.util;

import lombok.Data;

import java.io.File;

/**
 * @author devzl[zliangchn@126.com]
 * @version V1.0
 * @apiNote 文件解析请求信息
 * @date 2020/08/08 18:19 周六
 */
@Data
public class FileParseInfo {
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件
     */
    private File file;
    /**
     * sheet表格下标
     */
    private int sheetIndex;
    /**
     * 从第 beginIgnoreLine 行开始，beginIgnoreLine从0开始
     */
    private int beginIgnoreLines;
    /**
     * 忽略后面 endIgnoreLines 行
     */
    private int endIgnoreLines;

    public void init() {
        if (JudgeUtils.isNull(this.file)) {
            this.file = new File(filePath);
        }
        if (this.sheetIndex < 0) {
            this.sheetIndex = 0;
        }
        if (this.beginIgnoreLines < 0) {
            this.beginIgnoreLines = 0;
        }
        if (this.endIgnoreLines < 0) {
            this.endIgnoreLines = 0;
        }
    }
}
