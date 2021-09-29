package com.example.spring.demo.BO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.spring.demo.util.ExcelUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author han_lic
 * @date 2021/9/28 14:13
 */
@Data
public class MobileInfoBO {
    /**
     /**
     * illegalMobile 违规号段
     */
    @Excel(name="号段")
    private String mobile;

    /**
     * remark 备注
     */
    @Excel(name="备注")
    private String remark;

    public MobileInfoBO(Row row) {
        this.mobile = String.valueOf(ExcelUtils.getCellFormatValue(row.getCell(0))).trim();
        this.remark = String.valueOf(ExcelUtils.getCellFormatValue(row.getCell(1))).trim();
    }
}
