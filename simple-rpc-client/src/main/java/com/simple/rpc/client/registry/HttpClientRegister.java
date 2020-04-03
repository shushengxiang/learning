package com.simple.rpc.client.registry;

import com.simple.rpc.client.factory.HttpRPCFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 17:29
 **/
@Slf4j
public class HttpClientRegister extends AbstractClientRegister {

    @Override
    public BeanDefinition getRegisterBeanDefinition(Map<String, Object> attributes) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                .genericBeanDefinition(HttpRPCFactoryBean.class)
                .setScope(BeanDefinition.SCOPE_SINGLETON);
        attributes.forEach( (k,v) -> beanDefinitionBuilder.addPropertyValue(k,v));
        return beanDefinitionBuilder.getBeanDefinition();
    }



}
