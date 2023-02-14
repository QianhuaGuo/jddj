package com.example.qianhua.demo;

import com.example.qianhua.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListDemo implements Serializable {

    private static final long serialVersionUID = -794197191018223347L;

    public static void main(String[] args) {

        try{
            ListDemo.printss();
            System.out.println("sssssss");
        }catch (Exception e){
            log.info("exception....");
            e.printStackTrace();
        }

    }

    private static void printss() {
        List<String> s = new ArrayList<>();
        s.add("sss");
        s.add("sss");
        s.add("sss");
        try{
            s.get(6);
        }catch (Exception e){
            log.info("indexOutOf....");
//            throw new BizException(e.getMessage());
        }
    }
}
