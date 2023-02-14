package com.example.qianhua.exception;

import com.example.qianhua.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GrobalApiException {

    //自定义业务异常
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result exceptionHandler(BizException e){
        String randomCode = UUID.randomUUID().toString();
        log.warn("自定义业务异常 randomCode:{} exception:{}", randomCode, e.getMessage(), e);
        return Result.fail(e.getCode(), e.getMessage(), randomCode);
    }

}
