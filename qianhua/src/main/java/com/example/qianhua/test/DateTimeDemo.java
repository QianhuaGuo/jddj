package com.example.qianhua.test;

import java.util.*;

public class DateTimeDemo {
    public static void main(String[] args) {
        String p = "aa";
        HashSet hs = new HashSet(Arrays.asList(p));
        System.out.println(hs);

        Set<String> s = new HashSet<>();
        s.add("a");
        s.add("b");
        s.add("a");

        List<String> l = new ArrayList<>();
        l.addAll(s);
        System.out.println(l);

//        String value = "ss";
//
//        Integer.valueOf(value);
    }
}
