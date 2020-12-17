package com.mycode.javalearn.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description 业务异常
 * @Author toolman
 * @Date 2020/12/15 22:24
 **/

@AllArgsConstructor
@Getter
@Setter
public class BizException extends RuntimeException {

    private int code;

    private String message;
}
