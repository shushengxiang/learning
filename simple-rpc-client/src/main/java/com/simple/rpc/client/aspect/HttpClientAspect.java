package com.simple.rpc.client.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 17:53
 **/
@Aspect
public class HttpClientAspect {

    @Pointcut("@annotation(com.simple.rpc.client.annotation.HttpSimpleRPCClient)")
    public void http(){}

    @Around("http()")
    public Object invoke(ProceedingJoinPoint joinPoint){
        return "123";
    }

}
