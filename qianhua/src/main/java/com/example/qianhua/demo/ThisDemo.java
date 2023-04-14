package com.example.qianhua.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ThisDemo {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void main() {
        ThisDemo.setName(this,"aa");
    }

    public static void setName(ThisDemo demo,String name){
        demo.setName(name);
    }

    public static void main(String[] args) {
        ThisDemo d = new ThisDemo();
        d.main();
        System.out.println(JSONObject.toJSONString(d));

        List<String> l = Arrays.asList("a","b","c","d");
        for (int i = 0;i<l.size();i++){
            System.out.println(l.get(i));
            if (l.get(i).equals("c")) break;
        }
        System.out.println("end...");

    }
}
