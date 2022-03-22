package com.example.qianhua.proxy;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportDdcAdapterBeanDefinitionRegistrar.class)
public @interface EnableAutoDdcAdapterProxy {
}
