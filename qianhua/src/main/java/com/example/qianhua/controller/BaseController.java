package com.example.qianhua.controller;

import com.example.qianhua.config.ControllerInit;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BaseController {
    public BaseController(){}

    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request){
        ControllerInit.initBinder(binder,request);
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        long l = now.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(now);
        System.out.println(l);
        test();
        System.out.println("...");
    }

    private static void test() {
        for (int i = 0;i<10;i++){
            if (i == 5){
                return;
            }
        }
        System.out.println("借宿");
    }

}
