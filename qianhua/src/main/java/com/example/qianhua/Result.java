package com.example.qianhua;

import com.example.qianhua.enums.ErrorCode;
import com.example.qianhua.enums.SystemErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * 统一返回结果
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    //返回码
    private String code;

    //返回消息
    private String msg;

    //随机码
    private String randomCode;

    //返回结果
    private T data;

    public static <T> Result success(){
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(SystemErrorCodeEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(SystemErrorCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result success(T data,String msg){
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static <T> Result fail(String msg){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(SystemErrorCodeEnum.SYSTEM_ERROR.getCode());
        return result;
    }

    public static <T> Result fail(String code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result fail(ErrorCode errorCode){
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        return result;
    }

    public static Result fail(String code, String message, String randomCode) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        result.setRandomCode(randomCode);
        return result;
    }

    /**
     * 是否调用成功
     * @return
     */
    public boolean isSuccess(){
        return SystemErrorCodeEnum.SUCCESS.getCode().equals(this.code);
    }

}
