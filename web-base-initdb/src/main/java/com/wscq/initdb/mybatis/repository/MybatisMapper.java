package com.wscq.initdb.mybatis.repository;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by monst on 2016/11/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisMapper {
    String value() default "";
}