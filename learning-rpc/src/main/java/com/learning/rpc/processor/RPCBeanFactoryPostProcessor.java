package com.learning.rpc.processor;

import com.learning.rpc.annotation.RPC;
import com.learning.rpc.factory.RPCFactoryBean;
import com.learning.rpc.util.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 18:21
 **/
//@Component
@Slf4j
public class RPCBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("Start postProcessBeanFactory in RPCBeanFactoryPostProcessor");

        Map<Integer,Class> map = new HashMap<Integer,Class>();

        ClassScaner.scan("com.learning", RPC.class).forEach(x ->{
            try {
                Object object = new RPCFactoryBean<>(x).getObject();
                configurableListableBeanFactory.registerSingleton(x.getName(), object);
            } catch (Exception e) {
                log.error("",e);
            }
        });

        log.info("End postProcessBeanFactory in RPCBeanFactoryPostProcessor");
    }
}
