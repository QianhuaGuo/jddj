package com.example.qianhua.exception;

import com.example.qianhua.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

public class BizException extends RuntimeException{
    private static final long serialVersionUID = -1L;

    //错误码
    @Getter
    @Setter
    private String code;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String code,String message){
        super(message);
        this.code = code;
    }

    public BizException(ErrorCode errorCode){
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }
}
