package com.example.qianhua.utils;

import org.apache.poi.ss.formula.functions.T;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalUtils {

    /**
     * BigDecimal保留小数数字四舍五入取整
     *
     * @param value 需要保留小数的数字
     * @param scale 保留小数位数
     * @param mode  四舍五入方式（如BigDecimal.ROUND_HALF_UP、BigDecimal.ROUND_HALF_DOWN）
     * @return BigDecimal
     */
    public static BigDecimal round(BigDecimal value, int scale, int mode){
        return value.setScale(scale,mode);
    }

    public static <T> String test(T number){
        // 创建NumberFormat对象
        NumberFormat numberFormat = NumberFormat.getInstance();

        // 启用千分符
        numberFormat.setGroupingUsed(true);

        return numberFormat.format(number);
    }

    public static void main(String[] args) {
        long number = 1234567890L;
        int n = 123123123;

        BigDecimal b = new BigDecimal("12322.12");

        System.out.println(test(number));
        System.out.println(test(n));
        System.out.println(test(b));
        System.out.println("=====================");


        // 创建NumberFormat对象
        NumberFormat numberFormat = NumberFormat.getInstance();

        // 启用千分符
        numberFormat.setGroupingUsed(true);

        System.out.println(numberFormat.format(number));
        System.out.println(numberFormat.format(b));
        System.out.println(numberFormat.format(n));


        BigDecimal b1 = new BigDecimal("12.25");
        //向上取整
        System.out.println(BigDecimalUtils.round(b1,1, BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimalUtils.round(b1,0,BigDecimal.ROUND_HALF_UP));

        System.out.println("=====================================================");
        //向下取整
        System.out.println(BigDecimalUtils.round(b1,1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(BigDecimalUtils.round(b1,0,BigDecimal.ROUND_HALF_DOWN));
    }


}
