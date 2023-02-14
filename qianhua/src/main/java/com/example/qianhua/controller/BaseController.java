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
}
