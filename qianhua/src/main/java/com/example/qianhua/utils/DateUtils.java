package com.example.qianhua.utils;

import com.example.qianhua.entity.User;
import org.apache.poi.ss.formula.functions.T;


import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class DateUtils {
    private static final String COUNTDOWM = "您有新的天猫订单售后申请待审核，%s后将会自动同意，请及时处理！";
    public static void main(String[] args) {
        System.out.println(181%60);
        Date now = new Date();//当前时间

        //48小时自动处理时间(订单售后申请时间+48h)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY,48);
        Date autoDelTime = calendar.getTime();
        System.out.println(autoDelTime);



//        Date compareDate = new Date();
//        compareDate.setHours(11);
//        compareDate.setMinutes(01);
//        System.out.println(compareDate);
        System.out.println(new Date());
        Long hoursAgoTime = getHoursAgoTime(new Date(), autoDelTime);

        System.out.println(hoursAgoTime);

        System.out.println(hoursAgoTime/60);
        System.out.println(hoursAgoTime%60);
//        hoursAgoTime = 17L;

        String countDownTime;
        if (hoursAgoTime<60){
            countDownTime = hoursAgoTime + "分钟";
        }else{
            countDownTime = hoursAgoTime/60 + "小时" + (hoursAgoTime%60 !=0?hoursAgoTime%60+"分钟":"");
        }
        System.out.println(String.format(COUNTDOWM,countDownTime));

    }

    /**
     * 获取两个时间的分钟差
     *
     * @param sourceDate
     * @param compareDate
     * @return
     */
    public static Long getHoursAgoTime(Date sourceDate, Date compareDate) {
        long sourceTime = sourceDate.getTime();
        long compareTime = compareDate.getTime();
        long diff;
        if (compareTime > sourceTime) {
            diff = compareTime - sourceTime;
        } else {
            diff = sourceTime - compareTime;
        }
        long l = diff / (60 * 1000);


//        long day = diff / (24 * 60 * 60 * 1000);
//        long min = ((diff / (60 * 1000)) - day * 24 * 60);
        return l;
    }

    public static <T> T getValue(Function<User,T> function){
        return function.apply(new User("aa",2,"men"));
    }
}
