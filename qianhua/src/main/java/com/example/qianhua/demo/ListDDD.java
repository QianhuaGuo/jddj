package com.example.qianhua.demo;

import java.util.*;

public class ListDDD {
    public static void main(String[] args) {

//        LinkedHashMap lh = (LinkedHashMap) Collections.synchronizedMap(new LinkedHashMap<>());
//
//        HashSet<String> hs = new HashSet<>();
//        hs.add("a");
//
//        LinkedHashSet<String> lhs = new LinkedHashSet<>();
//        lhs.add("a");

        Set<String> s = new TreeSet<>();
        s.add("a");
        s.add("b");



        System.out.println(8>>2);
        List<Integer> l = new ArrayList<>(6);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(4,6);
        System.out.println(l);
    }
}
