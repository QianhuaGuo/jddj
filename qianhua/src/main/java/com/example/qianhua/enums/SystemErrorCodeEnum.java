package com.example.qianhua.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SystemErrorCodeEnum implements ErrorCode{
    SUCCESS("0","成功"),
    SYSTEM_ERROR("-1","系统错误"),
    PARAM_ERROR("1000","参数错误"),
    UNKNOW_ERROR("1009","未知异常")
    ;

    private String code;

    private String msg;

    SystemErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public static SystemErrorCodeEnum getByCode(String code){
        Optional<SystemErrorCodeEnum> optional = Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst();
        return optional.orElse(UNKNOW_ERROR);
    }
}
