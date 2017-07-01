package com.demo.base;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description: spring AOP
 * author: Smile
 * date: 2017/4/23
 */
@Aspect
@Component
public class AspectClass {

    private final static Logger logger = LoggerFactory.getLogger(AspectClass.class);

    @Pointcut("execution(public * com.oskyhang.springboot.controller.*.*(..))")
    public void pointCut(){
        logger.info("this is pointCut");
    }
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("this is before");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获去地址
        logger.info("url={}", request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    @After("pointCut()")
    public void doAfter(){
        logger.info("this is after");
    }

    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void doReturn(Object object){
        logger.info("response{}", object.toString() );
    }
}
