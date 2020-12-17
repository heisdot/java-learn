package com.mycode.javalearn.exception;

import com.mycode.javalearn.exception.base.BizException;
import com.mycode.javalearn.response.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 全局异常处理
 * @Author toolman
 * @Date 2020/12/15 22:32
 **/
@ResponseBody
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public ObjectRestResponse handle(BizException bizException) {
        log.error(bizException.getMessage());
        bizException.printStackTrace();
        return ObjectRestResponse.fail(bizException.getCode(), bizException.getMessage());
    }
}
