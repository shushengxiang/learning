package com.learning.register;

import com.learning.annotation.StrategyService;
import com.learning.util.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:58
 **/
@Component
@Slf4j
public class StrategySerivceConfigureRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;

    private Environment environment;


    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ClassScaner.scan("com.learning", StrategyService.class).stream().forEach( x -> {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(x);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue();
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            log.info("Register one strategyService BeanDefinitions, name={}",x.getName());
            registry.registerBeanDefinition(x.getName(),beanDefinition);
        });
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.environment = environment;
    }
}
