package com.mycode.javalearn.aop;

import com.mycode.javalearn.annotion.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Description TODO
 * @Author toolman
 * @Date 2020/12/15 23:08
 **/
@Aspect
@Slf4j
@Component
public class WebLogAspect {

    @Pointcut("execution(public * com.mycode.javalearn.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String ip = this.getIpAddr(request);
        log.info(httpMethod + " " + url + "   --->start....");

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        WebLog ann = targetMethod.getAnnotation(WebLog.class);
    }

    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
    }

    @After("webLog()")
    public void After(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        String ip = this.getIpAddr(request);
        log.info(httpMethod + " " + url + "   --->end....");
    }



    private String getIpAddr(HttpServletRequest request) {
        //先从nginx自定义配置获取
        String ip = request.getHeader("X-real-ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
