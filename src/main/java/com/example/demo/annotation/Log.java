package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 日志注解类
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    int logType()  default 1;
}