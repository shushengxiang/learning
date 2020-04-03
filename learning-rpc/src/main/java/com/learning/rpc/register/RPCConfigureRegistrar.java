package com.learning.rpc.register;

import com.learning.rpc.annotation.RPC;
import com.learning.rpc.factory.RPCFactoryBean;
import com.learning.rpc.util.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 17:01
 **/
@Slf4j
public class RPCConfigureRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        ClassScaner.scan("com.learning", RPC.class).stream().forEach(x -> {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(RPCFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue();
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            beanDefinition.setAttribute("clazz",x);
            beanDefinition.setLazyInit(false);
            log.info("Register one strategyService BeanDefinitions, name={}",x.getName());
            registry.registerBeanDefinition(x.getName(),beanDefinition);
        });

    }

}
