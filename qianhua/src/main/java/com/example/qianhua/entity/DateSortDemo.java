package com.example.qianhua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class DateSortDemo {
    public static void main(String[] args) {
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
