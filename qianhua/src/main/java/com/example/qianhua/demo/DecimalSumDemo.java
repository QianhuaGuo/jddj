package com.example.qianhua.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DecimalSumDemo {

    public static void main(String[] args) {
        List<DecimalSum> list = new ArrayList<>();
        DecimalSum s1 = new DecimalSum();
        s1.setPrice(new BigDecimal("12.12"));
        s1.setAge(12L);

        DecimalSum s2 = new DecimalSum();
        s2.setPrice(new BigDecimal("13.12"));
        s2.setAge(13L);

        DecimalSum s3 = new DecimalSum();
        s3.setPrice(new BigDecimal("14.12"));
        s3.setAge(14L);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println(list.stream().map(DecimalSum::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        System.out.println(list.stream().mapToLong(DecimalSum::getAge).sum());


        System.out.println(new BigDecimal("100"));
    }
}
