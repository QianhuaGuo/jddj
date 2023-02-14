package com.example.qianhua.annotation;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class CustomerSkuSortData {

    @ExcelProperty(value = "店铺规则",index = 0)
    private String string;

    @ExcelProperty(value = "ceshi",index = 1)
    private String aaa;
}



