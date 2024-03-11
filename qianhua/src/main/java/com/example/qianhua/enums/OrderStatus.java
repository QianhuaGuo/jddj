package com.example.qianhua.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public enum OrderStatus {

    NEW(1,"新建"),
    OK(2,"完成");

    private Integer code;

    private String desp;
}
