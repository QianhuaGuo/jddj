package com.example.qianhua.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;


public class DozerUtils implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(DozerUtils.class);

    private static ApplicationContext applicationContext;

    private static DozerBeanMapper dozerBeanMapper = null;

    static {
        try{
            dozerBeanMapper = applicationContext.getBean(DozerBeanMapper.class);
        }catch (Exception e){
            logger.warn(" SpringContextHolder.getBean(DozerBeanMapper.class) get fail , try new .", e);
        }
        if (dozerBeanMapper == null){
            dozerBeanMapper = new DozerBeanMapper();
        }
    }

    private DozerUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void map(Object source,Object destination){dozerBeanMapper.map(source,destination);}

    public static <T> T map(Object source,Class<T> destinationClass){
        return dozerBeanMapper.map(source,destinationClass);
    }

    public static <T,U> List<U> mapList(final List<T> source,final Class<U> destType){
        final List<U> destList = new ArrayList<>();
        if (CollectionUtils.isEmpty(source)){
            return destList;
        }
        for (T element : source){
            destList.add(dozerBeanMapper.map(element,destType));
        }
        return destList;
    }

}
