package com.example.qianhua.exception;

import com.example.qianhua.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GrobalApiException {

    @ExceptionHandler(BizException.class)
    public Result exceptionHandler(HttpServletRequest request,Exception e){
        log.info("出错了{}",e.getMessage(),e);
        return Result.fail(e.getMessage());
    }
}
