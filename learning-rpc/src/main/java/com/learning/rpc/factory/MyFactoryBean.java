package com.learning.rpc.factory;

import com.learning.rpc.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 18:11
 **/
@Slf4j
@AllArgsConstructor
public class MyFactoryBean<T> implements FactoryBean<T> {

    Class<T> clazz;

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            log.info("invoke");
            return "shushengxiang";
        };
        T proxy = (T) Proxy.newProxyInstance(handler.getClass().getClassLoader(),clazz.getInterfaces(),handler);
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }


    public static void main(String[] args) {
        InvocationHandler handler = (proxy, method, args1) -> {
            log.info("invoke");
            return "shushengxiang";
        };
        UserService proxy = (UserService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                new Class[]{UserService.class},handler);

        String s = proxy.queryName(1L);
        System.out.println(s);
        System.out.println(proxy.query(1L));

    }

}
