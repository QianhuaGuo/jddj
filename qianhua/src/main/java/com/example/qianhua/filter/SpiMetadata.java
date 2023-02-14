package com.example.qianhua.filter;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpiMetadata {

    String name();

    /**
     * 优先级
     *
     * @return
     */
    int priority() default 0;
}
