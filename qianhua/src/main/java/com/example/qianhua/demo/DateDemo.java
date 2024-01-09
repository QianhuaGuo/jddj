package com.example.qianhua.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DAY_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static void main(String[] args) throws ParseException {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Date date = new Date();
        System.out.println("localDate:"+localDate);
        System.out.println("localTime:"+localTime);
        System.out.println("localDateTime:"+localDateTime);
        System.out.println("date:"+date);


        System.out.println("getminute"+LocalTime.now().getMinute());
        System.out.println("getHour"+LocalTime.now().getHour());


        System.out.println("==================================");




        int totalPage = 3/1000 + 3 % 1000 ==0?0:1;




        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
//        System.out.println(calendar);

//        calendar.add(Calendar.MINUTE,-5);

        String format = sdf.format(calendar.getTime());
        System.out.println(format);

        long time = sdf.parse(format).getTime();

        System.out.println(time);

        long l = System.currentTimeMillis();
        System.out.println(sdf.format(l));



//        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM");
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
//
//        System.out.println(format.format(new Date()));
//        System.out.println(format1.format(new Date()));
//
//        int a1 = 1 << Integer.SIZE -3;
//        int a0 = 0 << Integer.SIZE -3;
//        System.out.println(a1);
//        System.out.println(a0);
    }
}
