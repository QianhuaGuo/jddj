package com.example.qianhua.entity;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class IteaorDemo {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(2);
        ls.add(6);
        System.out.println(JSONObject.toJSONString(ls));
        IteaorDemo iteaorDemo = new IteaorDemo();
        Integer anInt = iteaorDemo.getInt(0,ls);
        System.out.println(anInt);

        System.out.println(JSONObject.toJSONString(ls));


        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            String next = listIterator.next();
            if ("a".equals(next)){
                listIterator.remove();
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }

    public Integer getInt(Integer num,List<Integer> arr){
        for (int i = 0;i<arr.size();i++){
            if (arr.get(i)==2){
                num++;
                arr.remove(i);
                num = this.getInt(num,arr);
            }
        }
        return num;
    }
}
