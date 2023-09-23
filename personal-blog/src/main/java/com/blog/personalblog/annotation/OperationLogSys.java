package com.blog.personalblog.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogSys {

    /**
     * 日志描述
     */
    String desc() default "";

    /**
     * 日志操作类型
     */
    OperationType operationType() default OperationType.SYSTEM;

}
