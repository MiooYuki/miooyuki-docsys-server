package com.miooyuki.docsys.entity.toolbox;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TableEntity {

    @ColumnWidth(15)
    @ExcelProperty("*客户编号")
    private String tenantCode;

    @ColumnWidth(20)
    @ExcelProperty("*产品系统编号")
    private String productCode;

    @ColumnWidth(15)
    @ExcelProperty("优先级")
    private String yxj;

    @ColumnWidth(15)
    @ExcelProperty("服务内容")
    private String fwnr;

    @ColumnWidth(15)
    @ExcelProperty("*计划时间")
    private String time;

    @ColumnWidth(15)
    @ExcelProperty("情况说明")
    private String description;

}
