package com.example.qianhua.exception;

import com.baozun.i18n.util.I18nUtils;
import com.example.qianhua.Result;
import com.example.qianhua.enums.SystemErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;
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

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class, BindException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result exception(Exception e) {
        String randomCode = UUID.randomUUID().toString();
        log.debug("业务验证器异常 randomCode:{} exception:{}", new Object[]{randomCode, e.getMessage(), e});
        BindingResult result = null;
        if (e instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException)e).getBindingResult();
        } else if (e instanceof BindException) {
            result = ((BindException)e).getBindingResult();
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException)e).getConstraintViolations();
            StringBuilder errorMsg = new StringBuilder();
            Iterator var10 = constraintViolations.iterator();

            while(var10.hasNext()) {
                ConstraintViolation<?> violation = (ConstraintViolation)var10.next();
                errorMsg.append(I18nUtils.getOrDefault(violation.getMessage(), violation.getMessage())).append(",");
            }

            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            return Result.fail(SystemErrorCodeEnum.PARAM_ERROR.getCode(), errorMsg.toString(), randomCode);
        }

        if (result == null) {
            return Result.fail(SystemErrorCodeEnum.PARAM_ERROR.getCode(), randomCode);
        } else {
            StringBuilder errorMsg = new StringBuilder();
            Iterator var5 = result.getAllErrors().iterator();

            while(var5.hasNext()) {
                ObjectError error = (ObjectError)var5.next();
                errorMsg.append(I18nUtils.getOrDefault(error.getDefaultMessage(), error.getDefaultMessage())).append(",");
            }

            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            return Result.fail(SystemErrorCodeEnum.PARAM_ERROR.getCode(), errorMsg.toString(), randomCode);
        }
    }

}
