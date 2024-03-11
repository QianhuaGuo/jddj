package com.example.qianhua.multiDatasource;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class MultiDataSourceAspect {
//    @Before("@annotation(multiDataSource)")
//    public void switchDataSource(JoinPoint point, MultiDataSource multiDataSource) {
//        MultiDataSourceContextHolder.setDataSourceContextkeyholder(multiDataSource.value());
//    }
//
//    @After("@annotation(multiDataSource)")
//    public void restoreDataSource(JoinPoint point, MultiDataSource multiDataSource) {
//        MultiDataSourceContextHolder.clearDataSourceContextKey();
//    }

    @Around("@annotation(MultiDataSource) || @within(MultiDataSource)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MultiDataSource multiDataSource = method.getAnnotation(MultiDataSource.class);
        if (null == multiDataSource){
            multiDataSource = joinPoint.getClass().getAnnotation(MultiDataSource.class);
        }
        log.debug("determine datasource :{}.{}.multiDataSource = {}", signature.getDeclaringType().getName(), signature.getMethod().getName(), multiDataSource.value());

        if (StringUtils.isBlank(multiDataSource.value())){
            //没有值，则默认数据源 main
            MultiDataSourceContextHolder.setDataSourceContextkeyholder(MultiDataSourceConfig.MAIN_DATA_SOURCE);
        }else{
            MultiDataSourceContextHolder.setDataSourceContextkeyholder(multiDataSource.value());
        }
        Object var8;
        try {
            Object rtn = joinPoint.proceed(joinPoint.getArgs());
            var8 = rtn;
        } catch (Throwable var12) {
            throw var12;
        } finally {
            MultiDataSourceContextHolder.clearDataSourceContextKey();
        }
        return var8;

    }

}
