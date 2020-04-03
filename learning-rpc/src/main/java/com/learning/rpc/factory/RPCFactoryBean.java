package com.learning.rpc.factory;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 17:42
 **/
@Slf4j
@AllArgsConstructor
public class RPCFactoryBean<T> implements FactoryBean<T> {

    Class<T> clazz;

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            log.info("invoke");
            return "shushengxiang";
        };
        T proxy = (T) Proxy.newProxyInstance(handler.getClass().getClassLoader(),new Class[]{clazz},handler);
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
