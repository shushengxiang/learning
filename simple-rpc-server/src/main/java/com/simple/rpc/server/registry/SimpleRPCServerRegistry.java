package com.simple.rpc.server.registry;

import com.simple.rpc.common.annotation.SimpleRPCClient;
import com.simple.rpc.common.condition.HttpCondition;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import com.simple.rpc.common.util.ClassScaner;
import com.simple.rpc.server.annotation.EnableSimpleRPCServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 10:29
 **/
@Configuration
@Slf4j
@EnableConfigurationProperties(SimpleRPCServerProperties.class)
public class SimpleRPCServerRegistry implements ImportBeanDefinitionRegistrar {

    private String[] basePackages;

    // just want to get the EnableSimpleRPCServer
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        log.info("Start SimpleRPCServerRegistry registerBeanDefinitions");
        basePackages = getBasePackages(importingClassMetadata);
        if (basePackages == null){
            basePackages = new String[]{};
        }

        Set<Class<?>> classes = ClassScaner.scan(basePackages, SimpleRPCClient.class);

        if (CollectionUtils.isEmpty(classes)){
            return;
        }


        classes.forEach( clazz -> {
            SimpleRPCClient simpleRPCClient = clazz.getAnnotation(SimpleRPCClient.class);
            switch (simpleRPCClient.type()){
                case HTTP:
                    HttpCondition.enable = true;
                    break;
            }
        });

        if (HttpCondition.enable){
            registry.registerBeanDefinition(ServerRegistry.class.getName(),
                    BeanDefinitionBuilder.genericBeanDefinition(HttpServerRegistry.class).getBeanDefinition());

        }

    }

    private String[] getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableSimpleRPCServer.class.getCanonicalName() );
        return  (String[]) attributes.get( "basePackages" );
    }
}
