package com.simple.rpc.client.registry;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:17
 **/
public abstract class AbstractClientRegister {

    public void register(BeanDefinitionRegistry registry,
                         String className,
                         Map<String, Object> attributes){
        registry.registerBeanDefinition(className,getRegisterBeanDefinition(attributes));
    }

    public abstract BeanDefinition getRegisterBeanDefinition(Map<String, Object> attributes);

}
