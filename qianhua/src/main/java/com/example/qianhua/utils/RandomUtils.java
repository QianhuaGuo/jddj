package com.example.qianhua.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {
    public static final Logger log = LoggerFactory.getLogger(RandomUtils.class);

    public static String getRandom(){
        SecureRandom secureRandom = new SecureRandom();
        return String.valueOf(secureRandom.nextInt(900000) +100000);
    }

    public static String getRandom2(){
        Random random = new Random();
        return String.valueOf(random.nextInt(900000) + 100000);
    }

    public static String getRandom3(){
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    public static String getRandom4(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000,999999));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            String random = RandomUtils.getRandom2();
            String random = getRandom4();
            System.out.println(random);
        }


    }
}
