package com.example.qianhua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.misc.Contended;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String sex;

    public static void main(String[] args) {
        Field[] declaredFields = User.class.getDeclaredFields();
        Constructor<?>[] declaredConstructors = User.class.getDeclaredConstructors();
        User.class.getClasses();

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("task...");
//            }
//        },2,5000L);

        ScheduledExecutorService  se = new ScheduledThreadPoolExecutor(8);
        se.schedule(() -> {
            System.out.println("sche");
        },2, TimeUnit.MILLISECONDS);
    }
}
