package com.mycode.javalearn.annotion;

import java.lang.annotation.*;

/**
 * 接口日志注解
 *
 * @author toolman
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLog {
    String value() default "";
}
