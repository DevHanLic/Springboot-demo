package com.example.spring.demo.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author devzl[zliangchn@126.com]
 * @version V1.0
 * @apiNote ExcelUtils
 * @date 2020/07/29 11:11 周三
 */
@Slf4j
public class ExcelUtils {

    private static DecimalFormat decimalFmt = new DecimalFormat("0");

    /**
     * 下载Excel模板文件
     *
     * @param filePath 文件路径
     * @param templateFileName 模板文件名
     * @param response 请求响应
     */
    public static void downloadExcelFile(String filePath, String templateFileName, HttpServletResponse response) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath + templateFileName)) {
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.setHeader("Access-Control-Expose-Headers", "filename");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(templateFileName, "UTF-8"));

            // 循环取出流中的数据
            byte[] b = new byte[1024];
            int len;
            while ((len = fileInputStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
            response.getOutputStream().flush();

        } catch (IOException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, Boolean.TRUE));
            log.error("downloadExcelFile occurred IOException, errorInfo: {}", sw.toString());
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, Boolean.TRUE));
                log.error("downloadExcelFile close outputStream occurred exception, errorInfo: {}", sw.toString());
            }
        }
    }

    /**
     * 解析Excel文件(xls、xlsx)
     * ps. 请注意，使用该方法时，tClass必须拥有 public T(Row row){} 构造器
     *
     * @param fileParseInfo 文件解析请求信息
     * @param tClass Class
     *
     * @return List<T>
     */
    public static <T> List<T> parseExcelFile(FileParseInfo fileParseInfo, Class<T> tClass) {
        List<T> resultList = Lists.newLinkedList();
        try (FileInputStream fileInputStream = new FileInputStream(fileParseInfo.getFile());
             Workbook workbook = WorkbookFactory.create(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(fileParseInfo.getSheetIndex());
            Iterator<Row> rowIt = sheet.rowIterator();
            Row row;
            while (rowIt.hasNext()) {
                row = rowIt.next();
                if (row.getRowNum() >= fileParseInfo.getBeginIgnoreLines()) {
                    if (JudgeUtils.isBlank(String.valueOf(getCellFormatValue(row.getCell(0))))) {
                        break;
                    }
                    resultList.add(tClass.getDeclaredConstructor(Row.class).newInstance(row));
                }
            }
        } catch (Exception e) {
            log.error("parse excel file error.", e);
            return null;
        }
        return resultList;
    }

    /**
     * 单元格格式转换
     *
     * @param cell 单元格
     *
     * @return Object
     */
    public static Object getCellFormatValue(Cell cell) {
        Object cellVal;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    cellVal = cell.getRichStringCellValue().getString().trim();
                    break;
                case NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellVal = DateFormatUtils.format(date, "yyyyMMdd");
                    } else {
                        cellVal = decimalFmt.format(cell.getNumericCellValue());
                    }
                    break;
                case FORMULA:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellVal = cell.getDateCellValue();
                    } else {
                        cellVal = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                default:
                    cellVal = "";

            }
        } else {
            cellVal = "";
        }
        return cellVal;
    }
}
