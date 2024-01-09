package com.example.qianhua.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
    private Boolean isStudent;

    public User(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

//    public User(String name, Integer age, String sex, Boolean isStudent) {
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//        this.isStudent = isStudent;
//    }


    public static void main(String[] args) {

        String PULL_CATEGORY_PROPERTY_KEY = "%s_PULL_CATEGORY_PROPERTY_%s";

        System.out.println(String.format(PULL_CATEGORY_PROPERTY_KEY,"TMALL","001SSXXX"));


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
