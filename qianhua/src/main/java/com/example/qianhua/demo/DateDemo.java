package com.example.qianhua.demo;

import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DAY_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static void main(String[] args) throws ParseException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        compare();
        stopWatch.stop();
        System.out.println("处理时间分析："+stopWatch.getLastTaskTimeMillis());
        String str = " a";
        if (StringUtils.hasText(str)){
            System.out.println("hasText");
        }
//        if (StringUtils.isEmpty(str)){
//            System.out.println("isempty");
//        }
//        if (org.apache.commons.lang3.StringUtils.isNotBlank(str)){
//            System.out.println("isnotblank");
//        }

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start("testTask");
        System.out.println("test git stash");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Date date = new Date();
        System.out.println("localDate:"+localDate);
        System.out.println("localTime:"+localTime);
        System.out.println("localDateTime:"+localDateTime);
        System.out.println("date:"+date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);

        long time1 = simpleDateFormat.parse("2024-01-19 11:13:15").getTime();
        System.out.println("time1:"+time1);
        System.out.println("毫秒："+System.currentTimeMillis());


        System.out.println("getminute"+LocalTime.now().getMinute());
        System.out.println("getHour"+LocalTime.now().getHour());

        stopWatch2.stop();
        System.out.println("testTask:"+ stopWatch2.getLastTaskTimeMillis());

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
        File file = new File("d://");

        getNextHandleTime(2);
    }

    public static Date getNextHandleTime(Integer count) {
        double pow = Math.pow(2, count);//计算2的count次方
        return Date.from(OffsetDateTime.now().plusMinutes((long) pow).toInstant());//当前时间加上pow分钟，转换成Date
    }

    public static void compare(){

        Date date = new Date();

        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        String orderTime = "2022-05-17 15:39:33";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        LocalDateTime orderLocalTime = LocalDateTime.parse(orderTime, dateTimeFormatter);

        //比较当前时间和订单创建时间 计算时间差
//        Duration duration = Duration.between(orderLocalTime, now);
        Duration duration = Duration.between(now,orderLocalTime);

        long l = duration.toHours();
        System.out.println("相隔时间间隔-"+l+"小时");

    }
}
