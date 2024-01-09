package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class DateSortDemo {
    public static void main(String[] args) {


        Long price = 2355L;
        Integer a = 123;
        Long aa = 123L;


        String format0 = String.format("%.0f",price.doubleValue()/a.doubleValue());
        String format1 = String.format("%.1f",price.doubleValue()/a.doubleValue());
        String format2 = String.format("%.2f",price.doubleValue()/a.doubleValue());
        String format3 = String.format("%.2f",price.doubleValue()/aa.doubleValue());
        System.out.println("format0:"+format0);
        System.out.println("format1:"+format1);
        System.out.println("format2:"+format2);
        System.out.println("format3:"+format3);

        System.out.println((new BigDecimal(String.format("%.0f", ((a.doubleValue() / price.doubleValue()) * 100)))));

        List<String> label1 = new ArrayList<>();
        label1.add("标签11");
        label1.add("标签21");
        label1.add("标签31");

        List<String> lable2 = new ArrayList<>();
        lable2.add("标签");
        lable2.add("标签2");
        lable2.add("标签3");
        lable2.add("标签4");
        lable2.add("标签5");

        if (label1.stream().allMatch(l -> lable2.contains(l))){
            System.out.println("全部满足");
        }else{
            System.out.println("部分满足");
        }

        if (label1.stream().anyMatch(l -> lable2.contains(l))){
            System.out.println("任意满足");
        }

        if (label1.stream().noneMatch(l -> lable2.contains(l))){
            System.out.println("都不满足");
        }

        List<String> prices = new ArrayList<>();
        prices.add("99");
        prices.add("99");
        prices.add("199");
        prices.add("99");
        prices.add("99");
        System.out.println(prices);
        Collections.sort(prices);
//        Collections.sort(prices, (o1, o2) -> {
//            BigDecimal oo1 = new BigDecimal(o1);
//            BigDecimal oo2 = new BigDecimal(o2);
//            return oo1.compareTo(oo2);
//        });
        System.out.println(JSONObject.toJSONString(prices));
        String rangPrice = prices.get(0)+"~"+prices.get(prices.size()-1);
        System.out.println(rangPrice);
        System.out.println("=======================================");







        String str01 = "2021-06-26T12:11:52.000+0000";
        String str02 = "2021-06-25T12:08:41.000+0000";
        String str03 = "2021-06-27T12:18:22.000+0000";


        Student student01 = new Student(1, "张三", dealDateFormat(str01));
        Student student02 = new Student(2, "李四", dealDateFormat(str02));
        Student student03 = new Student(3, "王五", dealDateFormat(str03));


        List<Student> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, student01, student02, student03);

        System.out.println(arrayList);
        System.out.println("=====================");
        //升序
        Collections.sort(arrayList,Comparator.comparing(Student::getDate));
        System.out.println(arrayList);
        System.out.println("=====================");
        //降序
        Collections.sort(arrayList, new CalendarComparator());
        System.out.println(arrayList);
    }

    // 时间倒序排序
    private static class CalendarComparator implements Comparator {
        @Override
        public int compare(Object object1, Object object2) {// 实现接口中的方法
            Student p1 = (Student) object1; // 强制转换
            Student p2 = (Student) object2;
            return p2.getDate().compareTo(p1.getDate());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student{
        private int id;
        private String name;
        private Date date;
    }

    /**
     * 处理时间格式 2021-06-26T12:11:52.000+0000 为 yyyy-MM-dd HH:mm:ss
     */
    static Date dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat(ExchangeConstants.FORMAT_T);
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat(ExchangeConstants.FORMAT_Z, Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat(ExchangeConstants.FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date1;
    }
}
