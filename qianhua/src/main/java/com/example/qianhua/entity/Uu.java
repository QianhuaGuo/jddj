package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.*;

public class Uu implements Serializable {

    public static void main(String[] args) {
        int getint = gets(7);
        System.out.println(getint);
        Map<Integer,String> m = new HashMap<>();
        m.put(1,"a");
        m.put(2,"b");
        m.put(3,"c");
        m.put(4,"d");
        m.put(5,"e");
        Collection<String> values = m.values();
        System.out.println(JSONObject.toJSONString(values));

        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.add("a5");
        list.add("a6");
        list.add("a7");

        List<String> l2 = Arrays.asList("a1","a2","a3");

        //两个集合取交集
        List<String> intersection = new ArrayList<>(CollectionUtils.intersection(list, l2));
        //两个集合取并集
        List<String> union = new ArrayList<>(CollectionUtils.union(list,l2));


        List<String> list1 = list.subList(0, 3);
        List<String> list2 = list.subList(3,list.size());

        System.out.print(list1);
        System.out.print(list2);
        System.out.println(intersection);
        System.out.println(union);

        List<Integer> inlist = new ArrayList<>();
        inlist.add(1);
        inlist.add(2);
        inlist.add(3);
        inlist.add(4);
        inlist.add(5);
        int i = getint(inlist);
        System.out.println(i);
    }

    public static int getint(List<Integer> list){
        for(;;){
            if (list.contains(5)){
                return 10;
            }
        }
    }

    public static int gets(int n){
        if (n == 7){
            n++;
        }
        return n;
    }
}
